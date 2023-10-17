package me.antritus.astral.cosmiccapital.api.providers;


import me.antritus.astral.cosmiccapital.api.CosmicCapitalAPI;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class CosmicCapitalProvider{
	/**
	 * Locks the class so it can't be instanced.
	 */
	protected CosmicCapitalProvider(){}

	/**
	 * The economy field to reflect once provider is ready.
	 */
	private static CosmicCapitalAPI api;

	/**
	 * Returns the cosmic capital api.
	 * <p>
	 *     This will return null.. if the api has not loaded yet.
	 * </p>
	 * @return api
	 */
	@Nullable
	public static CosmicCapitalAPI getAPI(){
		return api;
	}
}
