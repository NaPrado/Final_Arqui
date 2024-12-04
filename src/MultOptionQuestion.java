import java.util.*;

public class MultOptionQuestion extends Question {
    private int[] options;

    // Constructor de la clase
    public MultOptionQuestion(String question, String suggestion, int[] options) {
        super(question, suggestion);
        this.options = options;
    }

    private int[] userSelection;

    @Override
    public boolean match() {
        if (userSelection == null || options == null) {
            return false; // Si uno de los arrays es nulo, no se puede comparar
        }

        // Usar un Set para comprobar si todos los elementos de userSelection están en options
        Set<Integer> optionSet = new HashSet<>();
        for (int o : options) {
            optionSet.add(o);
        }

        // Verificar si todos los elementos de userSelection están en optionSet
        for (int o : userSelection) {
            if (!optionSet.contains(o)) {
                return false; // Si falta un elemento, retorna false
            }
        }

        return true; // Si todos los elementos están en options, retorna true
    }

    @Override
    public void setParam() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese una cadena de dígitos:");
            String input = sc.nextLine();

            // Verifica si la cadena contiene solo dígitos
            if (input.matches("[0-9]+")) {
                userSelection = new int[input.length()];
                for (int i = 0; i < input.length(); i++) {
                    userSelection[i] = Character.getNumericValue(input.charAt(i)); // Convierte cada carácter a número
                }
                break; // Sale del bucle si la entrada es válida
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese solo caracteres numéricos.");
            }
        }
    }
}

