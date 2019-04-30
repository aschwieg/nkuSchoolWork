import java.util.ArrayList;

public class InstructorRepository implements Repository<Instructor> {
    private ArrayList<Instructor> repo;

    InstructorRepository() {
        this.repo = new ArrayList<Instructor>();
        insert(new Instructor("Dr", "Wilson", "Adjunct", "CSC201"));
        insert(new Instructor("Mr", "Burton", "Lecturer", "MAT101"));
        insert(new Instructor("Mrs", "Glover", "Adjunct", "PSY301"));
        insert(new Instructor("Ms", "Hanover", "Lecturer", "DSC401"));
        insert(new Instructor("Mr", "Seljuk", "Lecturer", "STA201"));
    }

    @Override
    public void insert(Instructor p) {
        repo.add(p);
    }

    @Override
    public Instructor get(int i) {
        return repo.get(i);
    }

    @Override
    public ArrayList<Instructor> getAll() {
        return repo;
    }

    @Override
    public String getTitle() {
        return "<prefix> <last>, <title>, <class>";
    }

}
