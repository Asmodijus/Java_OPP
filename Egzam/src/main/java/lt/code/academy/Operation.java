package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operation {


    private ObjectMapper objectMapper = new ObjectMapper();
    private List<StudentAnswer> studentAnswers = new ArrayList<>();
    private Map<String, List<String>> correctAnswers = new HashMap<>();
    private List<StudentResult> studentResults = new ArrayList<>();

    public static void main(String[] args) {



        Operation op = new Operation();
        op.readStudent();
        op.readCorrect();
        op.compareAnswers();
        op.writeStudent();

    }

    private void readStudent() {
        try {
            studentAnswers = objectMapper.readValue(new File("StudentAnswer.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, StudentAnswer.class));
        } catch (IOException e) {
            System.out.println("Error reading student answers file: " + e.getMessage());
        }
        System.out.println(studentAnswers);
    }

    private void readCorrect() {
        try {
            correctAnswers = objectMapper.readValue(new File("CorrectAnswers.json"), objectMapper.getTypeFactory().constructMapType(Map.class, String.class, List.class));
        } catch (IOException e) {
            System.out.println("Error reading correct answers file: " + e.getMessage());
        }
    }

    private void compareAnswers() {
        for (StudentAnswer studentAnswer : studentAnswers) {
            List<String> correctAnswer = correctAnswers.get(studentAnswer.getTestId());
            int correctCount = 0;
            for (int i = 0; i < correctAnswer.size(); i++) {
                if (studentAnswer.getAnswers().get(i).equals(correctAnswer.get(i))) {
                    correctCount++;
                }
            }
            studentResults.add(new StudentResult(studentAnswer.name,studentAnswer.surname,studentAnswer.studentId,studentAnswer.testId, correctCount));
        }
    }

    private void writeStudent() {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File("student_results.json"), studentResults);
            System.out.println("Student results written to student_results.json");
        } catch (IOException e) {
            System.out.println("Error writing student results file: " + e.getMessage());
        }
    }
}

