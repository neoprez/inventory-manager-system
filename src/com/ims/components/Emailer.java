package com.ims.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ims.classes.InventoryProduct;

public class Emailer {
	private Properties properties;
	private String HOST;
	private String PORT;
	private String AUTH;
	private String TTLS_ENABLE;
	private Session session;
	private String FROM;
	private String SERVER_EMAIL;
	private String SERVER_EMAIL_PASSWORD;
	private static final String EMAIL_TEMPLATE_STYLE = "<link href='https://fonts.googleapis.com/css?family=Erica+One' rel='stylesheet' type='text/css'><style>" +
			"table { margin: 0 auto; width: 768px; font-family:  Arial, Helvetica, sans-serif; border-collapse: collapse;}" +
			"table td, table th { padding: 10px; }" +
			"table h1 { font-family:  'Erica One', cursive;}" +
			"h1, h3, p {text-align: center; margin: 0; }" +
			".logo h1 { font-size: 72px;} " +
			".logo p { margin-top: -20px; color: #5D5D5D; }" +
			"h3 { text-transform: uppercase; color: #F44336; font-weight: bold; }" +
			"tbody td, tbody th { border: 1px solid #000; }" +
			"tbody td, tbody th { border-top: 0; border-left: 0; border-right: 0; }" +
			"tbody th { border-top: 1px solid #000;}" +
			"tbody td:first-child, th:first-child { border-left: 1px solid #000;}"+
			"tbody td:last-child, th:last-child {border-right: 1px solid #000;}" +
			".header { background-color: #FFEB3B;font-weight: bold;text-transform: uppercase;}"+
			"</style>";
	private static final String EMAIL_TEMPLATE_HEADER = "<table>" +
			"<thead><tr><td class=\"logo\" colspan=\"3\">" +
			"<h1>IMS</h1><p>Notification System</p></td></tr><tr><td colspan=\"3\">" +
			"<h3>These products need to be restocked</h3></td></tr></thead>" +
			"<tbody><tr class=\"header\"><th>Product UPC</th><th>Product name</th><th>Current Count</th></tr>";
	private static final String EMAIL_TEMPLATE_FOOTER = "</tbody></table>";
	/*
	 * Load email configuration file.
	 */
	{
		FileReader fr = null; 
		BufferedReader br = null;

		try {
			fr = new FileReader(new File("emailconfig.json"));
			br = new BufferedReader(fr);

			String jsonString = br.readLine();

			try {
				JSONParser jp 	= new JSONParser();
				Object obj 		= jp.parse(jsonString);

				JSONObject jo 	= (JSONObject)obj;
				HOST 			= (String)jo.get("host");
				PORT 			= (String)jo.get("port");
				AUTH 			= (String)jo.get("auth");
				TTLS_ENABLE		= (String)jo.get("ttls");
				FROM			= (String)jo.get("from");
				SERVER_EMAIL	= (String)jo.get("serverEmail");
				SERVER_EMAIL_PASSWORD = (String)jo.get("serverEmailPassword");

			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null ){
					fr.close();
				}	

				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	public Emailer() {
		properties = new Properties();
		properties.put("mail.smtp.starttls.enable", TTLS_ENABLE);
		
		properties.put("mail.smtp.host", HOST);
		properties.put("mail.smtp.port", PORT);
		properties.put("mail.smtp.auth", AUTH);
		
		// Get the default session object
		session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SERVER_EMAIL, SERVER_EMAIL_PASSWORD);
			}
		});
	}
	
	public void sendEmail(String to, ArrayList<InventoryProduct> products) {
		try {
			// Create a default MimeMessage etc.
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(FROM));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Product Restock Notification");
			
			String productsStr = Emailer.EMAIL_TEMPLATE_STYLE + Emailer.EMAIL_TEMPLATE_HEADER;
			
			for(InventoryProduct product : products) {
				productsStr += "<tr><td><a href='#'>" + product.getUpc() + "</a></td><td>" +
							product.getName() + "</td><td>" +
							product.getCount()
						+ "</td></tr>";
			}
			productsStr += Emailer.EMAIL_TEMPLATE_FOOTER;
			
			message.setContent(productsStr, "text/html; charset=utf-8");
			
			Transport.send(message);
			System.out.println("Email sent");
		} catch( MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
