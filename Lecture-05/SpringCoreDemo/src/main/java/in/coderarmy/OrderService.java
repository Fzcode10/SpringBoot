package in.coderarmy;

import in.coderarmy.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    @Autowired   //Third Field Injector only at spring boot
    private final PaymentService paymentService;

    @Autowired   // First Constructor Injector   Most Recommended (If only single constructor then i have not to write @Autowired)
    OrderService(@Qualifier("cp") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    @Autowired   // Second setter Injector
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){

        paymentService.payment();

        System.out.println("Order placed");
    }
}
