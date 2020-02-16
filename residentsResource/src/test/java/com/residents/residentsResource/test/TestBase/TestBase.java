package com.residents.residentsResource.test.TestBase;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class TestBase {
	public static RequestSpecification httpRequest;
	public static Response response;
	public static Logger logger;
	
	
	@BeforeClass
	public  void setup() {
		logger = Logger.getLogger("testbaseclass");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}

}
