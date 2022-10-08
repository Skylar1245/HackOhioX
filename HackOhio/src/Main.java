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
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        String fileName = "data/test.html";

        createHeader(fileName);

        createFooter(fileName);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
