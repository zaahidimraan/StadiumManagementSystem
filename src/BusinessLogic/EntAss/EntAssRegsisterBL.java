package BusinessLogic.EntAss;

import DBHandling.BillDB;
import DBHandling.EntAssDB;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntAssRegsisterBL {
    private ArrayList<Empire> empires=new ArrayList<Empire>();
    private  ArrayList<Commentator> commentators=new ArrayList<Commentator>();
    private Integer entAssID;
    
    public void setEntAssID(Integer temp) {
        entAssID=temp;    	
    }

    public ArrayList<BookingAss> getBookingList(Integer CNIC) throws SQLException {
        for(int i=0;i<empires.size();i++){
            if(CNIC==empires.get(i).getCNIC())
                return empires.get(i).getBookingA(CNIC);
        }
        for(int i=0;i<commentators.size();i++){
            if(CNIC==commentators.get(i).getCNIC())
                return commentators.get(i).getBookingA(CNIC);
        }
        return null;
    }

    public void addBooking(Integer CNIC,String M_ID,String date,String time) throws SQLException {
        for(int i=0;i<empires.size();i++){
            if(CNIC==empires.get(i).getCNIC())
                empires.get(i).addBooking(CNIC,M_ID,date,time);
        }
        for(int i=0;i<commentators.size();i++){
            if(CNIC==commentators.get(i).getCNIC())
                empires.get(i).addBooking(CNIC,M_ID,date,time);
        }
    }



    public ArrayList<Empire> getEmpires() {
        EntAssDB db=new EntAssDB();

        try {
            empires=db.getEmpireArray("Empire");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return empires;
    }

    public void setEmpires(ArrayList<Empire> empires) {

        this.empires = empires;
    }

    public ArrayList<Commentator> getCommentators() {
        EntAssDB db=new EntAssDB();

        try {
            commentators=db.getCommentatorArray("Commentator");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return commentators;
    }

    public void setCommentators(ArrayList<Commentator> commentators) {
        this.commentators = commentators;
    }

    public void addEntAss(Integer CNIC, String name, Integer pnumber, String type, Double fee) throws SQLException {
        if((type.equals("Empire"))||(type.equals("empire"))){
        	System.out.println(type);
            empires.add(new Empire(CNIC,name,pnumber,type,fee));
            EntAssDB db=new EntAssDB();
            db.addEmpire(new Empire(CNIC,name,pnumber,type,fee));

        }
        else if((type.equals("Commentator"))||(type.equals("commentator"))){
            commentators.add(new Commentator(CNIC,name,pnumber,type,fee));
            EntAssDB db=new EntAssDB();
            db.addCommentator(new Commentator(CNIC,name,pnumber,type,fee));
        }
    }

    public void removeEntAss(Integer CNIC,String type) throws SQLException {
        if((type.equals("Empire"))||(type.equals("empire"))){
            for(int i=0;i<empires.size();i++){
                if(empires.get(i).getCNIC()==CNIC){
                    empires.remove(i);
                    EntAssDB db=new EntAssDB();
                    db.removePerson(CNIC);
                    i=empires.size();
                }
            }

        }
        else if((type.equals("Commentator"))||(type.equals("commentator"))){
            for(int i=0;i<commentators.size();i++){
                if(commentators.get(i).getCNIC()==CNIC){
                    commentators.remove(i);
                    EntAssDB db=new EntAssDB();
                    db.removePerson(CNIC);
                    i=commentators.size();
                }
            }
        }

    }

    public void updateEntAss(Integer CNIC, String name, Integer pnumber, String type, Double fee) throws SQLException {
        if((type.equals("Empire"))||(type.equals("empire"))){
            for(int i=0;i<empires.size();i++){
                if(empires.get(i).getCNIC()==CNIC){
                    empires.get(i).setFee(fee);
                    empires.get(i).setType(type);
                    empires.get(i).setName(name);
                    empires.get(i).setPnumber(pnumber);
                    EntAssDB db=new EntAssDB();
                    db.updateEmpire(new Empire(CNIC,name,pnumber,type,fee));
                    i=empires.size();
                }
            }

        }
        else if((type.equals("Commentator"))||(type.equals("commentator"))){
            for(int i=0;i<commentators.size();i++){
                if(commentators.get(i).getCNIC()==CNIC){
                    commentators.get(i).setFee(fee);
                    commentators.get(i).setType(type);
                    commentators.get(i).setName(name);
                    commentators.get(i).setPnumber(pnumber);
                    EntAssDB db=new EntAssDB();
                    db.updateCommentator(new Commentator(CNIC,name,pnumber,type,fee));
                    i=commentators.size();
                }
            }
        }


    }


	public Integer getEntAssID() {
		return entAssID;
	}
    


}
