import org.junit.*;
import static org.junit.Assert.*;

public class testCalculator {

    @Test
    public void GivenNoCalculator_WhenCreateCalculator_ThenCalculatorCreated() {
        Calculator sut = new Calculator();
    }

    @Test
    public void GivenTwoNumbers_WhenCalculatorAddsNumbers_ThenCalculatorProducesSum() {
        Calculator sut = new Calculator();
        assertEquals(2.0, sut.add(1.0,1.0), .0);
    }

    @Test
    public void GivenTwoNumbers_WhenCalculatorMultipliesNumbers_ThenCalculatorProducesProduct() {
        Calculator sut = new Calculator();
        assertEquals(4.0, sut.multiply(2.0,2.0), .0);
    }

    @Test
    public void GivenTwoNumbers_WhenCalculatorSubtractsFirstNumberFromSecondNumber_ThenCalculatorProducesDifference() {
        Calculator sut = new Calculator();
        assertEquals(1.0, sut.subtract(2.0,1.0), .0);
    }

    @Test
    public void GivenTwoNumbers_WhenCalculatorDividesFirstNumberBySecondNumber_ThenCalculatorProducesQuotient() {
        Calculator sut = new Calculator();
        assertEquals(2.0, sut.divide(4.0,2.0), .0);
    }

    @Test
    public void GivenOneNumbers_WhenCalculatorDividesFirstNumberByZero_ThenCalculatorThrowsError() {
        Calculator sut = new Calculator();
        String exception = "";

        try {
            sut.divide(1.0, 0.0);
        }
        catch (Exception e){
            exception = e.toString();
        }

        assertEquals("java.lang.ArithmeticException: Divided by zero", exception);
    }

    @Test
    public void GivenTwoNumbers_WhenCalculatorTakesTheExponentByTheSecondNumber_ThenCalculatorProducesResult() {
        Calculator sut = new Calculator();
        assertEquals(4.0, sut.exponent(2.0,2.0), .0);
    }
}
