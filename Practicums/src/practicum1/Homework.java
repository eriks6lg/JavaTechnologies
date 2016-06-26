package practicum1;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Homework {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Sisesta mingi sõna!");

        String word = scanner.nextLine();

        Map<String, String> map = new HashMap<String, String>(){{
            put("A"," ### " +
                    "#   #" +
                    "#####" +
                    "#   #" +
                    "#   #");
            put("B","#### " +
                    "#   #" +
                    "#####" +
                    "#   #" +
                    "#### ");
            put("C","#####" +
                    "#    " +
                    "#    " +
                    "#    " +
                    "#####");
            put("D","#### " +
                    "#   #" +
                    "#   #" +
                    "#   #" +
                    "#### ");
            put("E","#####" +
                    "#    " +
                    "#####" +
                    "#    " +
                    "#####");
            put("F","#####" +
                    "#    " +
                    "#####" +
                    "#    " +
                    "#    ");
            put("G","#####" +
                    "#    " +
                    "# ###" +
                    "#   #" +
                    "#####");
            put("H","#   #" +
                    "#   #" +
                    "#####" +
                    "#   #" +
                    "#   #");
            put("I","    #" +
                    "    #" +
                    "    #" +
                    "    #" +
                    "    #");
            put("J"," ####" +
                    "    #" +
                    "    #" +
                    " #  #" +
                    "  ###");
            put("K","#   #" +
                    "#  # " +
                    "###  " +
                    "#  # " +
                    "#   #");
            put("L","#    " +
                    "#    " +
                    "#    " +
                    "#    " +
                    "#####");
            put("M","#   #" +
                    "## ##" +
                    "# # #" +
                    "#   #" +
                    "#   #");
            put("N","##  #" +
                    "##  #" +
                    "# # #" +
                    "#  ##" +
                    "#  ##");
            put("O","#####" +
                    "#   #" +
                    "#   #" +
                    "#   #" +
                    "#####");
            put("P","#####" +
                    "#   #" +
                    "#####" +
                    "#    " +
                    "#    ");
            put("Q","#####" +
                    "#   #" +
                    "#   #" +
                    "#####" +
                    "    #");
            put("R","#####" +
                    "#   #" +
                    "#### " +
                    "#  # " +
                    "#   #");
            put("S","#####" +
                    "#    " +
                    "#####" +
                    "    #" +
                    "#####");
            put("T","#####" +
                    "  #  " +
                    "  #  " +
                    "  #  " +
                    "  #  ");
            put("U","#   #" +
                    "#   #" +
                    "#   #" +
                    "#   #" +
                    "#####");
            put("V","#   #" +
                    "#   #" +
                    "#   #" +
                    " # # " +
                    "  #  ");
            put("W","#   #" +
                    "#   #" +
                    "# # #" +
                    "## ##" +
                    "#   #");
            put("X","#   #" +
                    " # # " +
                    "  #  " +
                    " # # " +
                    "#   #");
            put("Y","#   #" +
                    " # # " +
                    "  #  " +
                    " #   " +
                    "#    ");

        }
        };

        String mess = "";
        String newString = "";
        for(int i=0; i<word.length(); i++) {
            mess = mess + map.get(String.valueOf(word.charAt(i)).toUpperCase());
        }

        for(int i=0; i<5; i++) {

            for(int j=0; j<mess.length()/25; j++) {
                newString = newString + mess.substring(i*5+j*25, i*5+j*25+5) + " ";

            }
            newString = newString + "\n";

        }
        System.out.println(newString);

    }

}
