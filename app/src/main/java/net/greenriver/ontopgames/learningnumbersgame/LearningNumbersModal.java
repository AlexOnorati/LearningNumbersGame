package net.greenriver.ontopgames.learningnumbersgame;

import java.util.Random;

/**
 * Created by alexo on 4/7/2016.
 */
public class LearningNumbersModal {

    public static final int LEFT_SIDE = 0;
    public static final int RIGHT_SIDE = 1;

    private Random randInt;
    private int maximum = 10;
    private int leftNumber;
    private int rightNumber;
    private int gamesPlayed;
    private int gamesWon;

    public LearningNumbersModal(int maximum){
        this();
        this.maximum = maximum;
    }

    public LearningNumbersModal(){
        randInt = new Random();
        generateNumbers();
        gamesPlayed = 0;
        gamesWon = 0;
    }

    public void generateNumbers(){
        leftNumber = randInt.nextInt(maximum) + 1;
        rightNumber = randInt.nextInt(maximum) + 1;

        if(leftNumber == rightNumber){

            if(leftNumber > maximum/2){
                leftNumber = randInt.nextInt(leftNumber-1)+1;
            }else{
                leftNumber = randInt.nextInt(maximum - leftNumber)+1 + leftNumber;
            }
        }
    }

    public int getLeftNumber(){
        return leftNumber;
    }

    public int getRightNumber(){
        return rightNumber;
    }

    public int getGamesPlayed(){
        return gamesPlayed;
    }

    public int getGamesWon(){
        return gamesWon;
    }
    
    public boolean play(int choice){
        gamesPlayed++;
        boolean result;

        if(choice == LEFT_SIDE){
            result = leftNumber > rightNumber;
        }else{
            result = rightNumber > leftNumber;
        }

        if(result){
            gamesWon++;
        }

        generateNumbers();

        return result;
    }
}
