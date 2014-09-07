package westernunion.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;

public class Network {
	public String ip;
	public String host;
	public String mac_address;
	
	public Network() {
		try {
			this.ip = this.getIP();
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("Current IP address: " + ip.getHostAddress());
			this.host = ip.getHostName();
			System.out.println("HostName: " + this.host); 
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
	 
			byte[] mac = network.getHardwareAddress();
	 
			System.out.print("Current MAC address: ");
	 
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			
			this.mac_address = sb.toString();
			System.out.println(sb.toString());
		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	private String getIP() {
		URL myIP;
		try {
			myIP = new URL("http://myip.dnsomatic.com/");
			BufferedReader in = new BufferedReader(new InputStreamReader(myIP.openStream()));
			return ""+in.readLine();
		} catch (Exception e) { e.printStackTrace(); }
		return "IP not found";
	}
}