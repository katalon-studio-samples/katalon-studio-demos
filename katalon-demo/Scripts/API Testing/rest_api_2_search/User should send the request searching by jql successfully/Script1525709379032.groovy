import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

jql = String.format('text~"%s"', URLEncoder.encode(issue_summary, 'UTF-8'))

ResponseObject response = WS.sendRequest(findTestObject('API Test Objects/rest_api_2_search/Search by jql', [('jql') : jql]))

// Status code: Code is 200
WS.verifyResponseStatusCode(response, 200)
return response
