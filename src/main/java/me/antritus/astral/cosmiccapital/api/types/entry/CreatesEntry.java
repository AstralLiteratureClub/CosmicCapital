package me.antritus.astral.cosmiccapital.api.types.entry;

import org.jetbrains.annotations.ApiStatus;

import java.lang.annotation.*;

/**
 * Does the method create an entry to the entries of an account?
 * @author Antritus
 * @since 1.0-SNAPSHOT
 */
@SuppressWarnings("unused")
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
@ApiStatus.Experimental()
@Documented
public @interface CreatesEntry {
	/**
	 * Does the method create an entry to the history?
	 * @return entry
	 */
	boolean createsEntry() default true;
}
