import java.util.LinkedList;
import java.util.List;

public class BaseBallGame {

	private final InputView inputView;
	private GameNumbers computerNumbers;

	public BaseBallGame() {
		initComputerNumbers();
		inputView = new InputView();
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
		String input = inputView.inputNumbers();
		GameNumbers inputNumbers = new GameNumbers(input);
		while (!computerNumbers.isEndGame(inputNumbers)) {
			input = inputView.inputNumbers();
			inputNumbers = new GameNumbers(input);
		}
		return inputView.inputDoContinue();
	}

	public String printComputerNumbers() {
		return computerNumbers.toString();
	}
}
