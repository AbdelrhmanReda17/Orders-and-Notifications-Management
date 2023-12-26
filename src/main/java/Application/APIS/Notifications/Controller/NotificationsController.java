package Application.APIS.Notifications.Controller;

import Application.APIS.Notifications.Model.Notification;
import Application.APIS.Notifications.Service.NotificationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @RequestMapping("getNotifications")
    public ResponseEntity<Map<Notification,Integer>> getNoficaitions() {
        try {
            return ResponseEntity.ok(NotificationsService.getNotifications());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

// http://localhost:8080/api/orders/
// http://localhost:8080/api/notifications/getMostNotifications