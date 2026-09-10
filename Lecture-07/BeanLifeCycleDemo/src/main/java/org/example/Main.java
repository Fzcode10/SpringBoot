package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);


//        OrderService order = context.getBean(OrderService.class);
//        order.order();
//
//        AppConfig appConfig = context.getBean(AppConfig.class);
//        appConfig.demo();

//        CardService card = context.getBean(CardService.class);
//        card.getCard(1);

//        context2.close();
    }
}
