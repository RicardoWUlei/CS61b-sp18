import java.util.ArrayDeque;

/** If you project is set up properly, this file should execute.
* One thing you might consider is to try printing out the sequence of
* operations */
public class StudentArrayDequeLauncher {
    public static void main(String[] args) {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDeque<String> operationsMade = new ArrayDeque<>();
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                operationsMade.addLast("addLast(" + i + ")");
            } else {
                sad1.addFirst(i);
                operationsMade.addLast("addFirst(" + i + ")");
            }
        }

        sad1.printDeque();
        for (String s : operationsMade) {
            System.out.print(s + " ");
        }
    }
} 
