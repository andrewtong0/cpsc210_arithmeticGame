package internal;

import external.ConcreteObserver;
import external.ConcreteSubject;
import puzzles.QuestionSet;
import puzzles.createQuestionSet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Reader {
    createQuestionSet newQuestionSet = new QuestionSet();

    public void writePercentageToFile(Integer percentage) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("savedata.txt"));
        PrintWriter writer = new PrintWriter("savedata.txt","UTF-8");
        for (String line : lines){
            if (line.contains("Completed:")){
                writer.println(addOneToNumberOfPuzzlesDone((line.substring(line.lastIndexOf(":") + 2))));
            }
            else {
                writer.println(line);
            }
        }
        writer.println(percentage.toString());
        System.out.println("Writing " + percentage.toString() + " to file");
        writer.close();
    }

    public String addOneToNumberOfPuzzlesDone(String puzzlesDone) throws IOException {
        Integer completed = Integer.parseInt(puzzlesDone);
        completed += 1;
        String prefix = "Completed: ";
        return(prefix + completed.toString());
    }

    public static void main(String[] args) {
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();
        ConcreteObserver observer3 = new ConcreteObserver();
        ConcreteSubject subject = new ConcreteSubject();

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.updateObservers();

        observer1.getState(); // Should print True
        observer2.getState(); // Should print True
        observer3.getState(); // Should print False
    }
}