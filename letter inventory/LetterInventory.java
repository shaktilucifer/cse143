import java.util.Arrays;

public class LetterInventory {
    private int[] counter;
    private int size = 0;
    private final static int ALPHABET_SIZE = 26;
    LetterInventory() {

    }

    LetterInventory(String str) {
        this.counter = new int[ALPHABET_SIZE];
        for (char ch : str.toCharArray()) {
             int index = getIndexOfCharacter(ch);
             if(index < 0 || index >= ALPHABET_SIZE) continue;
             this.counter[index]++;
             size++;
        }
    }

    private int getIndexOfCharacter(char ch) {
        return Character.toLowerCase(ch) - 'a';
    }

    public int size() {
        return size;
    }

    public int get(char ch) {
        return this.counter[getIndexOfCharacter(ch)];
    }

    public void set(char ch, int count) {
        return;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LetterInventory add(LetterInventory other) {
        return new LetterInventory();
    }

    public LetterInventory subtract(LetterInventory other) {
        return new LetterInventory();
    }


    @Override
    public String toString() {
        return "";
    }
}