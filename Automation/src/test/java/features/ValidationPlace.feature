Feature: Validation Place API's

Scenario: Verify if Place is Added successfully 
Given Add Place Payload
When user calls "AddPlaceAPI" with Post request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"