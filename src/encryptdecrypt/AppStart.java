package encryptdecrypt;

import java.io.*;
import java.util.Scanner;

public class AppStart {

    private Algorithm algorithm;
    private String mode = "";
    private int key = 0;
    private String data = "";
    private File inputFile;
    private File outputFile;

    public void init(String[] commandLineOptions) {

        readCommandLine(commandLineOptions);
        String sentence = encryptDecrypt();
        outputData(sentence);
    }

    private void readCommandLine(String[] commandLineOptions) {

        for (int i = 0; i < commandLineOptions.length; i += 2) {

            switch (commandLineOptions[i]) {
                case "-mode":
                    mode = commandLineOptions[i + 1];
                    break;

                case "-alg":
                    algorithm =
                            commandLineOptions[i + 1].equals("shift") ?
                                    new Shift() :
                                    new Unicode();
                    break;

                case "-key":
                    key = Integer.parseInt(commandLineOptions[i + 1]);
                    break;

                case "-data":
                    data = commandLineOptions[i + 1];
                    break;

                case "-in":
                    inputFile = new File(commandLineOptions[i + 1]);
                    break;

                case "-out":
                    outputFile = new File(commandLineOptions[i + 1]);
                    break;

                default:
                    break;
            }
        }

    }

    private String encryptDecrypt() {

        if (data.isBlank() && inputFile.isFile()) {

            try (Scanner scanner = new Scanner(inputFile)) {

                data = scanner.nextLine();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        if ("dec".equals(mode)) {
            return new EncryptDecrypt().init(algorithm, data, -key);

        }

        return new EncryptDecrypt().init(algorithm, data, key);

    }

    private void outputData(String sentence) {

        if (outputFile.isFile()) {
            try (PrintWriter printWriter = new PrintWriter(outputFile)) {
                printWriter.print(sentence);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println(sentence);
        }
    }

}
