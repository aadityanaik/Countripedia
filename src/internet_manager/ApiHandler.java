package internet_manager;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

public class ApiHandler {
	URL url;

	public ApiHandler(String apiURL) throws MalformedURLException {
		url = new URL(apiURL);
	}

	public String generateGetResponse() throws IOException, UnknownHostException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");

		Scanner input = new Scanner(new InputStreamReader(connection.getInputStream()));
		String output = new String();

		while(input.hasNextLine()) {
			output += input.nextLine();
		}

		connection.disconnect();

		return output;
	}
}
