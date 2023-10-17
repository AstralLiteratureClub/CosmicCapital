package me.antritus.astral.cosmiccapital.api.types.bank;

import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

/**
 * Represents a bank account.
 */
public interface IBank extends IAccount {
	/**
	 * Bank account id
	 * @return uniqueId
	 */
	@NotNull UUID uniqueId();

	/**
	 * returns the uniqueId of the owner
	 * @return owner id
	 */
	UUID owner();

	/**
	 * Returns all members of the bank account
	 * @return members, including the owner
	 */
	List<UUID> members();
}
