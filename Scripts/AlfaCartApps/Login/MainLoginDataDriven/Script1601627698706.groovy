import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions




for (def row = 1; row <= findTestData('DataLogin').getRowNumbers(); row++) {
    WebUI.openBrowser('https://www.alfacart.com/')
    WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)
    if (WebUI.verifyElementPresent(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart'), 2, FailureHandling.OPTIONAL)) 
	{
        WebUI.click(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart')) //WebUI.navigateToUrl('https://www.alfacart.com')
    } 
    WebUI.click(findTestObject('Page_Alfacart - Login/button_Home Masuk  Daftar'))
    WebUI.setText(findTestObject('Page_Alfacart - Login/input_Email  Nomor Ponsel_email'), findTestData('DataLogin').getValue('Email', row))
	WebUI.setText(findTestObject('Page_Alfacart - Login/input_Password_password'), findTestData('DataLogin').getValue('Password', row))
    WebUI.click(findTestObject('Page_Alfacart - Login/input_Password_btn btn-login masuk'))
	
	if (WebUI.verifyElementText(findTestObject('ErrorMessage/AkunInvalidphone number or password'),'Invalid email/phone number or password')) 
		{
		String textToWrite = WebUI.getText(findTestObject ('ErrorMessage/AkunInvalidphone number or password'))
			if (WebUI.verifyElementText(findTestObject('ErrorMessage/AkunInvalidphone number or password'), findTestData('DataLogin').getValue('Expected', row))==true)
			{
				CustomKeywords.'com.utilities.TestWriteExcel.demoWriteExcel'(row,'OK (PASS)')
			}else{
			CustomKeywords.'com.utilities.TestWriteExcel.demoWriteExcel'(row,'NO (FAIL)')
			}
            println('Password Salah')
            WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)		
			CustomKeywords.'com.utilities.ExcelExpected.cobaWriteExcel'(row, textToWrite)
       } 
		else if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Alfacart - Login/h4_Ringkasan Akun'),2, FailureHandling.OPTIONAL)) 
		{
			String textToWrite = WebUI.getText(findTestObject ('Page_Alfacart - Login/NamaAkunprofile'))
			if (WebUI.verifyElementText(findTestObject('Page_Alfacart - Login/NamaAkunprofile'), findTestData('DataLogin').getValue('Nama', row))==true)
			{
				CustomKeywords.'com.utilities.TestWriteExcel.demoWriteExcel'(row,'OK (PASS)')
			}else{
				CustomKeywords.'com.utilities.TestWriteExcel.demoWriteExcel'(row,'NO (FAIL)')
			}
            WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)
            WebUI.takeScreenshot()
            WebUI.click(findTestObject('Page_Alfacart - Login/div_Hi,Akun'))
            WebUI.click(findTestObject('Page_Alfacart - Login/a_Keluar'))
            WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
			println('Akun Sukses masuk ke profile')	
			CustomKeywords.'com.utilities.ExcelExpected.cobaWriteExcel'(row,textToWrite)
		} 	
		else if (WebUI.verifyElementText(findTestObject('Object Repository/ErrorMessage/p_Akun Anda untuk sementara tidak dapat digunakan untuk berbelanja'), 'Akun Anda untuk sementara tidak dapat digunakan untuk berbelanja.'))
		{
			String textToWrite = WebUI.getText(findTestObject ('Object Repository/ErrorMessage/p_Akun Anda untuk sementara tidak dapat digunakan untuk berbelanja'))
			if(WebUI.verifyElementText(findTestObject('Object Repository/ErrorMessage/p_Akun Anda untuk sementara tidak dapat digunakan untuk berbelanja'), findTestData('DataLogin').getValue('Expected', row),FailureHandling.CONTINUE_ON_FAILURE)==true)
			{
				CustomKeywords.'com.utilities.TestWriteExcel.demoWriteExcel'(row, 'OK (PASS)')
			}else{
				CustomKeywords.'com.utilities.TestWriteExcel.demoWriteExcel'(row, 'NO (FAIL)')
			}
			WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)
			println('Email berupa character atau angka')
			CustomKeywords.'com.utilities.ExcelExpected.cobaWriteExcel'(row,textToWrite)
		}	
	WebUI.closeBrowser()
}
        
    




