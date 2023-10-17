package me.antritus.astral.cosmiccapital.api.types;

import me.antritus.astral.cosmiccapital.api.managers.ISingleAccountManager;
import me.antritus.astral.cosmiccapital.api.managers.IMultiAccountManager;

import java.util.Currency;
import java.util.UUID;

public interface IWorld {
	/**
	 * Returns name of the world
	 * @return name
	 */
	String name();

	/**
	 * Returns the world object from a given platform.
	 * @return platform world
	 */
	Object world();

	/**
	 * Returns unique id based on the world.
	 * @return world id
	 */
	UUID uniqueId();

	/**
	 * Returns single currency account manager based on given currency
	 * @param currency currency
	 * @return manager for given currency.
	 */
	ISingleAccountManager accountManager(Currency currency);

	/**
	 * Returns single currency account manager based on given currency
	 * @param currencyName currency name
	 * @return manager for given currency.
	 */
	ISingleAccountManager accountManager(String currencyName);

	/**
	 * Returns multi currency account manager based on given currency
	 * @return manager for given currency
	 */
	IMultiAccountManager multiAccountManager();
}
