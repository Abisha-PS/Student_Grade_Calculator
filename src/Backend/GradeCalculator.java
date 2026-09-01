package Backend;
public class GradeCalculator {

    private final int[] marks;

    public GradeCalculator(int[] marks) {

        MarkValidator.validateMarks(marks);

        this.marks = marks.clone();
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

        return GradeSystem.calculateGrade(
                calculatePercentage(),
                isPass()
        );
    }

    // ------------------------------------------------------------
    // PERFORMANCE REMARK
    // ------------------------------------------------------------

    public String getRemark() {

        return PerformanceRemark.getRemark(
                calculatePercentage(),
                isPass()
        );
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