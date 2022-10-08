import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HTMLPageGenerator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HTMLPageGenerator() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static void pageMaker() {
        /*
         * Put your code for myMethod here
         */
    }

    private static void cssPageMaker(String fileName) {
        SimpleWriter out = new SimpleWriter1L(fileName);
        out.println(
                "\n.title {\n\tfont-size: 60px;\n\tmargin: 0 auto;\n}\n\n.info {\n\tdisplay: inline-flex;\n\tflex-direction: row;\n\toverflow: hidden;\n\twidth: 100%;\n\theight: 75%;\n\tmargin: 0;\n}\n\n.facts {\n\tbackground-color: #ffffff;\n\twidth: 60%;\n\theight: auto;\n\tpadding: 20px;\n}\n\n.graph {\n\tbackground-color: #eff1f2;\n\twidth: 40%;\n\theight: auto;\n}\n\n.graph h1 {\n\tbackground-color:#646a6e;\n\tborder-radius: 30;\n\tcolor: white;\n\tmargin-top: 0px;\n\tpadding: 10px;\n}\n\n.facts h1 {\n\tborder-radius: 30;\n\tmargin-top: -20px;\n\tpadding: 10px;\n\ttext-align: center;\n}\n\n.scroll {\n\twidth: 100%;\n\theight: 5%;\n\tdisplay: flexbox;\n\talign-items: center;\n\toverflow: hidden;\n\tbackground-color: #d0022b;\n}\n\n.subtitle {\n\ttext-align: center;\n\tfont-size: 20;\n\tmargin-top: -5px;\n}\n\n.graphs {\n\theight: 80%;\n\tmargin: auto, 10%;\n\tmargin-top: -5px;\n\tanimation-duration: 7s;\n\tanimation-name: graph-move;\n\tanimation-iteration-count: infinite;\n}\n\nimg {\n\twidth: 100%;\n\tmax-height: 100%;\n\toverflow: hidden;\n}\n\nbody{\n\tfont-family: BuckeyeSans;\n\tbackground-color: black;\n\twidth: 100%;\n\taspect-ratio: 16 / 9;\n\tmargin: 0;\n\tpadding: 0;\n}\n\nheader {\n\tfont-weight: bolder;\n\twidth: 100%;\n\theight: 12%;\n\tbackground-color:  #dfe3e5;\n\tmargin: 15px auto;\n\tpadding-bottom: 10px;\n}\n\nh1 {\n\tfont-size: 50px;\n\tfont-weight: 600;\n\ttext-align: center;\n}\n\nli {\n\tfont-size: 40px;\n\tcolor: #d0022b;\n\tlist-style-type: square;\n}\n\n/* (A) FIXED WRAPPER */\n.hwrap {\n\toverflow: hidden; /* HIDE SCROLL BAR */\n}\n\n/* (B) MOVING TICKER WRAPPER */\n\t.hmove {\n\tdisplay: flex;\n}\n\n/* (C) ITEMS - INTO A LONG HORIZONTAL ROW */\n.hitem {\n\tflex-shrink: 0;\n\twidth: 100%;\n\t box-sizing: border-box;\n\tpadding: 10px;\n\tmargin: auto;\n\ttext-align: center;\n\tfont-size: 25;\n\tcolor: white;\n}\n\n @keyframes graph-move {\n\t0% {\n\t\tbackground-color: #d0022b;\n\t\tmargin-left: 100%;\n\t\twidth: 90%;\n\t}\n\n\t15%, 85% {\n\t\tbackground-color: #d0022b;\n\t\tmargin-left: 5%;\n\t\twidth: 90%;\n\t}\n\n\t100% {\n\t\tbackground-color: #d0022b;\n\t\tmargin-left: -100%;\n\t\tmargin-right: 100%;\n\t\twidth: 90%;\n\t}\n}\n\n.graphs:hover {animation-play-state:paused;}\n\n/* (D) ANIMATION - MOVE ITEMS FROM RIGHT TO LEFT */\n/* 4 ITEMS -400%, CHANGE THIS IF YOU ADD/REMOVE ITEMS */\n @keyframes tickerh\n{\n\t0%{transform:translate3d(100%,0,0);}\n\t100%{transform:translate3d(-500%,0,0);}\n\n}\n.hmove\n{animation:tickerh linear 25 s infinite;\n}\n.hmove:hover\n{\n\t\tanimation-play-state:paused;\n}");

        out.close();
    }

    private static void jsPageMaker() {

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

        out.println("What is the name of the output file?");
        String fileName = in.nextLine();
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        cssPageMaker(fileName + ".css");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
