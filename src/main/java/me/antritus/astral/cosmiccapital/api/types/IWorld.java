package me.antritus.astral.cosmiccapital.api.types;

import me.antritus.astral.cosmiccapital.api.managers.IAccountManager;
import me.antritus.astral.cosmiccapital.api.types.account.IAccount;

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
	 * Registers a new account manager for a given account type
	 * @param account account
	 * @param accountManager manager
	 */
	void register(Class<? extends IAccount> account, IAccountManager accountManager);

	/**
	 * Returns account manager based on given account class
	 * @param accountClass account manager to search for
	 * @return manager for given currency
	 */
	IAccountManager accountManager(Class<? extends IAccount> accountClass);

	IAccountManager worldPlayerManager();
}
