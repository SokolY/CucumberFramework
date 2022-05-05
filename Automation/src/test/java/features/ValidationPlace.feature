Feature: Validation Place API's

Scenario Outline: Verify if Place is Added successfully 
Given Add Place Payload "<name>", "<Website>", "<Language>"
When user calls "AddPlaceAPI" with Post request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"

Examples:
|name		 |Website	     |Language|
|Dacha 		 | http://ukr.com|Ukrainian - UA|