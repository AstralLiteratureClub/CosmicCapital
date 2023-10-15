package me.antritus.astral.cosmiccapital.api.types.currency;

@SuppressWarnings("unused")
public interface IObjectCurrency extends ICurrency {
	/**
	 * Returns the object for this currency.
	 *
	 * @return The item that this currency uses.
	 */
	Object object();

	/**
	 * Returns the required number of objects for this currency.
	 * @return number of objects.
	 */
	int objectsRequired();
}