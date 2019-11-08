package chow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import numberlist.objectlist.Money;
import numberlist.objectlist.ObjectArrayList;
import numberlist.primitivelist.IntegerArrayList;

/**
 * This is the business class.
 *
 * @author Wai Kwan Chow
 */
public class Reservation {

    private ObjectArrayList firstName;
    private ObjectArrayList lastName;
    private IntegerArrayList phoneNumber;
    private ObjectArrayList email;
    static private long confirmation;
    private IntegerArrayList confirmationNumber;
    private ObjectArrayList checkInDate;
    private ObjectArrayList checkOutDate;
    private ObjectArrayList bed;
    private IntegerArrayList rooms;
    private IntegerArrayList nights;
    private static final double SINGLE_BED = 60;
    private static final double TWIN_BED = 65;
    private static final double DOUBLE_BED = 75;

    /**
     * full constructor.
     */
    public Reservation() {
        this.firstName = new ObjectArrayList();
        this.lastName = new ObjectArrayList();
        this.phoneNumber = new IntegerArrayList();
        this.email = new ObjectArrayList();
        this.checkInDate = new ObjectArrayList();
        this.checkOutDate = new ObjectArrayList();
        this.bed = new ObjectArrayList();
        this.nights = new IntegerArrayList();
        this.confirmationNumber = new IntegerArrayList();
        this.rooms = new IntegerArrayList();
        loadReservations();
        confirmation = firstName.size();
    }

    /**
     * This method get the first name from the first name objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(first name) of that index
     */
    public String getFirstName(int index) {
        return (String) (firstName.get(index));
    }

    /**
     * This method get the last name from the last name objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(last name) of that index
     */
    public String getLastName(int index) {
        return (String) (lastName.get(index));
    }

    /**
     * This method get the phone number from the phone number objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(phone number) of that index
     */
    public int getPhoneNumber(int index) {
        return (int) (phoneNumber.get(index));
    }

    /**
     * This method get the email from the email objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(email) of that index
     */
    public String getEmail(int index) {
        return (String) (email.get(index));
    }

    /**
     * This method get the confirmation number from the confirmation number
     * objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(confirmation number) of that index
     */
    public long getConfirmation(int index) {
        return confirmationNumber.get(index);
    }

    /**
     * This method get the check in date from the check in date objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(check in date) of that index
     */
    public DatePicker getCheckInDate(int index) {
        return (DatePicker) (checkInDate.get(index));
    }

    /**
     * This method get the check out date from the check out date
     * objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(check out date) of that index
     */
    public DatePicker getCheckOutDate(int index) {
        return (DatePicker) (checkOutDate.get(index));
    }

    /**
     * This method get the type of bed from the bed objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(type of bed) of that index
     */
    public String getBed(int index) {
        return (String) (bed.get(index));
    }

    /**
     * This method get the number of nights the customers are staying in the
     * hotel from the nights objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(number of nights) of that index
     */
    public long getNights(int index) {
        return nights.get(index);
    }

    /**
     * This method get the number of rooms from the rooms objectArrayList
     *
     * @param index index of the objectArrayList
     * @return the value(number of rooms) of that index
     */
    public int getRooms(int index) {
        return (int) (rooms.get(index));
    }

    /**
     * This method calculate the price of the reservation
     *
     * @param index index of the rooms objectArrayList
     * @return the price of the reservation
     */
    public Money getPrice(int index) {
        if (bed.get(index).equals("Single")) {
            return new Money((long) (SINGLE_BED * rooms.get(index)),
                    (byte) (0));
        } else if (bed.equals("Twin")) {
            return new Money((long) (TWIN_BED * rooms.get(index)),
                    (byte) (0));
        } else {
            return new Money((long) (DOUBLE_BED * rooms.get(index)),
                    (byte) (0));
        }
    }

