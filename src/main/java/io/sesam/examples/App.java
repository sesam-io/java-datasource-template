package io.sesam.examples;

import static spark.Spark.get;

import java.io.StringWriter;
import java.util.Iterator;

import com.google.gson.Gson;

public class App {

	private static Gson gson = new Gson();
	
    public static void main(String[] args) {
    	Repository<Entity> repository = new EntityRepository();
        get("/entities", (req, res) -> {
        	String since = req.params("since");
        	res.type("application/json");
        	StringWriter sw = new StringWriter();
        	sw.append("[");
        	Iterator<? extends Entity> iter = repository.getEntities(since);
            while (iter.hasNext()) {
            	sw.append(gson.toJson(iter.next()));
            	if (iter.hasNext()) {
            		sw.append(",");
            	}
            };
        	sw.append("]");
            return sw.toString();
        });
    }

}