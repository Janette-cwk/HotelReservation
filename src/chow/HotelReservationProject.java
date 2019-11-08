package chow;

import java.util.Locale;
import javafx.application.Application;

/**
 * This is the launcher class.
 *
 * @author Wai Kwan Chow
 */
public class HotelReservationProject {

    /**
     * main method for launching the GUI and set the check in and check out
     * calender to be US time zone
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Application.launch(ProjectGUI.class);
    }

}
