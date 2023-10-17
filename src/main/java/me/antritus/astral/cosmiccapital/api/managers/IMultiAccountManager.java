package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.account.IMultiCurrencyAccount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents multi-currency account manager for account managers
 */
@SuppressWarnings("unused")
public interface IMultiAccountManager extends IAccountManager {
	@Nullable
	IMultiCurrencyAccount get(String name);
	@Nullable
	IMultiCurrencyAccount get(UUID uniqueId);
	@NotNull
	IMultiCurrencyAccount getKnownNonNull(String name);
	@NotNull
	IMultiCurrencyAccount getKnownNonNull(UUID uniqueId);
}
