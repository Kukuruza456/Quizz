package model;

import java.util.Arrays;

public class Questions {
    private String question;
    private String [] answers = new String[3];
    private String correct;

    public Questions(String question, String answer1, String answer2, String answer3, String correct) {
        this.question = question;
        this.answers[0] = answer1;
        this.answers[1] = answer2;
        this.answers[2] = answer3;
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }



    public String[] getAnswers() {
        return answers;
    }

    public String getCorrect() {
        return correct;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", correct='" + correct + '\'' +
                '}';
    }
}
