package baseballgame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    Ball ball = new Ball(1,1);

    @Test
    void numberValidate(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                        .isThrownBy(() -> {new Ball(1,0);});
        assertThatNoException().isThrownBy(() -> {new Ball(1,1);});
        assertThatNoException().isThrownBy(() -> {new Ball(1,9);});
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {new Ball(1,10);});
    }

    @Test
    void indexValidate(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {new Ball(-1,1);});
        assertThatNoException().isThrownBy(() -> {new Ball(0,1);});
        assertThatNoException().isThrownBy(() -> {new Ball(2,1);});
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {new Ball(3,1);});
    }

    @Test
    void matchNothing(){
        BallMatchStatus ballMatchStatus = ball.match(new Ball(1,3));
        assertThat(ballMatchStatus).isEqualTo(BallMatchStatus.NOTHING);
    }

    @Test
    void matchStrike(){
        BallMatchStatus ballMatchStatus = ball.match(new Ball(1,1));
        assertThat(ballMatchStatus).isEqualTo(BallMatchStatus.STRIKE);
    }

    @Test
    void matchBall(){
        BallMatchStatus ballMatchStatus = ball.match(new Ball(2,1));
        assertThat(ballMatchStatus).isEqualTo(BallMatchStatus.BALL);
    }



}