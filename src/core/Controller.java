package core;

import java.util.Stack;

public class Controller {
	public static DB db = new DB();
	public static Stack<DB> cache = new Stack<DB>();

	public void execute(String[] input) {

		switch (input[0]) {
		case "SET":

			// store rollback value in the stack top db
			// note: "NULL" will be stored as well
			String vs = db.getValue(input[1]);
			if (!cache.isEmpty())
				if (!cache.peek().countainsKey(input[1]))
					cache.peek().setValue(input[1], vs);

			db.setValue(input[1], input[2]);
			break;
		case "GET":
			System.out.println(db.getValue(input[1]));
			break;
		case "DELETE":
			// store rollback value in the stack top db
			// note: "NULL" will be stored as well
			String vd = db.getValue(input[1]);
			if (!cache.isEmpty())
				if (!cache.peek().countainsKey(input[1]))
					cache.peek().setValue(input[1], vd);

			db.deleteValue(input[1]);
			break;
		case "COUNT":
			System.out.println(db.countValue(input[1]));
			break;
		case "BEGIN":
			DB tmpb = new DB();
			cache.push(tmpb);
			break;
		case "ROLLBACK":
			if (cache.empty())
				System.out.println("NULL");
			db.copyValues(cache.pop());
			break;
		case "COMMIT":
			cache = new Stack<DB>();
			break;
		default:
			System.out.println("Syntax Error");
			break;
		}
	}
}
