package shopList.JavaInput;

public class InputValidator {

    // obsahuje speciální znak
    public boolean containsInvalidCharacters(String input) {
        for (int i = 0; i < input.length(); i++) {
            int ascii = (int) input.charAt(i);
            // speciální znaky – vše mimo písmena a čísla
            if (!((ascii >= 48 && ascii <= 57) ||  // 0–9
                    (ascii >= 65 && ascii <= 90) ||  // A–Z
                    (ascii >= 97 && ascii <= 122))) { // a–z
                return true;
            }
        }return false;
    }
    // obsahuje speciální znak
    public boolean isValidNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            int ascii = (int) input.charAt(i);

            if ((ascii >= 32 && ascii <= 47)||  // 0–9
            (ascii >= 58 && ascii <= 255)) { // a–z
                return false;
            }
        }return true;
    }
    public boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }



}