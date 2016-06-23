package practicum1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class Exercise3{

    public static void main(String[] args) {
        System.out.println("Tere sõber! Sisesta nüüd mulle omale 5 kõige armsama inimese nime :)");
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            arrayList.add(scanner.nextLine());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(arrayList.get(i));
        }

        Collections.sort(arrayList, new Comparator<String>() {
            public int compare (String one, String two){
                if (one.compareTo(two) < 0) {
                    return 1;
                }
                else if (one.compareTo(two) == 0) {
                    return 0;
                } else {
                    return -1;
                }

            }
    } );
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayList.get(i));
        }
    }


}