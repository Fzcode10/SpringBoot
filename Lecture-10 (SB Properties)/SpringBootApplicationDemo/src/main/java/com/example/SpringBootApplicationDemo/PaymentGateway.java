package com.example.SpringBootApplicationDemo;

import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

//    @Value("${paymentGateway.type:Razorpay}")  // We can also use this in this way at place of constructor here  /*Default value*/ is Razorpay
//    private String type;

//    @Value("${paymentGateway.retryCount:3}")
//    private int retryCount;

//    public PaymentGateway(@Value("${paymentGateway.type:Razorpay}") String type,
//                          @Value("${paymentGateway.retryCount:3}") int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getRetryCount() {
//        return retryCount;
//    }
//
//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;
//    }

    private PaymentProperties paymentproperties;

    public PaymentGateway(PaymentProperties paymentproperties){
        this.paymentproperties = paymentproperties;
    }

    public String getType(){
        return paymentproperties.getType();
    }

    public  int getRetryCount(){
        return paymentproperties.getRetrycount();
    }

    public boolean getEnable(){
        return paymentproperties.getEnable();
    }

    public int getTimeOut(){
        return paymentproperties.getTimeout();
    }

    public void print(){
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(getTimeOut());
        System.out.println(getEnable());
    }
}
