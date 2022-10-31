import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameNumbersTest {

	@Test
	public void gameNumbersTest() {
		GameNumbers gameNumbers = new GameNumbers("123");
		//then
		assertThat(gameNumbers.toString()).isEqualTo("123");
	}

	@Test
	public void bigSizeErrorTest() {
		//given
		assertThatThrownBy(() ->
			new GameNumbers("1234"))
			.isInstanceOf(IllegalStateException.class);
	}

	@Test
	public void sameNumberErrorTest() {
		//given
		assertThatThrownBy(() ->
			new GameNumbers("122"))
			.isInstanceOf(IllegalStateException.class);
	}

	@Test
	public void notValidateNumberErrorTest() {
		//given
		assertThatThrownBy(() ->
			new GameNumbers("-112231"))
			.isInstanceOf(IllegalStateException.class);
	}

	@Test
	public void gameNumbersToStringTest() {
		//given
		GameNumbers target = new GameNumbers("123");
		//when
		GameNumbers expected = new GameNumbers("123");
		//then
		assertThat(target).isEqualTo(expected);
	}

	@Test
	public void endGameFalseTest() {
		//given
		GameNumbers gameNumbers = new GameNumbers("425");
		//when
		GameNumbers otherNumbers = new GameNumbers("456");
		//then
		assertThat(gameNumbers.isEndGame(otherNumbers)).isFalse();
	}

	@Test
	public void endGameTrueTest() {
		//given
		GameNumbers gameNumbers = new GameNumbers("425");
		//when
		GameNumbers otherNumbers = new GameNumbers("425");
		//then
		assertThat(gameNumbers.isEndGame(otherNumbers)).isTrue();
	}
}
