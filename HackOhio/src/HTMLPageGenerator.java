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
    private static void pageMaker(String fileName, String graph1, int dormRank,
            double efficiancy) {
        SimpleWriter out = new SimpleWriter1L(fileName + ".html");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("\t<meta charset=\"UTF-8\">");
        out.println(
                "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println(
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println(
                "\t<link rel=\"stylesheet\" href=\"" + fileName + ".css\">");
        out.println(
                "\t<link rel=\"stylesheet\" href=\"https://assets.bux.osu.edu/bux-webfonts/bux-webfonts.css\" />");
        out.println("\t<title>ENGIE Campus Dashboards</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("\t<header>");
        out.println("\t\t<h1 class=\"title\"><b>ENGIE Energy Saver</b></h1>");
        out.println(
                "\t\t<h2 class=\"subtitle\"><em>Go to ENGIE.com to learn more</em></h2>");
        out.println("\t</header>");
        out.println("\t<div class=\"info\">");
        out.println("\t\t<div class=\"graph\">");
        out.println("\t\t\t<h1><b>How Do <em>YOU Compare?</em></b></h1>");
        out.println("\t\t\t<div class=\"graphs\">");
        out.println("\t\t\t\t<img id=\"img\" src=\"" + graph1 + "\">");
        out.println("\t\t\t</div>");
        out.println("\t\t</div>");
        out.println("\t\t<div class=\"facts\">");
        out.println(
                "\t\t\t<h1><b>Improve <em>YOUR</em> Sustainability</b></h1>");
        out.println("\t\t\t<div class=\"facts-list\">");
        out.println("\t\t\t\t<ul>");

        if (dormRank > 0) {
            out.println(
                    "\t\t\t\t\t<li>Turn your lights and electronics when they aren't in use!</li>");
            out.println("\t\t\t\t\t<li>Take shorter showers!</li>");
            out.println("\t\t\t\t\t<li>Turn your refridgerator down!</li>");
            out.println(
                    "\t\t\t\t\t<li>Turn the sink off when you brush your teeth</li>");
            out.println("\t\t\t\t\t<li>Do full loads of laundry</li>");
            out.println("\t\t\t\t\t<li>Put decorative lights on a timer</li>");
        } else {
            out.println(
                    "\t\t\t\t\t<li>Turn your lights and electronics when they aren't in use!</li>");
            out.println("\t\t\t\t\t<li>Uplug equipment when not in use</li>");
            out.println("\t\t\t\t\t<li>Print only when needed</li>");
            out.println(
                    "\t\t\t\t\t<li>Promote sustanability in the classroom</li>");
            out.println(
                    "\t\t\t\t\t<li>Reduce energy usage of small personal appliances</li>");
        }

        out.println("\t\t\t\t</ul>");
        out.println("\t\t\t</div>");
        out.println("\t\t</div>");
        out.println("\t</div>");
        out.println("\t<div class=\"scroll\">");
        out.println("\t\t<div class=\"scroll-animation\">");
        out.println("\t\t\t<div class=\"hwrap\">");
        out.println("\t\t\t\t<div class=\"hmove\">");
        out.println(
                "\t\t\t\t\t<div class=\"hitem\">You saved enough energy to power a car.</div>");

        if (dormRank > 0) {
            out.println("\t\t\t\t\t<div class=\"hitem\">Currently your dorm is"
                    + dormRank + "number.</div>");
        }

        out.println(
                "\t\t\t\t\t<div class=\"hitem\">Do you live energy efficent?</div>");
        out.println(
                "\t\t\t\t\t<div class=\"hitem\">Remember to recycle.</div>");

        if (efficiancy > 0) {
            if (dormRank > 0) {
                out.println(
                        "\t\t\t\t\t<div class=\"hitem\">Your dorm this month did "
                                + efficiancy
                                + "% better than last month.</div>");
            } else {
                out.println(
                        "\t\t\t\t\t<div class=\"hitem\">Your building this month did "
                                + efficiancy
                                + "% better than last month.</div>");
            }
        }
        out.println("\t\t\t\t</div>");
        out.println("\t\t\t</div>");
        out.println("\t\t</div>");
        out.println("\t</div> ");
        out.println("\t<script src=\"" + fileName + ".js" + "\"></script>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    private static void cssPageMaker(String fileName) {
        SimpleWriter out = new SimpleWriter1L(fileName + ".css");
        out.println(
                "\n.title {\n\tfont-size: 60px;\n\tmargin: 0 auto;\n}\n\n.info {\n\tdisplay: inline-flex;\n\tflex-direction: row;\n\toverflow: hidden;\n\twidth: 100%;\n\theight: 75%;\n\tmargin: 0;\n}\n\n.facts {\n\tbackground-color: #ffffff;\n\twidth: 60%;\n\theight: auto;\n\tpadding: 20px;\n}\n\n.graph {\n\tbackground-color: #eff1f2;\n\twidth: 40%;\n\theight: auto;\n}\n\n.graph h1 {\n\tbackground-color:#646a6e;\n\tborder-radius: 30;\n\tcolor: white;\n\tmargin-top: 0px;\n\tpadding: 10px;\n}\n\n.facts h1 {\n\tborder-radius: 30;\n\tmargin-top: -20px;\n\tpadding: 10px;\n\ttext-align: center;\n}\n\n.scroll {\n\twidth: 100%;\n\theight: 5%;\n\tdisplay: flexbox;\n\talign-items: center;\n\toverflow: hidden;\n\tbackground-color: #d0022b;\n}\n\n.subtitle {\n\ttext-align: center;\n\tfont-size: 20;\n\tmargin-top: -5px;\n}\n\n.graphs {\n\theight: 80%;\n\tmargin: auto, 10%;\n\tmargin-top: -5px;\n\tanimation-duration: 7s;\n\tanimation-name: graph-move;\n\tanimation-iteration-count: infinite;\n}\n\nimg {\n\twidth: 100%;\n\tmax-height: 100%;\n\toverflow: hidden;\n}\n\nbody{\n\tfont-family: BuckeyeSans;\n\tbackground-color: black;\n\twidth: 100%;\n\taspect-ratio: 16 / 9;\n\tmargin: 0;\n\tpadding: 0;\n}\n\nheader {\n\tfont-weight: bolder;\n\twidth: 100%;\n\theight: 12%;\n\tbackground-color:  #dfe3e5;\n\tmargin: 15px auto;\n\tpadding-bottom: 10px;\n}\n\nh1 {\n\tfont-size: 50px;\n\tfont-weight: 600;\n\ttext-align: center;\n}\n\nli {\n\tfont-size: 40px;\n\tcolor: #d0022b;\n\tlist-style-type: square;\n}\n\n/* (A) FIXED WRAPPER */\n.hwrap {\n\toverflow: hidden; /* HIDE SCROLL BAR */\n}\n\n/* (B) MOVING TICKER WRAPPER */\n\t.hmove {\n\tdisplay: flex;\n}\n\n/* (C) ITEMS - INTO A LONG HORIZONTAL ROW */\n.hitem {\n\tflex-shrink: 0;\n\twidth: 100%;\n\t box-sizing: border-box;\n\tpadding: 10px;\n\tmargin: auto;\n\ttext-align: center;\n\tfont-size: 25;\n\tcolor: white;\n}\n\n @keyframes graph-move {\n\t0% {\n\t\tbackground-color: #d0022b;\n\t\tmargin-left: 100%;\n\t\twidth: 90%;\n\t}\n\n\t15%, 85% {\n\t\tbackground-color: #d0022b;\n\t\tmargin-left: 5%;\n\t\twidth: 90%;\n\t}\n\n\t100% {\n\t\tbackground-color: #d0022b;\n\t\tmargin-left: -100%;\n\t\tmargin-right: 100%;\n\t\twidth: 90%;\n\t}\n}\n\n.graphs:hover {animation-play-state:paused;}\n\n/* (D) ANIMATION - MOVE ITEMS FROM RIGHT TO LEFT */\n/* 4 ITEMS -400%, CHANGE THIS IF YOU ADD/REMOVE ITEMS */\n @keyframes tickerh\n{\n\t0%{transform:translate3d(100%,0,0);}\n\t100%{transform:translate3d(-500%,0,0);}\n\n}\n.hmove\n{animation:tickerh linear 25 s infinite;\n}\n.hmove:hover\n{\n\t\tanimation-play-state:paused;\n}");

        out.close();
    }

    private static void jsPageMaker(String fileName, String graph1,
            String graph2, String graph3) {
        SimpleWriter out = new SimpleWriter1L(fileName + ".js");

        out.print("function displayNextImage() {");
        out.print("\n\tif(document.getElementById('img').src =='" + graph1
                + "') {");
        out.print(
                "\n\t\tdocument.getElementById('img').src = '" + graph2 + "';");
        out.print("\n\t} else if(document.getElementById('img').src =='"
                + graph2 + "') {");
        out.print(
                "\n\t\tdocument.getElementById('img').src = '" + graph3 + "';");
        out.print("\n\t} else {");
        out.print(
                "\n\t\tdocument.getElementById('img').src = '" + graph1 + "';");
        out.print("\n\t}");
        out.print("\n}");
        out.println(
                "\n\nmovingblock = document.getElementsByClassName('graphs');\nmovingblock[0].addEventListener(\"animationiteration\", displayNextImage);");

        out.close();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        //define varibles
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        int dormRank = -1;
        double efficiancy = 0;

        //get information
        out.println("What is the name of the output file?");
        String fileName = in.nextLine();

        out.println("What is the URL for the first graph");
        String graph1URL = in.nextLine();

        out.println("What is the URL for the second graph");
        String graph2URL = in.nextLine();

        out.println("What is the URL for the third graph");
        String graph3URL = in.nextLine();

        /*
         * Put your main program code here; it may call myMethod as shown
         */
        cssPageMaker(fileName);
        jsPageMaker(fileName, graph1URL, graph2URL, graph3URL);
        pageMaker(fileName, graph1URL, dormRank, efficiancy);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
