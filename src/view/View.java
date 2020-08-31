package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private JLabel textTop = new JLabel("Kunstquiz");

    private JLabel question = new JLabel();

    private JRadioButton answerOne = new JRadioButton("text");
    private JRadioButton answerTwo = new JRadioButton("text");
    private JRadioButton answerThree = new JRadioButton("text");

    private JButton backButton = new JButton("Zurück");
    private JButton nexButton = new JButton("Weiter");
    private int questionCounter = 0;
    private JLabel questionCounterLabel = new JLabel(questionCounter + " von " + 10);

    private JLabel answerInfo = new JLabel("");

    private JPanel topPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel forAllPanel = new JPanel();
    private JPanel generalPanel = new JPanel();

    private JLabel gameOver = new JLabel("GAME OVER");

    public View(){
        Container cp = getContentPane();

        gameOver.setVisible(false);

        initializeTopPanel();
        initializeBottomPanel();


        forAllPanel.setLayout(new BoxLayout(forAllPanel, BoxLayout.Y_AXIS));

        forAllPanel.add(topPanel);
        forAllPanel.add(bottomPanel);

        generalPanel.add(forAllPanel, BorderLayout.CENTER);

        answerInfo.setBackground(Color.red);
        answerInfo.setForeground(Color.red);


        cp.add(generalPanel, BorderLayout.CENTER);
        cp.add(answerInfo, BorderLayout.SOUTH);

        settings();
    }

    public void setListener(Controller c){
        nexButton.addActionListener(c);
        backButton.addActionListener(c);
    }

    private void initializeBottomPanel() {
        bottomPanel.setLayout(new FlowLayout());

        bottomPanel.add(backButton);
        bottomPanel.add(questionCounterLabel);
        bottomPanel.add(nexButton);
    }

    private void initializeTopPanel() {
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        topPanel.add(textTop);
        topPanel.add(question);

        ButtonGroup answers = new ButtonGroup();

        answers.add(answerOne);
        answers.add(answerTwo);
        answers.add(answerThree);

        topPanel.add(answerOne);
        topPanel.add(answerTwo);
        topPanel.add(answerThree);
        topPanel.add(gameOver);
    }

    private void settings() {
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setInvisibleAll(){
        textTop.setVisible(false);
        question.setVisible(false);
        answerOne.setVisible(false);
        answerTwo.setVisible(false);
        answerThree.setVisible(false);
        backButton.setVisible(false);
        nexButton.setVisible(false);
    }


    public JLabel getTextTop() {
        return textTop;
    }

    public JLabel getQuestion() {
        return question;
    }

    public JRadioButton getAnswerOne() {
        return answerOne;
    }

    public JRadioButton getAnswerTwo() {
        return answerTwo;
    }

    public JRadioButton getAnswerThree() {
        return answerThree;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getNexButton() {
        return nexButton;
    }

    public int getQuestionCounter() {
        return questionCounter;
    }

    public JLabel getQuestionCounterLabel() {
        return questionCounterLabel;
    }

    public void setQuestion(JLabel question) {
        this.question = question;
    }

    public void setQuestionCounter(int questionCounter) {
        this.questionCounter = questionCounter;
    }

    public JLabel getAnswerInfo() {
        return answerInfo;
    }

    public JLabel getGameOver() {
        return gameOver;
    }
}
