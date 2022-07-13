package baseballgame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BallsTest {
    Balls balls = new Balls(Arrays.asList(1,2,3));

    @Test
    void validateBalls(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {new Balls(Arrays.asList(1,2));});
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {new Balls(Arrays.asList(1,3,3));});
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {new Balls(Arrays.asList(0,3,2));});
    }

    @Test
    void matchBalls(){
        BallMatchStatus ballMatchStatus = balls.match(new Ball(1,4));
        assertThat(ballMatchStatus).isEqualTo(BallMatchStatus.NOTHING);
    }

    @Test
    void matchStrike(){
        BallMatchStatus ballMatchStatus = balls.match(new Ball(0,1));
        assertThat(ballMatchStatus).isEqualTo(BallMatchStatus.STRIKE);
    }

    @Test
    void matchBall(){
        BallMatchStatus ballMatchStatus = balls.match(new Ball(1,1));
        assertThat(ballMatchStatus).isEqualTo(BallMatchStatus.BALL);
    }
}
