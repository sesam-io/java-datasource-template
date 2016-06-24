package io.sesam.examples;

import static spark.Spark.get;

import java.io.Writer;
import java.util.Iterator;

import com.google.gson.Gson;

public class App {

    public static void main(String[] args) {
        Repository<Entity> repository = new EntityRepository();
        Gson gson = new Gson();

        get("/entities", (req, res) -> {
            res.type("application/json");
            String since = req.queryParams("since");
            Iterator<? extends Entity> iter = repository.getEntities(since);

            Writer writer = res.raw().getWriter();
            writer.append("[");
            while (iter.hasNext()) {
                gson.toJson(iter.next(), writer);
                if (iter.hasNext()) {
                    writer.append(",");
                }
            };
            writer.append("]");
            return null;
        });
    }

}