package BusinessLogic.Staff;

import java.util.ArrayList;

public class StaffRegsisterA {
    private ArrayList<Staff> staffArrayList=new ArrayList<Staff>();
    private Integer personID;

    public void addPerson(Integer CNIC, String name, String type, Double salary, String duty,String password){
     staffArrayList.add(new Staff(CNIC,name,type,salary,duty,password));
    }

    public void removePerson(Integer CNIC,String type){

            for(int i=0;i<staffArrayList.size();i++){
                if(CNIC==staffArrayList.get(i).getCNIC()) {
                    staffArrayList.remove(i);
                    i=staffArrayList.size();
                }
            }

    }

    public void updatePerson(Integer CNIC, String name, String type, Double salary, String duty){

            for(int i=0;i<staffArrayList.size();i++){
                if(CNIC==staffArrayList.get(i).getCNIC()) {
                    staffArrayList.get(i).setName(name);
                    staffArrayList.get(i).setType(type);
                    staffArrayList.get(i).setSalary(salary);
                    staffArrayList.get(i).setDuty(duty);
                    i=staffArrayList.size();
                }
            }

    }

    public void addSalary(Boolean status, Double payement, Integer CNIC){

            for(int i=0;i<staffArrayList.size();i++){
                if(CNIC==staffArrayList.get(i).getCNIC()) {
                    staffArrayList.get(i).addSalary(status,payement,CNIC);
                    i=staffArrayList.size();
                }
            }


    }
}
