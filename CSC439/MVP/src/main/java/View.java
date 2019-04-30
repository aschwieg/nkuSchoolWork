import java.util.ArrayList;

public class View <T extends Person> {
    private Presenter<T> pres;

    public View(Presenter<T> pres) {
        this.pres = pres;
    }

    public void displayData() {
        pres.sort();
        ArrayList<String> printList = pres.toStringArray();

        System.out.println(pres.getTitle());
        for (String person : printList) {
            System.out.println(person);
        }
    }
}
