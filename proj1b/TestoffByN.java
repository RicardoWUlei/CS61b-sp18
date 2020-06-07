import org.junit.Test;
import static org.junit.Assert.*;

public class TestoffByN {
    static CharacterComparator offByN = new offByN(5);

    /** Test for the equalChars(). */
    @Test
    public void testequalChars() {
        assertTrue(offByN.equalChars('a','f'));
        assertTrue(offByN.equalChars('b','g'));
        assertFalse(offByN.equalChars('a','h'));
        assertFalse(offByN.equalChars('a','a'));
        assertFalse(offByN.equalChars('a','z'));
    }
}
