module com.example.sistemavendas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.sistemavendas to javafx.fxml;
    opens com.example.sistemavendas.controllers to javafx.fxml;

    exports com.example.sistemavendas;
}