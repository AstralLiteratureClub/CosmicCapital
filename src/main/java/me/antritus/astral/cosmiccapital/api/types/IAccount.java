package me.antritus.astral.cosmiccapital.api.types;

import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import me.antritus.astral.cosmiccapital.api.types.entry.CreatesEntry;
import me.antritus.astral.cosmiccapital.api.types.entry.EntryType;
import me.antritus.astral.cosmiccapital.api.types.operator.Operator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.simple.JSONObject;

import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unused")
public interface IAccount {
	/**
	 * Gets the currency for this account.
	 * @return currency, else null
	 */
	@Nullable
	ICurrency currency();

	/**
	 * Returns the history of given account
	 * @return history
	 */
	@NotNull
	IHistory history();

	/**
	 * Returns the unique id for this account
	 * @return id
	 */
	@NotNull
	UUID uniqueId();

	/**
	 * Returns the name for this account.
	 * @return name
	 */
	@NotNull
	String name();

	/**
	 * Returns the date this account was created.
	 * @return creation date (millis)
	 */
	long created();

	/**
	 * Returns the balance of player's account.
	 * @return balalance
	 */
	double balance();


	@CreatesEntry()
	void resetHistory(@NotNull IEconomyProvider economy);



	/**
	 * Sends money from account to another account.
	 *
	 * @param economy economy plugin
	 * @param to      economy account
	 * @param amount  amount
	 */
	@CreatesEntry
	void transfer(@NotNull IEconomyProvider economy, @NotNull IAccount to, double amount, @Nullable JSONObject data);


	/**
	 * Sets the balance of the account to given amount
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 * @param amount        amount
	 */
	@CreatesEntry
	void operatorSet(@NotNull IEconomyProvider economy, @NotNull Operator operator, double amount, @Nullable JSONObject data);

	/**
	 * Resets balance of the account.
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 */
	@CreatesEntry
	void operatorReset(@NotNull IEconomyProvider economy, @NotNull Operator operator, @Nullable JSONObject data);

	/**
	 * Adds to the balance of the account.
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 * @param amount        amount
	 */
	@CreatesEntry
	void operatorAdd(@NotNull IEconomyProvider economy, @NotNull Operator operator, double amount, JSONObject data);

	/**
	 * Removes from the balance of the account.
	 *
	 * @param economy       economy plugin
	 * @param operator operator
	 * @param amount        amount
	 */
	@CreatesEntry
	void operatorRemove(@NotNull IEconomyProvider economy, @NotNull Operator operator, double amount, JSONObject data);

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
	void custom(@NotNull IEconomyProvider economy, @NotNull IAccount account, @NotNull CustomAction action, double amount, @Nullable JSONObject data);

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
	void custom(@NotNull IEconomyProvider economy, @NotNull Operator operator, @NotNull CustomAction action, double amount, @Nullable JSONObject data);

	/**
	 * Custom method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param action  action
	 * @param amount  amount
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void custom(@NotNull IEconomyProvider economy, @NotNull CustomAction action, double amount, @Nullable JSONObject data);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param operator operator
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider economy, @NotNull Operator operator, @Nullable JSONObject data);

	/**
	 * Custom reset method to allow factions to do their own actions.
	 *
	 * @param economy economy plugin
	 * @param data    extra data about action
	 */
	@CreatesEntry
	void customReset(@NotNull IEconomyProvider economy, @Nullable JSONObject data);

	/**
	 * Creates a json object out of maps.
	 * @param data map
	 * @return data
	 */
	default JSONObject createData(@NotNull Map<String, Object> data) {
		return new JSONObject(data);
	}



	enum CustomAction {
		/**
		 * Adds to the account's balance
		 */
		ADD(EntryType.ADD),
		/**
		 * Removes from the account's balance
		 */
		REMOVE(EntryType.REMOVE),
		/**
		 * Sets the account's balance
		 */
		SET(EntryType.SET),
		;

		private final EntryType entryType;
		CustomAction(EntryType entryType){
			this.entryType = entryType;
		}

		public EntryType entryType() {
			return entryType;
		}
	}
}