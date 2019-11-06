package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class readMail {

	@FXML
	private Label from;

	@FXML
	private Label date;

	@FXML
	private Label subject;

	@FXML
	private Label body;

	public sendMail sendMail = new sendMail();

	public void openStage(String[] item) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("../views/readMail.fxml"));
		Stage stage = new Stage();
		setData(item);
		stage.setTitle("Send Receive Mail");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.show();
	}
	/**
	 * sets the labels of stage
	 * @param data
	 * @param data
	 */
	public void setData(String[] data) {
		System.out.println(data[0]);
		date.setText(data[0]);
		subject.setText(data[1]);
		from.setText(data[2]);
		body.setText(data[3]);
	}

	/**
	 * calls sendMail methot with requşred field
	 * @throws Exception
	 */
	@FXML
	public void replyMail() throws Exception {
		sendMail.openStage();
		sendMail.setToMail(from.getText());
	}
}
