package routes;

import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import java.text.SimpleDateFormat;
import java.util.*;

import static javax.swing.UIManager.get;
import static spark.Spark.modelAndView;

/**
 * Created by XINLAI on 4/7/16.
 */
public class Step3 {
    public static ArticleDbService<Article> articleDbService = new ArticleServletDao<Article>();

    public Step3() {
        setupRoutes();
    }

    private void setupRoutes() {
        Spark.get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> viewObjects = new HashMap<String, Object>();
                /* Refactor */
                ArrayList<Article> articles = articleDbService.readAll();

                if (articles.isEmpty()) {
                    viewObjects.put("hasNoArticles", "Welcome, please click \"Write Article\" to begin.");
                } else {
                    Deque<Article> showArticles = new ArrayDeque<Article>();

                    for (Article article : articles) {
                        if (article.readable()) {
                            showArticles.addFirst(article);
                        }
                    }

                    viewObjects.put("articles", showArticles);
                }

                viewObjects.put("templateName", "articleList.ftl");

                return modelAndView(viewObjects, "layout.ftl");
            }
        });

        Spark.get("/article/create", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> viewObjects = new HashMap<String, Object>();

                viewObjects.put("templateName", "articleForm.ftl");

                return modelAndView(viewObjects, "layout.ftl");
            }
        });

        Spark.post("/article/create", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                String title = request.queryParams("article-title");
                String summary = request.queryParams("article-summary");
                String content = request.queryParams("article-content");

                /* Refactor */
                // Use the articleDbService.create method
                Article article = new Article(title, summary, content, articleDbService.readAll().size());
                articleDbService.create(article);

                response.status(201);
                response.redirect("/");
                return "";
            }
        });


        Spark.get("/article/read/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                Integer id = Integer.parseInt(request.params(":id"));
                Map<String, Object> viewObjects = new HashMap<String, Object>();

                viewObjects.put("templateName", "articleRead.ftl");

                viewObjects.put("article", articleDbService.readOne(id));

                return modelAndView(viewObjects, "layout.ftl");
            }
        });

        Spark.get("/article/update/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                Integer id = Integer.parseInt(request.params(":id"));
                Map<String, Object> viewObjects = new HashMap<String, Object>();

                viewObjects.put("templateName", "articleForm.ftl");

                /* Refactor */
                // Use the readOne to fetch an article by its unique id
                viewObjects.put("article", articleDbService.readOne(id));

                return modelAndView(viewObjects, "layout.ftl");
            }
        });

        Spark.post("/article/update/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                Integer id = Integer.parseInt(request.queryParams("article-id"));
                String title = request.queryParams("article-title");
                String summary = request.queryParams("article-summary");
                String content = request.queryParams("article-content");

                /* Refactor */
                // The articleDbService handles all the updating once it has
                // be provided with the correct data
                articleDbService.update(id, title, summary, content);

                response.status(200);
                response.redirect("/");
                return "";
            }
        });

        Spark.get("/article/delete/:id", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                Integer id = Integer.parseInt(request.params(":id"));

                /* Refactor */
                // Provide the unique article Id and then its deleted
                articleDbService.delete(id);

                response.status(200);
                response.redirect("/");
                return "";
            }
        });

    /*    Spark.get("/freemarker", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();

            attributes.put("blogTitle", "Spark Blog!");
            attributes.put("descriptionTitle", "We're using Twitter Bootstrap 3");
            attributes.put("descriptionBody1", "Special thanks to Twitter for being so dang awesome and helping us");
            attributes.put("descriptionBody2", "No seriously... the web would be so ugly without Bootstrap");

            return new ModelAndView(attributes, "layout.ftl");
        }, new FreeMarkerEngine());

    */
    }
}





