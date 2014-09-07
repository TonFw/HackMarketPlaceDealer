package westernunion.model;

import java.net.MalformedURLException;
import java.net.URL;

public class ServerConnector {
	public static String domain = "http://westernunion.webatu.com/mailler.php?";
	
	public static URL setupURL(String path) {
		try {
			return new URL(domain+path);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String createPath(String base_path, String value, String param) {
		String return_path = "";
		return_path += base_path + param +  "=" + ServerConnector.get_param(value) +"&";
		return return_path;
	}
	
	public static String get_param(String param_value) {
		return param_value.replaceAll(" ", "+");
	}
}
