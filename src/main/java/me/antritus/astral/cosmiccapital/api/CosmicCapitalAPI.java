package me.antritus.astral.cosmiccapital.api;

import me.antritus.astral.cosmiccapital.api.managers.*;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public interface CosmicCapitalAPI {
	/**
	 * Returns the operator manager.
	 * @see IOperatorManager
	 * @return operator manager
	 */
	IOperatorManager operatorManager();

	/**
	 * Returns the player account manager
	 * @see IAccountManager
	 * @return account manager
	 */
	@NotNull
	IAccountManager playerManager();

	/**
	 * Returns the banknote manager
	 * @see IAccountManager
	 * @return account manager
	 */
	@NotNull
	IAccountManager banknoteManager();

	/**
	 * Returns the manager for banks.
	 * @see IAccountManager
	 * @return account manager
	 */
	@NotNull
	IMultiAccountManager multiBankManager();

	@NotNull
	IAccountManager singleBankManager();

	/**
	 * Returns the currency manager
	 * @see ICurrencyManager
	 * @see ICurrencyManager
	 * @return currency manager
	 */
	@NotNull
	ICurrencyManager currencyManager();


	/**
	 * Returns the main currency for the server.
	 * @see ICurrency
	 * @see ICurrencyManager
	 * @return this currency can be changed in the plugin configurations.
	 */
	@NotNull
	default ICurrency mainCurrency() {
		return currencyManager().getMainCurrency();
	}


	/**
	 * Returns global the world manager
	 * @return world manager
	 */
	IWorldManager worldManager();
}
