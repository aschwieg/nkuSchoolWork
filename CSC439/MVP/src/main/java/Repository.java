import java.util.ArrayList;

public interface Repository<T extends Person> {

    void insert(T p);

    T get(int i);

    ArrayList<T> getAll();

    String getTitle();

}
