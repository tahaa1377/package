package cmpt213.assignment3.packagedeliveries.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EmptyPackage {

    @FXML
    private Label no_packages_to_show;


    public void no_packages_all(String s){
        no_packages_to_show.setText(s);
    }


}
