package Application.APIS.Orders.Model.OrderProcessors;

import Application.APIS.Orders.Model.IOrder;
import Application.APIS.Notifications.Service.NotificationsService;
import Application.APIS.Users.Model.User;
import Application.APIS.Notifications.Model.Notification;
import Application.Utilities.Template.ITemplate;
import Application.Utilities.Template.TemplateFactory;

public class SimpleOrderProcessor implements IOrderProcessor{

    @Override
    public void Process(IOrder newOrder) {
        try {
            User user = userRepository.findById(newOrder.getUserId());
            user.getPayment().WithDraw(user,newOrder.getPrice());
            ITemplate template = TemplateFactory.createTemplate(user.getTemplate() , user.getLanguage());
            NotificationsService.addNotification(
                    new Notification(
                    template.OrderMessage(user.getUserCredentials().getUsername() ,newOrder , false ) ,
                            template.OrderMessage(user.getUserCredentials().getUsername() ,newOrder , true ),
                            user)
            );
        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
