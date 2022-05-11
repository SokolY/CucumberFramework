package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceRequest;
import pojo.Location;
import recources.APIresources;
import recources.TestDataBuild;
import recources.Utils;

//@RunWith(Cucumber.class)
public class StepDefination extends Utils{

	RequestSpecification req;
	Response rs;
	String parsedResp;
	JsonPath respJson;
	TestDataBuild testData = new TestDataBuild();
	Utils reqSpec = new Utils();
	static String placeID;

	@Given("Add Place Payload {string}, {string}, {string}")
	public void add_Place_Payload(String name, String website, String language) throws IOException {
		req = given().spec(requestSpecification()).body(testData.addPlacePayload(name, website, language));
	}

	
	@When("user calls {string} with {string} request")
	public void user_calls_with_request(String resourse, String requestMethod) {
		
		APIresources resourseAPI = APIresources.valueOf(resourse);
				System.out.println("API resourse is: " + resourseAPI.getResourse());
		ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

		if(requestMethod.equalsIgnoreCase("POST")){
			rs = req.when().post(resourseAPI.getResourse());
		}
		else if(requestMethod.equalsIgnoreCase("Get")){
			rs = req.when().get(resourseAPI.getResourse());
		}
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		parsedResp = rs.then().assertThat().statusCode(200).extract().response().asString();
//		respJson = new JsonPath(parsedResp);
//		System.out.println(parsedResp);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String responseField, String expResponce) {
		assertEquals(getExtractedJson(rs, responseField), expResponce);
	}

	@Then("verify placeID created maps to {string} using {string}")
	public void verify_placeID_created_maps_to_using(String expactedName, String pathParam) throws IOException {
		
		placeID = getExtractedJson(rs, "place_id");
		req = given().spec(requestSpecification()).queryParam("place_id", placeID);
		user_calls_with_request(pathParam, "Get");
		String actualName = getExtractedJson(rs, "name");
		System.out.println("Actual name is: " + actualName);
		assertEquals(actualName, expactedName);
		
		
	}

	@Given("Delete Place Payload")
	public void delete_Place_Payload() throws IOException {
		System.out.println("Delete Place should be performed: " + testData.deletePlacePayload(placeID));
		req = given().spec(requestSpecification()).body(testData.deletePlacePayload(placeID));
		
//		req = given().spec(requestSpecification()).body("c0ee9cb925706ba9d7964bf98c6aec64");
	}

}
