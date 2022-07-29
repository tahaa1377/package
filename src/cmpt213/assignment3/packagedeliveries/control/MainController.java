package cmpt213.assignment3.packagedeliveries.control;

import cmpt213.assignment3.packagedeliveries.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_add1;

    @FXML
    private Button btn_add11;

    @FXML
    private Button btn_exit;

    @FXML
    private Button btn_show;

    @FXML
    void btn_add_electric_function(ActionEvent event) {

        try {
            Stage stage = (Stage) btn_add11.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getResource("/cmpt213/assignment3/packagedeliveries/view/add_a_electronic.fxml"));
            primaryStage.setTitle("Add a electronic");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btn_add_function(ActionEvent event) {
        try {
            Stage stage = (Stage) btn_add.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getResource("/cmpt213/assignment3/packagedeliveries/view/add_a_book.fxml"));
            primaryStage.setTitle("Add a book");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btn_add_perishble_function(ActionEvent event) {

        try {
            Stage stage = (Stage) btn_add1.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getResource("/cmpt213/assignment3/packagedeliveries/view/add_a_perishble.fxml"));
            primaryStage.setTitle("Add a perishble");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btn_exit_function(ActionEvent event) {
        Main.write_json_file();

        System.exit(0);
    }

    @FXML
    void btn_show_function(ActionEvent event) {

        try {
            Stage stage = (Stage) btn_show.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getResource("/cmpt213/assignment3/packagedeliveries/view/show_packages.fxml"));
            primaryStage.setTitle("show packages");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
