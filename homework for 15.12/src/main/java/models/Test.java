package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test_list test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    public int getRow_id() {
        return row_id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "row_id=" + row_id +
                ", test=" + test +
                ", question=" + question +
                '}';
    }

    public Question getQuestion() {
        return question;
    }

    public Test_list getTest() {
        return test;
    }

    public void setTest(Test_list test) {
        this.test = test;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


}
