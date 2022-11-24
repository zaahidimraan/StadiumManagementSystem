package BusinessLogic.Bill;
import java.util.ArrayList;

public class BillHandler {
   private ArrayList<BillDetail> billArrayList=new ArrayList<BillDetail>();

    public BillHandler() {
    }

    public void addBill(Integer billRefNo2, String billDate2, String billType2, Integer personID2, Double d, Boolean billStatus2){
    	billArrayList.add(new BillDetail(billRefNo2,billDate2,billType2,personID2,d,billStatus2));
    }
    
    public void removeBill(Integer billRefNo) {
    	for(int i=0;i<billArrayList.size();i++){
         if(billArrayList.get(i).getBillRefNo()==billRefNo){
          billArrayList.remove(i);
          i=billArrayList.size();
         }
        }
    }
    
    public void updateBill(Integer billRefNo2, String billDate2, String billType2, Integer personID2, Double d, Boolean billStatus2) {

      for(int i=0;i<billArrayList.size();i++){
       if(billArrayList.get(i).getBillRefNo()==billRefNo2){
        billArrayList.get(i).setBillDate(billDate2);
        billArrayList.get(i).setBillType(billType2);
        billArrayList.get(i).setPayment(d);
        billArrayList.get(i).setBillStatus(billStatus2);
        billArrayList.get(i).setPersonID(personID2);

       }
      }
    	
    }

    public ArrayList<BillDetail> getBillArrayList() {
        return billArrayList;
    }

    public void setBillArrayList(ArrayList<BillDetail> billArrayList) {
        this.billArrayList = billArrayList;
    }
}
