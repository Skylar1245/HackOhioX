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
            double efficiancy, String buildingTwin) {
        SimpleWriter out = new SimpleWriter1L(fileName + ".html");

        while (fileName.contains("/")) {
            int slashIndex = fileName.indexOf("/");
            fileName = fileName.substring(slashIndex + 1);
        }

        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("\t<meta charset=\"UTF-8\">");
        out.println(
                "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("\t<meta name=\"viewport\" content=\"width=devic"
                + "e-width, initial-scale=1.0\">");
        out.println(
                "\t<link rel=\"stylesheet\" href=\"" + fileName + ".css\">");
        out.println("\t<link rel=\"stylesheet\" href=\"https://"
                + "assets.bux.osu.edu/bux-webfonts/bux-webfonts.css\" />");
        out.println(
                "\t<title>ENGIE Campus Dashboards: " + fileName + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("\t<header>");
        out.println("\t\t<h1 class=\"title\"><b>ENGIE Energy Saver</b></h1>");
        out.println("\t\t<h2 class=\"subtitle\"><em>Go to "
                + "ENGIE.com to learn more</em></h2>");
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
            out.println("\t\t\t\t\t<li>Turn your lights and electronics "
                    + "when they aren't in use!</li>");
            out.println("\t\t\t\t\t<li>Take shorter showers!</li>");
            out.println("\t\t\t\t\t<li>Turn your refridgerator down!</li>");
            out.println(
                    "\t\t\t\t\t<li>Turn the sink off when you brush your teeth</li>");
            out.println("\t\t\t\t\t<li>Do full loads of laundry</li>");
            out.println("\t\t\t\t\t<li>Put decorative lights on a timer</li>");
        } else {
            out.println("\t\t\t\t\t<li>Turn your lights and electronics"
                    + " when they aren't in use!</li>");
            out.println("\t\t\t\t\t<li>Uplug equipment when not in use</li>");
            out.println("\t\t\t\t\t<li>Print only when needed</li>");
            out.println(
                    "\t\t\t\t\t<li>Promote sustanability in the classroom</li>");
            out.println("\t\t\t\t\t<li>Reduce energy usage of small "
                    + "personal appliances</li>");
        }

        out.println("\t\t\t\t</ul>");
        out.println("\t\t\t</div>");
        out.println("\t\t\t<div class=\"footnote\">");
        out.println("\t\t\t\t<p>(1 GW = 1E10 W)</p>");
        out.println("\t\t\t\t<p>(1MW = 1E6 W)</p>");
        out.println("\t\t\t</div>");
        out.println("\t\t</div>");
        out.println("\t</div>");
        out.println("\t<div class=\"scroll\">");
        out.println("\t\t<div class=\"scroll-animation\">");
        out.println("\t\t\t<div class=\"hwrap\">");
        out.println("\t\t\t\t<div class=\"hmove\">");
        out.println("\t\t\t\t\t<div class=\"hitem\">Your building twin is "
                + buildingTwin + "</div>");

        if (dormRank > 0) {
            out.println(
                    "\t\t\t\t\t<div class=\"hitem\">Currently your dorm is in"
                            + dormRank + "th.</div>");
        }

        out.println("\t\t\t\t\t<div class=\"hitem\">Do you live "
                + "energy efficent?</div>");
        out.println(
                "\t\t\t\t\t<div class=\"hitem\">Remember to recycle.</div>");

        if (efficiancy > 0) {
            if (dormRank > 0) {
                out.println("\t\t\t\t\t<div class=\"hitem\">Your dorm"
                        + " this month did " + efficiancy
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

        out.println(".title {\r\n" + "    font-size: 60px;\r\n"
                + "    margin: 0%;\r\n" + "    padding: 0%;\r\n" + "}");
        out.println("\n.info {\r\n" + "    display: inline-flex;\r\n"
                + "    flex-direction: row;\r\n" + "    overflow: hidden;\r\n"
                + "    width: 100%;\r\n" + "    height: 80%;\r\n"
                + "    margin: 0;  \r\n" + "    margin-top: -20px;\r\n" + "}");
        out.println("\n.facts { \r\n" + "    display: flex;\r\n"
                + "    flex-direction: column;\r\n"
                + "    justify-content: space-between;\r\n"
                + "    background-color: #ffffff;\r\n" + "    width: 40%;\r\n"
                + "    height: auto;\r\n" + "    padding: 20px;\r\n" + "}");
        out.println("\n.footnote {\r\n" + "    text-align: center;\r\n" + "}");
        out.println("\n.footnote p {\r\n" + "    display: inline-block;\r\n"
                + "    color: #d0022b;\r\n" + "    text-align: center;\r\n"
                + "    font-style: italic;\r\n" + "}");
        out.println("\n.graph {\r\n" + "    background-color: #eff1f2;\r\n"
                + "    width: 60%;\r\n" + "    height: auto;\r\n" + "}");
        out.println("\n.graph h1 {\r\n" + "    background-color:#646a6e;\r\n"
                + "    border-radius: 30;\r\n" + "    color: white;\r\n"
                + "    margin-top: 0px;\r\n" + "    padding: 10px;\r\n" + "}");
        out.println("\n.facts h1 {\r\n" + "    border-radius: 30;\r\n"
                + "    margin-top: -20px;\r\n" + "    padding: 10px;\r\n"
                + "    text-align: center;\r\n" + "}");
        out.println("\n.scroll {\r\n" + "    width: 100%;\r\n"
                + "    height: 5%;\r\n" + "    display: flexbox;\r\n"
                + "    align-items: center;\r\n" + "    overflow: hidden;\r\n"
                + "    background-color: #d0022b;\r\n" + "}");
        out.println("\n.subtitle {\r\n" + "    text-align: center;\r\n"
                + "    font-size: 20;\r\n" + "    margin-top: -5px;\r\n" + "}");
        out.println("\n.graphs {\r\n" + "    height: 80%;\r\n"
                + "    margin: auto, 10%;\r\n" + "    margin-top: -5px;\r\n"
                + "    animation-duration: 7s;\r\n"
                + "    animation-name: graph-move;\r\n"
                + "    animation-iteration-count: infinite;\r\n" + "}");
        out.println("\nimg {\r\n" + "    width: 100%;\r\n"
                + "    max-height: 100%;\r\n" + "    overflow: hidden;\r\n"
                + "}");
        out.println("\nbody {\r\n" + "    font-family: BuckeyeSans;\r\n"
                + "    background-color: black;\r\n"
                + "    overflow: hidden;\r\n" + "    width: 100%;\r\n"
                + "    aspect-ratio: 16 / 9;\r\n" + "    margin: 0;\r\n"
                + "    padding: 0;\r\n" + "}");
        out.println("\nheader {\r\n" + "    display: flex;\r\n"
                + "    flex-direction: column;\r\n"
                + "    justify-content: center;\r\n"
                + "    font-weight: bolder;\r\n" + "    width: 100%;\r\n"
                + "    height: 15%;\r\n" + "    background-color:  #dfe3e5;\r\n"
                + "    margin: auto;\r\n" + "    padding-bottom: 10px;\r\n"
                + "}");
        out.println("\nh1 {\r\n" + "    font-size: 50px;\r\n"
                + "    font-weight: 600;\r\n" + "    text-align: center;\r\n"
                + "}");
        out.println("\nli {\r\n" + "    font-size: 40px;\r\n"
                + "    color: #d0022b;\r\n" + "    list-style-type: square;\r\n"
                + "    margin-bottom: 3%;\r\n" + "}");
        out.println("\n/* (A) FIXED WRAPPER */\r\n" + ".hwrap {\r\n"
                + "    overflow: hidden; /* HIDE SCROLL BAR */\r\n" + "  }");
        out.println("\n  /* (B) MOVING TICKER WRAPPER */\r\n"
                + "  .hmove { \r\n" + "    display: flex; \r\n" + "}");
        out.println("\n/* (C) ITEMS - INTO A LONG HORIZONTAL ROW */\r\n"
                + "  .hitem {\r\n" + "    flex-shrink: 0;\r\n"
                + "    width: 100%;\r\n" + "    box-sizing: border-box;\r\n"
                + "    padding: 10px;\r\n" + "    margin: auto;\r\n"
                + "    text-align: center;\r\n" + "    font-size: 25;\r\n"
                + "    color: white;\r\n" + "  }");
        out.println("\n@keyframes graph-move {\r\n" + "    0% {\r\n"
                + "        background-color: #d0022b;\r\n"
                + "        margin-left: 100%;\r\n" + "        width: 90%;\r\n"
                + "      }\r\n" + "    \r\n" + "    15%, 85% {\r\n"
                + "        background-color: #d0022b;\r\n"
                + "        margin-left: 5%;\r\n" + "        width: 90%;\r\n"
                + "      }\r\n" + "\r\n" + "    100% {\r\n"
                + "        background-color: #d0022b;\r\n"
                + "        margin-left: -100%;\r\n"
                + "        margin-right: 100%;\r\n" + "        width: 90%;\r\n"
                + "      }      \r\n" + "  }");
        out.println("\n.graphs:hover {animation-play-state: paused;}");
        out.println("\n/* (D) ANIMATION - MOVE ITEMS FROM RIGHT TO LEFT */\r\n"
                + "  /* 4 ITEMS -400%, CHANGE THIS IF YOU ADD/REMOVE ITEMS */\r\n"
                + "  @keyframes tickerh {\r\n"
                + "    0% { transform: translate3d(100%, 0, 0); }\r\n"
                + "    100% { transform: translate3d(-500%, 0, 0); }\r\n"
                + "  }");
        out.println("\n.hmove { animation: tickerh linear 25s infinite; }");
        out.println("\n.hmove:hover { animation-play-state: paused; }");
        out.println("\n");

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
        out.println("\n\nmovingblock = document.getElementsByClass"
                + "Name('graphs');\nmovingblock[0].addEventListener(\"anim"
                + "ationiteration\", displayNextImage);");

        out.close();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Strings for the dorm based page.
         */
        String fileName = "HTML/TaylorTower";
        String graph1URL = "https://raw.githubusercontent.com/Skylar1245/"
                + "HackOhioX/4dc36a2c0a5c4e76943068692cc3234da969e14b/"
                + "HackOhio/graphs/BuschPlotPerPerson.png";
        String graph2URL = "https://raw.githubusercontent.com/Skylar1245/"
                + "HackOhioX/master/HackOhio/graphs/BuschPlotAnnual.png";
        String graph3URL = "https://raw.githubusercontent.com/Skylar1245/"
                + "HackOhioX/master/HackOhio/graphs/BuschPlotCategories.png";
        /*
         * Bridge over Data.java to be used here.
         */
        Data.main(1);
        String[][] matrix = Data.getMatrix();
        String thisBuilding = "Taylor Tower - Total Energy Consumption"
                + " (Cleaned) (kBTU)";
        String buildingTwin = Data.closestMatch(matrix, thisBuilding);
        int dormRank = Data.dormRank(matrix, thisBuilding);
        double lastMonthComparison = Data.compareToLastMonth(thisBuilding);

        pageMaker(fileName, graph1URL, dormRank, lastMonthComparison,
                buildingTwin);
        cssPageMaker(fileName);
        jsPageMaker(fileName, graph1URL, graph2URL, graph3URL);

        /*
         * Strings for the dorm based page.
         */
        fileName = "HTML/KnowltonHall";
        graph1URL = "https://raw.githubusercontent.com/Skylar1245/Hack"
                + "OhioX/master/HackOhio/graphs/KnowltonPlotAnnual.png";
        graph2URL = "https://raw.githubusercontent.com/Skylar1245/Hack"
                + "OhioX/master/HackOhio/graphs/KnowltonPlotCategories.png";
        graph3URL = "https://raw.githubusercontent.com/Skylar1245/Hack"
                + "OhioX/master/HackOhio/graphs/KnowltonPlotPerPerson.png";
        /*
         * Bridge over Data.java to be used here.
         */
        Data.main(2);
        matrix = Data.getMatrix();
        thisBuilding = "Knowlton Austin E Hall - Total Energy Consumption"
                + " (Cleaned) (kBTU)";
        buildingTwin = Data.closestMatch(matrix, thisBuilding);
        dormRank = Data.dormRank(matrix, thisBuilding);
        lastMonthComparison = Data.compareToLastMonth(thisBuilding);

        pageMaker(fileName, graph1URL, dormRank, lastMonthComparison,
                buildingTwin);
        cssPageMaker(fileName);
        jsPageMaker(fileName, graph1URL, graph2URL, graph3URL);
    }
}
