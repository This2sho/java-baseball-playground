package study;

import java.util.LinkedList;
import java.util.List;

public class Calculator {
	private final List<Integer> numbers;
	private final List<String> operators;
	public static final String OPERATORS = "+-*/";

	Calculator(String input) {
		String[] inputs = input.split(" ");
		numbers = new LinkedList<>();
		operators = new LinkedList<>();
		initInputs(inputs);
	}

	private void initInputs(String[] inputs) {
		boolean isNumber = true;
		for (String input : inputs) {
			isNumber = separatePart(isNumber, input);
		}
	}

	private boolean separatePart(boolean isNumber, String input) {
		if (isNumber) {
			addNumber(input);
			return false;
		}
		addOperator(input);
		return true;
	}

	private void addNumber(String number) {
		validateNumber(number);
		int num = Integer.parseInt(number);
		numbers.add(num);
	}

	private void validateNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalStateException("잘못된 형식의 입력입니다.");
		}
	}

	private void addOperator(String operator) {
		validateOperator(operator);
		operators.add(operator);
	}

	private void validateOperator(String operator) {
		boolean doContain = OPERATORS.contains(operator);
		if (!doContain) {
			throw new IllegalStateException("잘못된 형식의 입력입니다.");
		}
	}

	public int calculate() {
		return calculate(0, numbers.get(0));
	}

	private int calculate(int idx, int result) {
		if (idx == operators.size()) {
			return result;
		}

		String op = operators.get(idx++);
		if (op.equals("+")) {
			return calculate(idx, result + numbers.get(idx));
		}
		if (op.equals("-")) {
			return calculate(idx, result - numbers.get(idx));
		}
		if (op.equals("*")) {
			return calculate(idx, result * numbers.get(idx));
		}
		return calculate(idx, result / numbers.get(idx));
	}
}
