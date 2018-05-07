import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*
import  java.net.URLEncoder

jql = String.format('text~"%s"', URLEncoder.encode(issue_summary, "UTF-8"))

ResponseObject response = WS.sendRequest(findTestObject('API Test Objects/rest_api_2_search/Search by jql', [('jql') : jql]))

// Status code: Code is 200
WS.verifyResponseStatusCode(response, 200)

// Response body: Convert to JSON Object 
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())

// Response body: number of elements
assertThat(jsonResponse.issues[0].fields.summary).isEqualTo(issue_summary)
assertThat(jsonResponse.issues[0].fields.issuetype.name).isEqualTo(issue_type)