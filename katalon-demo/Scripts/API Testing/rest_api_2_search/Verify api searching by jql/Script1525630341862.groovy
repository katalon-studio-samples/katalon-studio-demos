import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonSlurper as JsonSlurper

response = WebUI.callTestCase(findTestCase('API Testing/rest_api_2_search/User should send the request searching by jql successfully'), 
    [('issue_summary') : issue_summary], FailureHandling.STOP_ON_FAILURE)

// Response body: Convert to JSON Object 
def jsonSlurper = new JsonSlurper()

def jsonResponse = jsonSlurper.parseText(response.getResponseText())

assertThat(jsonResponse.issues[0].fields.summary).isEqualTo(issue_summary)

assertThat(jsonResponse.issues[0].fields.issuetype.name).isEqualTo(issue_type)

