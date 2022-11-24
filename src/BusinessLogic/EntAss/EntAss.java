package BusinessLogic.EntAss;

public class EntAss {
    private Integer CNIC;
    private String name;
    private Integer Pnumber;

    public EntAss(Integer CNIC, String name, Integer pnumber) {
        this.CNIC = CNIC;
        this.name = name;
        Pnumber = pnumber;
    }

    public Integer getCNIC() {
        return CNIC;
    }

    public void setCNIC(Integer CNIC) {
        this.CNIC = CNIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPnumber() {
        return Pnumber;
    }

    public void setPnumber(Integer pnumber) {
        Pnumber = pnumber;
    }
}
