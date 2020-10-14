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

//Mobile.startApplication('D:\\Katalon Studio\\AlfaCart\\Alfacart_v2.5.5_apkpure.com.apk', false)
Mobile.tap(findTestObject('MobileAppsAlfaCart/Button.SearchBarang'), 0)

Mobile.setText(findTestObject('MobileAppsAlfaCart/AddToCart/Txt.CariBarang'), 'susu ultra', 0)

Mobile.tap(findTestObject('MobileAppsAlfaCart/AddToCart/TaphasilPencarianpertama'), 0)

Mobile.scrollToText('ULTRA MILK Susu UHT Plain 1', FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('MobileAppsAlfaCart/AddToCart/ClickViewBarang'), 2)

Mobile.takeScreenshot('', FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tap(findTestObject('MobileAppsAlfaCart/AddToCart/Btn.Tambahkan ke Keranjang'), 2)

Mobile.pressBack()

Mobile.pressBack()

Mobile.pressBack()

Mobile.pressBack()

Mobile.tap(findTestObject('MobileAppsAlfaCart/Button.CartBelanjaan'), 0)

Mobile.pressBack()

Mobile.closeApplication()
