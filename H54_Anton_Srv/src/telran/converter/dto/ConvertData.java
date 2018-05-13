package telran.converter.dto;

public class ConvertData {
	public String currencyFrom;
	public String currencyTo;
	public int amount;
	public String date;

	public ConvertData(String currencyFrom, String currencyTo, int amount, String date) {
		super();
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.amount = amount;
		this.date = date;
	}

	public ConvertData() {

	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public int getAmount() {
		return amount;
	}

	public String getDate() {
		return date;
	}

}
