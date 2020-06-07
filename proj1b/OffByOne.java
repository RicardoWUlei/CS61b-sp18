public class OffByOne implements CharacterComparator {
    /** Returns true if X and Y are different by one, or false otherwise. */
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == 1 || x - y == -1;
    }
}
