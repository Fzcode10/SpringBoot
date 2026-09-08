package in.coderarmy;

import in.coderarmy.Notification.EmailService;
import in.coderarmy.Notification.NotificationService;
import in.coderarmy.Notification.PopupService;
import in.coderarmy.Notification.SmsService;

public class OrderService {

    NotificationService notification;

    public OrderService(NotificationService notification){
        this.notification = notification;
    }

    public OrderService(){

    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }

    public void placeOrder(){
        System.out.println("Order Placed");
        notification.sendNotification();
    }
}
