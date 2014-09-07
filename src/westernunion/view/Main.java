package westernunion.view;

import westernunion.controller.MaillerController;

public class Main {

	public static void main(String[] args) {
		try {
			new MaillerController();
		} catch (Exception e) { e.printStackTrace(); }
	}
}
