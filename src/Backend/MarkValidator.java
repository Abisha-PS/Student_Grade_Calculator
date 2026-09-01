package Backend;

public class MarkValidator {

    private MarkValidator() {
        // Utility class
    }

    public static void validateMarks(int[] marks) {

        if (marks == null || marks.length != 5) {
            throw new IllegalArgumentException(
                    "Exactly 5 subject marks are required."
            );
        }

        for (int mark : marks) {

            if (mark < 0 || mark > 100) {
                throw new IllegalArgumentException(
                        "Marks must be between 0 and 100."
                );
            }
        }
    }
}