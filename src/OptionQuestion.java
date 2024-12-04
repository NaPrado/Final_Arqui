public class OptionQuestion extends MultOptionQuestion {
    int option;
    OptionQuestion(String question, String suggestion, int option) {
        super(question, suggestion,new int[]{option});
    }

}
