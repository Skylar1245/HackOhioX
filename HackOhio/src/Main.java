import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

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
     * Gets data given a line.
     *
     * @param line
     *            line with data
     * @return correct List
     */
    private static List<String> getDataFromLine(String line) {
        /*
         * Try to open a scanner based on the current line, if you can add all
         * data seperated by commas to a list of strings
         */
        List<String> data = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                data.add(rowScanner.next());
            }
        }
        return data;
    }

    /**
     * Creates a list based on a file.
     *
     * @param fileName
     *            name of the file
     * @return a list<list<string>>
     */
    private static List<List<String>> createDataList(String fileName) {
        /*
         * Try to make a scanner of the filename, if you can add the data from
         * the line to the list through getREcordFromLine
         */
        List<List<String>> dataList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName));) {
            while (scanner.hasNextLine()) {
                dataList.add(getDataFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    /**
     * Converts a List<List<String>> to a String[][].
     *
     * @param l
     *            a List<List<String>>
     * @return a String[][]
     */
    private static String[][] createMatrix(List<List<String>> l) {
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
    private static boolean canParseToDouble(String s) {
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
    private static double getAverage(String[][] matrix, int pos) {
        /*
         * Initial values
         */
        double average = 0.0;
        double elementCount = 0.0;
        /*
         * for all values in the matrix, if they are valid numbers at to average
         * can count the data population
         */
        for (int i = 0; i < matrix.length; i++) {
            if (canParseToDouble(matrix[i][pos])) {
                average += Double.parseDouble(matrix[i][pos]);
                elementCount++;
            }
        }
        /*
         * Catch case where there is no valid data
         */
        if (elementCount > 0) {
            average /= elementCount;
        } else {
            average = 0.0;
        }

        return average;
    }

    /**
     * Gets all files in provided directory.
     *
     * @param directory
     *            dir to search
     * @return array of valid files @
     */
    private static String[] getFiles(File directory) {
        /*
         * Creates an array of files based upon an implementation of javas
         * FilenameFilter that checks if the file name ends in .csv
         */
        File[] names = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File directory, String name) {
                return name.endsWith(".csv");
            }
        });
        /*
         * Convert the file array into an array of the file paths as strings
         */
        String[] strNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            strNames[i] = names[i].toString();
        }
        return strNames;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Time tracker
         */
        long start = System.currentTimeMillis();
        /*
         * Based on provided directory name, gets all valid csv file names
         */
        File dir = new File("data");
        String[] files = getFiles(dir);
        /*
         * Set-up queues to contain dynamic file counts
         */
        Queue<List<List<String>>> dataQueue = new LinkedList<>();
        Queue<String[][]> matrixQueue = new LinkedList<>();
        /*
         * Populate data queues with correct values
         */
        for (int i = 0; i < files.length; i++) {
            String currentFile = files[i];
            List<List<String>> tempList = createDataList(currentFile);
            dataQueue.add(tempList);
            matrixQueue.add(createMatrix(tempList));
        }
        /*
         * Prints the averages of all data sets
         */
        for (String[][] matrix : matrixQueue) {

            for (int i = 1; i < matrix[0].length; i++) {
                System.out.println("Average of " + matrix[0][i] + ": "
                        + String.format("%.2f", getAverage(matrix, i)));
                System.out.println();
            }
        }
        /*
         * time tracking
         */
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Ran in: " + Math.floor(timeElapsed) + " seconds");
    }
}
