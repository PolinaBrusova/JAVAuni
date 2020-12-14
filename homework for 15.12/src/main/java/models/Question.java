package models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    private String text;
    private int score;
    private boolean active;
    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Test> testQuestions;

    public Question() {

    }
    public Question(String text, int score, boolean active) {
        this.text = text;
        this.score = score;
        this.active = active;
        this.answers = new ArrayList<Answer>();
        this.testQuestions = new ArrayList<Test>();
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public int getScore() {
        return score;
    }

    public List<Test> getTestQuestions() {
        return testQuestions;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Question{" +
                "row_id=" + row_id +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", active=" + active +
                ", answers=" + answers +
                ", testQuestions=" + testQuestions +
                '}';
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTestQuestions(List<Test> testQuestions) {
        this.testQuestions = testQuestions;
    }
}
