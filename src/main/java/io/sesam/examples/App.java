package io.sesam.examples;

import static spark.Spark.get;

import java.io.Writer;
import java.util.Iterator;

import com.google.gson.Gson;

public class App {

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        Repository<Entity> repository = new EntityRepository();
        get("/entities", (req, res) -> {
            res.type("application/json");
            String since = req.queryParams("since");
            Iterator<? extends Entity> iter = repository.getEntities(since);

            Writer writer = res.raw().getWriter();
            writer.append("[");
            while (iter.hasNext()) {
                writer.append(gson.toJson(iter.next()));
                if (iter.hasNext()) {
                    writer.append(",");
                }
            };
            writer.append("]");
            return null;
        });
    }

}