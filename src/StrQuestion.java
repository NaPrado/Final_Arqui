import java.util.Scanner;

public class StrQuestion extends Question {
    private final String answer;
    StrQuestion(String question, String sugestion, String answer) {
        super(question, sugestion);
        this.answer=answer;
    }
    String state;
    @Override
    public boolean match() {
        return answer.equals(state);
    }

    @Override
    public void setParam() {
        Scanner sc=new Scanner(System.in);
        state=sc.nextLine();
    }
}
