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
		numbers.add(Integer.parseInt(number));
	}

	private void addOperator(String operator) {
		operators.add(operator.charAt(0));
	}
}
