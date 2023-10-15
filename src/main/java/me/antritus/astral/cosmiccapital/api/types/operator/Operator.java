package me.antritus.astral.cosmiccapital.api.types.operator;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;


@SuppressWarnings("unused")
public interface Operator {
	/**
	 * Returns the operator of this "operator"
	 * Examples:
	 *  - CommandSender
	 *  - Player
	 *  - OfflinePlayer
	 *  - ConsoleCommandSender
	 * @return instance
	 */
	Object get();

	/**
	 * Returns the unique id for this operator.
	 * @return id, else if console returns null
	 */
	@Nullable
	UUID uniqueId();
}
