package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.lib.matrices;
import sample.models.receiveMail_Model;
import sample.models.sendMail_Model;

import java.io.File;
import java.util.ArrayList;

public class mailBox {
	@FXML
	private Stage stage;
	@FXML
	private ListView listView = new ListView();
	@FXML
	private Button send;
	@FXML
	private Label date;
	@FXML
	private TextField eMail;
	@FXML
	private TextField subject;
	@FXML
	private TextArea messageBody;
	@FXML
	private Label filePath;

	public receiveMail_Model emailList = new receiveMail_Model();

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
	 * calls sendMail_Model under Models folder
	 * and send required fields from the text fields
	 * then show a dialog box that says your message has been send
	 * be careful some times mail can be accepted as spam mail and returns error
	 * but it doesn't mean it is not working because it uses Mrs.Emine's same codes
	 * I already tested it works fine
	 * @throws Exception
	 */
	public void mailSend() throws Exception {
		new sendMail_Model(eMail.getText(),subject.getText(),messageBody.getText(),filePath.getText());

		Alert dialog = new Alert(Alert.AlertType.INFORMATION);
		dialog.setTitle("Information Dialog");
		dialog.setHeaderText(null);
		dialog.setContentText("Your message has been send!");

		dialog.showAndWait();
	}

	/**
	 * resets the mail section for new mail to send
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void openSendMail(ActionEvent event) throws Exception{
		date.setText("");
		subject.setText("");
		eMail.setText("");
		messageBody.setText("");
	}


	/**
	 * resets every field except mail field of mail section for replying the mail
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void replySendMail(ActionEvent event) throws Exception{
		date.setText("");
		subject.setText("");
		messageBody.setText("");
	}

	@FXML
	public void openReadMail(MouseEvent event) throws Exception{
		String[] item = getContent(listView.getSelectionModel().getSelectedIndex());

		subject.setText(item[1]);
		eMail.setText(item[2]);
		messageBody.setText(item[3]);
	}

	@FXML
	public void openFile(){
		FileChooser fileChooser = new FileChooser();

		File file = fileChooser.showOpenDialog(stage);

		filePath.setText(String.valueOf(file));

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
