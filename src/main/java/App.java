import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import dao.sql2oclothes;
import dao.sql2ophones;
import models.Clothes;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {
        sql2oclothes clothesdao;
        sql2ophones phonesdao;
        Connection conn;
        Gson gson = new Gson();

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://localhost:5432/online_test";
        Sql2o sql2o = new Sql2o(connectionString, "belyse", "belyse");

        clothesdao=new sql2oclothes(sql2o);
        phonesdao=new sql2ophones(sql2o);
        conn=sql2o.open();

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/clothes", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Clothes> clothes = clothesdao.getAllClothes(); //refresh list of links for navbar
            model.put("clothes", clothes);
            return new ModelAndView(model, "clothes.hbs");
        }, new HandlebarsTemplateEngine());


    }

}