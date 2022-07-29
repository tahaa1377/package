package cmpt213.assignment3.packagedeliveries.control;

import cmpt213.assignment3.packagedeliveries.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.ResourceBundle;

public class ShowPackages implements Initializable {

    @FXML
    private Button add_package_show;

    @FXML
    private VBox vbox;

    @FXML
    private VBox vbox_overdue;

    @FXML
    private VBox vbox_upcoming;


    @FXML
    void add_package_show_function(ActionEvent event) {
        try {
            Stage stage = (Stage) add_package_show.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getResource("/cmpt213/assignment3/packagedeliveries/view/MainController.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Collections.sort(Main.packageArrayList);

        try {

            if (Main.packageArrayList.size() > 0){

                Node[]nodes = new Node[Main.packageArrayList.size()];

                for (int i = 0; i <Main.packageArrayList.size() ; i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(
                        "/cmpt213/assignment3/packagedeliveries/view/item.fxml"));
                 nodes[i] = fxmlLoader.load();


                Item item = fxmlLoader.getController();
                item.setData(Main.packageArrayList.get(i),i);

                vbox.getChildren().add(nodes[i]);

            }

            }else {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(
                        "/cmpt213/assignment3/packagedeliveries/view/empty_package.fxml"));
                Node node = fxmlLoader.load();

                EmptyPackage emptyPackage = fxmlLoader.getController();
                emptyPackage.no_packages_all("No packages to show");

                vbox.getChildren().add(node);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ///////////////////////overdue////////////////////////////////////////////////

        try {

        Node[]nodes = new Node[Main.packageArrayList.size()];

        int index=0;

        if (Main.packageArrayList.size() > 0){

            for (int i = 0; i <Main.packageArrayList.size() ; i++) {

                if (Main.packageArrayList.get(i).getExpected_delivery_date().isBefore(LocalDateTime.now())
                        && !Main.packageArrayList.get(i).isDelivered()
                ) {
                    index++;
//                    System.out.println(Main.packageArrayList.get(i));

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource(
                            "/cmpt213/assignment3/packagedeliveries/view/upcomeing_or_overdue_package.fxml"));

                    nodes[i] = fxmlLoader.load();

                    UpcomeingOrOverduePackage item = fxmlLoader.getController();
                    item.setData_overdue(Main.packageArrayList.get(i),index);

                    vbox_overdue.getChildren().add(nodes[i]);

                }
            }

        }else {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(
                    "/cmpt213/assignment3/packagedeliveries/view/empty_package.fxml"));
            Node node = fxmlLoader.load();

            EmptyPackage emptyPackage = fxmlLoader.getController();
            emptyPackage.no_packages_all("No packages to show");

            vbox_overdue.getChildren().add(node);

        }

        if (index==0){

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(
                    "/cmpt213/assignment3/packagedeliveries/view/empty_package.fxml"));
            Node node = fxmlLoader.load();

            EmptyPackage emptyPackage = fxmlLoader.getController();
            emptyPackage.no_packages_all("No overdue packages to show.");

            vbox_overdue.getChildren().add(node);

        }

        } catch (IOException e) {
            e.printStackTrace();
        }



        ///////////////////////upcoming////////////////////////////////////////////////

        try {

        Node[]nodes = new Node[Main.packageArrayList.size()];

        int index=0;

        if (Main.packageArrayList.size() > 0){

            for (int i = 0; i <Main.packageArrayList.size() ; i++) {

                if (Main.packageArrayList.get(i).getExpected_delivery_date().isAfter(LocalDateTime.now())
                        && !Main.packageArrayList.get(i).isDelivered()
                ) {
                    index++;

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource(
                            "/cmpt213/assignment3/packagedeliveries/view/upcomeing_or_overdue_package.fxml"));

                    nodes[i] = fxmlLoader.load();

                    UpcomeingOrOverduePackage item = fxmlLoader.getController();
                    item.setData_overdue(Main.packageArrayList.get(i),index);

                    vbox_upcoming.getChildren().add(nodes[i]);

                }
            }

        }else {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(
                    "/cmpt213/assignment3/packagedeliveries/view/empty_package.fxml"));
            Node node = fxmlLoader.load();

            EmptyPackage emptyPackage = fxmlLoader.getController();
            emptyPackage.no_packages_all("No packages to show");

            vbox_upcoming.getChildren().add(node);

        }

        if (index==0){

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(
                    "/cmpt213/assignment3/packagedeliveries/view/empty_package.fxml"));
            Node node = fxmlLoader.load();

            EmptyPackage emptyPackage = fxmlLoader.getController();
            emptyPackage.no_packages_all("No upcoming packages to show.");

            vbox_upcoming.getChildren().add(node);

        }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
