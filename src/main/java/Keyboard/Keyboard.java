package Keyboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keyboard {

    private List<Character> firstColumn;
    private List<Character> secondColumn;
    private List<Character> thirdColumn;
    private List<Character> fourthColumn;
    private List<List<Character>> completeKeyboard = new ArrayList<>();
    private Character[] aToG = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
    private Character[] hToN = {'h', 'i', 'j', 'k', 'l', 'm', 'n'};
    private Character[] oToU = {'o', 'p', 'q', 'r', 's', 't', 'u'};
    private Character[] vToZ = {'v', 'w', 'x', 'y', 'z'};

    public Keyboard() {
        this.firstColumn = Arrays.asList(aToG);
        this.secondColumn = Arrays.asList(hToN);
        this.thirdColumn = Arrays.asList(oToU);
        this.fourthColumn = Arrays.asList(vToZ);
        this.completeKeyboard.add(0, firstColumn);
        this.completeKeyboard.add(1, secondColumn);
        this.completeKeyboard.add(2, thirdColumn);
        this.completeKeyboard.add(3, fourthColumn);
    }

    public List<Character> getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(List<Character> firstColumn) {
        this.firstColumn = firstColumn;
    }

    public List<Character> getSecondColumn() {
        return secondColumn;
    }

    public void setSecondColumn(List<Character> secondColumn) {
        this.secondColumn = secondColumn;
    }

    public List<Character> getThirdColumn() {
        return thirdColumn;
    }

    public void setThirdColumn(List<Character> thirdColumn) {
        this.thirdColumn = thirdColumn;
    }

    public List<Character> getFourthColumn() {
        return fourthColumn;
    }

    public void setFourthColumn(List<Character> fourthColumn) {
        this.fourthColumn = fourthColumn;
    }

    public List<List<Character>> getCompleteKeyboard() {
        return (List<List<Character>>) completeKeyboard;
    }
}
