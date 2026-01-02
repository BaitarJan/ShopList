package shopList.JavaInput;

import java.util.Scanner;

public class InputReader {

    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator validator = new InputValidator();

    // základní vstup
    public String read() {
        return scanner.nextLine().trim();
    }

    // ověřený vstup – nepustí prázdný nebo bez speciálních znaku
    public String readValidatedText() {
        String input;

        do {
            input = read();

            if (validator.isEmpty(input)) {
                System.out.println("Vstup nesmí být prázdný.");
                continue;
            }

            if (!validator.containsInvalidCharacters(input)) {
                System.out.println("Vstup nesmí obsahovat speciální znaky.");
                continue;
            }

            return input;

        } while (true);
    }
    // ověřený vstup – nepustí prázdný a pouze čisla
    public int readValidatedNumber() {
        String input;

        do {
            input = read();

            if (validator.isEmpty(input)) {
                System.out.println("Vstup nesmí být prázdný.");
                continue;
            }

            if (!validator.isValidNumber(input)) {
                System.out.println("Vstup nesmí obsahovat pouze číselný vstup.");
                continue;
            }
          return Integer.parseInt(input);


        } while (true);
    }
}

