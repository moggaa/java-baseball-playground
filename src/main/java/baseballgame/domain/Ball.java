package baseballgame.domain;

import java.util.Objects;

public class Ball {
    private final Integer index;
    private final Integer number;

    public Ball(Integer index, Integer number) {
        if(!isValidIndex(index)){
            throw new IllegalArgumentException("순서가 유효하지 않습니다");
        }
        if(!isValidNumber(number)){
            throw new IllegalArgumentException("숫자가 유효하지 않습니다");
        }
        this.index = index;
        this.number = number;
    }

    private boolean isValidNumber(Integer number) {
        return number > 0 && number < 10;
    }

    private boolean isValidIndex(Integer index) {
        return index >= 0 && index <= 2;
    }

    public BallMatchStatus match(Ball ball) {
        if(this.equals(ball)){
            return BallMatchStatus.STRIKE;
        }
        if(isNumberSame(ball)){
            return BallMatchStatus.BALL;
        }
        return BallMatchStatus.NOTHING;
    }

    private boolean isNumberSame(Ball ball) {
        return Objects.equals(this.number, ball.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(index, ball.index) && Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, number);
    }
}
