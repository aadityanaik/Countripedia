import java.io.FileNotFoundException;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import internet_manager.ApiHandler;
import country.Country;

public class Main {
	public static void main(String[] args) {
		String input;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the full name of the country you wish to know about");
		input = s.nextLine();

		try {
			ApiHandler x = new ApiHandler("https://restcountries.eu/rest/v2/name/" + input.replace(" ", "%20")+ "?fullText=true");
			String output = x.generateGetResponse();
			Gson parser = new GsonBuilder().create();
			Country[] result = parser.fromJson(output, Country[].class);
			for(Country c : result) {
				System.out.println(c);
				System.out.println("To learn more, visit- https://www.wikipedia.org/wiki/" + input.replace(" ", "%20"));
			}
		} catch(FileNotFoundException e) {
			System.err.println("Could not get result");
		} catch(Exception e) {
			System.err.println(e);
		}
	}
}
