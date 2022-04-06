package Problems;

import Problems.Random.LinkedLists.RemoveNthNodeFromEnd;
import Problems.Random.LinkedLists.ReverseBetweenTheNodes;
import Problems.educative.Arrays.MaxInSlidingWindow;

public abstract class Problem {

    public abstract void run();

    public static void main(String[] args) {
        Problem problem = new MaxInSlidingWindow();
        problem.run();
    }

}
