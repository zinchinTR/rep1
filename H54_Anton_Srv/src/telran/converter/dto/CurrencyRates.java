package telran.converter.dto;

import java.util.Map;

public class CurrencyRates {
	public String date;
	public Map<String, Double> rates;

	public String getDate() {
		return date;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

}
