package BusinessLogic.EntAss;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class EntAssRegsister {
    private ArrayList<Empire> empires=new ArrayList<Empire>();
    private  ArrayList<Commentator> commentators=new ArrayList<Commentator>();


    public ArrayList<Empire> getEmpires() {
        return empires;
    }

    public void setEmpires(ArrayList<Empire> empires) {
        this.empires = empires;
    }

    public ArrayList<Commentator> getCommentators() {
        return commentators;
    }

    public void setCommentators(ArrayList<Commentator> commentators) {
        this.commentators = commentators;
    }

    public void addEntAss(Integer CNIC, String name, Integer pnumber, String type, Double fee){
        if((type=="Empire")||(type=="empire")){
            empires.add(new Empire(CNIC,name,pnumber,type,fee));

        }
        else if((type=="Commentator")||(type=="commentator")){
            commentators.add(new Commentator(CNIC,name,pnumber,type,fee));
        }
    }

    public void removeEntAss(Integer CNIC,String type){
        if((type=="Empire")||(type=="empire")){
            for(int i=0;i<empires.size();i++){
                if(empires.get(i).getCNIC()==CNIC){
                    empires.remove(i);
                    i=empires.size();
                }
            }

        }
        else if((type=="Commentator")||(type=="commentator")){
            for(int i=0;i<commentators.size();i++){
                if(commentators.get(i).getCNIC()==CNIC){
                    commentators.remove(i);
                    i=empires.size();
                }
            }
        }

    }

    public void updateEntAss(Integer CNIC, String name, Integer pnumber, String type, Double fee){
        if((type=="Empire")||(type=="empire")){
            for(int i=0;i<empires.size();i++){
                if(empires.get(i).getCNIC()==CNIC){
                    empires.get(i).setFee(fee);
                    empires.get(i).setType(type);
                    empires.get(i).setName(name);
                    empires.get(i).setPnumber(pnumber);
                    i=empires.size();
                }
            }

        }
        else if((type=="Commentator")||(type=="commentator")){
            for(int i=0;i<commentators.size();i++){
                if(commentators.get(i).getCNIC()==CNIC){
                    commentators.get(i).setFee(fee);
                    commentators.get(i).setType(type);
                    commentators.get(i).setName(name);
                    commentators.get(i).setPnumber(pnumber);
                    i=empires.size();
                }
            }
        }


    }


}
