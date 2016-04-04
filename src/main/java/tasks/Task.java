package tasks;

/**
 * Created by ${DPudov} on 01.04.2016.
 */
public class Task implements ITask {
    public boolean rightSolved = true;
    public int rightSolvedCounter = 0;

    public void setRightSolved(boolean rightSolved) {
        this.rightSolved = rightSolved;
    }

    public int counter = 1;

    public String[] generateRandomWrongAnswers(String rightAnswer) {
        return new String[0];
    }
}
