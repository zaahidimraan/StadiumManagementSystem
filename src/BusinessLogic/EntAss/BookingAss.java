package BusinessLogic.EntAss;

public class BookingAss {
    private Integer CNIC;
    private String M_ID;
    private String date;
    private String time;

    public BookingAss(Integer CNIC, String m_ID, String date, String time) {
        this.CNIC = CNIC;
        this.M_ID = m_ID;
        this.date = date;
        this.time = time;
    }

    public Integer getCNIC() {
        return CNIC;
    }

    public void setCNIC(Integer CNIC) {
        this.CNIC = CNIC;
    }

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
