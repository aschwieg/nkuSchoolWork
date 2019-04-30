import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

public class PresenterTest {
    Presenter<Student> sut;
    StudentRepository mockRepo;

    @Before
    public void init() {
        mockRepo = new StudentRepository();
        sut = new Presenter<Student>(mockRepo);
    }

    @Test
    public void givenPresenter_whenSortPeople_thenSortedProperly() {
        ArrayList<Student> sortedList = mockRepo.getAll();
        Collections.sort(sortedList);

        ArrayList<Student> sortedRepo = sut.sort();

        assertEquals(sortedList, sortedRepo);
    }

    @Test
    public void givenPresenter_whenToStringStudents_thenAListOfStudentStringsIsReturned() {
        ArrayList<String> stringArray = sut.toStringArray();
        assertEquals("Roberts Jr, Bob A - Age 20", stringArray.get(0));
    }

}
