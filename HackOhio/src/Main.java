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
    public static List<String> getDataFromLine(String line) {
        /*
         * Try to open a scanner based on the current line, if you can add all
         * data seperated by commas to a list of strings
         */
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
        /*
         * Try to make a scanner of the filename, if you can add the data from
         * the line to the list through getREcordFromLine
         */
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName));) {
            while (scanner.hasNextLine()) {
                records.add(getDataFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return records;
    }

    /**
     * Converts a List<List<String>> to a String[][].
     *
     * @param l
     *            a List<List<String>>
     * @return a String[][]
     */
    public static String[][] createMatrix(List<List<String>> l) {
        /*
         * for all list elements add a String[] based on the contents
         */
        int rows = l.size();
        int columns = l.get(0).size();

        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < columns; i++) {
            for (int k = 0; k < rows; k++) {
                matrix[k][i] = l.get(k).get(i);
            }
        }
        return matrix;
    }

    /**
     * Checks if a string can be parsed to a double.
     *
     * @param s
     *            String to be checked
     * @return true or false
     */
    public static boolean canParseToDouble(String s) {
        /**
         * Check if s can be parsed into a double
         */
        boolean canParse = true;
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            canParse = false;
        }
        return canParse;
    }

    /**
     * Averages the correct values in a matrix line.
     *
     * @param matrix
     *            matrix to work with
     * @param pos
     *            small matrix pos
     * @return the average of the line
     */
    public static double getAverage(String[][] matrix, int pos) {
        /*
         * Initial values
         */
        double average = 0.0;
        double pop = 0.0;
        /*
         * for all values in the matrix, if they are valid numbers at to average
         * can count the data population
         */
        for (int i = 0; i < matrix.length; i++) {
            if (canParseToDouble(matrix[i][pos])) {
                average += Double.parseDouble(matrix[i][pos]);
                pop++;
            }
        }
        return (average / pop);
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

        String[][] dormMatrix = createMatrix(dormData);
        //String[][] nonDormMatrix = createMatrix(nonDormData);
        //String[][] weatherMatrix = createMatrix(weatherData);

        out.println("Averaging " + dormMatrix[0][13] + ".");
        out.println(getAverage(dormMatrix, 13));
        /*
         * Webpage stuff.
         */
        String outputName = "data/test.html";

        createHeader(outputName);

        createFooter(outputName);

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        out.println("Ran in: " + Math.floor(timeElapsed) + " seconds");
        /*
         * Close input and output streams
         */

        in.close();
        out.close();
    }

}
