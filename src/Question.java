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
            if (st.equalsIgnoreCase("true") || st.equalsIgnoreCase("t") || st.equalsIgnoreCase("yes") || st.equalsIgnoreCase("y") || st.equalsIgnoreCase("v") || st.equalsIgnoreCase("verdadero")|| st.equalsIgnoreCase("facto")) {
                this.st = true;
                return;
            } else if (st.equalsIgnoreCase("false") || st.equalsIgnoreCase("f")|| st.equalsIgnoreCase("no") || st.equalsIgnoreCase("n") || st.equalsIgnoreCase("falso") || st.equalsIgnoreCase("infacto")) {
                this.st = false;
                return;
            } else {
                System.out.println("invalid input");
                System.out.println("try again");
            }
        } while (true);
    }

}

