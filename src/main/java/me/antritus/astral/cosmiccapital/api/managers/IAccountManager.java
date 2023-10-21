package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents default account manager
 */
public interface IAccountManager<T extends IAccount> {
	@Nullable
	T get(String name);
	@Nullable
	T get(UUID uniqueId);
	@NotNull
	T getKnownNonNull(String name);
	@NotNull
	T getKnownNonNull(UUID uniqueId);

	void createIfNotExists(T account);

	/**
	 * Deletes given account
	 * @param account account
	 */
	 void delete(T account);
	/**
	 * Delete accounts with given uniqueId
	 * @param uniqueId account id
	 */
	 void delete(UUID uniqueId);
	/**
	 * Delete accounts with given name
	 * @param name account name
	 */
	 void delete(String name);
}
