package WaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaterFlow {

    public static void main(String[] args) {
        List<Integer> firstLevel = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5)
        );
        getWaterLevel(firstLevel);

        List<Integer> secondLevel = new ArrayList<>(
                Arrays.asList(5, 2, 3, 4, 5)
        );
        getWaterLevel(secondLevel);

        List<Integer> thirdLevel = new ArrayList<>(
                Arrays.asList(3, 2, 3, 8, 5, 8)
        );
        getWaterLevel(thirdLevel);
    }


    public static void getWaterLevel (List<Integer> levels) {
        int waterAccumulated = 0;
        int levelLength = levels.size();
        int[] maxOnLeft = new int[levelLength];
        int[] maxOnRight = new int[levelLength];
        maxOnLeft[0] = 0;
        maxOnRight[levelLength - 1] = 0;

        for (int i=1; i < levelLength - 1; i++) {
            int currentLevelLeft = levels.get(i - 1);
            if (currentLevelLeft > maxOnLeft[i - 1]) {
                maxOnLeft[i] = currentLevelLeft;
            } else {
                maxOnLeft[i] = maxOnLeft[i-1];
            }
            int currentLevelRight = levels.get(levelLength - i);
            if (currentLevelRight > maxOnRight[(levelLength) - i]) {
                maxOnRight[(levelLength - 1) - i] = currentLevelRight;
            } else {
                maxOnRight[(levelLength - 1) - i] = maxOnRight[(levelLength) - i];
            }
        }

        for (int i=0; i<levelLength; i++) {
            int currentLevel = levels.get(i);
            int boundaries = Math.min(maxOnLeft[i], maxOnRight[i]);
            int waterLevel = (boundaries - currentLevel) > 0 ? boundaries - currentLevel : 0;
            waterAccumulated+= waterLevel;
        }

        System.out.println("Water level: " + waterAccumulated);
//        return waterAccumulated;
    }
}
