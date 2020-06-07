public class OffByN implements CharacterComparator {
    private int N;

    /** Constructor. */
    public OffByN(int n) {
        N = n;
    }

    /** Returns true for characters that are off by N */
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == N || y - x == N;
    }
}
