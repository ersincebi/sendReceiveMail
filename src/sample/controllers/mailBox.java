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
	public ArrayList<matrices> getEmailList() throws Exception {
		return emailList.mailList();
	}


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
