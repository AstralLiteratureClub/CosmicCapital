package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.types.IHistory;
import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import me.antritus.astral.cosmiccapital.api.types.entry.Entry;
import me.antritus.astral.cosmiccapital.api.types.entry.EntryCurrencyData;
import me.antritus.astral.cosmiccapital.api.types.entry.EntryType;
import me.antritus.astral.cosmiccapital.api.types.operator.Operator;
import org.intellij.lang.annotations.Language;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public interface IEntryManager {
	@Language("RegExp")
	String keyPattern = "^[a-zA-Z0-9]{6}$";
	/**
	 * Returns entry for the given key. Entry is null if no entry is not found
	 * @param key key
	 * @return entry, else null
	 */
	@NotNull
	CompletableFuture<@Nullable Entry> getEntry(@Pattern(keyPattern) String key);


	/**
	 * Returns account history for the given account
	 * @param account account
	 * @return history
	 */
	@NotNull
	IHistory getHistory(IAccount account);


	/**
	 * Creates a new entry key which is not used by the manager.
	 * @return key
	 */
	@Pattern(keyPattern) String createKey();


	/**
	 * Creates new entry to history.
	 * @param economyProvider economy provider
	 * @param account account this entry is created for
	 * @param otherAccount other account
	 * @param operator operator
	 * @param information extra information of entry
	 * @param currencyData currencies & data
	 */
	void createEntry(IEconomyProvider<?> economyProvider, EntryType entryType, IAccount account, IAccount otherAccount, Operator operator, String information, EntryCurrencyData... currencyData);

}
