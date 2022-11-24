package BusinessLogic.Staff;

import java.util.ArrayList;

public class StaffRegsister {
    private ArrayList<Office> offices=new ArrayList<Office>();
    private ArrayList<Managing> managings=new ArrayList<Managing>();
    private ArrayList<Admin> admins=new ArrayList<Admin>();

    public ArrayList<Office> getOffices() {
        return offices;
    }

    public void setOffices(ArrayList<Office> offices) {
        this.offices = offices;
    }

    public ArrayList<Managing> getManagings() {
        return managings;
    }

    public void setManagings(ArrayList<Managing> managings) {
        this.managings = managings;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public void addPerson(Integer CNIC, String name, String type, Double salary, String duty){
        if((type=="Office")||(type=="office")){

        } else if ((type=="Admin")||(type=="admin")) {

        } else if ((type=="Managing")||(type=="managing")) {

        }
    }

    public void removePerson(Integer CNIC,String type){
        if((type=="Office")||(type=="office")){
            for(int i=0;i<offices.size();i++){
                if(CNIC==offices.get(i).getCNIC()) {
                    offices.remove(i);
                    i=offices.size();
                }
            }

        } else if ((type=="Admin")||(type=="admin")) {
            for(int i=0;i<admins.size();i++){
                if(CNIC==admins.get(i).getCNIC()) {
                    admins.remove(i);
                    i=admins.size();
                }
            }
        } else if ((type=="Managing")||(type=="managing")) {
            for(int i=0;i<managings.size();i++){
                if(CNIC==managings.get(i).getCNIC()) {
                    managings.remove(i);
                    i=managings.size();
                }
            }
        }
    }

    public void updatePerson(Integer CNIC, String name, String type, Double salary, String duty){
        if((type=="Office")||(type=="office")){
            for(int i=0;i<offices.size();i++){
                if(CNIC==offices.get(i).getCNIC()) {
                    offices.get(i).setName(name);
                    offices.get(i).setType(type);
                    offices.get(i).setSalary(salary);
                    offices.get(i).setDuty(duty);
                    i=offices.size();
                }
            }

        } else if ((type=="Admin")||(type=="admin")) {
            for(int i=0;i<admins.size();i++){
                if(CNIC==admins.get(i).getCNIC()) {
                    admins.get(i).setName(name);
                    admins.get(i).setType(type);
                    admins.get(i).setSalary(salary);
                    admins.get(i).setDuty(duty);
                    i=admins.size();
                }
            }
        } else if ((type=="Managing")||(type=="managing")) {
            for(int i=0;i<managings.size();i++){
                if(CNIC==managings.get(i).getCNIC()) {
                    managings.get(i).setName(name);
                    managings.get(i).setType(type);
                    managings.get(i).setSalary(salary);
                    managings.get(i).setDuty(duty);
                    i=managings.size();
                }
            }
        }
    }

    public void addSalary(Boolean status, Double payement, Integer CNIC){

            for(int i=0;i<offices.size();i++){
                if(CNIC==offices.get(i).getCNIC()) {
                    offices.get(i).addSalary(status,payement,CNIC);
                    i=offices.size();
                }
            }

            for(int i=0;i<admins.size();i++){
                if(CNIC==admins.get(i).getCNIC()) {
                    admins.get(i).addSalary(status,payement,CNIC);
                    i=admins.size();
                }
            }
            for(int i=0;i<managings.size();i++){
                if(CNIC==managings.get(i).getCNIC()) {
                    managings.get(i).addSalary(status,payement,CNIC);
                    i=managings.size();
                }
            }

    }
}
