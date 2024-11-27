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

    static HashMap<String, String> asciiMorse = new HashMap<>();

    static{
        asciiMorse.put("A", ".-");
        asciiMorse.put("B", "-...");
        asciiMorse.put("C", "-.-.");
        asciiMorse.put("D", "-..");
        asciiMorse.put("E", ".");
        asciiMorse.put("F", "..-.");
        asciiMorse.put("G", "--.");
        asciiMorse.put("H", "....");
        asciiMorse.put("I", "..");
        asciiMorse.put("J", ".---");
        asciiMorse.put("K", "-.-");
        asciiMorse.put("L", ".-..");
        asciiMorse.put("M", "--");
        asciiMorse.put("N", "-.");
        asciiMorse.put("O", "---");
        asciiMorse.put("P", ".--.");
        asciiMorse.put("Q", "--.-");
        asciiMorse.put("R", ".-.");
        asciiMorse.put("S", "...");
        asciiMorse.put("T", "-");
        asciiMorse.put("U", "..-");
        asciiMorse.put("V", "...-");
        asciiMorse.put("W", ".--");
        asciiMorse.put("X", "-..-");
        asciiMorse.put("Y", "-.--");
        asciiMorse.put("Z", "--..");
        asciiMorse.put("Ñ", ".----.");
        asciiMorse.put(" ", "/");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
            System.out.println("1. Traducir de texto a código Morse");
            System.out.println("2. Traducir de código Morse a texto");
            System.out.println("3. Salir");
            int numero = scanner.nextInt();
            scanner.nextLine();

            switch (numero) {
                case 1:
                    System.out.println("introduce una palabra para traducir a codigo Morse:");
                    String palabra = scanner.nextLine().toUpperCase();
                    StringBuilder morse = new StringBuilder();

                    for (int i = 0; i < palabra.length(); i++) {
                        String letra = String.valueOf(palabra.charAt(i));
                        if (asciiMorse.containsKey(letra)) {
                            morse.append(asciiMorse.get(letra)).append(" ");
                        } else {
                            System.out.println("caracter no soportado: " + letra);
                        }
                    }

                    System.out.println("traduccion a Morse: " + morse.toString().trim());
                    break;

                case 2:
                    MorseAscii morseToText = new MorseAscii("");
                    morseToText.setInputText();
                    System.out.println("Traducción a texto:");
                    morseToText.morseToAscii();
                    break;

                case 3:
                    seguir = false;
                    break;

                default:
                    System.out.println("Elige un numero valido.");
            }
        }
    }
}


