package vn.coder.student.data;


public class ReaderFactory {
	public static Reader getReader(String readerType) {
		Reader reader = null;
		if (readerType.equalsIgnoreCase("XML")) {
			reader = new XMLReader();
		} else if (readerType.equalsIgnoreCase("CSV")) {
			reader = new CSVReader();
		} else if (readerType.equalsIgnoreCase("JSON")) {
			reader = new JsonReader();
		}
		return reader;
	}
}
