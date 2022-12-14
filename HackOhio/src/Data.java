import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import components.map.Map.Pair;
import components.map.Map1L;

/**
 * Works with HTML files and MATLAB graph outputs to read any amount of files
 * within a given folder. Assumes that the files are [NAME].csv and is exported
 * through excels save as .csv with delimiter matching the
 * {@code String: delimiter} (No cells include a comma)
 *
 * @author Skylar Stephens
 * @author Kate Goertz
 * @author Manny Jauregui
 * @author Avery Doctor
 */
public final class Data {
    /**
     * Points to folder that contains proper .csv files.
     */
    private static String folderName = "Data";
    /**
     * The chosen delimiter string in the .csv files.
     */
    private static String delimiter = ",";
    /**
     * The data holder.
     */
    private static String[][] matrix;

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
            rowScanner.useDelimiter(delimiter);
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
         * Needed values for simplistic code
         */
        int rows = l.size();
        int columns = l.get(0).size();
        String[][] matrix = new String[rows][columns];
        /*
         * For all rows and columns in l, add to correct Matrix location
         */
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
     * Populates a Queue of String matrixs for data processing.
     *
     * @param files
     *            Array containing file names
     * @return a formatted Queue of String Matrixs
     */
    private static Queue<String[][]> populateMatrixQueue(String[] files) {
        /*
         * Set-up queue to contain dynamic file counts
         */
        Queue<String[][]> matrixQueue = new LinkedList<>();
        /*
         * Populate data queues with correct values
         */
        for (int i = 0; i < files.length; i++) {
            String currentFile = files[i];
            List<List<String>> tempList = createDataList(currentFile);
            matrixQueue.add(createMatrix(tempList));
        }
        return matrixQueue;
    }

    /**
     * Gets the matrix position of the passed building name.
     *
     * @param matrix
     *            Matrix containing all data
     * @param buildingName
     *            Name of building to find position of
     * @return the int position of building name
     */
    private static int findPos(String[][] matrix, String buildingName) {
        int pos = 0;
        /*
         * Search the top column for buildingName, if found save it.
         */
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i].equals(buildingName)) {
                pos = i;
            }
        }
        return pos;
    }

    /**
     * Find the closest average match to the passed building name.
     *
     * @param matrix
     *            Matrix with all data
     * @param buildingName
     *            Name of building to find closest match
     * @return the name and average of the closest average building
     */
    public static String closestMatch(String[][] matrix, String buildingName) {
        /*
         * Values needed for comparisions
         */
        String match = "";
        int thisPos = findPos(matrix, buildingName);
        double thisAverage = getAverage(matrix, thisPos);
        double closest = Integer.MAX_VALUE;
        /*
         * For all buildings check if they are closer to the passed building
         * name
         */
        for (int i = 1; i < matrix[0].length; i++) {
            if (thisPos != i) {
                String name = matrix[0][i];
                double currentAverage = getAverage(matrix, i);
                double difference = Math.abs(thisAverage - currentAverage);
                if (difference < closest) {
                    match = name;
                    closest = difference;
                }
            }
        }
        /*
         * Returns the name of the building without extra wording
         */
        return match.split(" -")[0];
    }

    /**
     * Gets this buildings rank amoung dorms.
     *
     * @param matrix
     *            matrix of data
     * @param buildingName
     *            this building name
     * @return the rank if its a dorm
     * @convention -1 means this building is not a dorm
     */
    public static int dormRank(String[][] matrix, String buildingName) {
        int rank = -1;
        /*
         * Find if this building is a dorm or not
         */
        boolean isDorm = false;
        for (String s : matrix[0]) {
            if (s.equals(buildingName)) {
                isDorm = true;
            }
        }

        if (isDorm) {
            Map1L<String, Double> m = new Map1L<>();
            for (int i = 1; i < matrix[0].length; i++) {
                m.add(matrix[0][i],
                        getAverage(matrix, findPos(matrix, buildingName)));
            }
            double[] d = new double[matrix[0].length - 1];
            int t = 0;
            for (Pair<String, Double> p : m) {
                d[t] = p.value();
            }
            Arrays.sort(d);
            for (int c = 0; c < d.length; c++) {
                if (d[c] == m.value(buildingName)) {
                    rank = c;
                }
            }
        }
        return rank;
    }

    /**
     * Reads a data comparison from a MATLAB made file.
     *
     * @param buildingName
     *            the name of the building to compare
     * @return the differnce
     */
    public static String compareToLastMonth(String buildingName) {
        String efficiency = "0";
        try {
            Scanner scanner = new Scanner(new File("data/Months.txt"));
            if (buildingName.contains("Busch")) {
                efficiency = scanner.nextLine();
            } else {
                efficiency = scanner.nextLine();
                efficiency = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return efficiency.substring(0, 5);
    }

    /**
     * Accessor method for this.matrix, meant for use in HTMLPageGenerator.java.
     *
     * @return this.matrix
     */
    public static String[][] getMatrix() {
        return matrix;
    }

    /**
     * Main method.
     *
     * @param count
     *            reference to which file to read
     */
    public static void main(int count) {

        /*
         * Based on provided directory name, gets all valid csv file names
         */
        File dir = new File(folderName);
        String[] files = getFiles(dir);
        /*
         * Set-up queues to contain dynamic file counts and populate
         */
        Queue<String[][]> matrixQueue = populateMatrixQueue(files);

        for (int i = 0; i < count; i++) {
            matrix = matrixQueue.remove();
        }
    }
}
