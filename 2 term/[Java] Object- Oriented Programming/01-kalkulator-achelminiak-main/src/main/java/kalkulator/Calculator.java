package kalkulator;

import java.util.ArrayList;

public class Calculator {
	private int state = 0;
	private boolean calculatorstatus = true;
	private static ArrayList<Integer> list = new ArrayList<>();

	public int getState() {
		return state;
	}

	public boolean getStateCalculator() {
		return calculatorstatus;
	}

	public void saveToHistory() {
		list.add(state);
	}

	public int getResultsHistory(int index) {
		return list.get(index);
	}

	public void setState(int state) {
		this.state = state;
	}

	public void add(int value) {
		try {
			state = Math.addExact(state, value);
		} catch (ArithmeticException e) {
			calculatorstatus = false;
		}
	}

	public void mult(int value) {
		try {
			state = Math.multiplyExact(state, value);
		} catch (ArithmeticException e) {
			calculatorstatus = false;
		}
	}

	public void divi(int value) {
		try {
			if (value == 0) {
				state = 0;
			} else {
				state = Math.floorDiv(state, value);
			}
		} catch (ArithmeticException e) {
			calculatorstatus = false;
		}
	}

	public void sub(int value) {
		try {
			state = Math.subtractExact(state, value);
		} catch (ArithmeticException e) {
			calculatorstatus = false;
		}
	}

	public void log(int value) {
		state = (int) Math.log10(value);
	}
}
