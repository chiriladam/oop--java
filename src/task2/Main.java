package task2;

/*
 * Task 2 runner.
 * Reads a .txt file path from program arguments,
 * loads it, analyzes it using TextData, and prints the results.
 */
public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Pass a .txt file path to analyze!");
            return;
        }

        // Take the first file path from args
        String path = args[0];

        String text = FileReaderUtil.readFileIntoString(path);

        // Analyze and print results
        TextData data = new TextData(path, text);
        data.print();
    }
}
