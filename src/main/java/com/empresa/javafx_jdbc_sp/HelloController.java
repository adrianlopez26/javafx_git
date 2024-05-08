package com.empresa.javafx_jdbc_sp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nombre;

    @FXML
    private TextField ciudad;

    @FXML
    private TextField facturacion;

    @FXML
    protected void onHelloButtonClick() {

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, user, password);
            String insertarsp = "CALL sp_add_clientesfx(?, ?, ?);";
            CallableStatement cs = conexion.prepareCall(insertarsp);
            cs.setString(1, nombre.getText());
            cs.setString(2, ciudad.getText());
            cs.setString(3, facturacion.getText());
            int filas = cs.executeUpdate();

            nombre.clear();
            ciudad.clear();
            facturacion.clear();

            System.out.println("Gegistros Guardados: " + filas);
            welcomeText.setText("Cliente Guardado");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}