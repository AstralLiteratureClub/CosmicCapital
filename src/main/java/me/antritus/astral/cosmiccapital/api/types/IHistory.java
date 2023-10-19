package me.antritus.astral.cosmiccapital.api.types;

import com.google.gson.JsonObject;
import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import me.antritus.astral.cosmiccapital.api.types.entry.Entry;
import me.antritus.astral.cosmiccapital.api.types.entry.EntryCurrencyData;
import me.antritus.astral.cosmiccapital.api.types.entry.EntryType;
import me.antritus.astral.cosmiccapital.api.types.operator.Operator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("unused")
public interface IHistory {
	/**
	 * Returns all entries
	 * @return entries
	 */
	@NotNull
	List<Entry> entries();

	/**
	 * Returns all entries of given type
	 * @param type entries
	 * @return entries, else empty list
	 */
	@NotNull
	List<Entry> entriesOf(EntryType type);

	/**
	 * Returns entries from given time to time.
	 * @param from from (millis)
	 * @param to to (millis)
	 * @return entries, else empty list
	 */
	@NotNull
	List<Entry> entriesFrom(long from, long to);

	/**
	 * Returns entries from given time to current time
	 * @param from from (millis)
	 * @return entries, else empty list
	 */
	@NotNull
	List<Entry> entriesFromToCurrent(long from);

	/**
	 * Searches for entry with given id
	 * @param id id
	 * @return entry, else null
	 */
	@Nullable
	Entry entry(int id);


	/**
	 * Creates new entry to history.
	 * @param economyProvider economy provider
	 * @param to account
	 * @param operator operator
	 * @param jsonData json info
	 * @param currencyData currencies & data
	 */
	void newHistoryEntry(IEconomyProvider<?> economyProvider, EntryType entryType, IAccount to, Operator operator, JsonObject jsonData, EntryCurrencyData... currencyData);
}
