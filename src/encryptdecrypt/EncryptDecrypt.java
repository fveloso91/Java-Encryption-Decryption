package encryptdecrypt;

public class EncryptDecrypt {

    public String init(Algorithm algorithm, String sentence, int key) {

        String[] sentenceToEncrypt = sentence.split("");
        StringBuilder finalSentence = new StringBuilder();

        for (String s : sentenceToEncrypt) {

            finalSentence.append(algorithm.execute(s, key));

        }

        return finalSentence.toString();
    }
}
