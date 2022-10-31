import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {

	private static final String START_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private GameNumbers computerNumbers;

	public BaseBallGame() {
		initComputerNumbers();
	}

	private void initComputerNumbers() {
		List<Integer> list = new LinkedList<>();
		setComputerNumbers(list);
	}


	private void setComputerNumbers(List<Integer> list) {
		if (list.size() == GameNumbers.NUMBER_SIZE) {
			computerNumbers = new GameNumbers(list);
			return;
		}
		int randomNumber = getRandomNumber();
		if (!list.contains(randomNumber)) {
			list.add(randomNumber);
		}
		setComputerNumbers(list);
	}

	private int getRandomNumber() {
		return (int) (Math.random() * 9 + 1);
	}

	public void start() {
		boolean doContinue = true;
		while (doContinue) {
			doContinue = doPlay();
		}
	}

	private boolean doPlay() {
		Scanner scanner = new Scanner(System.in);
		printStartMessage();
		String input = scanner.next();
		GameNumbers inputNumbers = new GameNumbers(input);
		while (!computerNumbers.isEndGame(inputNumbers)) {
			printStartMessage();
			input = scanner.next();
			inputNumbers = new GameNumbers(input);
		}
		printEndMessage();
		int selectMenu = scanner.nextInt();
		return selectMenu == 1;
	}

	private void printStartMessage() {
		System.out.print(START_MESSAGE);
	}

	private void printEndMessage() {
		System.out.println(END_MESSAGE);
	}

	public String printComputerNumbers() {
		return computerNumbers.toString();
	}
}
