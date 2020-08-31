package controller;

import model.Model;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Controller implements ActionListener {

    private View view;
    private Model model;

    Random random = new Random();
    int rand = random.nextInt(30);

    int counter = 0;

    ArrayList <Integer> usedRandomNumbers = new ArrayList();

    public Controller() {
        this.view = new View();
        this.model = new Model();
        view.setListener(this);


        for (int i = 0; i < 30 ; i++) {
            usedRandomNumbers.add(i);
        }

        Collections.shuffle(usedRandomNumbers);

        model.readFile();

        System.out.println(model.getQuestions(usedRandomNumbers.get(counter)).getQuestion());
        view.getQuestion().setText(model.getQuestions(usedRandomNumbers.get(counter)).getQuestion());

        view.getAnswerOne().setText(model.getQuestions(usedRandomNumbers.get(counter)).getAnswers()[0]);
        view.getAnswerTwo().setText(model.getQuestions(usedRandomNumbers.get(counter)).getAnswers()[1]);
        view.getAnswerThree().setText(model.getQuestions(usedRandomNumbers.get(counter)).getAnswers()[2]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(counter <= 9) {
            if (e.getActionCommand().equals(view.getNexButton().getActionCommand())) {
                checkIfAnswerTrue();
            }
        }else{
            gameOver();
            view.getGameOver().setVisible(true);
        }
    }

    private void gameOver() {
        view.setInvisibleAll();
    }

    private void getNextQuestion() {
        counter++;
        view.getQuestion().setText(model.getQuestions(usedRandomNumbers.get(counter)).getQuestion());

        view.getAnswerOne().setText(model.getQuestions(usedRandomNumbers.get(counter)).getAnswers()[0]);
        view.getAnswerTwo().setText(model.getQuestions(usedRandomNumbers.get(counter)).getAnswers()[1]);
        view.getAnswerThree().setText(model.getQuestions(usedRandomNumbers.get(counter)).getAnswers()[2]);

        view.getQuestionCounterLabel().setText(counter + " von " + 10);

        view.invalidate();
        view.validate();
        view.repaint();
    }

    private void checkIfAnswerTrue() {
        if (view.getAnswerThree().isSelected()){
            System.out.println(model.getQuestions(usedRandomNumbers.get(counter)).getCorrect());
            if(view.getAnswerThree().getText().equals(model.getQuestions(usedRandomNumbers.get(counter)).getCorrect())){
                getNextQuestion();
                view.getAnswerInfo().setText("");
            }else{
                view.getAnswerInfo().setText("Falsch");
            }
        }else if(view.getAnswerTwo().isSelected()){
            if(view.getAnswerTwo().getText().equals(model.getQuestions(usedRandomNumbers.get(counter)).getCorrect())){
                getNextQuestion();
                view.getAnswerInfo().setText("");
            }else{
                view.getAnswerInfo().setText("Falsch");
            }
        }else if(view.getAnswerOne().isSelected()){
            if(view.getAnswerOne().getText().equals(model.getQuestions(usedRandomNumbers.get(counter)).getCorrect())){
                getNextQuestion();
                view.getAnswerInfo().setText("");
            }else{
                view.getAnswerInfo().setText("Falsch");
            }
        }
    }
}
