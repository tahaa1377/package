package cmpt213.assignment3.packagedeliveries.control;

import cmpt213.assignment3.packagedeliveries.Main;
import cmpt213.assignment3.packagedeliveries.model.Book;
import cmpt213.assignment3.packagedeliveries.model.Electronic;
import cmpt213.assignment3.packagedeliveries.model.Package;
import cmpt213.assignment3.packagedeliveries.model.Perishable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Item {

    @FXML
    private Button btn_remove;

    @FXML
    private Label package_description;

    @FXML
    private Label pakage_title_info;

    @FXML
    private CheckBox radiobutton_delivered;


    @FXML
    void deilverd_function(ActionEvent event) {

        int n = Integer.parseInt(pakage_title_info.getText().split(" ")[1].replace("#",""));

        for (int i = 0; i < Main.packageArrayList.size() ; i++) {
            if ((i+1) == n){
                Main.packageArrayList.get(i).setDelivered(true);
                break;
            }
        }

        try {
            Stage stage = (Stage) btn_remove.getScene().getWindow();
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


    @FXML
    void btn_remove_function(ActionEvent event) {

        int n = Integer.parseInt(pakage_title_info.getText().split(" ")[1].replace("#",""));

        for (int i = 0; i < Main.packageArrayList.size() ; i++) {
            if ((i+1) == n){
                Main.packageArrayList.remove(i);
                break;
            }
        }

        try {
            Stage stage = (Stage) btn_remove.getScene().getWindow();
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

    public void setData(Package aPackage,int i){

        switch (aPackage.getClass().getSimpleName()) {
            case "Book": {

                Book book = (Book) aPackage;
                //////////////////////////////////////////////////////////////
                pakage_title_info.setText("Package #" + ( i+ 1) +(" (Book)"));
                package_description.setText(
                        "Package: " + aPackage.getName() + "\n" +
                        "author: " + book.getAuthor_name() + "\n" +
                        "Notes: " + aPackage.getNotes() + "\n" +
                        "Price: $" + aPackage.getPrice() + "\n" +
                        "Weight: " + aPackage.getWeight() + "kg\n" +
                        "Expected Delivery Date: " +
                        String.valueOf(aPackage.getExpected_delivery_date()).
                                replace("T", " ")
                );
                radiobutton_delivered.setSelected(aPackage.isDelivered());
                //////////////////////////////////////////////////////////////
                if (radiobutton_delivered.isSelected()){
                    radiobutton_delivered.setDisable(true);
                }
                break;
            }
            case "Electronic": {

                Electronic electronic = (Electronic) aPackage;

                //////////////////////////////////////////////////////////////
                pakage_title_info.setText("Package #" + (i + 1)+(" (Electronic)"));
                package_description.setText(
                        "Package: " + aPackage.getName() + "\n" +
                        "Notes: " + aPackage.getNotes() + "\n" +
                        "Price: $" + aPackage.getPrice() + "\n" +
                        "Environmental handling fee: $" + electronic.getEnvironmental_handling_fee() + "\n" +
                        "Weight: " + aPackage.getWeight() + "kg\n" +
                        "Expected Delivery Date: " +
                        String.valueOf(aPackage.getExpected_delivery_date()).
                                replace("T", " ")
                );
                radiobutton_delivered.setSelected(aPackage.isDelivered());
                //////////////////////////////////////////////////////////////
                if (radiobutton_delivered.isSelected()){
                    radiobutton_delivered.setDisable(true);
                }

                break;
            }
            case "Perishable": {

                Perishable perishable = (Perishable) aPackage;
                //////////////////////////////////////////////////////////////
                pakage_title_info.setText("Package #" + (i + 1)+(" (Perishable)"));
                package_description.setText(
                        "Package: " + aPackage.getName() + "\n" +
                        "Notes: " + aPackage.getNotes() + "\n" +
                        "Price: $" + aPackage.getPrice() + "\n" +
                        "Weight: " + aPackage.getWeight() + "kg\n" +
                        "Expected Delivery Date: " +
                        String.valueOf(aPackage.getExpected_delivery_date()).
                                replace("T", " ") + "\n" +
                        "Expiry Date: " +
                        String.valueOf(perishable.getExpiry_date()).
                                replace("T", " ") + "\n"
                );
                radiobutton_delivered.setSelected(aPackage.isDelivered());

                if (radiobutton_delivered.isSelected()){
                    radiobutton_delivered.setDisable(true);
                }

                break;
            }
        }



    }






}
