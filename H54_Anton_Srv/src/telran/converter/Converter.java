package telran.converter;

import java.time.LocalDate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.converter.dto.CurrencyRates;

public class Converter {

	protected static final String LATEST = "latest";

	static protected String url = "http://api.fixer.io/";
	static protected RestTemplate restTemplate = new RestTemplate();
	static protected HttpHeaders headers = new HttpHeaders();
	static protected CurrencyRates currencyRates = getRates(LATEST);

	double convert(String date, String currencyFrom, String currencyTo, int amount) {
		if (date.equalsIgnoreCase(LATEST)) {
			currencyRates = getLatest();
		}
		currencyRates = getRates(date);
		return amount / currencyRates.rates.get(currencyFrom) * currencyRates.rates.get(currencyTo);
	}

	CurrencyRates getCurrency() {
		return getLatest();
	}

	private CurrencyRates getLatest() {
		if (LocalDate.parse(currencyRates.date).isBefore(LocalDate.now()))
			currencyRates = getRates(LATEST);
		return currencyRates;
	}

	protected static CurrencyRates getRates(String date) {
		ResponseEntity<CurrencyRates> response = restTemplate.exchange(url + date, HttpMethod.GET,
				new HttpEntity<String>(headers), CurrencyRates.class);
		CurrencyRates rates = response.getBody();
		rates.rates.put("EUR", 1.0);
		return rates;
	}

}
