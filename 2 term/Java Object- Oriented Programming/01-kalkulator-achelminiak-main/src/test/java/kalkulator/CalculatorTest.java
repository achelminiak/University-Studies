package kalkulator;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {
	@Test
	public void Addition() {
		Calculator sut = new Calculator();
		sut.add(1);
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void Multiplication() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void Division() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.divi(2);
		assertEquals("10/2 = 5", 5, sut.getState());
	}

	@Test
	public void Substraction() {
		Calculator sut = new Calculator();
		sut.setState(20);
		sut.sub(2);
		assertEquals("20-2 = 18", 18, sut.getState());
	}

	@Test
	public void UpperBoundaryAddition() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);
		sut.add(1);
		assertFalse("Overflow occurred while adding 1 to the upper boundary", sut.getStateCalculator());
	}

	@Test
	public void LowerBoundarySubtraction() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MIN_VALUE);
		sut.sub(1);
		assertFalse("Overflow occurred while subtracting 1 from the lower boundary", sut.getStateCalculator());
	}

	@Test
	public void UpperBoundaryMultiplication() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);
		sut.mult(2);
		assertFalse("Overflow occurred while multiplying the upper boundary by 2", sut.getStateCalculator());
	}

	@Test
	public void LowerBoundaryMultiplication() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MIN_VALUE);
		sut.mult(2);
		assertFalse("Overflow occurred while multiplying the lower boundary by 2", sut.getStateCalculator());
	}

	@Test
	public void testDivisionByOne() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);
		sut.divi(1);
		assertFalse("Overflow occurred while dividing the upper boundary by 1", sut.getStateCalculator());
	}

	@Test
	public void Divisionby0() {
		Calculator sut = new Calculator();
		sut.setState(5);
		sut.divi(0);
		assertTrue("Division by 0 occurred", sut.getStateCalculator());
	}

	@Test
	public void Log10() {
		Calculator sut = new Calculator();
		sut.log(100);
		assertEquals("Logarithm of 100 to base 10", 2, sut.getState());
	}

	@Test
	public void aSecondEquationSaved() {
		Calculator sut = new Calculator();
		sut.setState(12);
		sut.mult(12);
		sut.saveToHistory();
		sut.setState(23);
		sut.add(23);
		sut.saveToHistory();
		assertEquals("12*12=144", 46, sut.getState());
		assertEquals("result from first equation made by user", 46, sut.getResultsHistory(1));
	}
}