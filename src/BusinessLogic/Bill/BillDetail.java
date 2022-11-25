package BusinessLogic.Bill;


public class BillDetail {
  private Integer billRefNo;
  private String billDate;
  private String billType;
  private Integer personID;
  private Double payment;
  private Boolean billStatus;
  
  

public BillDetail(Integer billRefNo2, String billDate2, String billType2, Integer personID2, Double d, Boolean billStatus2) {
	// TODO Auto-generated constructor stub

	this.billRefNo = billRefNo2;
	this.billDate = billDate2;
	this.billType = billType2;
	this.personID = personID2;
	this.payment = d;
	this.billStatus = billStatus2;
}


public Integer getBillRefNo() {
	return billRefNo;
}


public void setBillRefNo(Integer billRefNo) {
	this.billRefNo = billRefNo;
}


public String getBillDate() {
	return billDate;
}


public void setBillDate(String billDate) {
	this.billDate = billDate;
}


public String getBillType() {
	return billType;
}


public void setBillType(String billType) {
	this.billType = billType;
}


public Integer getPersonID() {
	return personID;
}


public void setPersonID(Integer personID) {
	this.personID = personID;
}


public Double getPayment() {
	return payment;
}


public void setPayment(Double payment) {
	this.payment = payment;
}


public Boolean getBillStatus() {
	return billStatus;
}


public void setBillStatus(Boolean billStatus) {
	this.billStatus = billStatus;
}
  

  
  
}
