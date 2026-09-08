package in.coderarmy.Notification;

public class FakeEmail implements NotificationService{

    @Override
    public void sendNotification(){
        System.out.println("Dummy Email send");
    }
}
