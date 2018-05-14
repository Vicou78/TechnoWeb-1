package lab.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AutoComplete {

	
	public List<String> getData(String query) {
		ArrayList<String> countries = Maison.get_villes();
		int totalCountries = countries.size();
		String country = null;
		query = query.toLowerCase();
		List<String> matched = new ArrayList<String>();
		for(int i=0; i<totalCountries; i++) {
			country = countries.get(i).toLowerCase();
			if(country.startsWith(query)) {
				matched.add(countries.get(i));
			}
		}
		return matched;
	}
}