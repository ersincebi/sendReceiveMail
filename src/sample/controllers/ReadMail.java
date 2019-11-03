package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class ReadMail {

	@FXML
	private Label from;

	@FXML
	private Label date;

	@FXML
	private Label subject;

	@FXML
	private Label body;

	/**
	 * sets the text of date label
	 * @param date
	 */
	public void setDate(Label date) {
		date.setText(String.valueOf(date));
	}

	/**
	 * sets the text of from label
	 * @param from
	 */
	public void setFrom(Label from) {
		from.setText(String.valueOf(from));;
	}

	/**
	 * sets the text of subject label
	 * @param subject
	 */
	public void setSubject(Label subject) {
		subject.setText(String.valueOf(subject));;
	}

	/**
	 * sets the text of messageBody label
	 * @param body
	 */
	public void setBody(Label body) {
		body.setText(String.valueOf(body));;
	}

	/**
	 * calls sendMail methot with requşred field
	 * @throws Exception
	 */
	@FXML
	public void replyMail() throws Exception {
		// new sendMail(from.getText());
	}
}
