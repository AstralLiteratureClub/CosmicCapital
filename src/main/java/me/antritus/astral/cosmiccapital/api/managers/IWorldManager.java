package me.antritus.astral.cosmiccapital.api.managers;

import me.antritus.astral.cosmiccapital.api.types.IWorld;

import java.util.Collection;

public interface IWorldManager {

	/**
	 * Returns a world from a platform-specific world
	 * @param worldName world name
	 * @return world
	 */
	IWorld world(String worldName);

	/**
	 * Returns world from a platform-specific world
	 * @param world platform world
	 * @return world
	 */
	IWorld world(Object world);

	/**
	 * Returns all the world objects
	 * @return worlds
	 */
	Collection<IWorld> worlds();
}
