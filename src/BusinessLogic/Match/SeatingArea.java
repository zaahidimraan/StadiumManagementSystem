package BusinessLogic.Match;

import java.util.ArrayList;

public class SeatingArea {
    private String seatType;
    private Integer seatCount;
    private ArrayList<Seat> seats=new ArrayList<Seat>();

    public SeatingArea(String seatType, Integer seatCount) {
        this.seatType = seatType;
        this.seatCount = seatCount;

        Double price=0.0;
        if(seatType=="A")
            price=1500.0;
        else if(seatType=="B")
            price=1000.0;
        else if(seatType=="C")
            price=500.0;

        for (int i=0;i<seatCount;i++){
            seats.add(new Seat(i,seatType,500.0));
        }
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}
