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

WebUI.callTestCase(findTestCase('AlfaCartApps/Beranda/OrderBarang'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.navigateToUrl('https://www.alfacart.com/')

if (WebUI.verifyElementPresent(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Alfacart - Login/a_AdvertiseAlfaCart'))

    WebUI.delay(2)
}

WebUI.click(findTestObject('CheckoutCart/i_Pencarian Populer_demo-icon icon-cart'))

WebUI.click(findTestObject('CheckoutCart/button_View Cart'))

WebUI.delay(2)

WebUI.click(findTestObject('CheckoutCart/button_Lanjut Checkout'))

WebUI.click(findTestObject('CheckoutCart/button_BAYAR'))

WebUI.delay(7)

WebUI.click(findTestObject('CheckoutCart/span_RadioBtnBANK TRANSFER'))

WebUI.click(findTestObject('CheckoutCart/button_BAYARFinal'))

WebUI.verifyElementText(findTestObject('CheckoutCart/p_a.n PT. Sumber Trijaya Lestari (Alfacart)'), 'a.n PT. Sumber Trijaya Lestari (Alfacart)')

WebUI.takeScreenshot()

