package models.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {

    }

    public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation: Room " + 8021);
        sb.append(", check-in: " + checkIn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        sb.append(", check-out: " + checkOut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        sb.append(", " + duration() + " nights");
        return sb.toString();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

}
