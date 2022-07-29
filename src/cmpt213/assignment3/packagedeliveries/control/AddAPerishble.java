package cmpt213.assignment3.packagedeliveries.control;

import cmpt213.assignment3.packagedeliveries.Main;
import cmpt213.assignment3.packagedeliveries.model.Electronic;
import cmpt213.assignment3.packagedeliveries.model.PackageFactory;
import cmpt213.assignment3.packagedeliveries.model.Perishable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddAPerishble {

    @FXML
    private Button btn_cancel_perishable;

    @FXML
    private Button btn_create_perishable;

    @FXML
    private DatePicker datePicker_delivery_date_perishable;

    @FXML
    private DatePicker datePicker_expairy_date_perishable1;

    @FXML
    private TextField input_name_perishable;

    @FXML
    private TextField input_note_perishable;

    @FXML
    private TextField input_price_perishable;

    @FXML
    private TextField input_weight_perishable;


    private LocalDate dateTime_delivery;
    private LocalDate dateTime_expiry;


    @FXML
    void btn_create_function_perishable(ActionEvent event) {


        String d[] = dateTime_delivery.toString().split("-");
        String d1[] = dateTime_expiry.toString().split("-");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);

        int year1 = Integer.parseInt(d1[0]);
        int month1 = Integer.parseInt(d1[1]);
        int day1 = Integer.parseInt(d1[2]);

        LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime expiry_dateTime = LocalDateTime.of(year1, month1, day1, 0, 0);

        PackageFactory packageFactory = new PackageFactory();
        Perishable p_perishable = (Perishable) packageFactory.getPackage("perishable",input_name_perishable.getText(),input_note_perishable.getText(),Double.parseDouble(input_price_perishable.getText()),Double.parseDouble(input_weight_perishable.getText()),false,dateTime);
        p_perishable.setExpiry_date(expiry_dateTime);

        Main.packageArrayList.add(p_perishable);

        System.out.println(Main.packageArrayList);

        try {
            Stage stage = (Stage) btn_cancel_perishable.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getResource("/cmpt213/assignment3/packagedeliveries/view/MainController.fxml"));
            primaryStage.setTitle("Add a package");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void btn_cancel_function_perishable(ActionEvent event) {
        try {
            Stage stage = (Stage) btn_cancel_perishable.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getResource("/cmpt213/assignment3/packagedeliveries/view/MainController.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void get_date_perishable(ActionEvent event) {
        dateTime_delivery  = datePicker_delivery_date_perishable.getValue();

    }

    @FXML
    void get_date_perishable_expairy(ActionEvent event) {
        dateTime_expiry  = datePicker_expairy_date_perishable1.getValue();

    }

}
