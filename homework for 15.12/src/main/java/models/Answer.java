package models;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    private String text;
    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "student_answer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student_answer> student_answers;

    public Answer() {
    }
    public Answer(String line, boolean is_correct) {

        this.text = line;
        this.correct = is_correct;
        this.student_answers = new ArrayList<Student_answer>();
    }

    @Override
    public String toString() {
        return "Answer{" +
                "row_id=" + row_id +
                ", text='" + text + '\'' +
                ", correct=" + correct +
                ", question=" + question +
                ", student_answers=" + student_answers +
                '}';
    }
    public int getRow_id() {
        return row_id;
    }

    public String getText() {
        return text;
    }

    public List<Student_answer> getStudent_answers() {
        return student_answers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setStudent_answers(List<Student_answer> student_answers) {
        this.student_answers = student_answers;
    }

}
