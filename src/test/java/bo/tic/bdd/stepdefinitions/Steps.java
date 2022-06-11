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
	private static final String CLIENT_SECRET = "ns1huoaQM3aCPq1yh6dcizirP99cMrsc";
	private static final String GRANT_TYPE = "client_credentials";	
	private static final String BASE_URL = "https://sbx-api-sec.ziniopro.com";
	private static final String AUTH_ENDPOINT = "/oauth/v2/tokens";
	private static final String CATALOG_ENDPOINT = "/catalog/v2/catalogs";

	private static String token;
	private static io.restassured.response.Response response;
	private static JsonPath json;

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

	@When("an authorized client goes to catalog endpoit")
	public void aCatalogEndpointWithHttpStatus200() {
		
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
	public void catalog_status_is(String expectedCatalogStatus) {
		
		String catalogSatus = json.get("status").toString();
		Assert.assertEquals(expectedCatalogStatus,catalogSatus);
		System.out.println("expectedCatalogStatus ==> " + expectedCatalogStatus);
	}
	
	@Then("calalog number of items are: {int}")
	public void catalugNumberOfItemsAre(int expectedNumberOfItems) {
		System.out.println("expectedNumberOfItems ==> " + expectedNumberOfItems);
		
		 int numberOfItems = json.getInt("data.size()");
		 System.out.println("numberOfItems ==> " + numberOfItems);
		 
		 Assert.assertEquals(expectedNumberOfItems,numberOfItems);
	}
	

	

}
