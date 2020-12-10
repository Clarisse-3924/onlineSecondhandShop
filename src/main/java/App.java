import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.staticFileLocation;
import static spark.route.HttpMethod.get;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        Spark.get("/",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            return new ModelAndView(model,"shoes.hbs");
        },new HandlebarsTemplateEngine());



    }

}