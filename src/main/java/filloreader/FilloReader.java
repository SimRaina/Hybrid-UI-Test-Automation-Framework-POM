package filloreader;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloReader {
	
	ArrayList<String> row= new ArrayList<String>();
	ArrayList<String> loginValues=new ArrayList<String>();
	public String filepath;
	public static final Logger log = Logger.getLogger(FilloReader.class.getName());
	
	
	public ArrayList<String> getData(String filepath,String excelName,String sheetName, int rowNumber) throws FilloException {
		this.filepath=filepath;
		Fillo fillo=new Fillo();
		String filepath1 = filepath+excelName;
	
		Connection connection=fillo.getConnection(filepath1);  // Setting connection with the Excel File
		
		String strQuery="Select * from" +" "+sheetName+" "+ "where TCNumber='"+rowNumber+"' "; // Writing SQL Query
		
		Recordset recordset=connection.executeQuery(strQuery); // Execute Query and store result in Recordset
    
		while(recordset.next()){  // Condition till recordset has values
        
			row=recordset.getFieldNames(); // get column names
          
			for (int i=1;i<=row.size()-1;i++) {  // run for loop for desired column values
                loginValues.add(recordset.getField(row.get(i)));  // add row values to ArrayList
            }
        } 
		recordset.close();
		connection.close();
		return loginValues;
    }
	
	public void updateData(String filepath,String excelName,String sheetName, String result, int rowNumber) throws FilloException {
		this.filepath=filepath;
		Fillo fillo=new Fillo();
		String filepath1 = filepath+excelName;
	
		Connection connection=fillo.getConnection(filepath1);  // Setting connection with the Excel File
		
		String strQuery="UPDATE" +" "+sheetName+" "+ "SET Result='"+result+"' " + "where TCNumber='"+rowNumber+"' "; // Writing SQL Query
		connection.executeUpdate(strQuery);
		connection.close();
    }
}


