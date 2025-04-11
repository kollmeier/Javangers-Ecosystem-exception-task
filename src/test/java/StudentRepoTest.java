import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StudentRepoTest {

    @Test
    public void findById_shouldReturnStudent_whenStudentExists() {
        StudentRepo studentRepo = new StudentRepo();

        Student student = Student.builder()
                .id("1")
                .name("John Doe")
                .subject("Math")
                .build();

        studentRepo.save(student);

        Student result = studentRepo.findById("1");

        assertEquals(student, result);
    }

    @Test
    public void findById_shouldThrowIllegalArgumentsException_whenStudentDoesNotExist() {
        StudentRepo studentRepo = new StudentRepo();

        assertThrows(IllegalArgumentException.class, () -> {
            studentRepo.findById("2");
        });
    }

    @Test
    public void findById_shouldThrowNullPointerException_whenIdIsNull() {
        StudentRepo studentRepo = new StudentRepo();

        assertThrows(NullPointerException.class, () -> {
            studentRepo.findById(null);
        });
    }
}