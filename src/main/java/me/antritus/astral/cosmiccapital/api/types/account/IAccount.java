package me.antritus.astral.cosmiccapital.api.types.account;

import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.types.IHistory;
import me.antritus.astral.cosmiccapital.api.types.entry.CreatesEntry;
import me.antritus.astral.cosmiccapital.api.types.entry.EntryType;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@SuppressWarnings("unused")
public interface IAccount {
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
	 * Resets the history of the account.
	 * @param economy economy provider
	 */
	@CreatesEntry()
	void resetHistory(@NotNull IEconomyProvider economy);

	/**
	 * Returns the currency(|ies) used in this account
	 */
	Object currency();



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
