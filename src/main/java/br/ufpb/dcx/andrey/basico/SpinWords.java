package br.ufpb.dcx.andrey.basico;

public class SpinWords {
    public static String spinWords(String sentence) {
        //TODO: Code stuff here
        String[] arrayString = sentence.split(" ");
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].length() >= 5) {
                String finalString = new StringBuilder(arrayString[i]).reverse().toString();
                arrayString[i] = finalString;
            }
        }
        return String.join(" ", arrayString);
    }
}