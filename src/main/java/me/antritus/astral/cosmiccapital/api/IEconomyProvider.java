package me.antritus.astral.cosmiccapital.api;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface IEconomyProvider<T> {
	/**
	 * Provider name
	 * @return name
	 */
	@NotNull
	String getName();

	/**
	 * Provider version
	 * @return version
	 */
	@NotNull
	String getVersion();

	/**
	 * Provider mod/plugin
	 * @return mod/plugin
	 */
	@Nullable
	T getPlugin();

	/**
	 * Converts name and version to json
	 * @return json of name and version
	 */
	@Contract(" -> new")
	default @NotNull JsonObject toJson(){
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", getName());
		jsonObject.addProperty("version", getVersion());
		return jsonObject;
	}

}