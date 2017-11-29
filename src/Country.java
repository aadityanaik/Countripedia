package country;

import java.net.URL;

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
	String[] timezones, borders;
	String nativeName, numericCode;
	Language[] languages;
	Currency[] currencies;

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
			output += "\t\t\t" + language + "\n";
		}
		output += "\n";

		output += "Currencies-\n";
		for(Currency currency : currencies) {
			output += "\t\t\t" + currency + "\n";
		}
		output += "\n";

		return output;
	}
}