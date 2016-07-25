import java.io.IOException;
import com.csvreader.CsvReader;

public class ReadFileWriteToConsole {

    private static final String inFile = "in.csv";

    private String[][] data;

    public static void main(String args[]) throws IOException {
        // (add code to implement the following)
        // create a ReadFileWriteToConsole object
        // call method below to read the data from inFile
        // call method below to write the data to the console
        // Do not change the signature of this method.

        ReadFileWriteToConsole sheeter = new ReadFileWriteToConsole();
        sheeter.makeSheet();
        sheeter.writeSheet();
    }

    public String getCell(int row, int col) throws IOException {
        if (data == null)
            return null;
        if (row < 0 || row > data.length - 1)
            return null;
        if (col < 0 || col > data[0].length - 1)
            return null;

        return data[row][col];
    }

    public int getRowCount() {
        return data != null ? data.length : 0;
    }

    public int getColCount() {
        if (data == null || data.length == 0){
            return 0;
        }
        return data[0].length;
    }

    public void makeSheet() throws IOException {
        if (data != null) {
            return;
        }

        CsvReader csvReader = new CsvReader(inFile);
        int row = 0;

        while (csvReader.readRecord()) {
            if (data == null) {
                data = new String[csvReader.getColumnCount()][csvReader.getColumnCount()];
            }

            String[] values = csvReader.getValues();
            for (int i = 0; i < values.length; i++) {
                data[row][i] = values[i];
            }
            row++;
        }
    }

    public void writeSheet() {
        if (data == null) {
            return;
        }

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                System.out.print("[" + data[row][col] + "]");
            }
            System.out.println();
        }
    }
}
