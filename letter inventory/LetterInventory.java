import java.util.Arrays;

public class LetterInventory {
    private int[] counter;
    private int size = 0;
    private final static int ALPHABET_SIZE = 26;
    private final static String alphabets = "abcdefghijklmnopqrstuvwxyz";
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
        int index = getIndexOfCharacter(ch);
        int prev = this.counter[index];
        this.counter[index] = count;
        this.size = this.size - prev + count;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LetterInventory add(LetterInventory other) {
        String stringBuilder = this +
                other.toString();
        return new LetterInventory(stringBuilder);
    }

    public LetterInventory subtract(LetterInventory other) {
        int[] subtractedCounter = new int[ALPHABET_SIZE];
        for (int i = 0; i < subtractedCounter.length; i++) {
            int val = this.counter[i] - other.counter[i];
            if(val < 0) return null;
            subtractedCounter[i] = val;
        }
        return new LetterInventory(convertCounterToString(subtractedCounter));
    }

    private String convertCounterToString(int[] counter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counter.length; i++) {
            int count = counter[i];
            int j = 0;
            while (j < count) {
                sb.append(alphabets.charAt(i));
                j++;
            }
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "[" +
                convertCounterToString(this.counter) +
                "]";
    }
}