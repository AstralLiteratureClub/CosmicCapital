package me.antritus.astral.cosmiccapital.api.types.entry;

import com.google.gson.annotations.Expose;
import me.antritus.astral.cosmiccapital.api.CosmicCapitalAPI;
import me.antritus.astral.cosmiccapital.api.managers.ICurrencyManager;
import me.antritus.astral.cosmiccapital.api.providers.CosmicCapitalProvider;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class EntryCurrencyData {
	@Expose(deserialize = false, serialize = false)
	private String currency;
	@Expose
	private final double balanceBefore;
	@Expose
	private final double balanceAfter;
	@Expose
	private final double balanceChange;

	protected EntryCurrencyData(@NotNull ICurrency currency, double balanceBefore, double balanceAfter, double balanceChange) {
		this.currency = currency.name();
		this.balanceBefore = balanceBefore;
		this.balanceAfter = balanceAfter;
		this.balanceChange = balanceChange;
	}

	protected EntryCurrencyData(@NotNull String currency, double balanceBefore, double balanceAfter, double balanceChange) {
		this.currency = currency;
		this.balanceBefore = balanceBefore;
		this.balanceAfter = balanceAfter;
		this.balanceChange = balanceChange;
	}
	public EntryCurrencyData(@NotNull ICurrency currency, double balanceBefore, double balanceAfter){
		this.currency = currency.name();
		this.balanceBefore = balanceBefore;
		this.balanceAfter = balanceAfter;
		this.balanceChange = balanceBefore-balanceAfter;
	}

	public EntryCurrencyData(@NotNull String currency, double balanceBefore, double balanceAfter){
		this.currency = currency;
		this.balanceBefore = balanceBefore;
		this.balanceAfter = balanceAfter;
		this.balanceChange = balanceBefore-balanceAfter;
	}
	private EntryCurrencyData(){
		this.currency = null;
		this.balanceBefore = 0;
		this.balanceAfter = 0;
		this.balanceChange = 0;
	}

	/**
	 * Currency for this bundle
	 * @return currency
	 */
	public ICurrency currencyInstance() {
		if (currency != null){
			CosmicCapitalAPI<?> api = CosmicCapitalProvider.getAPI();
			if (api == null){
				throw new IllegalStateException(CosmicCapitalProvider.class.getName() +"#getAPI() is null! Please wait until using this method!");
			}
			ICurrencyManager currencyManager = api.currencyManager();
			return currencyManager.getCurrency(this.currency);
		}
		return null;
	}

	/**
	 * Returns name of the currency in this bundle
	 * @return currency's name
	 */
	public String currency() {
		return currency;
	}

	public double balanceBefore() {
		return balanceBefore;
	}

	public double balanceAfter() {
		return balanceAfter;
	}

	public double balanceChange() {
		return balanceChange;
	}
}
