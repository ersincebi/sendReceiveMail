package sample.models;

import com.sun.mail.imap.IMAPFolder;
import sample.lib.mailInfo;

import javax.mail.*;
import java.util.ArrayList;
import java.util.Properties;


public class receiveMail_Model {
    public ArrayList mailList() throws Exception {
        mailInfo info = new mailInfo();
        IMAPFolder folder = null;
        Store store = null;

        ArrayList list = new ArrayList();

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", info.getProtocol());

        Session session = Session.getDefaultInstance(props, null);

        store = session.getStore(info.getProtocol());
        store.connect(info.getHost(),info.getUser(), info.getPassword());

        folder = (IMAPFolder) store.getFolder("inbox");


        if(!folder.isOpen())
            folder.open(Folder.READ_WRITE);
        Message[] messages = folder.getMessages();


        for (int i=0; i < messages.length;i++) {
            Message msg =  messages[i];
            list.add(msg);
        }

        return list;
    }
}

