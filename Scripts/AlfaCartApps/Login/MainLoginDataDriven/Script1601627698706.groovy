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
    //WebUI.click(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart'))
    WebUI.openBrowser('https://www.alfacart.com/')

    WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

    if (WebUI.verifyElementPresent(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart'), 2, FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart')) //WebUI.navigateToUrl('https://www.alfacart.com')
        //WebUI.navigateToUrl('https://www.alfacart.com')
        //WebUI.click(findTestObject('Page_Alfacart - Login/a_KlikAkunProfile'))
        //WebUI.click(findTestObject('Page_Alfacart - Login/a_ButtonKeluarAkun'))
        // WebUI.navigateToUrl('https://www.alfacart.com/Login')
        //WebUI.navigateToUrl('https://www.alfacart.com/Login')
    } else {
        WebUI.click(findTestObject('Page_Alfacart - Login/button_Home Masuk  Daftar'))

        WebUI.setText(findTestObject('Page_Alfacart - Login/input_Email  Nomor Ponsel_email'), findTestData('DataLogin').getValue(
                'Email', row))

        WebUI.setText(findTestObject('Page_Alfacart - Login/input_Password_password'), findTestData('DataLogin').getValue(
                'Password', row))

        WebUI.click(findTestObject('Page_Alfacart - Login/input_Password_btn btn-login masuk'))

        if (WebUI.verifyElementPresent(findTestObject('ErrorMessage/AkunInvalidphone number or password'), 2, FailureHandling.OPTIONAL)) {
            WebUI.verifyElementText(findTestObject('ErrorMessage/AkunInvalidphone number or password'), findTestData('DataLogin').getValue(
                    'Expected', row))

            println('Password Salah')

            WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
        } else if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Alfacart - Login/h4_Ringkasan Akun'), 
            2, FailureHandling.OPTIONAL)) {
            WebUI.verifyElementText(findTestObject('Page_Alfacart - Login/NamaAkunprofile'), findTestData('DataLogin').getValue(
                    'Nama', row))

            WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

            WebUI.takeScreenshot()

            WebUI.click(findTestObject('Page_Alfacart - Login/div_Hi,Akun'))

            WebUI.click(findTestObject('Page_Alfacart - Login/a_Keluar'))

            WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)
        } else if (WebUI.verifyElementPresent(findTestObject('Object Repository/ErrorMessage/p_UnikEmailAkunAndaSementaraTidakDapatDigunakan'), 
            2, FailureHandling.OPTIONAL)) {
            WebUI.verifyElementText(findTestObject('ErrorMessage/p_UnikEmailAkunAndaSementaraTidakDapatDigunakan'), findTestData(
                    'DataLogin').getValue('Expected', row))

            println('Email berupa character atau angka /n')
        }
    }
}

WebUI.closeBrowser()

