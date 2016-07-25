import java.io.IOException;
import com.csvreader.CsvReader;

public class ReadFileWriteToConsole {
	
	private static final int MAXROW = 3;
	private static final int MAXCOL = 3;
    private static final String inFile = "in.csv";
	   
    public String[][] sheet = new String[MAXROW][MAXCOL];
	   
    public static void main(String args[]) throws IOException {
    	// create a ReadWriteToConsole object
    	//  Do not change the signature of this method.
    	// ... insert code here ...
    	// invoke readSheet()
    	// ... insert code here ...
    	// invoke writeSheet()
    	// ... insert code here ...
        ReadFileWriteToConsole wtf = new ReadFileWriteToConsole();
        wtf.readSheet();
        wtf.writeSheet();
    }	
	   
    public void readSheet() throws IOException {
        CsvReader reader = new CsvReader(inFile);

        String[] rowData = null;
        for (int i = 0; i < MAXROW; i++) {
            reader.readRecord();
            rowData = reader.getValues();
            for (int j = 0; j < MAXCOL; j++) {
                sheet[i][j] = rowData[j];
            }
        }

        reader.close();
	}
	   
	public void writeSheet(){
	    for (int i = 0; i < MAXROW; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                System.out.printf("[%s]", sheet[i][j]);
            }
            System.out.println();
        }
	}
}
