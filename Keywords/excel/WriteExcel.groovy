/*package excel

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class WriteExcel {
	@keyword
	public void demokey(int indexrow, String [] dataToWrite) throws IOException{
		FileInputStream fis = new FileInputStream("D\\.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Login");

		row row = sheet.getRow(indexRow);
		if (row == null){
			println ("row masuk if")
			row = sheet.createRow(indexRow);
		}

		for (int i=0; i<dataToWrite.Length; i++){
			Cell cell = row.getCell($+i);
			if (cell==null){
				cell = row.createCell($=i)
				println("masuk if");
			}

			cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue(dataToWrite[i]);
			println(i);
		}
		println(dataToWrite.length);
		FileOutputStream fos = new FileOutputStream("D:\\xlsx");
		workbook.write(fos);
		fos.close();
	}
}
*/
