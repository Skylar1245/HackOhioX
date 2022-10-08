import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Main file for Energy Dashboard.
 *
 * @author Skylar Stephens
 * @author Kate Goertz
 * @author Manny Jareugui
 * @author Avery Doctor
 *
 */
public final class Template {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Template() {
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
        //test

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
