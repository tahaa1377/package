module fx.project {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens cmpt213.assignment3.packagedeliveries to javafx.fxml;
    exports cmpt213.assignment3.packagedeliveries;


}