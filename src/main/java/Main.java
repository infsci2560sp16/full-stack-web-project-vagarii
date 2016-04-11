import static spark.Spark.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;
import lombok.Data;
import routes.Article;
import routes.Step2;
import routes.Step3;


public class Main {

  public static void main(String[] args) {


    //Object r = new JavaGettingStarted();
    //Object r = new Week6Routes();
    //Object r = new Week7Routes();
    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
    //Object r = new Step2();
    Object r = new Step3();


  }
}



