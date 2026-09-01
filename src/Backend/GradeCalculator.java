package Backend;
public class GradeCalculator {

    private final int[] marks;

    public GradeCalculator(int[] marks) {

        if (marks == null || marks.length != 5) {
            throw new IllegalArgumentException(
                    "Exactly 5 subject marks are required."
            );
        }

        this.marks = marks.clone();

        validateMarks();
    }

    // ------------------------------------------------------------
    // VALIDATE MARKS
    // ------------------------------------------------------------

    private void validateMarks() {

        for (int mark : marks) {

            if (mark < 0 || mark > 100) {
                throw new IllegalArgumentException(
                        "Marks must be between 0 and 100."
                );
            }
        }
    }

    // ------------------------------------------------------------
    // TOTAL
    // ------------------------------------------------------------

    public int calculateTotal() {

        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    // ------------------------------------------------------------
    // AVERAGE
    // ------------------------------------------------------------

    public double calculateAverage() {

        return calculateTotal() / 5.0;
    }

    // ------------------------------------------------------------
    // PERCENTAGE
    // ------------------------------------------------------------

    public double calculatePercentage() {

        return calculateTotal() / 500.0 * 100;
    }

    // ------------------------------------------------------------
    // PASS / FAIL
    // ------------------------------------------------------------

    public boolean isPass() {

        for (int mark : marks) {

            if (mark < 35) {
                return false;
            }
        }

        return true;
    }

    // ------------------------------------------------------------
    // GRADE
    // ------------------------------------------------------------

    public String calculateGrade() {

        double percentage = calculatePercentage();

        if (!isPass()) {
            return "F";
        }

        if (percentage >= 90) {
            return "A+";
        }

        if (percentage >= 80) {
            return "A";
        }

        if (percentage >= 70) {
            return "B";
        }

        if (percentage >= 60) {
            return "C";
        }

        if (percentage >= 50) {
            return "D";
        }

        return "F";
    }

    // ------------------------------------------------------------
    // PERFORMANCE REMARK
    // ------------------------------------------------------------

    public String getRemark() {

        double percentage = calculatePercentage();

        if (!isPass()) {

            return "One or more subjects are below the passing mark. "
                    + "Focus on improving those subjects.";
        }

        if (percentage >= 90) {

            return "Outstanding performance! "
                    + "Keep maintaining this level.";
        }

        if (percentage >= 80) {

            return "Excellent performance! "
                    + "You are doing very well.";
        }

        if (percentage >= 70) {

            return "Very good performance. "
                    + "Keep working consistently.";
        }

        if (percentage >= 60) {

            return "Good performance. "
                    + "There is still room for improvement.";
        }

        if (percentage >= 50) {

            return "Average performance. "
                    + "More practice can improve your score.";
        }

        return "Needs improvement. "
                + "Create a regular study plan.";
    }

    // ------------------------------------------------------------
    // HIGHEST MARK
    // ------------------------------------------------------------

    public int getHighestMark() {

        int highest = marks[0];

        for (int mark : marks) {

            if (mark > highest) {
                highest = mark;
            }
        }

        return highest;
    }

    // ------------------------------------------------------------
    // LOWEST MARK
    // ------------------------------------------------------------

    public int getLowestMark() {

        int lowest = marks[0];

        for (int mark : marks) {

            if (mark < lowest) {
                lowest = mark;
            }
        }

        return lowest;
    }

    // ------------------------------------------------------------
    // GET MARK
    // ------------------------------------------------------------

    public int getMark(int index) {

        if (index < 0 || index >= marks.length) {

            throw new IndexOutOfBoundsException(
                    "Invalid subject index."
            );
        }

        return marks[index];
    }

    // ------------------------------------------------------------
    // GET ALL MARKS
    // ------------------------------------------------------------

    public int[] getMarks() {

        return marks.clone();
    }
}