import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;

public class ViewMockitoTest {
    View sut;
    @Mock Presenter<Person> mockPres;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        sut = new View(mockPres);
        when(mockPres.toStringArray()).thenReturn(new ArrayList<String>(Arrays.asList("a", "b", "c")));
    }

    @Test
    public void givenView_whenCallDisplayData_thenDataPrintedToConsole() {
        sut.displayData();
    }

}
