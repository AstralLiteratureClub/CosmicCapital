package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents default account manager
 */
public interface IAccountManager {
	@Nullable
	IAccount get(String name);
	@Nullable
	IAccount get(UUID uniqueId);
	@NotNull
	IAccount getKnownNonNull(String name);
	@NotNull
	IAccount getKnownNonNull(UUID uniqueId);

	void createIfNotExists(IAccount account);
}
