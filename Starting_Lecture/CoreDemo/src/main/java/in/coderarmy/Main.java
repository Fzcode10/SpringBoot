package in.coderarmy;

import in.coderarmy.Notification.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationService notification = new FakeEmail();
//        OrderService order = new OrderService(notification);
        OrderService order = new OrderService();
        order.setNotification(new EmailService());
        order.placeOrder();
    }
}