import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.testng.Assert.assertEquals;

public class EachCountryTest extends BaseProvider {

	@Test(dataProvider = "endpointsValidCountries")
	public void getEachCountry(String endpoint) throws IOException {

		HttpGet get = new HttpGet(Constants.BASE_ENDPOINT + Constants.GET_METHOD + endpoint);
		HttpResponse response = client.execute(get);
		int actualStatus = response.getStatusLine().getStatusCode();
		assertEquals(actualStatus, HTTP_OK);

		Header contentType = response.getEntity().getContentType();
		assertEquals(contentType.getValue(), "application/json;charset=UTF-8");
	}


}
