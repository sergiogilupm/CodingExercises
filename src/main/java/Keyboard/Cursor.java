package Keyboard;

import java.util.ArrayList;
import java.util.List;

public class Cursor {

    private int xPosition;
    private int jPosition;
    private char currentChar;
    private Keyboard keyboard;

    public Cursor(Keyboard keyboard) {
        xPosition = 0;
        jPosition = 0;
        currentChar = 'a';
        this.keyboard = keyboard;
    }

    public Character getCharacter() {
        return currentChar;
    }

    public void updateCursor(){
        List<Character> column = keyboard.getCompleteKeyboard().get(jPosition);
        Character newCharacter = column.get(xPosition);
        currentChar = newCharacter;
    }

    public void printCharacter(){
        System.out.println(currentChar);
    }

    public void moveRight(){
        if (jPosition < 4 && xPosition < 4) {
            jPosition+=1;
        }
        updateCursor();
    }

    public void moveLeft(){
        if (jPosition > 0) {
            jPosition-=1;
        }
        updateCursor();
    }

    public void moveUp(){
        if (xPosition > 0) {
            xPosition -= 1;
        }
        updateCursor();
    }

    public void moveDown(){
        if (xPosition < 6) {
            xPosition +=1;
        }
        updateCursor();
    }

    public void goToChar(Character character) {
        int position = (int) character - (int) 'a';
        int newJPosition = position / 7;
        int newXPosition = position % 7;

        while (newJPosition != jPosition) {
            if (newJPosition < jPosition) {
                moveLeft();
            } else {
                moveRight();
            }
        }

        while (newXPosition != xPosition) {
            if (newXPosition < xPosition) {
                moveUp();
            } else {
                moveDown();
            }
        }
    }


}
