import java.util.ArrayList;
import java.util.List;

public class GameNumbers {

	static final int NUMBER_SIZE = 3;
	private final List<Integer> numbers;

	public GameNumbers(List<Integer> numbers) {
		validateNumbers(numbers);
		this.numbers = numbers;
	}

	public GameNumbers(String inputString) {
		List<Integer> numbers = stringToIntegers(inputString);
		validateNumbers(numbers);
		this.numbers = numbers;
	}

	private List<Integer> stringToIntegers(String inputString) {
		List<Integer> inputNumbers = new ArrayList<>();
		for (int i = 0; i < inputString.length(); i++) {
			int inputNumber = Character.getNumericValue(inputString.charAt(i));
			inputNumbers.add(inputNumber);
		}
		return inputNumbers;
	}

	public boolean isEndGame(GameNumbers otherNumbers) {
		int ballCount = 0;
		int strikeCount = 0;
		for (int i = 0; i < NUMBER_SIZE; i++) {
			int otherNumber = otherNumbers.get(i);
			strikeCount += checkStrike(i, otherNumber);
			ballCount += checkBall(i, otherNumber);
		}
		printMessage(ballCount, strikeCount);
		return strikeCount == NUMBER_SIZE;
	}

	private void printMessage(int ballCount, int strikeCount) {
		if (strikeCount == NUMBER_SIZE) {
			System.out.println("3스트라이크");
			return;
		}
		if (ballCount == 0 && strikeCount == 0) {
			System.out.println("낫싱");
			return;
		}
		if (ballCount > 0) {
			System.out.print(ballCount + "볼 ");
		}
		if (strikeCount > 0) {
			System.out.print(strikeCount + "스트라이크");
		}
		System.out.println();
	}

	private int get(int idx) {
		return this.numbers.get(idx);
	}

	private int checkBall(int idx, int otherNumber) {
		if (this.get(idx) == otherNumber) {
			return 0;
		}
		if (this.numbers.contains(otherNumber)) {
			return 1;
		}
		return 0;
	}

	private int checkStrike(int idx, int otherNumber) {
		if (this.get(idx) == otherNumber) {
			return 1;
		}
		return 0;
	}

	private void validateNumbers(List<Integer> numbers) {
		if (numbers.size() != NUMBER_SIZE) {
			throw new IllegalStateException("숫자 야구 게임의 숫자는 1부터 9까지 서로 다른 수로 이루어진 세자리 수입니다.");
		}
		for (Integer number : numbers) {
			if (number > 9 || number < 1) {
				throw new IllegalStateException("숫자 야구 게임의 숫자는 1부터 9까지 서로 다른 수로 이루어진 세자리 수입니다.");
			}
		}
		Integer num1 = numbers.get(0);
		Integer num2 = numbers.get(1);
		Integer num3 = numbers.get(2);
		if (num1.equals(num2) || num1.equals(num3) || num2.equals(num3)) {
			throw new IllegalStateException("숫자 야구 게임의 숫자는 1부터 9까지 서로 다른 수로 이루어진 세자리 수입니다.");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < NUMBER_SIZE; i++) {
			sb.append(numbers.get(i));
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object otherGameNumbers) {
		if (!otherGameNumbers.getClass().isAssignableFrom(GameNumbers.class)) {
			return false;
		}
		return this.toString().equals(otherGameNumbers.toString());
	}
}
