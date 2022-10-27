package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	@Test
	public void stringCalculatorBasicTest() {
		//given
		Calculator calculator = new Calculator("2 + 3 * 4 / 2");
		//when
		int actual = calculator.calculate();
		//then
		assertThat(actual).isEqualTo(10);
	}
}
