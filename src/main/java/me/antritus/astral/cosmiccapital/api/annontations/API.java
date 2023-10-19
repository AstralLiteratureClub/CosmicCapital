package me.antritus.astral.cosmiccapital.api.annontations;

import java.lang.annotation.*;

public class API {
	/**
	 * Marks API which is unstable or should not be used without knowing the internals.
	 */
	@Retention(RetentionPolicy.SOURCE)
	@Documented
	@Target({ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.PACKAGE})
	public @interface Unstable {
		boolean isUnstable() default false;
	}
}
