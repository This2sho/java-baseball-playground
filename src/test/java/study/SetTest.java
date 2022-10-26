package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	// Test Case 구현
	@Test
	@DisplayName("Set 크기 테스트")
	public void setSizeTest() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest(name = "Set에 {index} 포함되는지 테스트")
	@ValueSource(ints = {1, 2, 3})
	public void setContainsTest(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}
}
