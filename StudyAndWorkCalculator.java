public class StudyAndWorkCalculator {

    public static void main(String[] args) {
        int totalHours = calculateTotalHours();
        System.out.println("Total hours spent studying: " + totalHours);

        int totalHours2 = calculateTotalHours2();
        System.out.println("Total hours spent studying: " + totalHours2);
    }

    public static int calculateTotalHours() {
        int hoursInElementarySchool = 3 * 4 * 6 * 274 / 7; // 3 жил * 4 цаг/өдөр * 6 өдөр/долоо хоног * 274/7 долоо
                                                           // хоног/жил
        int hoursInMiddleSchool = 5 * 34 * 274 / 7; // 5 жил * 34 цаг/долоо хоног * 274/7 долоо хоног/жил
        int hoursInHighSchool = 2 * 6 * 6 * 274 / 7; // 2 жил * 6 цаг/өдөр * 6 өдөр/долоо хоног * 274/7 долоо хоног/жил

        // Арван жилийн хичээлийн цагийг энгийн цаг руу шилжүүлэх
        int convertedMiddleSchoolHours = (hoursInMiddleSchool + hoursInHighSchool + hoursInElementarySchool) * 45 / 60;

        // Дээд сургуулийн цаг
        int hoursInUniversity = 5 * 3 * 6 * 274 / 7; // 5 жил * 6 цаг/өдөр * 6 өдөр/долоо хоног * 274/7 долоо хоног/жил

        // Дээд сургуулийн хичээлийн цагийг энгийн цаг руу шилжүүлэх
        int convertedUniverHours = hoursInUniversity * 60 / 90;

        // нийт цаг
        int totalHours = convertedMiddleSchoolHours + convertedUniverHours;

        return totalHours;
    }

    public static int calculateTotalHours2() {
        int hoursInElementarySchool = 5 * 4 * 5 * 274 / 7; // 5 жил * 4 цаг/өдөр * 5 өдөр/долоо хоног * 274/7 долоо
                                                           // хоног/жил
        int hoursInMiddleAndHighSchool = 7 * 6 * 5 * 274 / 7; // 7 жил * 6 цаг/өдөр * 5 өдөр/долоо хоног * 274/7 долоо
                                                              // хоног/жил

        // Арван жилийн хичээлийн цагийг энгийн цаг руу шилжүүлэх
        int convertedMiddleSchoolHours = (hoursInMiddleAndHighSchool + hoursInElementarySchool) * 35 / 60;

        // Дээд сургуулийн цаг
        int hoursInUniversity = 5 * 3 * 6 * 274 / 7; // 5 years * 6 hours/day * 6 days/week * 4 weeks/month

        // Дээд сургуулийн хичээлийн цагийг энгийн цаг руу шилжүүлэх
        int convertedUniverHours = hoursInUniversity * 60 / 90;

        // нийт цаг
        int totalHours2 = convertedMiddleSchoolHours + convertedUniverHours;

        return totalHours2;
    }
}
