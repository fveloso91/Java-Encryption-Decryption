package encryptdecrypt;

public class Unicode implements Algorithm {

    @Override
    public char execute(String word, int key) {
        return (char) (word.charAt(0) + key);
    }
}
