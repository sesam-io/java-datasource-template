package io.sesam.examples;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityRepository implements Repository<Entity> {

	private List<Entity> entities;
	
	public EntityRepository() {
		entities = new ArrayList<Entity>();
        Instant now = Instant.now();
		for (int i=0; i < 10; i++) {
            entities.add(new Entity("entity-" + i, "entity-" + i, now.plus(Duration.ofMillis(i)).toString()));
		}
	}
	
	@Override
	public Iterator<? extends Entity> getEntities(String since) throws InvalidSinceException {
		if (since == null) {
			return entities.iterator();
		} else {
			return entities.stream().filter(e -> e.getUpdated().compareTo(since) > 0).iterator();	
		}
	}

}
