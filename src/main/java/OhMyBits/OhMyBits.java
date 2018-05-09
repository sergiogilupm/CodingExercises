package OhMyBits;

public class OhMyBits {

    public static void main(String[] args) {

        // Get number of 1s in the byte representation of an integer
        int number = 16;
        String numberInBinary = Integer.toBinaryString(number);
        int numberOf1s = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                numberOf1s+=1;
            }
            number = number >> 1;
        }

        System.out.println("Number " + number + " (" + numberInBinary + ") has " + numberOf1s + " 1s.");
    }
}
