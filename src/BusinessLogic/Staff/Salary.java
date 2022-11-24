package BusinessLogic.Staff;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Salary {

   private Boolean Status;
   private Double payement;
   private Integer CNIC;
   private String month;
   private String date;

    public Salary(Boolean status, Double payement, Integer CNIC) {
        Status = status;
        this.payement = payement;
        this.CNIC = CNIC;
        // Date
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        this.date = dateFormat.format(date);
        // Month
        DateFormat dateFormat1 = new SimpleDateFormat("mm-yyyy");
        this.month = dateFormat1.format(date);
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public Double getPayement() {
        return payement;
    }

    public void setPayement(Double payement) {
        this.payement = payement;
    }

    public Integer getCNIC() {
        return CNIC;
    }

    public void setCNIC(Integer CNIC) {
        this.CNIC = CNIC;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
