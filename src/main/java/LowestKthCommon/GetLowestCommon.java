package LowestKthCommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetLowestCommon {

    public static void main(String[] args) {

        List<Integer> firstList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(2,4,5,7));
        List<Integer> thirdList = new ArrayList<>(Arrays.asList(2,5,7));

        int result = getIthLowestCommon(sortArray(firstList), sortArray(secondList), sortArray(thirdList), 1);
        System.out.println("Result is: " + result);
    }

    private static List<Integer> sortArray(List<Integer> inputList) {
        List<Integer> result = new ArrayList<>();

        return inputList;
    }


    private static int getIthLowestCommon(List<Integer> firstList, List<Integer> secondList, List<Integer> thirdList, int ith) {

        int firstPointer = 0;
        int secondPointer = 0;
        int thirdPointer = 0;
        int count = 0;
        int highestCurrentElement = 0;

        while (firstPointer < firstList.size() && secondPointer < secondList.size() && thirdPointer < thirdList.size()) {
            int firstListElement = firstList.get(firstPointer);
            highestCurrentElement = firstListElement;
            int secondListElement = secondList.get(secondPointer);
            highestCurrentElement = secondListElement > highestCurrentElement ? secondListElement : highestCurrentElement;
            int thirdListElement = thirdList.get(thirdPointer);
            highestCurrentElement = thirdListElement > highestCurrentElement ? thirdListElement : highestCurrentElement;


            while (firstListElement < highestCurrentElement && firstPointer + 1 < firstList.size()) {
                firstPointer++;
                firstListElement = firstList.get(firstPointer);
            }

            while (secondListElement < highestCurrentElement && secondPointer + 1 < secondList.size()) {
                secondPointer++;
                secondListElement = secondList.get(secondPointer);
            }

            while (thirdListElement < highestCurrentElement && thirdPointer + 1 < thirdList.size()) {
                thirdPointer++;
                thirdListElement = thirdList.get(thirdPointer);
            }

            if (firstListElement == secondListElement && secondListElement ==  thirdListElement) {
                count ++;
                if (count == ith) {
                    return firstListElement;
                }
                firstPointer++;
                secondPointer++;
                thirdPointer++;
            }
        }

        return -1;
    }
}


class Person {
    void walk() {
        System.out.println("Can Run...");
    }
}
class Employee extends Person {
    void walk() {
        System.out.println("Running Fast...");
    }
    public static void main(String arg[]) {
        Person p = new Employee(); //upcasting
        p.walk();
    }
}
