package me.antritus.astral.tests;

public class Plugin {
	private final String name;
	private final String version;
	private final String author;

	public Plugin(String name, String version, String author) {
		this.name = name;
		this.version = version;
		this.author = author;
	}

	public String name() {
		return name;
	}

	public String version() {
		return version;
	}

	public String author() {
		return author;
	}
}
