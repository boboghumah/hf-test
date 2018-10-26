import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static org.testng.Assert.assertEquals;

public class AddCountryTest extends BaseProvider {

	@Test
	public void AddNewCountry() throws IOException {

		HttpPost request = new HttpPost(Constants.BASE_ENDPOINT);
		String json = "{\"name\": \"Test Country\",\n" +
				"     \"alpha2_code\" :\"TC\",\n" +
				"     \"alpha3_code\" :\"TCY\"}";

		request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

		CloseableHttpResponse response = client.execute(request);

		int actualStatus = response.getStatusLine().getStatusCode();
		assertEquals(actualStatus, HTTP_CREATED);

	}


}
