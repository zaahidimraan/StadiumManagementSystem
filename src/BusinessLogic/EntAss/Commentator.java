package BusinessLogic.EntAss;

public class Commentator extends EntAss{
    private String Type;
    private Double fee;

    public Commentator(Integer CNIC, String name, Integer pnumber, String type, Double fee) {
        super(CNIC, name, pnumber);
        Type = type;
        this.fee = fee;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
