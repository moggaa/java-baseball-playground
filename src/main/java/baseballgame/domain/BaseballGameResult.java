package baseballgame.domain;

public class BaseballGameResult {

    private int strike;

    private int ball;



    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        String returnString = "";
        if(getBall()>0){
            returnString += getBall()+"볼 ";
        }
        if(getStrike()>0){
            returnString += getStrike()+"스트라이크";
        }

        return returnString;
    }

    public void addStatus(BallMatchStatus status) {
        if(status == BallMatchStatus.STRIKE){
            addStrike();
            return;
        }
        if(status == BallMatchStatus.BALL){
            addBall();
        }
    }

    private void addStrike(){
        strike+=1;
    }
    private void addBall(){
        ball+=1;
    }
}
