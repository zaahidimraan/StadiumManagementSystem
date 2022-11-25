package BusinessLogic.Staff;

import java.util.ArrayList;

public class Staff {
    private Integer CNIC;
    private String name;
    private String type;
    private Double salary;
    private String duty;
    private String password;

    public Staff(Integer CNIC, String name, String type, Double salary, String duty, String password) {
        this.CNIC = CNIC;
        this.name = name;
        this.type = type;
        this.salary = salary;
        this.duty = duty;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    private ArrayList<Salary> salaries=new ArrayList<Salary>();

    public ArrayList<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(ArrayList<Salary> salaries) {
        this.salaries = salaries;
    }

    public void addSalary(Boolean status, Double payement, Integer CNIC){
        salaries.add(new Salary(status, payement, CNIC));
    }


}
