package telran.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.converter.dto.ConvertData;
import telran.converter.dto.CurrencyRates;

@SpringBootApplication
@RestController
public class ConverterAppl {
	Converter converter = new Converter();

	@PostMapping(value = "convert")
	double getResult(@RequestBody ConvertData data) {
		return converter.convert(data.date, data.currencyFrom, data.currencyTo, data.amount);
	}

	@GetMapping(value = "getCurrencies")
	CurrencyRates getCurrency() {
		return converter.getCurrency();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConverterAppl.class, args);
	}

}
