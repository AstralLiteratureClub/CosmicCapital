package me.antritus.astral.cosmiccapital.api.types.entry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * @author Antritus
 * @since 1.0-SNAPSHOT
 */
@SuppressWarnings("unused")
public interface Entry {

	/**
	 * Returns the name of the provider for this history entry.
	 * @return name of provider
	 */
	@NotNull
	String providerName();

	/**
	 * Extra information left behind this entry. For example, Comment from operator when setting balance
	 * @return information, else null
	 */
	@Nullable
	String extraInformation();

	/**
	 * Returns the type of this entry.
	 * @return type
	 */
	@NotNull
	EntryType type();

	/**
	 * Returns the uniqueId for the owner account of this entry
	 * @return id
	 */
	@NotNull
	UUID accountId();

	/**
	 * Returns the unique id for secondary account
 	 * @return unique id
	 */
	UUID secondaryAccountId();

	/**
	 * Returns the operator
	 * @return operator
	 */
	String operator();

	/**
	 * Returns the date this entry was first created.
	 * @return unix timestamp. (millis)
	 */
	long created();


	/**
	 * Returns the currencies and changes of this entry.
	 * @return data
	 */
	EntryCurrencyData[] entryCurrencyData();
}
