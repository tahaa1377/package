package cmpt213.assignment3.packagedeliveries.control;

import cmpt213.assignment3.packagedeliveries.model.Book;
import cmpt213.assignment3.packagedeliveries.model.Electronic;
import cmpt213.assignment3.packagedeliveries.model.Package;
import cmpt213.assignment3.packagedeliveries.model.Perishable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UpcomeingOrOverduePackage implements Initializable {

    @FXML
    private Label package_description_up;

    @FXML
    private Label pakage_title_info_up;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData_overdue(Package aPackage , int i){

        switch (aPackage.getClass().getSimpleName()) {
            case "Book": {

                Book book = (Book) aPackage;
                //////////////////////////////////////////////////////////////
                pakage_title_info_up.setText("Package #" + (i)+(" (Book)"));
                package_description_up.setText(
                        "Package: " + aPackage.getName() + "\n" +
                                "author: " + book.getAuthor_name() + "\n" +
                                "Notes: " + aPackage.getNotes() + "\n" +
                                "Price: $" + aPackage.getPrice() + "\n" +
                                "Weight: " + aPackage.getWeight() + "kg\n" +
                                "Expected Delivery Date: " +
                                String.valueOf(aPackage.getExpected_delivery_date()).
                                        replace("T", " ")
                );
                //////////////////////////////////////////////////////////////

                break;
            }
            case "Electronic": {

                Electronic electronic = (Electronic) aPackage;
                //////////////////////////////////////////////////////////////
                pakage_title_info_up.setText("Package #" + (i)+(" (Electronic)"));
                package_description_up.setText(
                        "Package: " + aPackage.getName() + "\n" +
                                "Notes: " + aPackage.getNotes() + "\n" +
                                "Price: $" + aPackage.getPrice() + "\n" +
                                "Environmental handling fee: $" + electronic.getEnvironmental_handling_fee() + "\n" +
                                "Weight: " + aPackage.getWeight() + "kg\n" +
                                "Expected Delivery Date: " +
                                String.valueOf(aPackage.getExpected_delivery_date()).
                                        replace("T", " ")
                );
//                System.out.println();
                //////////////////////////////////////////////////////////////


                break;
            }
            case "Perishable": {

                Perishable perishable = (Perishable) aPackage;
                //////////////////////////////////////////////////////////////
                pakage_title_info_up.setText("Package #" + (i)+(" (Perishable)"));
                package_description_up.setText(
                        "Package: " + aPackage.getName() + "\n" +
                                "Notes: " + aPackage.getNotes() + "\n" +
                                "Price: $" + aPackage.getPrice() + "\n" +
                                "Weight: " + aPackage.getWeight() + "kg\n" +
                                "Expected Delivery Date: " +
                                String.valueOf(aPackage.getExpected_delivery_date()).
                                        replace("T", " ") + "\n" +
                                "Expiry Date: " +
                                String.valueOf(perishable.getExpiry_date()).
                                        replace("T", " ")
                );
//                System.out.println();
                //////////////////////////////////////////////////////////////

                break;
            }
        }

    }

}
