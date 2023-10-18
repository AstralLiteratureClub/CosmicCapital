# CosmicCapitalAPI
## Usage
Getting CosmicCapitalAPI (any platform)
```
CosmicCapitalAPI cosmicCapitalAPI = CosmicCapitalProvider.get();
```
Registering your own EconomyProvider
```java
import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyPlugin extends JavaPlugin implements IEconomyProvider {
	private CosmicCapitalAPI cosmicCapitalAPI;

	@Override
	public void onEnable(){

		cosmicCapitalAPI = CosmicCapitalProvider.getAPI();
		getLogger().info("MyPlugin has enabled!");
	}


	public void onDisable(){
		getLogger().info("MyPlugin has disabled!");
	}

	// Cannot override JavaPlugin getName() method
	//@Override
	//public @NotNull String getName() {
	//	return name;
	//}

	@Override
	public @NotNull String getVersion() {
		//noinspection UnstableApiUsage
		return getPluginMeta().getVersion();
	}

	@Override
	public @Nullable MyPlugin getPlugin() {
		return this;
	}
}
```

Getting player's account
```java
CosmicCapitalAPI cosmicCapitalAPI = CosmicCapitalProvider.get();

// Global
public IAccount getAccount(Player player){
	IAccountManager accountManager = cosmicCapitalAPI.playerManager();
	UUID uniqueId = player.getUniqueId();
	IAccount account = accountManager.get(uniqueId);
	return account;
}

public IAccount getAccount(Player player, String world){
	IWorldManager worldManager = cosmicCapitalAPI.worldManager();
	IWorld iWorld = worldManager.get(world);
	IAccountManager accountManager = worldManager.worldPlayerManager();
	UUID uniqueId = player.getUniqueId();
	IAccount account = accountManager.get(uniqueId);
	return account;
}
```

Getting normal currency balance
```java
CosmicCapitalAPI cosmicCapitalAPI = CosmicCapitalProvider.get();

double balance(IAccount account, String currency){
	return account.balance(currency);
}
```
Full example
```
import io.papermc.paper.event.player.AsyncChatDecorateEvent;
import me.antritus.astral.cosmiccapital.api.CosmicCapitalAPI;
import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import me.antritus.astral.cosmiccapital.api.managers.IAccountManager;
import me.antritus.astral.cosmiccapital.api.managers.IWorldManager;
import me.antritus.astral.cosmiccapital.api.providers.CosmicCapitalProvider;
import me.antritus.astral.cosmiccapital.api.types.IWorld;
import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Pattern;

public class MyPlugin extends JavaPlugin implements IEconomyProvider {
	CosmicCapitalAPI api;

	@Override
	public void onEnable(){

		api = CosmicCapitalProvider.getAPI();
		getLogger().info("MyPlugin has enabled!");
	}


	public void onDisable(){
		getLogger().info("MyPlugin has disabled!");
	}


	// Cannot override JavaPlugin getName() method
	//@Override
	//public @NotNull String getName() {
	//	return name;
	//}

	@Override
	public @NotNull String getVersion() {
		//noinspection UnstableApiUsage
		return getPluginMeta().getVersion();
	}

	@Override
	public @Nullable MyPlugin getPlugin() {
		return this;
	}


	public IAccount getAccount(Player player){
		IAccountManager accountManager = api.playerManager();
		return accountManager.get(player.getUniqueId());
	}


	public IAccount getAccount(Player player, World world){
		IWorldManager worldManager = api.worldManager();
		IWorld iWorld = worldManager.world(world);
		IAccountManager playerManager = iWorld.worldPlayerManager();
		return playerManager.get(player.getUniqueId());
	}



	// Example to show how accounts and currencies work
	private final Pattern pattern = Pattern.compile("<(?i)balance>");
	private final MiniMessage miniMessage = MiniMessage.miniMessage();
	@SuppressWarnings("UnstableApiUsage")
	public void onChat(AsyncChatDecorateEvent event){
		Player player = event.player();
		if (player == null){
			return;
		}

		ICurrency currency = api.mainCurrency();

		// World currency
		World world = player.getWorld();
		IAccount worldAccount = getAccount(player, world);
		double worldBalance = worldAccount.balance(currency);


		// Global
		IAccount globalAccount = getAccount(player);
		double globalBalance = globalAccount.balance(currency);


		// Replace <balance> with "%player%'s balance" <- Text
		String balanceText = "<hover:show_text:<green>%player%'s balance\n"+
				"<yellow>Balance: <white>"+ globalBalance + "\n" +
				"<yellow>Balance (<gray>"+world.getName()+"</gray>): <white>"+ worldBalance;

		Component message = event.result();
		message = message.replaceText(consumer->{
			consumer.match(pattern).replacement(miniMessage.deserialize(balanceText));
		});
		event.result(message);
	}
}
```
## Contributes
Antritus lik what
