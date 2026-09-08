package in.coderarmy.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fp")
public class FakePay implements PaymentService{

    @Override
    public void payment(){
        System.out.println("Fake payment to test");
    }
}
