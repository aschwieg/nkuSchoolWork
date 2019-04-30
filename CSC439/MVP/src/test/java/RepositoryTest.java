import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RepositoryTest {

    Repository sut;

    @Before
    public void init() {
        sut = new StudentRepository();
    }

    @Test
    public void givenRepository_whenInsertStudent_thenStudentInserted() {
        Student s = new Student();
        sut.insert(s);
    }

    @Test
    public void givenRepositoryWithStudent_whenGetStudent_thenStudentReturned() {
        Student s = new Student();
        sut.insert(s);
        assertEquals(s, sut.get(0));
    }

    @Test
    public void givenRepositoryWithSeveralStudents_whenGetAll_thenListOfStudentsReturned() {
        ArrayList<Student> sal = new ArrayList();
        Student s1 = new Student();
        Student s2 = new Student();
        sut.insert(s1);
        sut.insert(s2);
        sal.add(s1);
        sal.add(s2);

        assertEquals(sal, sut.getAll());
    }

}
