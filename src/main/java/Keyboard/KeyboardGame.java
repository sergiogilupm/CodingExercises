package Keyboard;

public class KeyboardGame {

    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard();
        Cursor cursor = new Cursor(keyboard);

        cursor.printCharacter();

        cursor.goToChar('q');
        cursor.printCharacter();

        cursor.goToChar('z');
        cursor.printCharacter();
    }
}
