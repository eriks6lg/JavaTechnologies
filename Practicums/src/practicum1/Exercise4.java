package practicum1;
import java.util.Scanner;
import java.util.ArrayList;

public class Exercise4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Sisesta arve! Lõpetamiseks sisesta arv, mis on väiksem kui 1!");

        ArrayList<Integer> numbers = new ArrayList<>();
        int lastNum = 1;
        while(lastNum>=1) {
            lastNum = scanner.nextInt();
            if(lastNum>=1)
                numbers.add(lastNum);
        }

        for(int i=0; i<getMax(numbers) + 2; i++) {
            for(int j=0; j<numbers.size(); j++) {
                if(i==getMax(numbers))
                    System.out.print("___");
                else if(i==getMax(numbers)+1)
                    System.out.printf(" %d ", numbers.get(j));
                else if (numbers.get(j)>=getMax(numbers)-i)
                    System.out.print(" X ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }



    }

    public static int getMax(ArrayList<Integer> list) {
        int max=0;
        for(int i=0; i< list.size(); i++) {
            if(list.get(i)>max)
                max = list.get(i);
        }
        return max;
    }

}
