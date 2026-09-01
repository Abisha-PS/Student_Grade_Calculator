package Backend;

public class PerformanceRemark {

    private PerformanceRemark() {
        // Utility class
    }

    public static String getRemark(
            double percentage,
            boolean pass) {

        if (!pass) {

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
}