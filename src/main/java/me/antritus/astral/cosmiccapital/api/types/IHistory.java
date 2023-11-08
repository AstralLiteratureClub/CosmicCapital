package me.antritus.astral.cosmiccapital.api.types;

import me.antritus.astral.cosmiccapital.api.types.entry.Entry;
import me.antritus.astral.cosmiccapital.api.types.entry.EntryType;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Acts like a middle man between databases and developers. Calls database methods
 */
@SuppressWarnings("unused")
public interface IHistory {
	/**
	 * Returns all entries
	 * @return entries
	 */
	@NotNull
	CompletableFuture<@NotNull List<@NotNull Entry>> entries();

	/**
	 * Returns entry for given entry
	 * @param key entry key
	 * @return entry, else null
	 */
	@NotNull
	CompletableFuture<@NotNull Entry> entryOf(@Pattern("[a-zA-Z0-9]*") String key);

	/**
	 * Returns all entries of given type
	 * @param type entries
	 * @return entries, else empty list
	 */
	@NotNull
	CompletableFuture<@NotNull List<@NotNull Entry>> entriesOf(EntryType type);
}
