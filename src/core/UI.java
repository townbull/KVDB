package core;

import java.io.*;

public class UI {
	public static Controller ctl = new Controller();

	public static void main(String[] args) {

		while (true) {

			// prompt the user to enter their name
			System.out.print(">>> ");

			// open up standard input
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String cmd = null;

			// read the username from the command-line; need to use try/catch
			// with
			// the
			// readLine() method
			try {
				cmd = br.readLine();
			} catch (IOException ioe) {
				System.out.println("IO error trying to read your command!");
				System.exit(1);
			}

			// parse the command
			String[] input = cmd.split(" ");
			if ("END".equals(input[0])) {
				break;
			}

			ctl.execute(input);
		}
		
	}
}
