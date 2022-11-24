package BusinessLogic.Staff;

import java.util.ArrayList;

public class Staff {
    private Integer CNIC;
    private String name;

    private ArrayList<Salary> salaries=new ArrayList<Salary>();
    public Staff(Integer CNIC, String name) {
        this.CNIC = CNIC;
        this.name = name;
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
