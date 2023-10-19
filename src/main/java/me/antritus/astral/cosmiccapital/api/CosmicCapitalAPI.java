package me.antritus.astral.cosmiccapital.api;

import me.antritus.astral.cosmiccapital.api.managers.*;
import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import me.antritus.astral.cosmiccapital.api.types.bank.IBank;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public interface CosmicCapitalAPI<T> {
	/**
	 * Returns the operator manager.
	 * @see IOperatorManager
	 * @return operator manager
	 */
	IOperatorManager operatorManager();

	/**
	 * Returns the player account manager
	 * @see me.antritus.astral.cosmiccapital.api.types.account.IAccount
	 * @return account manager
	 */
	@NotNull
	IAccountManager<? extends IAccount> playerManager();

	/**
	 * Returns the banknote manager
	 * @see me.antritus.astral.cosmiccapital.api.types.account.IAccount
	 * @return account manager
	 */
	@NotNull
	IAccountManager<? extends IAccount> banknoteManager();

	/**
	 * Returns the <b>global</b> manager bank manager.
	 * @see me.antritus.astral.cosmiccapital.api.types.bank.IBank
	 * @return account manager
	 */
	@NotNull
	IBankManager<? extends IBank> bankManager();

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


	/**
	 * Returns the account registry manager
	 * @return account registry manager
	 */
	IAccountRegistryManager accountRegistryManager();
}
