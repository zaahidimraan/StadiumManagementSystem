package BusinessLogic.Staff;

import DBHandling.staffDB;

import java.sql.SQLException;
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

    public void removeSalary(Integer CNIC,String Month) throws SQLException {
          for(int i=0;i<salaries.size();i++){
              if((salaries.get(i).getCNIC()==CNIC)&&(Month.equals(salaries.get(i).getMonth()))){
                  staffDB db=new staffDB();
                  db.removeSalary(CNIC,Month);
                  salaries=db.getSalaryArray();
               i=salaries.size();
              }
          }
    }

    public void addSalary(Boolean status, Double payement, Integer CNIC,String date,String month) throws SQLException {
        staffDB db=new staffDB();
            db.addsSalary(new Salary(status, payement, CNIC,date,month));
        salaries=db.getSalaryArray();
    }

    public void updateSalary(Boolean status,Double pay,Integer CNIC,String date,String Month) throws SQLException {
        staffDB db=new staffDB();
        db.updateSalary(new Salary(status,pay,CNIC,date,Month));
        salaries=db.getSalaryArray();
    }

}
