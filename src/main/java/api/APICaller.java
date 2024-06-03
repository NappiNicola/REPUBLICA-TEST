package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.parser.ParseException;

public class APICaller {

	CloseableHttpClient httpClient;
	HttpGet request;
	HttpPost requestP;
	HttpResponse response;

	public APICaller() {

		httpClient = HttpClientBuilder.create().build();
	}

	public void call(String apiURL) throws ClientProtocolException, IOException, ParseException {

		request = new HttpGet(apiURL);
		response = httpClient.execute(request);

		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuilder result = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			result.append(line);
		}
		
		System.out.println("\n\nRisposta dall'API: <" + apiURL + ">\n");
		
		System.out.println(result.toString());
		System.out.println("\nStatus: " + response.getStatusLine().getStatusCode());

		reader.close();

	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException, ParseException {
		
		new APICaller().call("https://jsonplaceholder.typicode.com/posts");
		
	}

}
