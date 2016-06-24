package io.sesam.examples;

public class Entity {

	private final String id;
	private final String name;
	private final int updated;

	public Entity(String id, String name, int updated) {
		this.id = id;
		this.name = name;
		this.updated = updated;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getUpdated() {
		return updated;
	}
	
}
