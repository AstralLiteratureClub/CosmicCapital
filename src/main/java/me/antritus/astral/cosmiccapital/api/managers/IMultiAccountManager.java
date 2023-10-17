package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.account.IMultiCurrencyAccount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@SuppressWarnings("unused")
public interface IMultiAccountManager {
	@Nullable
	IMultiCurrencyAccount get(String name);
	@Nullable
	IMultiCurrencyAccount get(UUID uniqueId);
	@NotNull
	IMultiCurrencyAccount getKnownNonNull(String name);
	@NotNull
	IMultiCurrencyAccount getKnownNonNull(UUID uniqueId);
}
