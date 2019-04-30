import org.junit.Before;
import org.junit.Test;

public class ViewTest {

    View sut;

    @Before
    public void init() {
        StudentRepository r =  new StudentRepository();
        Presenter p = new Presenter<Student>(r);
        sut = new View(p);
    }

    @Test
    public void givenView_whenCallDisplayData_thenDataPrintedToConsole() {
        sut.displayData();
    }

}
