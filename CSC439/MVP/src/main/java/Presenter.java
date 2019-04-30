import java.util.ArrayList;
import java.util.Collections;

public class Presenter <T extends Person> {
    private Repository<T> repo;
    private String title;

    public Presenter(Repository<T> repo) {
        this.repo = repo;
        this.title = repo.getTitle();
    }

    public ArrayList<T> sort() {
        ArrayList<T> personArray = repo.getAll();

        Collections.sort(personArray);

        return personArray;
    }

    public ArrayList<String> toStringArray() {
        ArrayList<T> personArray = repo.getAll();
        ArrayList<String> stringArray = new ArrayList<String>();

        for (T p : personArray) {
            stringArray.add(p.toStringFormat());
        }

        return stringArray;
    }

    public String getTitle() {
        return this.title;
    }
}
