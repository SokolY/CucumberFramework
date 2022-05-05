package recources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification reqbuild;
	public RequestSpecification requestSpecification() throws IOException {
		PrintStream outstream = new PrintStream(new FileOutputStream("logs.txt"));
		reqbuild = new RequestSpecBuilder().setBaseUri(getGlobalProperty("baseURI"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(outstream))
				.addFilter(ResponseLoggingFilter.logResponseTo(outstream))
				.setContentType(ContentType.JSON).build();
		return reqbuild;
	}
	
	public static String getGlobalProperty(String pr) throws IOException {
		Properties properties = new Properties();
		FileInputStream fi = new FileInputStream("D:\\FromPC\\DiscD\\Java\\Cucumber\\Automation\\src\\test\\java\\recources\\global.properties");
		properties.load(fi);
		return properties.getProperty(pr);
	}
}
