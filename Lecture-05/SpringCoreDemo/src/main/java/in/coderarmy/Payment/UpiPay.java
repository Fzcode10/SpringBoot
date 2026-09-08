package in.coderarmy.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("up")
public class UpiPay implements PaymentService{

    @Override
    public void payment(){
        System.out.println("Pay with UPI");
    }
}
