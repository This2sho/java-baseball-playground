import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class BaseBallGameTest {

	@RepeatedTest(10)
	public void getRandomTest() {
		//given
		BaseBallGame basBallGame = new BaseBallGame();
		String randomNumber = basBallGame.printComputerNumbers();
		System.out.println(randomNumber);
		//then
		assertThat(randomNumber).isNotEmpty();
	}
}
