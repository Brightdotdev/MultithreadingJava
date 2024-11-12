module org.example.multithreadingjavapractive {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.multithreadingjavapractive to javafx.fxml;
    exports org.example.multithreadingjavapractive;
    exports org.example.multithreadingjavapractive.Utils;
}