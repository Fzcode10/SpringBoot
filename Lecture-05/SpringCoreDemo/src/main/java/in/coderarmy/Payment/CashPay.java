package in.coderarmy.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary  // Set Primary payment method
@Qualifier("chp")
public class CashPay implements PaymentService{

    @Override
    public void payment(){
        System.out.println("Pay on delivery");
    }
}
