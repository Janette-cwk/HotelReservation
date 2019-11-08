package chow;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.application.Application;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Control;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * This is the UI class.
 *
 * @author Wai Kwan Chow
 */
public class ProjectGUI extends Application {

    private Button btnReserve = new Button("Reserve");
    private Button btnExit = new Button("Exit");
    private Button btnClear = new Button("Clear");
    private DatePicker checkInDatePicker;
    private DatePicker checkOutDatePicker;
    private TextField tfFirstName;
    private TextField tfLastName;
    private TextField tfEmail;
    private TextField tfPhoneNumber;
    private ComboBox<String> cmbBed;
    private ComboBox<Integer> cmbRoom;
    private TextField tfConfirm;
    private TextField tfCode;
    private Reservation reservation = new Reservation();
    private TextArea txt;
    private ComboBox<String> cmbSort;

    @Override
    public void start(Stage primaryStage) {

        TabPane tabs = new TabPane();
        Tab tabNew = new Tab();
        tabNew.setText("New Reservation");
        tabNew.setContent(newReservation());

        Tab tabExisting = new Tab();
        tabExisting.setText("Existing Reservation");
        tabExisting.setContent(existingReservation());

        Tab tabReview = new Tab();
        tabReview.setText("Reservations Overview");
        tabReview.setContent(overviewReservation());

        tabs.getTabs().addAll(tabNew, tabExisting, tabReview);

        Scene scene = new Scene(tabs, 300, 400); 
        primaryStage.setTitle("Welcome to Hotel Inn");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create the GUI of the New Reservation tab
     *
     * @return the BoarderPane
     */
    private Pane newReservation() {

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));
        GridPane List = new GridPane();
        border.setLeft(List);
        border.setBottom(createButtonRow());
        Label lblFirstName = new Label("First Name: ");
        tfFirstName = new TextField();
        Label lblLastName = new Label("Last Name: ");
        tfLastName = new TextField();
        Label lblEmail = new Label("Email: ");
        tfEmail = new TextField();
        Label lblPhoneNumber = new Label("Phone Number: ");
        tfPhoneNumber = new TextField();
        Label lblBed = new Label("Bed: ");
        cmbBed = new ComboBox();
        cmbBed.getItems().addAll("Single", "Twin", "Double");
        Label lblRoom = new Label("Room: ");
        cmbRoom = new ComboBox();
        cmbRoom.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        checkInDatePicker = new DatePicker();
        checkOutDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory
                = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(
                                checkInDatePicker.getValue().plusDays(1))) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                        long p = ChronoUnit.DAYS.between(
                                checkInDatePicker.getValue(), item);
                        setTooltip(new Tooltip(
                                "You're about to stay for " + p + " days"));
                    }
                };
            }
        };
        checkOutDatePicker.setDayCellFactory(dayCellFactory);
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));
        Label lblCheckIn = new Label("Check-In Date: ");
        Label lblCheckOut = new Label("Check-Out Date: ");
        List.add(lblFirstName, 0, 0);
        List.add(tfFirstName, 1, 0);
        List.add(lblLastName, 0, 1);
        List.add(tfLastName, 1, 1);
        List.add(lblEmail, 0, 2);
        List.add(tfEmail, 1, 2);
        List.add(lblPhoneNumber, 0, 3);
        List.add(tfPhoneNumber, 1, 3);
        List.add(lblBed, 0, 4);
        List.add(cmbBed, 1, 4);
        List.add(lblRoom, 0, 5);
        List.add(cmbRoom, 1, 5);
        List.add(lblCheckIn, 0, 6);
        List.add(checkInDatePicker, 1, 6);
        List.add(lblCheckOut, 0, 7);
        List.add(checkOutDatePicker, 1, 7);
        List.setVgap(10);
        btnClear.setOnAction(e -> clear());
        btnExit.setOnAction(e -> exit());
        btnReserve.setOnAction(e -> add());
        return border;
    }

    /**
     * Create the GUI of the Existing Reservation tab
     *
     * @return the GridPane
     */
    private Pane existingReservation() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(12);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().add(column1);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column2);
        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10.0);
        hbButtons.setAlignment(Pos.CENTER);
        Button btnSubmit = new Button("Submit");
        Button btnClear = new Button("Clear");
        Button btnExit = new Button("Exit");
        Label lblConfirm = new Label("Confirmation Number:");
        tfConfirm = new TextField();
        hbButtons.getChildren().addAll(btnSubmit, btnClear, btnExit);
        grid.add(lblConfirm, 0, 0);
        grid.add(tfConfirm, 1, 0);
        grid.add(hbButtons, 0, 2, 2, 1);
        hbButtons.setAlignment(Pos.CENTER);
        btnExit.setOnAction(e -> exit());
        btnSubmit.setOnAction(e -> {
            try {
                submit(Integer.parseInt(tfConfirm.getText()));
            } catch (NumberFormatException o) {
                Alert missingInput = new Alert(Alert.AlertType.ERROR);
                missingInput.setTitle("Error");
                missingInput.setHeaderText(null);
                missingInput.setContentText("Invalid confirmation number.");
                missingInput.showAndWait();
            }
        });
        btnClear.setOnAction(e -> clear());
        return grid;
    }

    /**
     * Creates a row of buttons and makes them all the same size.
     *
     * @return the TilePane
     */
    private TilePane createButtonRow() {
        btnReserve.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnExit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnClear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        TilePane tileButtons = new TilePane(Orientation.HORIZONTAL);
        tileButtons.setPadding(new Insets(20, 10, 20, 0));
        tileButtons.setHgap(10.0);
        tileButtons.setVgap(8.0);
        tileButtons.getChildren().addAll(btnReserve, btnClear, btnExit);
        return tileButtons;
    }

    /**
     * Create the GUI of Overview Reservation tab
     *
     * @return the VBox
     */
    private Pane overviewReservation() {
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        txt = new TextArea();
        HBox hbButtons = new HBox();
        Button btnSubmit = new Button("Submit");
        Button btnClear = new Button("Clear");
        Button btnExit = new Button("Exit");
        txt.setMinHeight(220);
        Label lblCode = new Label("Staff code:");
        tfCode = new TextField();
        btnSubmit.setOnAction(e -> checkAndDisplay(tfCode.getText()));
        hbox.getChildren().addAll(lblCode, tfCode);
        btnExit.setOnAction(e -> exit());
        cmbSort = new ComboBox<>();
        cmbSort.getItems().addAll("sort by last name", "sort by confirmation number");
        cmbSort.setVisible(false);
        btnClear.setOnAction(e -> clear());
        vbox.setSpacing(10);
        hbox.setSpacing(10);
        hbButtons.getChildren().addAll(btnSubmit, btnClear, btnExit);
        vbox.getChildren().addAll(hbox, txt, cmbSort, hbButtons);
        hbButtons.setSpacing(10);
        hbButtons.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        return vbox;
    }

    /**
     * This method is the action(clear all the data that the user input) when
     * users click clear button.
     */
    public void clear() {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfEmail.setText("");
        tfPhoneNumber.setText("");
        tfConfirm.setText("");
        cmbBed.getSelectionModel().select(0);
        cmbRoom.getSelectionModel().select(0);
        checkInDatePicker.setValue(LocalDate.now());
        checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(1));
        txt.setText("");
        tfCode.setText("");
    }

    /**
     * This method calls the addReservation method in the business class and add
     * the customers' information by gathering informations from the user input
     * when the users click add button.
     */
    public void add() {
        if (tfFirstName.getText().isEmpty() || tfLastName.getText().isEmpty()
                || tfPhoneNumber.getText().isEmpty() || tfEmail.getText().isEmpty()) {
            Alert missingInput = new Alert(Alert.AlertType.ERROR);
            missingInput.setTitle("Missing Input");
            missingInput.setHeaderText(null);
            missingInput.setContentText("Make sure you enter all the fields.");
            missingInput.showAndWait();
        }
        try {
            reservation.addReservation(tfFirstName.getText(), tfLastName.getText(),
                    Integer.parseInt(tfPhoneNumber.getText()), tfEmail.getText(),
                    checkInDatePicker, checkOutDatePicker,
                    ChronoUnit.DAYS.between(checkInDatePicker.getValue(), checkOutDatePicker.getValue()),
                    cmbRoom.getValue(), cmbBed.getValue());
        } catch (NumberFormatException e) {
            Alert missingInput = new Alert(Alert.AlertType.ERROR);
            missingInput.setTitle("Wrong Input");
            missingInput.setHeaderText(null);
            missingInput.setContentText("Make sure you enter integer for phone number.");
            missingInput.showAndWait();
        }

    }

    /**
     * This method is the action(display their reservation's details) when users
     * click the submit button
     *
     * @param confirmation the confirmation number of each reservation
     */
    public void submit(long confirmation) {

        Label lblOutput = new Label();
        lblOutput.setWrapText(true);
        lblOutput.setText(reservation.display(confirmation));
        Scene scene = new Scene(lblOutput, 300, 400);
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.show();

    }

    /**
     * This method is the action(save the reservations to the file and close the
     * program) when users click the exit button.
     */
    public void exit() {
        reservation.saveReservation();
        System.exit(0);
    }

    /**
     * This method is the action(check the staff code and display all
     * reservations) of the submit button in the overview tab
     *
     * @param code the staff code
     */
    public void checkAndDisplay(String code) {
        if (code.equals("12a34b")) {
            cmbSort.setVisible(true);
            cmbSort.setOnAction(e -> {
                reservation.sort(cmbSort.getSelectionModel().getSelectedItem());
                txt.setText(reservation.displayReservations());
            });
            txt.setText(reservation.displayReservations());
            txt.setEditable(false);
        } else {
            Alert missingInput = new Alert(Alert.AlertType.ERROR);
            missingInput.setTitle("Wrong Code");
            missingInput.setHeaderText(null);
            missingInput.setContentText("Make sure you enter the right staff code.");
            missingInput.showAndWait();
        }
    }

}
