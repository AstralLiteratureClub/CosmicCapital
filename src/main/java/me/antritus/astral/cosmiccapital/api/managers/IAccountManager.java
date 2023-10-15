package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.IAccount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@SuppressWarnings("unused")
public interface IAccountManager {
	@Nullable
	IAccount get(String name);
	@Nullable
	IAccount get(UUID uniqueId);
	@NotNull
	IAccount getKnownNonNull(String name);
	@NotNull
	IAccount getKnownNonNull(UUID uniqueId);

}
