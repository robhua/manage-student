package vn.coder.student.data;

public class TableFactory {

	public static DbTable createTable(String type) {
		DbTable db = null;
		if (type.equalsIgnoreCase("oracle")) {
			db = new OracleTable();
		} else if (type.equalsIgnoreCase("mysql")) {
			db = new MySqlTable();
		} else if (type.equalsIgnoreCase("hsql")) {
			db = new HSqlTable();
		}
		return db; // default is mysql
	}
}
