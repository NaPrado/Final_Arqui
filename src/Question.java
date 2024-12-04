import java.util.Scanner;
import java.util.function.Predicate;

public class Question {
    String question;
    String sugestion;
    boolean state;
    Question(String question, String sugestion) {
        this.question = question;
        this.sugestion = sugestion;
    }

    Question(String question, String sugestion, boolean state) {
        this(question, sugestion);
        this.state = state;
    }


    public String getQuestion() {
        return question;
    }
    public String getSugestion() {
        return sugestion;
    }
    boolean st;
    public boolean match() {
        return st==state;
    }
    public void setParam(){
        Scanner sc=new Scanner(System.in);
        do{
            String st=sc.nextLine();
            if (st.equals("true") || st.equals("t")) {
                this.st = true;
                return;
            } else if (st.equals("false") || st.equals("f")) {
                this.st = false;
                return;
            }
        } while (true);
    }

}