    /**
     * This method displays the reservation
     *
     * @param confirmation the confirmation number of the reservation
     * @return the string output(reservation details) of the reservation
     */
    public String display(long confirmation) {
        int index = confirmationNumber.find(confirmation);
        return "Confirmation Number: " + confirmationNumber.get(index) + "\n"
                + firstName.get(index) + " " + lastName.get(index) + "\n"
                + " Phone Number: " + phoneNumber.get(index) + "Emails: " + email.get(index)
                + "\n" + "Check-In Date: " + ((DatePicker) (checkInDate.get(index))).getValue() + " Check-Out Date: "
                + ((DatePicker) (checkOutDate.get(index))).getValue() + "\n" + nights.get(index) + " nights   "
                + rooms.get(index) + " " + bed.get(index) + " bedrooms" + "\n"
                + "Total: " + getPrice(index).toString();
    }

    /**
     * This method adds the customers' informations to the corresponding
     * ArrayList
     *
     * @param firstName the first name of the customer
     * @param lastName the last name of the customer
     * @param phoneNumber the phone number of the customer
     * @param email the email of the customer
     * @param checkInDate the check in date of the customer
     * @param checkOutDate the check out date of the customer
     * @param nights the number of nights the customers are staying
     * @param rooms the number of rooms the customers booked
     * @param bed the type of bed the customers booked
     */
    public void addReservation(String firstName, String lastName,
            int phoneNumber, String email, DatePicker checkInDate, DatePicker checkOutDate,
            long nights, int rooms, String bed) {
        confirmation++;
        this.confirmationNumber.add(this.confirmationNumber.size(), confirmation);
        this.lastName.add(this.lastName.size(), lastName);
        this.firstName.add(this.firstName.size(), firstName);
        this.phoneNumber.add(this.phoneNumber.size(), phoneNumber);
        this.email.add(this.email.size(), email);
        this.checkInDate.add(this.checkInDate.size(), checkInDate);
        this.checkOutDate.add(this.checkOutDate.size(), checkOutDate);
        this.nights.add(this.nights.size(), nights);
        this.rooms.add(this.rooms.size(), rooms);
        this.bed.add(this.bed.size(), bed);
    }

