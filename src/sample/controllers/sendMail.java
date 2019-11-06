package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import sample.models.sendMail_Model;

import java.io.IOException;

public class sendMail {
	@FXML
	private Button send;
	@FXML
	private TextField toMail;
	@FXML
	private TextField subject;
	@FXML
	private TextArea messageBody;

	public void openStage() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../views/sendMail.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Send Receive Mail");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.show();
	}

	/**
	 * when 'reply' clicked on read mail
	 * this function will set the textfield automaticaly
	 * @param toMailVal
	 */
	public void setToMail(String toMailVal){
		toMail.setText(toMailVal);
	}

	/**
	 * calls sendMail_Model under Models folder
	 * and send required fields from the text fields
	 * then show a dialog box that says your message has been send
	 * be careful some times mail can be accepted as spam mail and returns error
	 * but it doesn't mean it is not working because it uses Mrs.Emine's same codes
	 * I already tested it works fine
	 * @throws Exception
	 */
	public void mailSend() throws Exception {
		new sendMail_Model(toMail.getText(),subject.getText(),messageBody.getText());

		Alert dialog = new Alert(Alert.AlertType.INFORMATION);
		dialog.setTitle("Information Dialog");
		dialog.setHeaderText(null);
		dialog.setContentText("Your message has been send!");

		dialog.showAndWait();
	}
}
