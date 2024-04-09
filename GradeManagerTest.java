import static org.junit.Assert.*;
import org.junit.Test;

public class GradeManagerTest {

    @Test
    public void testAddGrade() throws InvalidGradeException {
        GradeManager gradeManager = new GradeManager();
        gradeManager.addGrade("Alice", 85);
        assertEquals(1, gradeManager.getGrades().size());
        assertEquals(Integer.valueOf(85), gradeManager.getGrades().get("Alice"));
    }

    @Test(expected = InvalidGradeException.class)
    public void testAddGradeWithInvalidGrade() throws InvalidGradeException {
        GradeManager gradeManager = new GradeManager();
        gradeManager.addGrade("Bob", 110); // Grade exceeds the valid range
    }
}
