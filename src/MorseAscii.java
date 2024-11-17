import java.util.HashMap;
import java.util.Scanner;

public class MorseAscii {
    String inputText;
    HashMap<String, String> translations = new HashMap<>();

    public MorseAscii (String inputText) {
        this.inputText = inputText;
        translations.put(".-", "a");
        translations.put("-...", "b");
        translations.put("-.-.", "c");
        translations.put("-..", "d");
        translations.put(".", "e");
        translations.put("..-.", "f");
        translations.put("--.", "g");
        translations.put("....", "h");
        translations.put("..", "i");
        translations.put(".---", "j");
        translations.put("-.-", "k");
        translations.put(".-..", "l");
        translations.put("--", "m");
        translations.put("-.", "n");
        translations.put("---", "o");
        translations.put(".--.", "p");
        translations.put("--.-", "q");
        translations.put(".-.", "r");
        translations.put("...", "s");
        translations.put("-", "t");
        translations.put("..-", "u");
        translations.put("...-", "v");
        translations.put(".--", "w");
        translations.put("-..-", "x");
        translations.put("-.--", "y");
        translations.put("--..", "z");
        translations.put(".----", "1");
        translations.put("..---", "2");
        translations.put("...--", "3");
        translations.put("....-", "4");
        translations.put(".....", "5");
        translations.put("-....", "6");
        translations.put("--...", "7");
        translations.put("---..", "8");
        translations.put("----.", "9");
        translations.put("-----", "0");
    }

    // Frase de prueba: .... --- .-.. .-  -- ..- -. -.. ---  -> ('Hola Mundo').

    public String getInputText() {
        return inputText;
    }

    public void setInputText() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nA continuación introduzca su codigo Morse.");
        System.out.println("(Introduzca un solo espacio para separar las letras y dos para las palabras).");
        System.out.println("También puedes usar esta frase de prueba en codigo morse para probar el programa");
        System.out.println("-> .... --- .-.. .-  -- ..- -. -.. ---  --> 'Hola Mundo'.\n");
        System.out.println("Introduzca frase a traducir:");
        String text = sc.nextLine();
        this.inputText = text;
    }

    public void morseToAscii() {
        String [] separateWords = inputText.split("  ");
        for (String word : separateWords) {
            String [] chars = word.split(" ");
            for (String character : chars) {
                System.out.print(translations.get(character));
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        MorseAscii morse = new MorseAscii("");
        morse.setInputText();
        System.out.println("\nTraducción:");
        morse.morseToAscii();
    }
}


