Feature: Validation Place API's

@AddPlace
Scenario Outline: Verify if Place is Added successfully 
Given Add Place Payload "<name>", "<Website>", "<Language>"
When user calls "addPlaceAPI" with "Post" request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify placeID created maps to "<name>" using "getPlaceAPI"

Examples:
|name		 |Website	     |Language		|
|Dacha 		 | http://ukr.com|Ukrainian - UA|
#|House  | http://i.ua   |English  - ENG| 


@DeletePlace
Scenario: Verify that Delete place is peformed

Given Delete Place Payload
When user calls "deletePlaceAPI" with "POST" request
Then the API call got success with status code 200
And "status" in response body is "God"