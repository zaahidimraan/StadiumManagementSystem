package BusinessLogic.Match;

public class Seat {
    private Integer seatNumber;
    private String seatType;
    private Double price;
    private Boolean status=false;

    public Seat(Integer seatNumber, String seatType, Double price) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
