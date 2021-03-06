package routes;

/**
 * Created by XINLAI on 4/8/16.
 */

import java.util.ArrayList;

public interface ArticleDbService<T> {
    public Boolean create(T entity);
    public T readOne(int id);
    public ArrayList<T> readAll();
    public Boolean update(int id, String title, String summary, String content);
    public Boolean delete(int id);
}