import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import internet_manager.ApiHandler;

class Country {
	String name, capital;

	@Override
	public String toString() {
		return name + "\t" + capital;
	}
}

public class Countries {
	public static void main(String[] args) {
		try {
			ApiHandler x = new ApiHandler("https://restcountries.eu/rest/v2/name/india?fullText=true");
			String output = x.generateGetResponse();
			System.out.println(output+"\n\n\n");
			Gson parser = new GsonBuilder().create();
			Country[] result = new Country[1];
			result = parser.fromJson(output, Country[].class);
			System.out.println(result[0]);
		} catch(Exception e) {

		}
	}
}
