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

WebUI.callTestCase(findTestCase('AlfaCartApps/Login/LoginUserValid'), [('Email') : '', ('Password') : '', ('Nama') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://www.alfacart.com/')

if (WebUI.verifyElementPresent(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart'))
}

WebUI.setText(findTestObject('OrderbarangAddToCart/input_txtKategori_inputSearch'), 'SUSU ULTRA')

WebUI.click(findTestObject('OrderbarangAddToCart/i_kliktombolSearch'))

WebUI.click(findTestObject('OrderbarangAddToCart/p_HasilPencarianULTRA MILK Susu UHT Cokelat 1 Liter'))

WebUI.click(findTestObject('OrderbarangAddToCart/button_Add to CartSpesifik'))

