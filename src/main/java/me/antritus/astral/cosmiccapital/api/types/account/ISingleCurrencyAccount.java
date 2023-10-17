package me.antritus.astral.cosmiccapital.api.types.account;

import com.google.gson.JsonObject;
import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import me.antritus.astral.cosmiccapital.api.types.entry.CreatesEntry;
import me.antritus.astral.cosmiccapital.api.types.operator.Operator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface ISingleCurrencyAccount {
	/**
	 * Gets the currency for this account.
	 * @return currency, else null
	 */
	@Nullable
	ICurrency currency();

	/**
	 * Returns the balance of player's account.
	 * @return balance
	 */
	double balance();



	/**
	 * Sends money from account to another account.
	 *
	 * @param economy economy plugin
	 * @param to      economy account
	 * @param amount  amount
	 */
	@CreatesEntry
	void transfer(@NotNull IEconomyProvider economy, @NotNull ISingleCurrencyAccount to, double amount, @Nullable JsonObject data);


	/**
	 * Sets the balance of the account to given amount
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 * @param amount        amount
	 */
	@CreatesEntry
	void operatorSet(@NotNull IEconomyProvider economy, @NotNull Operator operator, double amount, @Nullable JsonObject data);

	/**
	 * Resets balance of the account.
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 */
	@CreatesEntry
	void operatorReset(@NotNull IEconomyProvider economy, @NotNull Operator operator, @Nullable JsonObject data);

	/**
	 * Adds to the balance of the account.
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 * @param amount        amount
	 */
	@CreatesEntry
	void operatorAdd(@NotNull IEconomyProvider economy, @NotNull Operator operator, double amount, JsonObject data);

	/**
	 * Removes from the balance of the account.
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 * @param amount        amount
	 */
	@CreatesEntry
	void operatorRemove(@NotNull IEconomyProvider economy, @NotNull Operator operator, double amount, JsonObject data);

	/**
	 * Custom method to allow plugins to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param account other account
	 * @param action  action
	 * @param amount  amount
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider economy, @NotNull ISingleCurrencyAccount account, @NotNull IAccount.CustomAction action, double amount, @Nullable JsonObject data);

	/**
	 * Custom method to allow plugins to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param operator operator
	 * @param action  action
	 * @param amount  amount
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider economy, @NotNull Operator operator, @NotNull IAccount.CustomAction action, double amount, @Nullable JsonObject data);

	/**
	 * Custom method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param action  action
	 * @param amount  amount
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider economy, @NotNull IAccount.CustomAction action, double amount, @Nullable JsonObject data);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param operator operator
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider economy, @NotNull Operator operator, @Nullable JsonObject data);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider economy, @Nullable JsonObject data);

}