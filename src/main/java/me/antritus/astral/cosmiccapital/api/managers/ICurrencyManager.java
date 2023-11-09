package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.currency.ICurrency;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Allows registering and getting currencies by name
 */
@SuppressWarnings("unused")
public interface ICurrencyManager<C extends ICurrency<?>> {
	/**
	 * Returns the main currency of the server.
	 * @return currency
	 */
	@NotNull
	C getMainCurrency();

	/**
	 * Returns currency for name.
	 * @param name name
	 * @return currency, else null
	 */
	@Nullable
	ICurrency<?> getCurrency(String name);

	/**
	 * Creates a new currency if one does not exist.
	 * @param currency currency
	 * @return true if created, false if existed already
	 */
	boolean createCurrency(ICurrency<?> currency);

	/**
	 * Is the currency found in the registry?
	 * @return true if registered, else false
	 */
	boolean isRegistered(ICurrency<?> currency);
}
