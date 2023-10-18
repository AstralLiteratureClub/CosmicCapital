# CosmicCapitalAPI
## Usage
Getting CosmicCapitalAPI (any platform)
<code>java
CosmicCapitalAPI cosmicCapital = CosmicCapitalProvider.get();
</code>
Registering your own EconomyProvider
```java
import me.antritus.astral.cosmiccapital.api.IEconomyProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyPlugin extends JavaPlugin implements IEconomyProvider {

	@Override
	public void onEnable(){
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

## Contributes
