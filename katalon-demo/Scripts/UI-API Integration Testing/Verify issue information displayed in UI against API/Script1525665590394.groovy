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

import groovy.json.JsonSlurper
import  java.net.URLEncoder
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Open UI
WebUI.callTestCase(findTestCase('UI Testing/Pages/Login Page/Login with username and encrypted password'), [('username') : GlobalVariable.username
	, ('encryptedPassword') : GlobalVariable.encrypted_password], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('UI Testing/Pages/Master Page/Open the Search for issue page'), [:], FailureHandling.STOP_ON_FAILURE)
jql = String.format('text~"%s"', issue_summary)
WebUI.callTestCase(findTestCase('UI Testing/Pages/Search Issue Page/Search issues using jql'), [('jql') : jql], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('UI Testing/Pages/Search Issue Page/Simple Issue List/Open the issue having specified summary'),
[('issue_summary') : issue_summary], FailureHandling.STOP_ON_FAILURE)

// Get Information from WS
jql = String.format('text~"%s"', URLEncoder.encode(issue_summary, "UTF-8"))
ResponseObject response = WS.sendRequest(findTestObject('API Test Objects/rest_api_2_search/Search by jql', [('jql') : jql]))
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())
summary = jsonResponse.issues[0].fields.summary
type = jsonResponse.issues[0].fields.issuetype.name

// Verify UI displayed information and data returned from WS
WebUI.callTestCase(findTestCase('UI Testing/Pages/Search Issue Page/Issue Content/Verify opening issue content'), [('issue_summary') : summary
	, ('issue_type') : type], FailureHandling.STOP_ON_FAILURE)
