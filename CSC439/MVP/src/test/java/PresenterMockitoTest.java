import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Arrays;

public class PresenterMockitoTest {
    Presenter<Person> sut;

    @Mock Repository<Person> mockRepo;
    @Mock Person p1;
    @Mock Person p2;
    @Mock Person p3;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        sut = new Presenter<Person>(mockRepo);
        when(p1.compareTo(p2)).thenReturn(1);
        when(p1.compareTo(p3)).thenReturn(1);
        when(p2.compareTo(p1)).thenReturn(-1);
        when(p2.compareTo(p3)).thenReturn(-1);
        when(p3.compareTo(p2)).thenReturn(1);
        when(p3.compareTo(p1)).thenReturn(-1);
        when(mockRepo.getAll()).thenReturn(new ArrayList<>(Arrays.asList(p1, p2, p3)));
        when(p1.toStringFormat()).thenReturn("Smith Jr, Joe Alexander – Age 25");
    }

    @Test
    public void givenPresenter_whenSortPeople_thenSortedProperly() {
        ArrayList<Person> sortedList = new ArrayList<Person>();
        sortedList.add(p2);
        sortedList.add(p3);
        sortedList.add(p1);
        ArrayList<Person> sortedRepo = sut.sort();

        assertEquals(sortedList, sortedRepo);
    }

    @Test
    public void givenPresenter_whenToStringStudents_thenAListOfStudentStringsIsReturned() {
        ArrayList<String> stringArray = sut.toStringArray();
        assertEquals("Smith Jr, Joe Alexander – Age 25", stringArray.get(0));
    }

}
