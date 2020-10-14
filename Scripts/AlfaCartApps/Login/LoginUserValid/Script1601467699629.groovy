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

WebUI.openBrowser('https://www.alfacart.com/')

/*Map<String, Object> chromePrefs = new HashMap<String, Object>()

chromePrefs.put('profile.default_content_setting_values.notifications', 2)

System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('prefs', chromePrefs)

WebDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl('https://www.alfacart.com/')
*/
WebUI.delay(5, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart'))
}

WebUI.click(findTestObject('Page_Alfacart - Login/button_Home Masuk  Daftar'))

//WebUI.setText(findTestObject('Page_Alfacart - Login/input_Email  Nomor Ponsel_email'), Email)
//WebUI.setText(findTestObject('Page_Alfacart - Login/input_Password_password'), Password)
WebUI.setText(findTestObject('Page_Alfacart - Login/input_Email  Nomor Ponsel_email'), findTestData('DataLogin').getValue(
        'Email', 3))

WebUI.setText(findTestObject('Page_Alfacart - Login/input_Password_password'), findTestData('DataLogin').getValue('Password', 
        3))

WebUI.click(findTestObject('Page_Alfacart - Login/input_Password_btn btn-login masuk'))

WebUI.verifyElementText(findTestObject('Page_Alfacart - Login/NamaAkunprofile'), findTestData('DataLogin').getValue('Nama', 
        3))

