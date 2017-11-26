import internet_manager.ApiHandler;

public class Countries {
	public static void main(String[] args) {
		try {
			ApiHandler x = new ApiHandler("https://restcountries.eu/rest/v2/name/india");
			String output = x.generateGetResponse();
			System.out.println(output);
		} catch(Exception e) {

		}
	}
}
