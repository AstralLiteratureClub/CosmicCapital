package me.antritus.astral.cosmiccapital.api.types.currency;

import com.google.gson.annotations.Expose;
import me.antritus.astral.cosmiccapital.api.CosmicCapitalAPI;
import me.antritus.astral.cosmiccapital.api.managers.ICurrencyManager;
import me.antritus.astral.cosmiccapital.api.providers.CosmicCapitalProvider;

/**
 * Creates bundle/double for currencies. This helps in lists with multiple currencies and amounts of "cash" or "money"
 */
public class CurrencyBundle {
	@Expose(deserialize = false, serialize = false)
	private ICurrency currency;
	private String currencyName;
	@Expose
	private final double amount;

	/**
	 * Creates a new currency bundle.
	 * @param currency currency
	 * @param amount amount
	 */
	public CurrencyBundle(ICurrency currency, double amount) {
		this.currency = currency;
		this.amount = amount;
		this.currencyName = currency.name();
	}
	/**
	 * Creates a new currency bundle.
	 * @param currencyName currency name
	 * @param amount amount
	 */
	public CurrencyBundle(String currencyName, double amount) {
		this.currencyName = currencyName;
		this.amount = amount;
		this.currency = null;
	}

	private CurrencyBundle(){
		this.amount = 0;
		this.currency = null;
		this.currencyName = null;
	}


	/**
	 * Currency for this bundle
	 * @return currency
	 */
	public ICurrency currency() {
		if (currencyName != null && currency == null){
			CosmicCapitalAPI api = CosmicCapitalProvider.getAPI();
			if (api == null){
				throw new IllegalStateException(CosmicCapitalProvider.class.getName() +"#getAPI() is null! Please wait until using this method!");
			}
			ICurrencyManager currencyManager = api.currencyManager();
			ICurrency currency = currencyManager.getCurrency(currencyName);
			if (currency == null){
				return null;
			}
			this.currency = currency;
		}
		return currency;
	}

	/**
	 * Returns amount of currency in this bundle
	 * @return amount
	 */
	public double amount() {
		return amount;
	}

	/**
	 * Returns name of the currency in this bundle
	 * @return currency's name
	 */
	public String currencyName() {
		if (currencyName == null && currency != null){
			currencyName = currency.name();
		}
		return currencyName;
	}
}
