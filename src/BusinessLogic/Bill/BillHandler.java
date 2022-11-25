package BusinessLogic.Bill;
import java.sql.SQLException;
import java.util.ArrayList;
import DBHandling.*;

public class BillHandler {
   private ArrayList<BillDetail> billArrayList=new ArrayList<BillDetail>();

    public BillHandler() {
        BillDB db=new BillDB();

        try {
			billArrayList=db.getBillArray();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void addBill(Integer billRefNo2, String billDate2, String billType2, Integer personID2, Double d, Boolean billStatus2) throws SQLException {
    	billArrayList.add(new BillDetail(billRefNo2,billDate2,billType2,personID2,d,billStatus2));
        BillDB db=new BillDB();
        db.addBill(new BillDetail(billRefNo2,billDate2,billType2,personID2,d,billStatus2));
    }
    
    public void removeBill(Integer billRefNo) throws SQLException {
    	for(int i=0;i<billArrayList.size();i++){
         if(billArrayList.get(i).getBillRefNo()==billRefNo){
          BillDB db=new BillDB();
          db.removeBill(billArrayList.get(i).getBillRefNo());
          billArrayList.remove(i);
          i=billArrayList.size();
         }
        }
    }
    
    public void updateBill(Integer billRefNo2, String billDate2, String billType2, Integer personID2, Double d, Boolean billStatus2) throws SQLException {

      for(int i=0;i<billArrayList.size();i++){
       if(billArrayList.get(i).getBillRefNo()==billRefNo2){
        billArrayList.get(i).setBillDate(billDate2);
        billArrayList.get(i).setBillType(billType2);
        billArrayList.get(i).setPayment(d);
        billArrayList.get(i).setBillStatus(billStatus2);
        billArrayList.get(i).setPersonID(personID2);
        BillDB db=new BillDB();
        db.updateBill(billArrayList.get(i));
       }
      }
    	
    }

    public ArrayList<BillDetail> getBillArrayList() throws SQLException {
    	BillDB db=new BillDB();
    	db.getBills();
        return billArrayList;
    }

    public void setBillArrayList(ArrayList<BillDetail> billArrayList) {
        this.billArrayList = billArrayList;
    }
}
