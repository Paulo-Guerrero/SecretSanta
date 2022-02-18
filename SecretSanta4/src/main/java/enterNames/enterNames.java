package enterNames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class enterNames {
	private ArrayList<String> allNames;
	private HashMap<String, String> pairs;
	private HashMap<String, String> emails;
	private String email;
	private String rec;
	private int status;
	
	public enterNames() {
		emails = new HashMap<String, String>();
		allNames = new ArrayList<String>();
		pairs = new HashMap<String,String>();
	}
	
	
	public void doProcess(String namesUnparsed, String emailsUnparsed, String msg) {
		
		String[] allEmailsTxt = emailsUnparsed.split("\n");
		String[] allNamesTxt = namesUnparsed.split("\n");
		if(allEmailsTxt.length!=allNamesTxt.length) {
			status=0;
		}else if(allEmailsTxt.length<2) {
			status=1;
		}else {
		for(int i=0;i<allEmailsTxt.length;i++) {
			System.out.println("Adding... "+allNamesTxt[i]);
			System.out.println("Adding... "+allEmailsTxt[i]);
			allNames.add(allNamesTxt[i]);
			emails.put(allNamesTxt[i], allEmailsTxt[i]);
		}

		Random generator = new Random();
		int randomIndex = generator.nextInt(allNames.size());
		String recepient = allNames.get(randomIndex);
		ArrayList<Integer> used = new ArrayList<Integer>();

		for(String name:allNames) {
			while(used.contains(randomIndex) || recepient==name) {
				randomIndex = generator.nextInt(allNames.size());
				recepient = allNames.get(randomIndex);
			}
			used.add(randomIndex);
			recepient = allNames.get(randomIndex);
			pairs.put(name, recepient);
			}
		
		for(String name:allNamesTxt) {
			rec = pairs.get(name);
			email = emails.get(name);
			boolean result = true;
			try {
				InternetAddress emailAddr = new InternetAddress(email);
				emailAddr.validate();
				
			}catch(AddressException ex) {
				result = false;
			}
			if(result) {
			System.out.println("Sending email to... "+name+" at "+email);
			SendEmail send = new SendEmail(email, rec, name, msg);
			send.send();
			}else {
				status=3;
				break;
			}
		}
		if(status!=3) {
			status=2;
		}
		}
		
	}
	public int getStatus() {
		return status;
	}
	
}
