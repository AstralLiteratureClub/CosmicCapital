package me.antritus.astral.cosmiccapital.api.types.currency;

import me.antritus.astral.cosmiccapital.api.IEconomyProvider;

@SuppressWarnings("unused")
public interface IObjectCurrency<T, C extends IEconomyProvider<?>> extends ICurrency<C> {
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