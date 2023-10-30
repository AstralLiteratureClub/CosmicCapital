package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.bank.IBank;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.RunnableFuture;

public interface IBankManager<T extends IBank> extends IAccountManager<T> {

	/**
	 * Returns a copy of nullable. This will not initialize a new bank object.
	 * @param name name
	 * @return bank
	 */
	@Nullable
	@Override
	RunnableFuture<T> get(String name);
	/**
	 * Returns a copy of nullable. This will not initialize a new bank object.
	 * @param uniqueId uniqueId
	 * @return bank
	 */
	@Nullable
	@Override
	RunnableFuture<T> get(UUID uniqueId);
	@NotNull
	@Override
	T getKnownNonNull(String name);
	@NotNull
	T getKnownNonNull(UUID uniqueId);


	/**
	 * This method should not be used
	 * @param account account to create
	 * @throws IllegalStateException when used
	 */
	@Override
	@ApiStatus.NonExtendable
	@Deprecated
	void createIfNotExists(T account) throws IllegalStateException;

	/**
	 * Creates a new bank for a given owner
	 * @param owner owner unique id
	 * @return id
	 */
	T create(UUID owner, String name);



	/**
	 * Returns all banks owned by given owner. Owners can own multiple banks
	 * @param owner owner unique Id
	 * @return banks
	 */
	RunnableFuture<List<? extends T>> getAllOfOwner(UUID owner);

	/**
	 * Returns all banks where given member is part of. Members can own multiple banks
	 * @param member member uniqueId
	 * @return banks
	 */
	RunnableFuture<List<? extends T>> getAllOfMember(UUID member);
}
