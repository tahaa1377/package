package cmpt213.assignment3.packagedeliveries.control;

import cmpt213.assignment3.packagedeliveries.Main;
import cmpt213.assignment3.packagedeliveries.model.Book;
import cmpt213.assignment3.packagedeliveries.model.Electronic;
import cmpt213.assignment3.packagedeliveries.model.PackageFactory;
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

public class AddAElectronic {

    @FXML
    private Button btn_cancel_electronic;

    @FXML
    private Button btn_create_electronic;

    @FXML
    private DatePicker datePicker_delivery_date_electronic;

    @FXML
    private TextField input_environment_electronic;

    @FXML
    private TextField input_name_electronic;

    @FXML
    private TextField input_note_electronic;

    @FXML
    private TextField input_price_electronic;

    @FXML
    private TextField input_weight_electronic;


    private LocalDate dateTime1;


    @FXML
    void btn_create_function_electronic(ActionEvent event) {


        String d[] = dateTime1.toString().split("-");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0);

        PackageFactory packageFactory = new PackageFactory();
        Electronic p_electronic = (Electronic) packageFactory.getPackage("electronic",input_name_electronic.getText(),input_note_electronic.getText(),Double.parseDouble(input_price_electronic.getText()),Double.parseDouble(input_weight_electronic.getText()),false,dateTime);
        p_electronic.setEnvironmental_handling_fee(Double.parseDouble(input_environment_electronic.getText()));

        Main.packageArrayList.add(p_electronic);

        System.out.println(Main.packageArrayList);


        try {
            Stage stage = (Stage) btn_cancel_electronic.getScene().getWindow();
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
    void btn_cancel_function_electronic(ActionEvent event) {
        try {
            Stage stage = (Stage) btn_cancel_electronic.getScene().getWindow();
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
    void get_date_electronic(ActionEvent event) {
        dateTime1  = datePicker_delivery_date_electronic.getValue();

    }

}
