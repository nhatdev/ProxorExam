import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class WriteHtml {
	public static final String inFileName = "input.csv";
	public static final String outFileName = "output.html";
	public static final String[] headerValues = {
			"<html>",
			"<head>",
			"</head>",
			"<body>",
			"<table style=" + "\"" + "text-align: left;" + "\"" + " border="
					+ "\"" + 1 + "\"" + "" + " cellpadding=" + "\"" + 2 + "\""
					+ " cellspacing=" + "\"" + 2 + "\"" + ">", "<tbody>" };
	public static final String[] footerValues = { "</tbody>", "</table>",
			"<br>", "</body>", "</html>" };

	public static void main(String[] args) {
		// ... insert code here ...
		// Do not change the signature of this method.
		CsvReader reader = null;
		CsvWriter writer = null;
		try {
			reader = new CsvReader(inFileName);

			writer = new CsvWriter(outFileName);
			writer.setEscapeMode(1);
			writer.setTextQualifier(Character.MIN_VALUE);
			writer.setUseTextQualifier(true);
//			writer.setUseTextQualifier(false);
			for (String string : headerValues) {
				writer.write(string, true);
				writer.endRecord();
			}

			while (reader.readRecord()) {
				writer.write("<tr>", true);
				writer.endRecord();
				for (String val : reader.getValues()) {
					String newVal = EscapeHTML.stringToHTMLString(val);
					writer.write("<td>" + newVal + "<br>");
					writer.endRecord();
					writer.write("</td>", true);
					writer.endRecord();
				}
				writer.write("</tr>", true);
				writer.endRecord();
			}

			for (String string : footerValues) {
				writer.write(string, true);
				writer.endRecord();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
			writer.close();
		}
	}
}
