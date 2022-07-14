package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void checkDuplicatedTest(){
        assertThat(Utils.checkDuplicated(Arrays.asList(1,2,3))).isTrue();
        assertThat(Utils.checkDuplicated(Arrays.asList(1,1,3))).isFalse();
    }

    @Test
    void checkRandomNumberGenerate(){
        assertThat(Utils.randomNumberGenerate(3)).size().isEqualTo(3);
    }

}