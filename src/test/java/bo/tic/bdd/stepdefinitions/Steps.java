package bo.tic.bdd.stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;


public class Steps {
	
	private static final String CLIENT_ID = "C9EeT8cWZ7u7LcYYvOTlFyONeHCN3OZp";
	private static final String INVALID_CLIENT_ID = "C9EeT8cWZ7u7LcYYvOTlFyONeHCN3OZa";
	private static final String CLIENT_SECRET = "ns1huoaQM3aCPq1yh6dcizirP99cMrsc";
	private static final String GRANT_TYPE = "client_credentials";	
	private static final String BASE_URL = "https://sbx-api-sec.ziniopro.com";
	private static final String AUTH_ENDPOINT = "/oauth/v2/tokens";
	private static final String CATALOG_ENDPOINT = "/catalog/v2/catalogs";

	private static String token;
	private static io.restassured.response.Response response;
	private static JsonPath json;
	private static String error_description;
	private static String error_type;

	@Given("an authorized client")
	public void anAuthorizedClient() {

		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();		
				
		response = request.formParam("client_id", CLIENT_ID)
				.formParam("client_secret", CLIENT_SECRET)
				.formParam("grant_type", GRANT_TYPE)				
				.post(AUTH_ENDPOINT)
				.then()	
				.statusCode(200)
                .extract()
                .response();
		
		
		json = response.jsonPath();
		//System.out.println("jsonString ==> " + jsonString);
		token = json.get("access_token");
		System.out.println("token ==> " + token);
		
	}

	@When("client uses invalid client id to get access_token")
	public void clientUsesInvalidClientIdToGetAccessToken() {

		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		response = request.formParam("client_id", INVALID_CLIENT_ID)
				.formParam("client_secret", CLIENT_SECRET)
				.formParam("grant_type", GRANT_TYPE)
				.post(AUTH_ENDPOINT)
				.then()
				.statusCode(400)
				.extract()
				.response();

		json = response.jsonPath();
		error_description = json.get("error_description");
		error_type = json.get("error");
		System.out.println("error_description ==> " + error_description);
		System.out.println("error ==> " + error_type);

	}

	@When("an authorized client goes to catalog endpoit")
	public void anAuthorizedClientGoesToCatalogEndpoit() {
		
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();		
				
		response = request.queryParam("access_token", token)				
				.get(CATALOG_ENDPOINT)
				.then()	
				.statusCode(200)
                .extract()
                .response();
		
		json = response.jsonPath();
		//System.out.println("jsonString ==> " + jsonString);
	}


	@Then("catalog status is {string}")
	public void catalogStatusIs(String expectedCatalogStatus) {
		
		String catalogSatus = json.get("status").toString();
		Assert.assertEquals(expectedCatalogStatus,catalogSatus);
		System.out.println("expectedCatalogStatus ==> " + expectedCatalogStatus);
	}
	
	@Then("calalog number of items are: {int}")
	public void catalogNumberOfItemsAre(int expectedNumberOfItems) {
		System.out.println("expectedNumberOfItems ==> " + expectedNumberOfItems);
		int numberOfItems = json.getInt("data.size()");
		System.out.println("numberOfItems ==> " + numberOfItems);
		Assert.assertEquals(expectedNumberOfItems,numberOfItems);
	}

	@Then("error description with text {string} is sent")
	public void errorDescriptionWithTextIsSent(String expected_error_description) {
		System.out.println("expected_error_description ==> " + expected_error_description);
		String error_description = json.get("error_description").toString();
		System.out.println("error_description ==> " + error_description);
		Assert.assertEquals(expected_error_description,error_description);
	}

	@Then("error type is {string}")
	public void errorTypeIs(String expected_error) {
		System.out.println("expected_error ==> " + expected_error);
		String error = json.get("error").toString();
		System.out.println("error ==> " + error);
		Assert.assertEquals(expected_error,error);
	}




}
