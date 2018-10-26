
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class InExistentCountriesTest extends BaseProvider {

	@Test(dataProvider = "endpoints")
	public void getEachCountry(String endpoint, String state) throws IOException {

		HttpGet get = new HttpGet(Constants.BASE_ENDPOINT + Constants.GET_METHOD + endpoint);
		HttpResponse response = client.execute(get);
		JSONObject responseBody = new JSONObject(EntityUtils.toString(response.getEntity()));
		JSONObject restResponse = responseBody.optJSONObject("RestResponse");
		JSONArray message = restResponse.optJSONArray("messages");

		String expected = "No matching country found for requested code [%s].";
		expected = String.format(expected, state);
		assertEquals(expected, message.getString(0));

		Header contentType = response.getEntity().getContentType();
		assertEquals(contentType.getValue(), "application/json;charset=UTF-8");
	}



}
