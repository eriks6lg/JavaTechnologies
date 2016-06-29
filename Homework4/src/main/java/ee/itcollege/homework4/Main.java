package ee.itcollege.homework4;


import java.util.HashMap;



class Main {

    public static void main(String[] args) {
        HashMap<String, String> oldNews  = Methods.decodeJson();
        HashMap<String, String> newNews = Methods.getNew();
        System.out.println("Uued uudised:");
        System.out.println();
        Methods.printMap(newNews);
        System.out.println("Vanad uudised:");
        System.out.println();
        Methods.printMap(oldNews);



    }
}
