package baseballgame.domain;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    public static final int BALLSIZE = 3;
    private final List<Ball> ballList;

    public Balls(List<Integer> numberList) {
        if(!validateNumbers(numberList)){
            throw new IllegalArgumentException("올바른 숫자들이 아닙니다");
        }
        ballList = new ArrayList<>();

        for(int i = 0 ; i < 3 ; i++){
            ballList.add(new Ball(i,numberList.get(i)));
        }

    }

    private boolean validateNumbers(List<Integer> numberList){
        return Utils.validateNumbers(numberList,BALLSIZE);
    }

    public BallMatchStatus match(Ball ball) {
        return ballList.stream()
                .map(iBall -> iBall.match(ball))
                .filter(ballMatchStatus -> ballMatchStatus!=BallMatchStatus.NOTHING)
                .findFirst()
                .orElse(BallMatchStatus.NOTHING);
    }

    List<Ball> getBallList() {
        return ballList;
    }
}
