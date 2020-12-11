import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import dao.Sql2oAdmin;
import dao.Sql2oUsers;
import dao.sql2oclothes;
import dao.sql2ophones;
import models.Admin;
import models.Clothes;
import models.Users;
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
        Sql2oUsers usersdao;
        Sql2oAdmin admindao;
        Connection conn;
        Gson gson = new Gson();

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://localhost:5432/online_test";
        Sql2o sql2o = new Sql2o(connectionString, "belyse", "belyse");

        clothesdao=new sql2oclothes(sql2o);
        phonesdao=new sql2ophones(sql2o);
        admindao=new Sql2oAdmin(sql2o);
        usersdao=new Sql2oUsers(sql2o);

        conn=sql2o.open();

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/admin", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Admin.hbs");
        }, new HandlebarsTemplateEngine());

        get("/about", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "About us.hbs");
        }, new HandlebarsTemplateEngine());

        get("/contact", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "contact us.hbs");
        }, new HandlebarsTemplateEngine());

        get("/home", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        post("/admin/find", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String username=req.queryParams("username");
            String password=req.queryParams("password");
            Admin alladmin = admindao.findAdmin(username,password);
            model.put("admin", alladmin);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/clothes", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "clothes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/checkout", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "orderform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/buy", (req, res) -> { //URL to make new task on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String location = req.queryParams("location");
            String phonenumber = req.queryParams("phonenumber");
            Users newUsers = new Users(name,location,phonenumber); //ignore the hardcoded categoryId for now
            usersdao.addUsers(newUsers);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());



    }

}