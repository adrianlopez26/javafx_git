module com.empresa.javafx_jdbc_sp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.j;


    opens com.empresa.javafx_jdbc_sp to javafx.fxml;
    exports com.empresa.javafx_jdbc_sp;
}