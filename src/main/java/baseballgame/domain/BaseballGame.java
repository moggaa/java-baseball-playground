package baseballgame.domain;

import util.Utils;

import java.util.List;

public class BaseballGame {

    private Balls answerBalls;

    private Boolean finished;

    public void generateAnswer(List<Integer> numberList) {
        answerBalls = new Balls(numberList);
        setFinished(false);
    }

    public void randomGenerate() {
        generateAnswer(Utils.randomNumberGenerate(Balls.BALLSIZE));
    }

    public BaseballGameResult play(List<Integer> numberList) {
        Balls balls = new Balls(numberList);
        BaseballGameResult baseballGameResult = new BaseballGameResult();
        balls.getBallList().forEach(ball -> baseballGameResult.addStatus(answerBalls.match(ball)));

        if(baseballGameResult.getStrike() == Balls.BALLSIZE){
            setFinished(true);
        }
        return baseballGameResult;

    }

    private void setFinished(boolean finished){
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }
}
