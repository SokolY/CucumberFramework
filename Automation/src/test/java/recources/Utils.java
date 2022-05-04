package recources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification reqbuild;
	public RequestSpecification requestSpecification() throws FileNotFoundException {
		PrintStream outstream = new PrintStream(new FileOutputStream("logs.txt"));
		reqbuild = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(outstream))
				.addFilter(ResponseLoggingFilter.logResponseTo(outstream))
				.setContentType(ContentType.JSON).build();
		return reqbuild;
	}
}
