
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.testng.Assert.assertEquals;

public class AllCountriesTest extends BaseProvider {

	private final String REST_RESPONSE_KEY = "RestResponse";
	private final String RESULT_KEY = "result";

	private final String COUNTRY_CODE_ALPHA_2 = "alpha2_code";


	private void testResponseContainsSelectedCountries(String[] countryCodes, JSONArray resultsArray) {
		int counter = 0;

		for (Object result : resultsArray) {
			JSONObject resultItem = (JSONObject) result;
			String alphaCode2 = resultItem.getString(COUNTRY_CODE_ALPHA_2);

			for (String countryCode : countryCodes) {
				if (alphaCode2.equals(countryCode)) counter++;
			}

		}

		assertEquals(counter, countryCodes.length);
	}

	@Test
	public void getAllCountries() throws IOException {

		HttpGet get = new HttpGet(Constants.BASE_ENDPOINT + Constants.GET_METHOD + Constants.ALL_COUNTRIES);
		HttpResponse response = client.execute(get);
		int actualStatus = response.getStatusLine().getStatusCode();
		assertEquals(actualStatus, HTTP_OK);

		ContentType ct = ContentType.getOrDefault(response.getEntity());
		assertEquals(ct.getMimeType(), "application/json");


		String jsonBody = EntityUtils.toString(response.getEntity());
		JSONObject jsonObject = new JSONObject(jsonBody);


		JSONObject restResponseValue = jsonObject.getJSONObject(REST_RESPONSE_KEY);
		JSONArray resultsArray = restResponseValue.getJSONArray(RESULT_KEY);

		String[] testResultsCountriesArray = {"US", "DE", "GB"};
		testResponseContainsSelectedCountries(testResultsCountriesArray, resultsArray);

	}



}
