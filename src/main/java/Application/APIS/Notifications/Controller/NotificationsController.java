package Application.APIS.Notifications.Controller;

import Application.APIS.Notifications.Service.NotificationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notifications")
public class NotificationsController  {
    @RequestMapping("getMostNotifications")
    public ResponseEntity<Object> getMostNoficaitions() {
        try {
            return ResponseEntity.ok(NotificationsService.getMostNotifications());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

// http://localhost:8080/api/orders/
// http://localhost:8080/api/notifications/getMostNotifications