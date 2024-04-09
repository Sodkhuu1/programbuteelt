import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Custom exception class
class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

// Main class
public class GradeManager {
    private Map<String, Integer> grades;
    private FileWriter fileWriter;

    public GradeManager() {
        this.grades = new HashMap<>();
        try {
            this.fileWriter = new FileWriter("answers.txt", true); // файл руу
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add grade with exception handling
    public void addGrade(String studentName, int grade) throws InvalidGradeException {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException("Invalid grade: " + grade);
        }
        grades.put(studentName, grade);
        char gradeLetter = getLetterGrade(grade);
        writeToFile(studentName + ": " + grade + " (" + gradeLetter + ")"); // Дүнг оруулсны дараа файл руу хуулах
    }

    // Method to get letter grade
    public char getLetterGrade(int grade) {
        if (grade >= 90) {
            return 'A';
        } else if (grade >= 80) {
            return 'B';
        } else if (grade >= 70) {
            return 'C';
        } else if (grade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // файл руу хуулах method
    private void writeToFile(String content) {
        try {
            fileWriter.write(content + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // дүнг хүлээн авах
    public Map<String, Integer> getGrades() {
        return grades;
    }

    // Main method
    public static void main(String[] args) {
        GradeManager gradeManager = new GradeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Suragchiin neriig oruulna uu! (Garah bol 'quit' gej bichne uu!): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.println("Dung oruulna uu!: ");
            int grade = Integer.parseInt(scanner.nextLine());

            try {
                gradeManager.addGrade(name, grade);
                System.out.println("Dung amjilttai hadgallaa.");
            } catch (InvalidGradeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
