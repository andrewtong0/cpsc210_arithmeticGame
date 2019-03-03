package puzzles;

public interface createQuestion {
    void generateNumbers();
    String selectOperand();
    int calculateAnswer(Integer num1, Integer num2);
    String presentQuestionAsString();
    void makeQuestion();
}
