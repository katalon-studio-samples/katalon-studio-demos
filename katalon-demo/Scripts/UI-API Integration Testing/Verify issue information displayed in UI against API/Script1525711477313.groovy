import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper
import java.net.URLEncoder as URLEncoder
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import org.openqa.selenium.Keys as Keys

// Open UI
WebUI.callTestCase(findTestCase('UI Testing/Tests/Search Issue Test/User should be able to search issues with an jql'), 
    [('issue_summary') : issue_summary], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('UI Testing/Pages/Search Issue Page/Simple Issue List/Open the issue having specified summary'), 
    [('issue_summary') : issue_summary], FailureHandling.STOP_ON_FAILURE)

// Get Information from WS
response = WebUI.callTestCase(findTestCase('API Testing/rest_api_2_search/User should send the request searching by jql successfully'), 
    [('issue_summary') : issue_summary], FailureHandling.STOP_ON_FAILURE)

def jsonSlurper = new JsonSlurper()

def jsonResponse = jsonSlurper.parseText(response.getResponseText())

// Response body: number of elements
WebUI.callTestCase(findTestCase('UI Testing/Pages/Search Issue Page/Issue Content/Verify opening issue content'), [('issue_summary') : jsonResponse.issues[
        0].fields.summary, ('issue_type') : jsonResponse.issues[0].fields.issuetype.name], FailureHandling.STOP_ON_FAILURE)


