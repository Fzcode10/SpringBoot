package in.coderarmy;

import in.strick.CartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

        CartService c = context.getBean(CartService.class);
        c.addToCard();

        User user = context.getBean(User.class);
        System.out.println(user.getName());
//        System.out.println(user.getAge());

    }
}