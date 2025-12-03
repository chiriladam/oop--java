package task2;

/*
 * The TextData class analyzes a text:
 * - counts vowels, consonants, letters
 * - counts sentences
 * - finds the longest word
 */
public class TextData {

    String fileName;
    String text;
    int numberOfVowels;
    int numberOfConsonants;
    int numberOfLetters;
    int numberOfSentences;
    String longestWord;

    // Constructor triggers analysis immediately
    public TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        analyze(); // process the text
    }

    // Analyzes the text for required metrics
    private void analyze() {
        numberOfVowels = 0;
        numberOfConsonants = 0;
        numberOfLetters = 0;

        // Sentence count based on punctuation
        numberOfSentences = text.split("[.!?]").length;

        longestWord = "";
        String[] words = text.split("\\W+");

        for (String w : words) {
            if (w.length() > longestWord.length()) longestWord = w;

            // iterate characters
            for (char c : w.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) >= 0) numberOfVowels++;
                else if (Character.isLetter(c)) numberOfConsonants++;
                if (Character.isLetter(c)) numberOfLetters++;
            }
        }
    }

    // Prints all collected stats
    public void print() {
        System.out.println("File: " + fileName);
        System.out.println("Letters: " + numberOfLetters);
        System.out.println("Vowels: " + numberOfVowels);
        System.out.println("Consonants: " + numberOfConsonants);
        System.out.println("Sentences: " + numberOfSentences);
        System.out.println("Longest word: " + longestWord);
    }
}
