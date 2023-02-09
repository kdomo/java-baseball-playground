package Calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ColculatorTest {
	Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("계산기가 정상적으로 동작하는지 확인")
	void 계산기가_정상적으로_동작하는지_확인() {
	    //when
		int result = calculator.calculate("1 + 2 + 3 / 3");
		//then
		assertEquals(result, 2);
		Assertions.assertThatCode(() -> calculator.calculate("1 + 2 + 3 / 3"))
				.doesNotThrowAnyException();
	}

	@ParameterizedTest
	@CsvSource(value = {"2:+:10:12", "3:*:5:15"}, delimiter = ':')
	@DisplayName("계산기가 정상적으로 동작하는지 ParameterizedTest로 확인")
	void 계산기가_정상적으로_동작하는지_ParameterizedTest로_확인(
			int num1, String opration, int num2, int result
	) {
	    //then
		assertEquals(calculator.operateResult(opration, num1, num2), result);
	}

	@Test
	@DisplayName("더하기가 정상적으로 수행되는지 확인")
	void 더하기가_정상적으로_수행되는지_확인() {
	    //given
	    //when
		int result = calculator.add(1, 2);
		//then
		assertEquals(result, 3);
	}

	@Test
	@DisplayName("뺄셈이 정상적으로 수행되는지 확인")
	void 뺄셈이_정상적으로_수행되는지_확인() {
	    //given
		//when
		int result = calculator.subtraction(3,5);
	    //then
		assertEquals(result, -2);
	}

	@Test
	@DisplayName("나누기가 정상적으로 수행되는지 확인")
	void 나누기가_정상적으로_수행되는지_확인() {
	    //given
	    //when
		int result = calculator.divide(6, 3);
	    //then
		assertEquals(result, 2);
	}

	@Test
	@DisplayName("곱하기가 정상적으로 수행되는지 확인")
	void 곱하기가_정상적으로_수행되는지_확인() {
	    //given
	    //when
		int result = calculator.multiply(10, 2);
		//then
		assertEquals(result, 20);
	}
}