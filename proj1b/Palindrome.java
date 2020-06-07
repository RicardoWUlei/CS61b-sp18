public class Palindrome {
    /** Returns a deque where the characters appear in the same order as in the word. */
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque result = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i ++ ){
            result.addLast(word.charAt(i));
        }
        return result;
    }

    /** Returns true if the given word is a palindrome, and false otherwise.*/
    public boolean isPalindrome(String word) {
        LinkedListDeque wordDeque = (LinkedListDeque) wordToDeque(word);
        return isPalindromeHelper(wordDeque);
    }

    /** The helper method for isPalindrome. */
    private boolean isPalindromeHelper(Deque<Character> wordDeque) {
        if (wordDeque.size() < 2) {
            return true;
        }
        if (wordDeque.removeFirst() == wordDeque.removeLast()) {
            return isPalindromeHelper(wordDeque);
        } else {
            return false;
        }
    }

    /** Returns true if the word is palindrome according to the CharacterComparator. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        LinkedListDeque wordDeque = (LinkedListDeque) wordToDeque(word);
        return isPalindromeHelper(wordDeque, cc);
    }

    /** The helper method for isPalindrome with CharacterComparator. */
    private boolean isPalindromeHelper(Deque<Character> wordDeque, CharacterComparator cc) {
        if (wordDeque.size() < 2) {
            return true;
        }
        if (cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())) {
            return isPalindromeHelper(wordDeque, cc);
        } else {
            return false;
        }
    }
}
