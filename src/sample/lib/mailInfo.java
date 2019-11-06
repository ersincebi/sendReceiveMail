package sample.lib;

public class mailInfo {
	public String protocol = "imaps";
	public String host = "imap.gmail.com";
	public String user = "cse482atisik@gmail.com";
	public String password = "EmineEkin";
	public String smtpHost = "smtp.google.com";

	public String getProtocol() { return protocol; }

	public String getHost() { return host; }

	public String getSmtpHost() { return smtpHost; }

	public String getUser() {
		return user;
	}

	public String getPassword() { return password; }

}
