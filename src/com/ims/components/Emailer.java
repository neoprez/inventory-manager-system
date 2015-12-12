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
			
			String productsStr = "<style> thead td { background-color: #FFE700; font-weight: bold; }"
					+ " table { border: 1px solid #E5E4DA; } table td { padding: 10px; } </style><h1 style=\"color: ##990000;\">"
					+ "These products need to be restocked</h1><table> <thead>"
					+ "<td>Product UPC</td><td>Product Name</td> <td>Current Count</td></thead>"
					+ "<tbody>";
			
			for(InventoryProduct product : products) {
				productsStr += "<tr><td>" + product.getUpc() + "</td><td>" +
							product.getName() + "</td><td>" +
							product.getCount()
						+ "</td></tr>";
			}
			productsStr += "</tbody></table>";
			
			message.setContent(productsStr, "text/html; charset=utf-8");
			
			Transport.send(message);
			System.out.println("Message sent");
		} catch( MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
