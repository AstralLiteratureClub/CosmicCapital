package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.account.ISingleCurrencyAccount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents a single currency account manager for single currency accounts.
 */
@SuppressWarnings("unused")
public interface ISingleAccountManager extends IAccountManager {
	@Nullable
	@Override
	ISingleCurrencyAccount get(String name);
	@Nullable
	ISingleCurrencyAccount get(UUID uniqueId);
	@NotNull
	ISingleCurrencyAccount getKnownNonNull(String name);
	@NotNull
	ISingleCurrencyAccount getKnownNonNull(UUID uniqueId);

}
