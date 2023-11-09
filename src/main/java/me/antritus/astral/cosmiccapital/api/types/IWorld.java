package me.antritus.astral.cosmiccapital.api.types;

import me.antritus.astral.cosmiccapital.api.managers.IAccountManager;
import me.antritus.astral.cosmiccapital.api.managers.IBankManager;
import me.antritus.astral.cosmiccapital.api.managers.IEntryManager;
import me.antritus.astral.cosmiccapital.api.types.account.IAccount;
import me.antritus.astral.cosmiccapital.api.types.bank.IBank;

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
	void register(Class<? extends IAccount> account, IAccountManager<? extends IAccount> accountManager, IEntryManager entryManager);
	/**
	 * Registers a new bank manager for a given account type
	 * @param account account
	 * @param bankManager manager
	 */
	void register(Class<? extends IAccount> account, IBankManager<? extends IBank> bankManager, IEntryManager entryManager);

	/**
	 * Returns account manager based on given account class
	 * @param accountClass account manager to search for
	 * @return manager for given currency
	 */
	IAccountManager<? extends IAccount> accountManager(Class<? extends IAccount> accountClass);
	/**
	 * Returns bank account manager based on given bank account class
	 * @param bankClass bank account manager to search for
	 * @return manager for given currency
	 */
	IBankManager<? extends IBank> bankManager(Class<? extends IBank> bankClass);

	IAccountManager<? extends IAccount> worldPlayerManager();

	/**
	 * Returns the main bank manager for the world.
	 * @return bank manager
	 */
	IBankManager<? extends IBank> worldBankManager();

	/**
	 * Returns the history manager for the given account
	 * @param accountClass account
	 * @return manager
	 */
	IEntryManager entryManager(Class<? extends IAccount> accountClass);
	/**
	 * Returns the history manager for the given bank account
	 * @param accountClass account
	 * @return manager
	 */
	IEntryManager entryManagerBank(Class<? extends IBank> accountClass);

	/**
	 * Returns history manager for the world's banks
	 * @return entry manager
	 */
	IEntryManager worldBankEntryManager();

	/**
	 * Returns the history manager for players in the given world
	 * @return entry manager
	 */
	IEntryManager worldPlayerEntryManager();
}
