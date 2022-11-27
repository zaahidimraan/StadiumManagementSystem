package BusinessLogic.Staff;

import DBHandling.staffDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class StaffRegsisterA {
    private ArrayList<Staff> staffArrayList=new ArrayList<Staff>();
    private Integer index;


    public void addPerson(Integer CNIC, String name, String type, Double salary, String duty, String password) throws SQLException {
     staffDB db=new staffDB();
     db.addstaff(new Staff(CNIC,name,type,salary,duty,password));
     staffArrayList.add(new Staff(CNIC,name,type,salary,duty,password));
    }

    public void removePerson(Integer CNIC,String type) throws SQLException {

            for(int i=0;i<staffArrayList.size();i++){
                if(CNIC==staffArrayList.get(i).getCNIC()) {
                    staffArrayList.remove(i);
                    staffDB db=new staffDB();
                    db.removestaff(CNIC);
                    i=staffArrayList.size();
                }
            }

    }

    public void updatePerson(Integer CNIC, String name, String type, Double salary, String duty,String password) throws SQLException {

            for(int i=0;i<staffArrayList.size();i++){
                if(CNIC==staffArrayList.get(i).getCNIC()) {
                    staffArrayList.get(i).setName(name);
                    staffArrayList.get(i).setType(type);
                    staffArrayList.get(i).setSalary(salary);
                    staffArrayList.get(i).setDuty(duty);
                    staffDB db=new staffDB();
                    db.updatestaff(new Staff(CNIC,name,type,salary,duty,password));
                    i=staffArrayList.size();
                }
            }

    }

    public ArrayList<Staff> getStaffArrayList() throws SQLException {
        staffDB db=new staffDB();
        staffArrayList=db.getstaffArray();
    	return staffArrayList;
    }

    public Staff getLogin(Integer CNIC,String password) throws SQLException {
    	staffArrayList=this.getStaffArrayList();
    	
         
        for(int i=0;i<staffArrayList.size();i++){
            if((CNIC.equals(staffArrayList.get(i).getCNIC()))&&(password.equals(staffArrayList.get(i).getPassword())))
            {
                return staffArrayList.get(i);
            }
        }
        return null;

    }

    public ArrayList<Salary> getSalaryArray(Integer CNIC) throws SQLException {
        for(int i=0;i<staffArrayList.size();i++)
        	if(CNIC==staffArrayList.get(i).getCNIC())
    	          return staffArrayList.get(i).getSalaries(CNIC);
		return null;
    }

    public void addSalary(Boolean status,Double pay,Integer CNIC,String date,String month) throws SQLException {
        staffArrayList=this.getStaffArrayList();
        for(int i=0;i<staffArrayList.size();i++)
        	if(CNIC.intValue()==staffArrayList.get(i).getCNIC().intValue())
               staffArrayList.get(i).addSalary(status,pay,CNIC,date,month);
    }
    public void removeSalary(Integer CNIC,String Month) throws SQLException {
        for(int i=0;i<staffArrayList.size();i++)
        	if(CNIC.intValue()==staffArrayList.get(i).getCNIC().intValue())
                   staffArrayList.get(i).removeSalary(CNIC,Month);
    }
    public void updateSalary(Boolean status,Double pay,Integer CNIC,String date,String Month) throws SQLException {
        staffArrayList=this.getStaffArrayList();
        for(int i=0;i<staffArrayList.size();i++)
        	if(CNIC.intValue()==staffArrayList.get(i).getCNIC().intValue())
               staffArrayList.get(i).updateSalary(status,pay,CNIC,date,Month);
    }

}
