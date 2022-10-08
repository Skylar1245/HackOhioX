import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Main file for Energy Dashboard.
 *
 * @author Skylar Stephens
 * @author Kate Goertz
 * @author Manny Jauregui
 * @author Avery Doctor
 *
 */
public final class Main {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Main() {
    }

    /**
     * Creates generic unclosed HTML headers.
     *
     * @param fileName
     *            name of the file output
     */
    public static void createHeader(String fileName) {
        SimpleWriter out = new SimpleWriter1L(fileName);
        /*
         * Create generic HTML header
         */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Webpage</title>");
        out.println("</head>");
        out.println("<body>");

        out.close();
    }

    /**
     * Creates generic HTML footer.
     *
     * @param fileName
     *            name of the output file
     */
    public static void createFooter(String fileName) {
        SimpleWriter out = new SimpleWriter1L(fileName);
        /*
         * Create generic HTML footer
         */
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    /**
     * Gets data given a line.
     *
     * @param line
     *            line with data
     * @return correct List
     */
    public static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    /**
     * Creates a list based on a file.
     *
     * @param fileName
     *            name of the file
     * @return a list<list<string>>
     */
    public static List<List<String>> createDataList(String fileName) {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return records;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        long start = System.currentTimeMillis();
        /*
         * Data reading stuff
         */
        String dormFile = "data/Dorm Buildings.csv";
        String nonDormFile = "data/Non-Dorm Buildings.csv";
        String weatherFile = "data/Weather Data.csv";

        List<List<String>> dormData = createDataList(dormFile);
        List<List<String>> nonDormData = createDataList(nonDormFile);
        List<List<String>> weatherData = createDataList(weatherFile);

        List<String> l = dormData.get(0);
        Object[] a = l.toArray();
        out.println(a[6]);

        /*
         * Webpage stuff.
         */
        String outputName = "data/test.html";

        createHeader(outputName);

        createFooter(outputName);

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        out.println(Math.floor(timeElapsed) + " milliseconds");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