    /**
     * This method save the reservations to the txt file from all ArrayLists.
     */
    public void saveReservation() {
        PrintWriter writer = null;
        try {
            File file = new File("src/chow/reservations.txt");
            writer = new PrintWriter(file);
            for (int i = 0; i < confirmationNumber.size(); i++) {
                writer.println(confirmationNumber.get(i));
                writer.println(firstName.get(i));
                writer.println(lastName.get(i));
                writer.println(phoneNumber.get(i));
                writer.println(email.get(i));
                writer.println(((DatePicker) checkInDate.get(i)).getValue());
                writer.println(((DatePicker) checkOutDate.get(i)).getValue());
                writer.println(rooms.get(i));
                writer.println(bed.get(i));
                writer.println("---------------------------");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }

    /**
     * This method load the reservations from the txt file to the ArrayLists
     */
    public void loadReservations() {
        try {
            File file = new File("src/chow/reservations.txt");
            Scanner scanIn = new Scanner(file);
            while (scanIn.hasNext()) {
                confirmationNumber.add(Long.parseLong(scanIn.nextLine()));
                firstName.add(this.firstName.size(), scanIn.nextLine());
                lastName.add(this.lastName.size(), scanIn.nextLine());
                phoneNumber.add(this.phoneNumber.size(), Long.parseLong(scanIn.next()));
                email.add(this.email.size(), scanIn.next());
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dtf = dtf.withLocale(Locale.US);
                LocalDate date = LocalDate.parse(scanIn.next(), dtf);
                DatePicker checkInDate = new DatePicker(date);
                this.checkInDate.add(this.checkInDate.size(), checkInDate);
                date = LocalDate.parse(scanIn.next(), dtf);
                DatePicker checkOutDate = new DatePicker(date);
                this.checkOutDate.add(this.checkOutDate.size(), checkOutDate);
                nights.add(this.nights.size(), ChronoUnit.DAYS.between(checkInDate.getValue(),
                        checkOutDate.getValue()));
                rooms.add(this.rooms.size(), scanIn.nextInt());
                bed.add(this.bed.size(), scanIn.next());
                scanIn.nextLine();
                scanIn.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This is a insertion sort method that will sort the reservations by 
     * customers' last names and confirmation numbers of all the reservations
     *
     * @param sorting The choice of how the staff want the reservations to be
     * sorted
     */
    public void sort(String sorting) {
        if (sorting.equals("sort by last name")) {
            for (int i = firstName.size() - 1; i >= 0; i--) {
                for (int j = 1; j <= i; j++) {
                    if (((String) (lastName.get(j - 1))).
                            compareToIgnoreCase(((String) lastName.get(j))) > 0) {
                        swap(j, j - 1);
                    }
                }
            }
        } else {
            for (int i = firstName.size() - 1; i >= 0; i--) {
                for (int j = 1; j <= i; j++) {
                    if (confirmationNumber.get(j - 1) > confirmationNumber.get(j)) {
                        swap(j, j - 1);
                    }
                }
            }
        }
    }

    /**
     * This method swap the elements that are inside the file when the staff
     * choose to sort them
     *
     * @param index1 the index of first element that are going to be swapped
     * @param index2 the index of element that are going to be swapped with the
     *               first element
     */
    public void swap(int index1, int index2) {
        String tempLastName = (String) (lastName.get(index1));
        lastName.set(index1, lastName.get(index2));
        lastName.set(index2, tempLastName);
        String tempFirstName = (String) (firstName.get(index1));
        firstName.set(index1, firstName.get(index2));
        firstName.set(index2, tempFirstName);
        long tempPhoneNumber = phoneNumber.get(index1);
        phoneNumber.set(index1, phoneNumber.get(index2));
        phoneNumber.set(index2, tempPhoneNumber);
        String tempEmail = (String) (email.get(index1));
        email.set(index1, email.get(index2));
        email.set(index2, tempEmail);
        long tempConfirmationNumber = confirmationNumber.get(index1);
        confirmationNumber.set(index1, confirmationNumber.get(index2));
        confirmationNumber.set(index2, tempConfirmationNumber);
        Object tempCheckInDate = checkInDate.get(index1);
        checkInDate.set(index1, checkInDate.get(index2));
        checkInDate.set(index2, tempCheckInDate);
        Object tempCheckOutDate = checkOutDate.get(index1);
        checkOutDate.set(index1, checkOutDate.get(index2));
        checkOutDate.set(index2, tempCheckOutDate);
        String tempBed = (String) (bed.get(index1));
        bed.set(index1, bed.get(index2));
        bed.set(index2, tempBed);
        long tempRoom = rooms.get(index1);
        rooms.set(index1, rooms.get(index2));
        rooms.set(index2, tempRoom);
        long tempNight = nights.get(index1);
        nights.set(index1, nights.get(index2));
        nights.set(index2, tempNight);
    }

    /**
     * This method displays all the reservations at once for the staff
     *
     * @return the string output (the format of how all reservations are going
     *         to be displayed
     */
    public String displayReservations() {
        String output = "";
        for (int i = 0; i < lastName.size(); i++) {
            output += "Confirmation Number: " + confirmationNumber.get(i) + "\n"
                    + firstName.get(i) + " " + lastName.get(i) + "\n"
                    + "Phone Number: " + phoneNumber.get(i) + "\n" + "Email: " + email.get(i)
                    + "\n" + "Check-In Date: " + ((DatePicker) (checkInDate.get(i))).getValue()
                    + "\n" + "Check-Out Date: " + ((DatePicker) (checkOutDate.get(i))).getValue() + "\n" + nights.get(i) + " nights   "
                    + rooms.get(i) + " " + bed.get(i) + " bedrooms" + "\n"
                    + "Total: " + getPrice(i).toString() + "\n-------------------------" + "\n";
        }
        return output;
    }

}
