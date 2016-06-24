package io.sesam.examples;

import java.util.Iterator;

public interface Repository<T> {

	public Iterator<? extends T> getEntities(String since) throws InvalidSinceException;
	
}
