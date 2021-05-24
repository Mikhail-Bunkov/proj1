package server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class Controller {

Server server;







	public void tryToAuth(ActionEvent actionEvent) {
	server.connect();
	}







	public void showRegWindow(ActionEvent actionEvent) {
	}
}
