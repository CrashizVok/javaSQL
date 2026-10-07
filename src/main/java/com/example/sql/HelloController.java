package com.example.sql;

import com.mysql.cj.xdevapi.InsertResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML public TextField input_host;
    @FXML public Spinner<Integer> number_port;
    @FXML public TextField input_username;
    @FXML public PasswordField input_password;
    @FXML public TextField input_database_name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        String dbHost = EnvLoader.get("DB_HOST");
        int dbPort = Integer.parseInt(EnvLoader.get("DB_PORT"));
        String dbUsername = EnvLoader.get("DB_NAME");
        String dbPassword = EnvLoader.get("DB_PASSWORD");
        String dbDatabase = EnvLoader.get("DB_DATABASE");

        input_host.setText(dbHost);
        input_username.setText(dbUsername);
        input_password.setText(dbPassword);
        input_database_name.setText(dbDatabase);



    }

    public void handleConnectClick(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String jdbcConnStr = String.format("jdbc:mysql://%s:%d/%s",


                input_host.getText(),
                3306,
                input_database_name.getText()
        );
        Connection conn = DriverManager.getConnection(jdbcConnStr, input_username.getText(),input_password.getText());
        System.out.println(conn);
    }
}