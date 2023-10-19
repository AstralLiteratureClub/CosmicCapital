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
}
