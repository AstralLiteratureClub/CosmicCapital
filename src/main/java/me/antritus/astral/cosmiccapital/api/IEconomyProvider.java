package me.antritus.astral.cosmiccapital.api;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public interface IEconomyProvider {
	@NotNull
	String getName();
	@NotNull
	String getVersion();
	@Nullable
	Object getPlugin();
	@Contract(" -> new")
	default @NotNull JSONObject toJson(){
		Map<String, Object> json = new HashMap<>();
		json.put("name", getName());
		json.put("version", getVersion());
		return new JSONObject(json);
	}

}