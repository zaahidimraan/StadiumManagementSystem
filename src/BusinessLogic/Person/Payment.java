package BusinessLogic.Person;

public class Payment {
    private Double payment;
    private Boolean paymentStatus;
    private String paymentMethod;

    public Payment(Double payment, Boolean paymentStatus, String paymentMethod) {
        this.payment = payment;
        this.paymentStatus = false;
        this.paymentMethod = paymentMethod;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
