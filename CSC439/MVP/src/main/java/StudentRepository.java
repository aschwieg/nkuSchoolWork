import java.util.ArrayList;

public class StudentRepository implements Repository<Student> {
    private ArrayList<Student> repo;

    StudentRepository() {
        this.repo = new ArrayList<Student>();
        insert(new Student("Roberts", "Jr", "Bob", "A", 20));
        insert(new Student("Welson", "", "Alison", "B", 25));
        insert(new Student("Anderson", "Sr", "Kelly", "C", 30));
        insert(new Student("Reaves", "", "Jeff", "D", 35));
        insert(new Student("Bork", "Jr", "Albert", "E", 40));
    }

    @Override
    public void insert(Student p) {
        repo.add(p);
    }

    @Override
    public Student get(int i) {
        return repo.get(i);
    }

    @Override
    public ArrayList<Student> getAll() {
        return repo;
    }

    @Override
    public String getTitle() {
        return "<last> <suffix>, <first> <middle> - Age <age>";
    }

}
