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
    @DisplayName("1,2 를 ,로 split 했을 때 잘 분리된다.")
    void split() {
        String tmp = "1,2";
        String[] split = tmp.split(",");
        assertThat(split[0]).isEqualTo("1");
        assertThat(split[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("(1,2)를 substring 메소드를 활용해 ()를 제거한다.")
    void substring() {
        String tmp = "(1,2)";
        String substring = tmp.substring(1, tmp.length() -1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc가 주어졌을 때 charAt()을 활용해 특정위치의 문자를 가져온다")
    void charAt() {
        String abc = "abc";
        assertThat(abc.charAt(0)).isEqualTo('a');
        assertThat(abc.charAt(1)).isEqualTo('b');
        assertThat(abc.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt()에서 위치 범위를 벗어났을 때 예외를 발생하시킨다.")
    void charAtException() {
        String abc = "abc";
        assertThatThrownBy(() -> abc.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .withFailMessage("String index out of range: \\d");
    }


}
