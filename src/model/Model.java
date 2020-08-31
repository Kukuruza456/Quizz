package model;

import java.io.*;
import java.util.HashMap;
import java.util.Random;

public class Model {

    private HashMap <Integer, Questions> questions = new HashMap();
    private HashMap <Integer, Questions> randomQuestions = new HashMap();

    public void readFile(){
        try {
            File file = new File("src/MaterialUTF.txt");

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {

                String[] question = line.split(";");
                questions.put(Integer.parseInt(question[0]), new Questions(question[1], question[2], question[3], question[4], question[5]));

                line = reader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Questions getQuestions(int random){
        Random random = new Random();
      int a = 0;


        return questions.get(random);
    }
    public void change(){
        String a = "change";
    }

}
