package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

	@Test
	@DisplayName("size()메서드를 활용해 Set의 크기를 확인한다")
	void setSize() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("Set의 contains를 활용해 1,2,3의 값이 존재하는지 확인")
	void setContains() {
		assertThat(numbers.contains(1)).isTrue();
		assertThat(numbers.contains(2)).isTrue();
		assertThat(numbers.contains(3)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("ParameterizedTest를 활용해 중복코드를 제거해본다")
	void setContains(int input) {
		assertTrue(numbers.contains(input));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("입력 값이 여러개일때")
	void setContains_csvSource(int num, boolean result) {
		assertThat(numbers.contains(num)).isEqualTo(result);
	}
}
