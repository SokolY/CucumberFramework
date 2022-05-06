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
	public static RequestSpecification reqvestBuild;
	public RequestSpecification requestSpecification() throws IOException {
		if(reqvestBuild == null) {
		PrintStream outstream = new PrintStream(new FileOutputStream("logs.txt"));
		reqvestBuild = new RequestSpecBuilder().setBaseUri(getGlobalProperty("baseURI"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(outstream))
				.addFilter(ResponseLoggingFilter.logResponseTo(outstream))
				.setContentType(ContentType.JSON).build();
		return reqvestBuild;
		}
		return reqvestBuild;
	}
	
	public static String getGlobalProperty(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream fi = new FileInputStream("D:\\FromPC\\DiscD\\Java\\Cucumber\\Automation\\src\\test\\java\\recources\\global.properties");
		properties.load(fi);
		return properties.getProperty(key);
	}
}
