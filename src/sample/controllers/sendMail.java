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
import sample.lib.mailInfo;
import sample.models.sendMail_Model;

public class sendMail {
	@FXML
	private Button send;
	@FXML
	private TextField toMail;
	@FXML
	private TextField subject;
	@FXML
	private TextArea messageBody;

	/**
	 * initializer of send mail takes empty or filled toMail value and calls open stage
	 * according to toMail value it fills the 'toMail' text field
	 * @param tomail
	 * @throws Exception
	 */
	/*public sendMail(String tomail) throws Exception{
		if(!tomail.isEmpty())
			toMail.setText(tomail);
	}*/

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
		mailInfo info = new mailInfo();
		new sendMail_Model(info.getUser(),info.getPassword(),toMail.getText(),subject.getText(),messageBody.getText());

		Alert dialog = new Alert(Alert.AlertType.INFORMATION);
		dialog.setTitle("Information Dialog");
		dialog.setHeaderText(null);
		dialog.setContentText("Your message has been send!");

		dialog.showAndWait();
	}
}
