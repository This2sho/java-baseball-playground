package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void replace() {
		String actual = "abc".replace("b", "d");
		assertThat(actual).isEqualTo("adc");
	}

	@Test
	public void 요구사항1() {
		//given
		String origin = "1,2";
		//when
		String[] split = origin.split(",");
		//then
		assertThat(split).contains("1");
		assertThat(split).containsExactly("1", "2");
	}

	@Test
	public void 요구사항2() {
		//given
		String origin = "(1,2)";
		//when
		String actual = origin.substring(1, origin.length() - 1);
		//then
		assertThat(actual).isEqualTo("1,2");
	}

	@Test
	@DisplayName(value = "IndexOutOfBound 예외 발생")
	public void 요구사항3() {
		//given
		String given = "abc";
		//then
		assertThat(given.charAt(0)).isEqualTo('a');
		assertThat(given.charAt(1)).isEqualTo('b');
		assertThat(given.charAt(2)).isEqualTo('c');

		assertThatThrownBy(() ->
				given.charAt(3))
				.isInstanceOf(IndexOutOfBoundsException.class);
	}

}
