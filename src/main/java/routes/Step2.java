package routes;

import com.google.gson.Gson;
import com.heroku.sdk.jdbc.DatabaseUrl;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by XINLAI on 3/22/16.
 */


public class Step2 {

    Gson gson = new Gson();

    public Step2() {
        setupRoutes();
    }

    private void setupRoutes() {

        get("/loop", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            List paragraph =new ArrayList();
            int k = 10;
            for (int i=0; i<k; i++) {
                paragraph.add("Sharing the footprint of every journey you take and tell us the unique story and meaningful pic.");
            }
            attributes.put("paragraph", paragraph);

            return new ModelAndView(attributes, "about.ftl");
        }, new FreeMarkerEngine());

        get("/hello", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();

            SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            String dayOfWeek = formatter.format(new Date());
            String dayOfTime = formatter1.format(new Date());
            attributes.put("dayOfTime", dayOfTime);
            attributes.put("dayOfWeek", dayOfWeek);

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());


        get("/api/my_info", (req, res) -> {
            Connection connection = null;
            Map<String, Object> data = new HashMap<>();
        try {
            //connection = DatabaseUrl.extract().getConnection();

            //Statement stmt = connection.createStatement();
            //ResultSet rs = stmt.executeQuery("SELECT Name, Phone, Emial FROM users");

            data.put("Name", "Author: Barbara Lai");
            data.put("Phone", "Phone: 000-652-7800");
            data.put("Email", "Email: xil154@pitt.edu");
            return data;
        } catch (Exception except){
            data.put("message", "There was an error: " + except);
            return new ModelAndView(data, "error.ftl");
        } finally {
            if (connection != null) try{connection.close();} catch(SQLException e){}
        }
        }, gson::toJson);



        post("/api/add_music_info", (req, res) -> {
            Connection connection = null;
            try {
            String info = req.queryParams("info");

            Map<String, Object> data = new HashMap<>();
            data.put("info", info);
            data.put("status", "OK");


            return data;
        } catch (Exception except) {
                return except.getMessage();
            } finally {
                if (connection != null) try{connection.close();} catch(SQLException e){}
            }
            }, gson::toJson);


        class MyInfo {
            public String Name;
            public String Phone;
            public String Email;

            public MyInfo(String a, String p, String e) {
                Name = a;
                Phone = p;
                Email = e;
            }
        }

    }

}


