import java.util.*;

public class MergeIntervals {


    public static void main(String[] args) {

        List<Interval> inputTest = new ArrayList<>();
        Interval firstInterval = new Interval(2, 4);
        Interval secondInterval = new Interval(1, 2);
        Interval thirdInterval = new Interval(4, 9);
        Interval fourthInterval = new Interval(5, 7);
        Interval fifthInterval = new Interval(6, 8);
        inputTest.add(firstInterval);
        inputTest.add(secondInterval);
        inputTest.add(thirdInterval);
        inputTest.add(fourthInterval);
        inputTest.add(fifthInterval);

        List<Interval> result = merge(inputTest);

        for (Interval interval : result) {
            System.out.println(interval.getLowerBound() + "," + interval.getHigherBound());
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval interval1, Interval interval2) {
                return interval1.getLowerBound() - interval2.getLowerBound();
            }
        });

        LinkedList<Interval> results = new LinkedList<>();
        for (Interval interval : intervals) {
            if (results.isEmpty() || results.getLast().getHigherBound() < interval.getLowerBound()) {
                results.add(interval);
            } else {
                results.getLast().setHigherBound(Math.max(results.getLast().getHigherBound(), interval.getHigherBound()));
            }
        }
        return results;
    }
}


class Interval {

    private int lowerBound;
    private int higherBound;

    public Interval(int lowerBound, int higherBound) {
        this.lowerBound = lowerBound;
        this.higherBound = higherBound;
    }


    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getHigherBound() {
        return higherBound;
    }

    public void setHigherBound(int higherBound) {
        this.higherBound = higherBound;
    }
}
