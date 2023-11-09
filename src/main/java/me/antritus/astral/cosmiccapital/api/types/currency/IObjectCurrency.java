package me.antritus.astral.cosmiccapital.api.types.currency;

@SuppressWarnings("unused")
public interface IObjectCurrency<T, C> extends ICurrency<C> {
	/**
	 * Returns the object for this currency.
	 *
	 * @return The item that this currency uses.
	 */
	T object();



	/**
	 * Returns the required number of objects for this currency.
	 * @return number of objects.
	 */
	int objectsRequired();
}