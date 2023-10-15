package me.antritus.astral.cosmiccapital.api;

import me.antritus.astral.cosmiccapital.api.managers.IAccountManager;
import me.antritus.astral.cosmiccapital.api.managers.ICurrencyManager;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public interface CosmicCapitalAPI extends IEconomyProvider {
	/**
	 * Returns the player account manager
	 * @return account manager
	 */
	@NotNull
	IAccountManager playerManager();

	/**
	 * Returns the banknote manager
	 * @return account manager
	 */
	@NotNull
	IAccountManager banknoteManager();

	/**
	 * Returns the manager for banks.
	 * @return account manager
	 */
	@NotNull
	IAccountManager bankManager();

	/**
	 * Returns the currency manager
	 * @return currency manager
	 */
	@NotNull
	ICurrencyManager currencyManager();


	/**
	 * Returns the main currency for the server.
	 * @return this currency can be changed in the plugin configurations.
	 */
	@NotNull
	default ICurrency mainCurrency() {
		return currencyManager().getMainCurrency();
	}
}
