package practicum1;
import java.util.Scanner;

class Exercise2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisestage mingi arv");
        String text = scanner.nextLine();
        int sum = 0;
        for(int i=0; i<text.length(); i++) {
            sum += Integer.parseInt(Character.toString(text.charAt(i)));
        }
        System.out.printf("Sinu sisestatu summa on %d", sum);
    }
}