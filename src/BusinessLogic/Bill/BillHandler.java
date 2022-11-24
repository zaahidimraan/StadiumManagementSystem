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
    	
    }
    
    public void updateBill(Integer billRefNo2, String billDate2, String billType2, Integer personID2, Double d, Boolean billStatus2) {
    	
    }
}
