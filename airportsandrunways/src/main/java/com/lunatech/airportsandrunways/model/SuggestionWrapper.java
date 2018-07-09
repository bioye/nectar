package com.lunatech.airportsandrunways.model;

import java.util.ArrayList;
import java.util.List;
public class SuggestionWrapper {

  List<CountryValue> suggestions;

  public List<CountryValue> getSuggestions() {
    return suggestions;
  }

  public void setSuggestions(List<Country> suggestions) {
	List<CountryValue> countryValues = new ArrayList<>();
	for (Country country : suggestions) {
		CountryValue countVal = new CountryValue(country.getName());
		//countVal.setData(country.get);
		countryValues.add(countVal);
	}
    this.suggestions = countryValues;
  }
}