package io.sesam.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityRepository implements Repository<Entity> {

	private List<Entity> entities;
	
	public EntityRepository() {		
		entities = new ArrayList<Entity>();
		for (int i=0; i < 10; i++) {
			entities.add(new Entity("entity-" + i, "entity-" + i, i));
		}
	}
	
	@Override
	public Iterator<? extends Entity> getEntities(String since) throws InvalidSinceException {
		if (since == null) {
			return entities.iterator();
		} else {
			int sinceValue = parseSince(since);
			return entities.stream().filter(e -> e.getUpdated() > sinceValue).iterator();	
		}
	}

	private int parseSince(String since) throws InvalidSinceException {
		try {
			return Integer.parseInt(since);
		} catch (NumberFormatException e) {
			throw new InvalidSinceException();
		}
	}
}
