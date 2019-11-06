package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import sample.lib.matrices;
import sample.lib.semaphore;
import sample.models.receiveMail_Model;

import java.util.ArrayList;

public class mailBox {
	@FXML
	private ListView listView = new ListView();
	public receiveMail_Model emailList = new receiveMail_Model();
	public sendMail sendMail = new sendMail();
	public readMail readMail = new readMail();

	/**
	 * refreseh the listview
	 * loads the received mails
	 * @throws Exception
	 */
	@FXML
	public void listMails() throws Exception {
		clearListView();
		emailList.clearList();
		populateListview(getEmailList());
	}

	/**
	 * returns the all mail contents
	 * @return
	 * @throws Exception
	 */
<<<<<<< HEAD
	public ArrayList<matrices> getEmailList() throws Exception {
		return emailList.mailList();
	}
=======
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
>>>>>>> cee53b9084de8783f0018ef8b5e7637ac9c40b1e

	public String[] getContent(int index) throws Exception{
		ArrayList<matrices> list = getEmailList();
		String[] data;
		matrices item = list.get(index);
		data = new String[]{
				String.valueOf(item.date)
				, item.subject
				, item.from
				, String.valueOf(item.message)
		};
		return data;
	}
	/**
	 * populates inside of the listview
	 * @param list
	 * @throws Exception
	 */
	public void populateListview(ArrayList<matrices> list) throws Exception {
		for (matrices item: list) {
			listView.getItems().add(
					item.from
					+ " -> " +
					item.subject
			);
		}
	}

	/**
	 * opens sendMail window with an empty tomail variable
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void openSendMail(ActionEvent event) throws Exception{
		sendMail.openStage();
	}

	@FXML
	public void openReadMail(MouseEvent event) throws Exception{
		String[] item = getContent(listView.getSelectionModel().getSelectedIndex());
		readMail.openStage(item);
	}

	/**
	 * closes entire app when it called
	 * @param event
	 */
	public void closeStage(ActionEvent event){
		System.exit(0);
	}

	/**
	 * clears  the items inside listView
	 * every time called
	 */
	public void clearListView(){ listView.getItems().clear(); }
}
