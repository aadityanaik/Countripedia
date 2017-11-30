package country;

import com.google.gson.Gson;
import java.net.URL;
import internet_manager.ApiHandler;

class Language {
	String name, nativeName;
	
	@Override
	public String toString() {
		return "Name- " + name + " Native name- " + nativeName;
	}
}

class Currency {
	String code, name, symbol;

	@Override
	public String toString() {
		return "Name- " + name + " Symbol- " + symbol + " Code- " + code;
	}
}

class Neighbour {
	String name;
}

public class Country {
	String name, capital;
	String[] topLevelDomain;
	String alpha2Code, alpha3Code;
	int[] callingCodes;
	String[] altSpellings;
	String region, subregion;
	long population;
	String demonym;
	double area;
	String[] timezones;
	String[] borders;
	String nativeName, numericCode;
	Language[] languages;
	Currency[] currencies;

	Neighbour[] neighbours;

	void getNeighbours() {
		neighbours = new Neighbour[borders.length];

		for(int i = 0; i < borders.length; i++) {
			try{
				//some bad code ahead
				neighbours[i] = new Gson().fromJson(
					new ApiHandler("https://restcountries.eu/rest/v2/alpha/" + borders[i] + "?fields=name").generateGetResponse(),
					Neighbour.class);
			} catch(Exception e) {
				System.err.println(e);
				neighbours[i].name = "";
			}
		}
	}

	URL flag;

	@Override
	public String toString() {
		String output = new String();
		
		output += ("Name-\t\t\t" + name + "\n");
		output += ("Capital-\t\t" + capital + "\n\n");
		output += ("Codes-\n" +
							 "\tTwo letter-\t" + alpha2Code + "\n" +
							 "\tThree letter-\t" + alpha3Code + "\n\n");

		output += ("Region-\t\t\t" + region + "\n" +
							 "Sub-region-\t\t" + subregion + "\n" +
							 "Area (sqkm)-\t\t" + area + "\n" +
							 "Population-\t\t" + population + "\n" +
							 "Demonym-\t\t" + demonym + "\n\n");

		output += "Calling codes-\n";
		for(int i : callingCodes) {
			output += "\t\t\t" + i + "\n";
		}
		output += "\n";

		output += "Languages-\n";
		for(Language language : languages) {
			output += "\tName-\t\t" + language.name + "\n";
			output += "\tNative Name-\t" + language.nativeName + "\n\n";
		}

		output += "Currencies-\n";
		for(Currency currency : currencies) {
			output += "\tName-\t\t" + currency.name + "\n";
			output += "\tSymbol-\t\t" + currency.symbol + "\n" +
								"\tCode-\t\t" + currency.code + "\n\n";
		}
		output += "Neighbours-\n";

		getNeighbours();

		for(Neighbour i : neighbours) {
			output += "\t\t\t" + i.name + "\n";
		}

		return output;
	}
}