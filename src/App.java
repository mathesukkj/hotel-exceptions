import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import models.entities.Reservation;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("What is the room number? ");
        int roomNumber = s.nextInt();

        System.out.print("What is the checkin date? ");
        LocalDate checkIn = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("What is the checkout date? ");
        LocalDate checkOut = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (checkIn.isAfter(checkOut)) {
            System.out.println("ERROR! Check-out date must be after Check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("\nEnter data to update the reservation: ");
            System.out.print("What is the checkin date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("What is the checkout date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
                System.out.println("ERROR! Reservation dates for update must be future dates");
            } else if (checkIn.isAfter(checkOut)) {
                System.out.println("ERROR! Check-out date must be after Check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }
        }

        s.close();
    }
}
