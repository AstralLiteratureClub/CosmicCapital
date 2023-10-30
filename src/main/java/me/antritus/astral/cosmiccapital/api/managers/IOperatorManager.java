package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.operator.Operator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.RunnableFuture;

@SuppressWarnings("unused")
public interface IOperatorManager {
	/**
	 * Creates new instance of given unique id, if player is found online
	 * @param uniqueId id
	 * @return operator, else null
	 */
	@Nullable
	RunnableFuture<Operator> getPlayerOperator(UUID uniqueId);
	/**
	 * Creates new instance of given name id, if player is found online
	 * @param name name
	 * @return operator, else null
	 */
	@Nullable
	RunnableFuture<Operator> getPlayerOperator(String name);

	/**
	 * Returns the operator instance for console
	 * @return console
	 */
	@NotNull
	Operator getConsoleOperator();

	/**
	 * Returns the player instance of given operator.
	 * @param operator operator
	 * @return player
	 */
	@Nullable
	RunnableFuture<Object> getPlayer(Operator operator);
	/**
	 * Returns the player instance of given operator.
	 * @return player
	 */
	@NotNull
	Object getConsole();
}
