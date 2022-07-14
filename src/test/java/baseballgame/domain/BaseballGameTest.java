package baseballgame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BaseballGameTest {
    BaseballGame baseballGame;

    @BeforeEach
    void generate(){
        baseballGame = new BaseballGame();
        baseballGame.generateAnswer(Arrays.asList(1,2,3));
    }

    @Test
    void checkValidate(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseballGame.generateAnswer(Arrays.asList(1,2)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseballGame.generateAnswer(Arrays.asList(1,3,3)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> baseballGame.generateAnswer(Arrays.asList(0,3,2)));

    }

    @Test
    void randomGenerate(){
        baseballGame.randomGenerate();
    }

    @Test
    void playNothing(){
        BaseballGameResult baseballGameResult =  baseballGame.play(Arrays.asList(5,6,7));
        assertThat(baseballGameResult.getStrike()).isEqualTo(0);
        assertThat(baseballGameResult.getBall()).isEqualTo(0);
    }

    @Test
    void playOneBallOneStrike(){
        BaseballGameResult baseballGameResult =  baseballGame.play(Arrays.asList(1,3,7));
        assertThat(baseballGameResult.getStrike()).isEqualTo(1);
        assertThat(baseballGameResult.getBall()).isEqualTo(1);
    }

    @Test
    void gameEndTest(){
        baseballGame.play(Arrays.asList(1,2,3));
        assertThat(baseballGame.isFinished()).isTrue();
    }





}