package task4;

/*
 * Task 4 runner.
 * Allows multiple .txt file paths in args and prints TextData
 * for each one.
 */
public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Pass one or more file paths!");
            return;
        }

        // Loop through all provided file paths
        for (String path : args) {
            String text = FileReaderUtil.readFileIntoString(path);
            TextData data = new TextData(path, text);

            data.print();
            System.out.println("----------------------------");
        }
    }
}
