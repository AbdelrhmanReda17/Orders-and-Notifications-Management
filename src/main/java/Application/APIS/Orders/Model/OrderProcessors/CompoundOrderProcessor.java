package Application.APIS.Orders.Model.OrderProcessors;

import Application.APIS.Orders.Model.CompoundOrder;
import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Notifications.Service.NotificationsService;
import Application.APIS.Users.Model.User;
import Application.APIS.Notifications.Model.Notification;
import Application.Utilities.Template.ITemplate;
import Application.Utilities.Template.TemplateFactory;

public class CompoundOrderProcessor implements IOrderProcessor{
    @Override
    public void Process(IOrder newOrder , boolean isCompound) {
        try {
            User user = userRepository.findById(newOrder.getUserId());
            for(IOrder order : ((CompoundOrder) newOrder).getOrderList()){
                User dummmyUser = userRepository.findById(order.getUserId());
                if(!dummmyUser.getUserCredentials().getCountry().equals(user.getUserCredentials().getCountry())){
                    throw new IllegalStateException("Orders in compound order must be from the same country");
                }
                if(!dummmyUser.getUserCredentials().getCity().equals(user.getUserCredentials().getCity())){
                    throw new IllegalStateException("Orders in compound order must be from the same city");
                }
            }
            newOrder.setPrice(newOrder.getPrice() + (OrderFees / (((CompoundOrder) newOrder).getOrderList().size() + 1)));
            user.getPayment().WithDraw(user, newOrder.getPrice());
            for (IOrder order : ((CompoundOrder) newOrder).getOrderList()) {
                order.setPrice(order.getPrice() + (OrderFees / (((CompoundOrder) newOrder).getOrderList().size() + 1)));
                OrderProcessorFactory.CreateOrderProcessor(order).Process(order , true);
            }
            ITemplate template = TemplateFactory.createTemplate(user.getTemplate() , user.getLanguage());
            NotificationsService.addNotification(
                    new Notification(
                   template.OrderMessage(user.getUserCredentials().getUsername() , newOrder , false) ,
                   template.OrderMessage(user.getUserCredentials().getUsername() , newOrder , true),
                   user)
            );
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
