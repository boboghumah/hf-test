import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class BaseProvider {

	CloseableHttpClient client;

	@DataProvider
	Object[][] endpoints() {
		return new Object[][]{
				{"/iso2code/PPP", "PPP"},
				{"/iso2code/DD", "DD"},
				{"/iso2code/OG", "OG"}
		};
	}

	@DataProvider
	Object[][] endpointsValidCountries() {
		return new Object[][]{
				{"/iso2code/US"},
				{"/iso2code/DE"},
				{"/iso2code/GB"}
		};
	}

	@BeforeMethod
	public void setup() {
		client = HttpClientBuilder.create().build();
	}


	@AfterMethod
	public void closeResources() throws IOException {
		client.close();
	}
}
