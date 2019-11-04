package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sample.models.receiveMail_Model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;

public class mailBox {
	@FXML
	private ListView listView = new ListView();

	/**
	 * refreseh the listview
	 * loads the received mails
	 * @throws Exception
	 */
	@FXML
	public void listMails() throws Exception {
		receiveMail_Model emailList = new receiveMail_Model();
		ArrayList list = emailList.mailList();
		for (Object listItem:list) {
			listView.getItems().add(mailData(listItem));
		}
	}

	/**
	 * it runs when it called by listMail
	 * returns the readable data for users
	 * @param item
	 * @return
	 * @throws Exception
	 */
	public String mailData(Object item) throws Exception {
		Message message = (Message) item;
		Multipart multiPart = (Multipart) message.getContent();
		BodyPart bodyPart = multiPart.getBodyPart(0);
		Address[] froms = message.getFrom();
		String email = froms == null ? null : ((InternetAddress) froms[0]).getAddress();

		String data = message.getReceivedDate() + " -> " + message.getSubject() + " -> " + email;

		// System.out.println(message.getReceivedDate());
		// System.out.println(message.getSubject());
		// System.out.println(email);
		// System.out.println(bodyPart.getContent());

		return data;
	}

	/**
	 * opens sendMail window with an empty tomail variable
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void openSendMail(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("../views/sendMail.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Send Receive Mail");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.show();
	}

	@FXML
	public void openReadMail(ActionEvent event) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("../views/readMail.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Send Receive Mail");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.show();
	}

	/**
	 * closes entire app when it called
	 * @param event
	 */
	public void closeStage(ActionEvent event){
		System.exit(0);
	}
}
