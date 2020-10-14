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

Mobile.startApplication('D:\\Katalon Studio\\AlfaCart\\Alfacart_v2.5.5_apkpure.com.apk', false)

Mobile.tap(findTestObject('MobileAppsAlfaCart/AddToCart/Btn.CloseIklan'), 0)

Mobile.tap(findTestObject('MobileAppsAlfaCart/Login/BtnMenu'), 0)

Mobile.tap(findTestObject('MobileAppsAlfaCart/Login/BtnMasuk'), 0)

Mobile.tap(findTestObject('MobileAppsAlfaCart/Login/Txt.Email atau Nomor Ponsel'), 0)

Mobile.setText(findTestObject('MobileAppsAlfaCart/Login/Txt.Email atau Nomor Ponsel'), 'hilmi.falih@yahoo.com', 0)

Mobile.tap(findTestObject('MobileAppsAlfaCart/Login/Txt.Password'), 0)

Mobile.setText(findTestObject('MobileAppsAlfaCart/Login/Txt.Password'), 'admin123', 0)

Mobile.tap(findTestObject('MobileAppsAlfaCart/Login/Button - MASUKFormLogin'), 0)

Mobile.takeScreenshot('', FailureHandling.CONTINUE_ON_FAILURE)

