import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class StudyTimeCalculator {

    // Method to calculate study time in high school and middle school for the first
    // period
    public static long calculateStudyTimePeriod1() {
        LocalDate start = LocalDate.of(1978, 9, 1);
        LocalDate end = LocalDate.of(1988, 9, 1);
        return calculateStudyTime(start, end);
    }

    // Method to calculate study time in high school and middle school for the
    // second period
    public static long calculateStudyTimePeriod2() {
        LocalDate start = LocalDate.of(2006, 9, 1);
        LocalDate end = LocalDate.of(2018, 9, 1);
        return calculateStudyTime(start, end);
    }

    // Method to calculate total study time between two dates
    private static long calculateStudyTime(LocalDate start, LocalDate end) {
        long studyTime = 0;
        LocalDate date = start;
        while (date.isBefore(end)) {
            // Calculating study time based on school schedule
            if (date.isBefore(LocalDate.of(1988, 9, 1))) { // For the first period
                if (date.getYear() >= 1978 && date.getYear() <= 1981) {
                    studyTime += 4 * 180; // 4 hours/day for 180 days/year (1st-3rd grade)
                } else if (date.getYear() >= 1982 && date.getYear() <= 1987) {
                    studyTime += 34 * 5; // 34 hours/week for 5 days (4th-8th grade)
                } else {
                    studyTime += 6 * 180; // 6 hours/day for 180 days/year (9th-10th grade)
                }
            } else { // For the second period
                if (date.getYear() >= 2006 && date.getYear() <= 2017) {
                    studyTime += 4 * 180; // 4 hours/day for 180 days/year (1st-5th grade)
                } else {
                    studyTime += 6 * 180; // 6 hours/day for 180 days/year (6th-12th grade)
                }
            }
            date = date.plusYears(1);
        }
        return studyTime;
    }

    // Method to compare hours spent on interests
    public static int compareInterestHours() {
        // First period: 4 hours per week, only counting 7 days
        int interestHoursPeriod1 = 4 * (365 / 7);
        // Second period: 4 hours per week, only counting 7 days
        int interestHoursPeriod2 = 4 * (365 / 7);
        return Integer.compare(interestHoursPeriod1, interestHoursPeriod2);
    }

    // Method to calculate the percentage of internship time
    public static double calculateInternshipPercentage() {
        int totalSemesters = 12; // 12 semesters for 6 years
        int internships = totalSemesters * 2; // 2 internships per semester
        int totalStudyWeeks = totalSemesters * 36; // Assuming 36 weeks per semester
        int totalInternshipWeeks = internships * 8; // 8 weeks per internship
        return ((double) totalInternshipWeeks / totalStudyWeeks) * 100;
    }

    public static void main(String[] args) {
        long period1Time = calculateStudyTimePeriod1();
        long period2Time = calculateStudyTimePeriod2();

        System.out.println("Study time in period 1: " + period1Time + " hours");
        System.out.println("Study time in period 2: " + period2Time + " hours");

        if (period1Time > period2Time) {
            System.out.println("Period 1 has more study time.");
        } else if (period1Time < period2Time) {
            System.out.println("Period 2 has more study time.");
        } else {
            System.out.println("Both periods have equal study time.");
        }

        int comparisonResult = compareInterestHours();
        if (comparisonResult > 0) {
            System.out.println("More hours spent on interests in period 1.");
        } else if (comparisonResult < 0) {
            System.out.println("More hours spent on interests in period 2.");
        } else {
            System.out.println("Equal hours spent on interests in both periods.");
        }

        double internshipPercentage = calculateInternshipPercentage();
        System.out.println("Percentage of internship time: " + internshipPercentage + "%");
    }
}