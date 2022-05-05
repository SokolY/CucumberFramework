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
import recources.TestDataBuild;
import recources.Utils;

//@RunWith(Cucumber.class)
public class stepDefination extends Utils{

	RequestSpecification req;
	Response rs;
	String parsedResp;
	JsonPath respJson;
	TestDataBuild testData = new TestDataBuild();
	Utils reqSpec = new Utils();

//	@Given("Add Place Payload")
//	public void add_Place_Payload() throws IOException {
//	
//		
//		
//		req = given().spec(requestSpecification()).body(testData.addPlacePayload());
//	}

	@Given("Add Place Payload {string}, {string}, {string}")
	public void add_Place_Payload(String name, String website, String language) throws IOException {
		req = given().spec(requestSpecification()).body(testData.addPlacePayload(name, website, language));
	}
	@When("user calls {string} with Post request")
	public void user_calls_with_Post_request(String string) {
		ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

		rs = req.when().post("/maps/api/place/add/json");
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		parsedResp = rs.then().assertThat().statusCode(200).extract().response().asString();
		respJson = new JsonPath(parsedResp);
		System.out.println(parsedResp);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String responseField, String expResponce) {
		System.out.println("Actual status is: " + respJson.getString(responseField));
		respJson.getString(responseField);
		assertEquals(respJson.getString(responseField), expResponce);
	}

}
