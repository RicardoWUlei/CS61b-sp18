public class offByN implements CharacterComparator{
    public int N;

    /** Constructor. */
    public offByN(int n) {
        N = n;
    }

    /** Returns true for characters that are off by N */
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == N || y - x == N;
    }
}
