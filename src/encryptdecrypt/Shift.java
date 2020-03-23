package encryptdecrypt;

public class Shift implements Algorithm {

    @Override
    public char execute(String word, int key) {
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        if(ALPHABET.contains(word)) {
            return transform(ALPHABET, word, key);
        }

        if(ALPHABET.toUpperCase().contains(word)) {
            return transform(ALPHABET, word, key);
        }

        return word.charAt(0);
    }

    private char transform(String alphabet, String word, int key) {
        int index = alphabet.indexOf(word) + key;

        if(index < 0) {
            index += alphabet.length();
        }

        return alphabet.charAt(index % alphabet.length());
    }
}
