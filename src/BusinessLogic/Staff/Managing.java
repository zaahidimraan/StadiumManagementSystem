package BusinessLogic.Staff;

public class Managing extends Staff{
    private String type;
    private Double salary;
    private String duty;

    public Managing(Integer CNIC, String name, String type, Double salary, String duty) {
        super(CNIC, name);
        this.type = type;
        this.salary = salary;
        this.duty = duty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
