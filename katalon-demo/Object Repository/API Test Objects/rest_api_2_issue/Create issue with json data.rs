<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Create issue with json data</name>
   <tag></tag>
   <elementGuidId>08926842-6ad2-40dc-9921-18beb83154db</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;fields\&quot;: {\n       \&quot;project\&quot;:\n       { \n          \&quot;key\&quot;: \&quot;KTP\&quot;\n       },\n       \&quot;summary\&quot;: \&quot;Always do right. This will gratify some people and astonish the REST.\&quot;,\n       \&quot;description\&quot;: \&quot;Creating an issue while setting custom field values\&quot;,\n       \&quot;issuetype\&quot;: {\n          \&quot;name\&quot;: \&quot;Bug\&quot;\n       }       \n   }\n}&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${authorization}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>   https://jira-dev.katalon.com/rest/api/2/issue/

</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
