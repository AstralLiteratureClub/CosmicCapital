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


	/**
	 * Adds member to the bank. Does not add members multiple times
	 * @param memberId member
	 * @return true, if a member was added, false if already was in the list
	 */
	boolean addMember(UUID memberId);


	/**
	 * Removes member from the bank.
	 * @param memberId member
	 */
	void removeMember(UUID memberId);
}
