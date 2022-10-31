import java.util.Scanner;

public class InputView {

	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final Scanner scanner = new Scanner(System.in);

	public String inputNumbers() {
		printInputMessage();
		return scanner.next();
	}

	public boolean inputDoContinue() {
		printEndMessage();
		int selectMenu = scanner.nextInt();
		return selectMenu == 1;
	}

	private void printInputMessage() {
		System.out.print(INPUT_MESSAGE);
	}

	private void printEndMessage() {
		System.out.println(END_MESSAGE);
	}
}
