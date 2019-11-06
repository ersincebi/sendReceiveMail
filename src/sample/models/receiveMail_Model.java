package sample.models;

import sample.lib.mailInfo;
import sample.lib.matrices;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Properties;


public class receiveMail_Model {
    public ArrayList<matrices> list = new ArrayList<matrices>();
    public ArrayList mailList() throws Exception {
        clearList();
        mailInfo info = new mailInfo();
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", info.getProtocol());

        Session session = Session.getInstance(props, null);
        Store store = session.getStore(info.getProtocol());
        store.connect(info.getHost(), info.getUser(), info.getPassword());

        Folder[] f = store.getDefaultFolder().list();

        Folder messages = store.getFolder("INBOX");
        messages.open(Folder.READ_ONLY);

        for (int i=messages.getMessageCount();i>0;i--){
            Message message = messages.getMessage(i);
            Address[] address = message.getFrom();
            String from = address == null ? null : ((InternetAddress) address[0]).getAddress();

            list.add(new matrices(
                    message.getReceivedDate()
                    ,message.getSubject()
                    ,from
                    ,message.getContent()));
        }

        return list;
    }

    /**
     * clears  the items inside array list
     * every time receive_model called
     */
    public void clearList(){
        list.clear();
    }
}

