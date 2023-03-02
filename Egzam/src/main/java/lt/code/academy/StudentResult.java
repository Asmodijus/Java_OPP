package lt.code.academy;

public class StudentResult {
    private String name;
    private String surname;

    private String studentId;
    private String test;;
    private int mark;

    public StudentResult(String name, String surname, String studentId, String test, int mark) {
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
        this.test = test;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
