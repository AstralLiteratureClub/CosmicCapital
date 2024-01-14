package me.antritus.astral.tests;

import me.antritus.astral.cosmiccapital.api.CosmicCapitalAPI;
import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.managers.*;
import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CosmicCapital extends Plugin implements CosmicCapitalAPI<Plugin>, IEconomyProvider<Plugin> {
	public CosmicCapital(String name, String version, String author) {
		super(name, version, author);
	}

	@Override
	public @NotNull IOperatorManager operatorManager() {
		return null;
	}

	@Override
	public @NotNull IAccountManager<? extends IAccount> playerManager() {
		return null;
	}

	@Override
	public @NotNull IAccountManager<? extends IAccount> banknoteManager() {
		return null;
	}

	@Override
	public @NotNull IEntryManager playerEntryManager() {
		return null;
	}

	@Override
	public @NotNull IEntryManager bankEntryManager() {
		return null;
	}

	@Override
	public @NotNull IBankManager<? extends IAccount> bankManager() {
		return null;
	}

	@Override
	public @NotNull ICurrencyManager currencyManager() {
		return null;
	}

	@Override
	public @NotNull IWorldManager worldManager() {
		return null;
	}

	@Override
	public @NotNull IAccountRegistryManager accountRegistryManager() {
		return null;
	}

	@Override
	public @NotNull String getName() {
		return null;
	}

	@Override
	public @NotNull String getVersion() {
		return null;
	}

	@Override
	public @Nullable CosmicCapital getPlugin() {
		return this;
	}
}
