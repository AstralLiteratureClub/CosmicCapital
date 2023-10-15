package me.antritus.astral.cosmiccapital.api.types.entry;

import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.types.IAccount;
import me.antritus.astral.cosmiccapital.api.types.operator.Operator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.simple.JSONObject;

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
	 * Returns the class of the provider. Null if class is not found.
	 * @return class, else null
	 */
	@Nullable
	Class<? extends IEconomyProvider> providerClass();

	/**
	 * Returns the type of this entry.
	 * @return type
	 */
	@NotNull
	EntryType type();

	/**
	 * Returns the account this entry belongs to
	 * @return account
	 */
	@Nullable
	IAccount account();

	/**
	 * Returns another account if another account is used in this entry too.
	 * @return account, else null
	 */
	IAccount secondaryAccount();

	/**
	 * Returns the operator this entry might have, else null
	 * @return operator
	 */
	Operator operator();

	/**
	 * Returns the id for this entry.
	 * @return id
	 */
	int id();

	/**
	 * Returns the date this entry was first created.
	 * @return unix timestamp. (millis)
	 */
	long created();

	/**
	 * Returns extra info about this entry.
	 * @return info
	 */
	JSONObject info();

	/**
	 * Balance amount before change.
	 * @return amount
	 */
	double balanceBefore();

	/**
	 * Balance after change.
	 * @return amount
	 */
	double balanceAfter();

	/**
	 * How much balance changed in the action?
	 * @return change amount
	 */
	double balanceChange();
}
