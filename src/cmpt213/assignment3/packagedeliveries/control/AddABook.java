package cmpt213.assignment3.packagedeliveries.control;

import cmpt213.assignment3.packagedeliveries.Main;
import cmpt213.assignment3.packagedeliveries.model.Book;
import cmpt213.assignment3.packagedeliveries.model.PackageFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class AddABook {

    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_create;

    @FXML
    private DatePicker datePicker_delivery_date;

    @FXML
    private TextField input_author;

    @FXML
    private TextField input_name;

    @FXML
    private TextField input_note;

    @FXML
    private TextField input_price;

    @FXML
    private TextField input_weight;


    private LocalDate dateTime1;


    @FXML
    void btn_create_function(ActionEvent event) {


        String d[] = dateTime1.toString().split("-");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0);

        PackageFactory packageFactory = new PackageFactory();
        Book p_book = (Book) packageFactory.getPackage("book",input_name.getText(),input_note.getText(),Double.parseDouble(input_price.getText()),Double.parseDouble(input_weight.getText()),false,dateTime);
        p_book.setAuthor_name(input_author.getText());

        Main.packageArrayList.add(p_book);

        System.out.println(Main.packageArrayList);

        try {
            Stage stage = (Stage) btn_cancel.getScene().getWindow();
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
    void btn_cancel_function(ActionEvent event) {

        try {
            Stage stage = (Stage) btn_cancel.getScene().getWindow();
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
    void get_date(ActionEvent event) {
         dateTime1  = datePicker_delivery_date.getValue();
    }


}
