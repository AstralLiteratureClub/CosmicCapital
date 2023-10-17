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
	 * Registers a new account manager for given account type
	 * @param account account
	 * @param accountManager manager
	 */
	void register(IAccount account, IAccount accountManager);

	/**
	 * Returns multi currency account manager based on given currency
	 * @return manager for given currency
	 */
	IAccountManager multiAccountManager(IAccount account);
}
