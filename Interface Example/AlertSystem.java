
import javax.management.Notification;



public interface NotificationService{
    void sendNotification(String msg);
}

public class EmailNotification implements NotificationService{
    void sendNotification(String msg){
        System.out.println("Sent by Email : "+ msg);
    }
}
public class PagerNotification implements NotificationService{
    void sendNotification(String msg){
        System.out.println("Sent by Email : "+ msg);
    }
}
public class AlertService{
    private NotificationService notifier;
    public AlertService(NotificationService notifier){
        this.notifier=notifier;
    }
    void sendTrigger(String msg){
        notifier.sendNotification(msg);
    }
}
public class Main{
    public static void main(String args[]){
        AlertService alertEmailAlertService = new AlertService(new EmailNotification());
        alertEmailAlertService.sendTrigger("Hello");
        AlertService alertPagerAlertService = new AlertService(new PagerNotification());
        alertPagerAlertService.sendTrigger("Hello");


        

    }
}