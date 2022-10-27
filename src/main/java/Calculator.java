import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
	private final List<Integer> numbers;
	private final List<Character> operators;

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
		char op = operator.charAt(0);
		validateOperator(op);
		operators.add(op);
	}

	private void validateOperator(char op) {
		char[] OPERATORS = {'+', '-', '*', '/'};
		boolean doContain = Arrays.asList(OPERATORS).contains(op);
		if (!doContain) {
			throw new IllegalStateException("잘못된 형식의 입력입니다.");
		}
	}
}
