package routes;

import com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

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

        get("/loop", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            List paragraph =new ArrayList();
            int k = 10;
            for (int i=0; i<k; i++) {
                paragraph.add("Sharing the footprint of every journey you take and tell us the unique story and meaningful pic.");
            }
            attributes.put("paragraph", paragraph);

            return new ModelAndView(attributes, "about.ftl");
        }, new FreeMarkerEngine());

        get("/index", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();

            SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            String dayOfWeek = formatter.format(new Date());
            String dayOfTime = formatter1.format(new Date());
            attributes.put("dayOfTime", dayOfTime);
            attributes.put("dayOfWeek", dayOfWeek);

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        /*post("/api/add_copyright", (req, res) -> {
            String info = req.queryParams("info");

            Map<String, Object> data = new HashMap<>();
            data.put("info", info);
            data.put("status", "OK");
            return data;
        }, gson::toJson);

        get("/api/copyright", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("Name", "Xin");
            data.put("Phone", "412-652-7800");
            data.put("Email", "xil154@pitt.edu");
            return data;
        }, gson::toJson);*/

        get("/api/my_info", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("Name", "Author: Barbara Lai");
            data.put("Phone", "Phone: 000-652-7800");
            data.put("Email", "Email: xil154@pitt.edu");
            return data;
        }, gson::toJson);


        post("/api/add_music_info", (req, res) -> {
            String info = req.queryParams("info");

            Map<String, Object> data = new HashMap<>();
            data.put("info", info);
            data.put("status", "OK");
            return data;
        }, gson::toJson);

        /*get("/api/copyright", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("copyright", new Date());
            return data;
        }, gson::toJson);*/

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


