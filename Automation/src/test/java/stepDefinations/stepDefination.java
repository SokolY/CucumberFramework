package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

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

	@Given("Add Place Payload")
	public void add_Place_Payload() {
	
		
		ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

		req = given().spec(requestSpecification()).body(testData.addPlacePayload());
	}

	@When("user calls {string} with Post request")
	public void user_calls_with_Post_request(String string) {
		rs = req.when().post("/maps/api/place/add/json");
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		parsedResp = rs.then().assertThat().statusCode(200).extract().response().asString();
		respJson = new JsonPath(parsedResp);
		System.out.println(parsedResp);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String actualStatus1, String expStatus) {
		System.out.println("Actual status is: " + respJson.getString(actualStatus1));
		respJson.getString(actualStatus1);
		assertEquals(respJson.getString(actualStatus1), expStatus);
	}

}
