import static spark.Spark.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;
import lombok.Data;
import routes.Step2;


public class Main {
  /*private static Map<String, Book> books = new HashMap<String, Book>();

  public static class Book {

    public String author, title;

    public Book(String author, String title) {
      this.author = author;
      this.title = title;
    }

    public String getAuthor() {
      return author;
    }

    public void setAuthor(String author) {
      this.author = author;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }
  }*/



  /*private static final int HTTP_BAD_REQUEST = 400;

  interface Validable {
    boolean isValid();
  }

  @Data
  static class NewPostPayload {
    private String title;
    private List categories = new LinkedList<>();
    private String content;

    public boolean isValid() {
      return title != null && !title.isEmpty() && !categories.isEmpty();
    }
  }

  // In a real application you may want to use a DB, for this example we just store the posts in memory
  public static class Model {
    private int nextId = 1;
    private Map posts = new HashMap<>();

    @Data
    class Post {
      private int id;
      private String title;
      private List categories;
      private String content;
    }

    public int createPost(String title, String content, List categories){
      int id = nextId++;
      Post post = new Post();
      post.setId(id);
      post.setTitle(title = "1");
      post.setTitle() = "2";
      post.setContent(content);
      post.setCategories(categories);
      posts.put(id, post);
      return id;
    }
    public List getAllPosts(){

      return (List) posts.keySet().stream().sorted().map((id) -> posts.get(id)).collect(Collectors.toList());
    }


  }




  public static String dataToJson(Object data) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.enable(SerializationFeature.INDENT_OUTPUT);
      StringWriter sw = new StringWriter();
      mapper.writeValue(sw, data);
      return sw.toString();
    } catch (IOException e){
      throw new RuntimeException("IOException from a StringWriter?");
    }
  }

*/



  public static void main(String[] args) {

    /*final Random random = new Random();

    // Creates a new book resource, will return the ID to the created resource
    // author and title are sent in the post body as x-www-urlencoded values e.g. author=Foo&title=Bar
    // you get them by using request.queryParams("valuename")
    post("/books", (request, response) -> {
      String author = request.queryParams("author");
      String title = request.queryParams("title");
      Book book = new Book(author, title);

      int id = random.nextInt(Integer.MAX_VALUE);
      books.put(String.valueOf(id), book);

      response.status(201); // 201 Created
      return id;
    });

    // Gets the book resource for the provided id
    get("/books/:id", (request, response) -> {
      Book book = books.get(request.params(":id"));
      if (book != null) {
        return "Title: " + book.getTitle() + ", Author: " + book.getAuthor();
      } else {
        response.status(404); // 404 Not found
        return "Book not found";
      }
    });

    // Updates the book resource for the provided id with new information
    // author and title are sent in the request body as x-www-urlencoded values e.g. author=Foo&title=Bar
    // you get them by using request.queryParams("valuename")
    put("/books/:id", (request, response) -> {
      String id = request.params(":id");
      Book book = books.get(id);
      if (book != null) {
        String newAuthor = request.queryParams("author");
        String newTitle = request.queryParams("title");
        if (newAuthor != null) {
          book.setAuthor(newAuthor);
        }
        if (newTitle != null) {
          book.setTitle(newTitle);
        }
        return "Book with id '" + id + "' updated";
      } else {
        response.status(404); // 404 Not found
        return "Book not found";
      }
    });

    // Deletes the book resource for the provided id
    delete("/books/:id", (request, response) -> {
      String id = request.params(":id");
      Book book = books.remove(id);
      if (book != null) {
        return "Book with id '" + id + "' deleted";
      } else {
        response.status(404); // 404 Not found
        return "Book not found";
      }
    });

    // Gets all available book resources (ids)
    get("/books", (request, response) -> {
      String ids = "";
      for (String id : books.keySet()) {
        ids += id + " ";
      }
      return ids;
    });


    //port(Integer.valueOf(System.getenv("PORT")));
    //staticFileLocation("/public");
    */
   /* Model model = new Model();

    // insert a post (using HTTP post method)
    post("/posts", (request, response) -> {
      try {
        ObjectMapper mapper = new ObjectMapper();
        NewPostPayload creation = mapper.readValue(request.body(), NewPostPayload.class);
        if (!creation.isValid()) {
          response.status(HTTP_BAD_REQUEST);
          return "";
        }
        int id = model.createPost(creation.getTitle(), creation.getContent(), creation.getCategories());
        response.status(200);
        response.type("application/json");
        return id;
      } catch (JsonParseException jpe) {
        response.status(HTTP_BAD_REQUEST);
        return "";
      }
    });

    // get all post (using HTTP get method)
    get("/posts", (request, response) -> {
      response.status(200);
      response.type("application/json");
      return dataToJson(model.getAllPosts());
    });

*/


    //Object r = new JavaGettingStarted();
    //Object r = new Week6Routes();
    //Object r = new Week7Routes();
    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
    Object r = new Step2();


  }
}



