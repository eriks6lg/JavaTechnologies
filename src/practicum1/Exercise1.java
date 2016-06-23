package practicum1;

public class Exercise1 {

    public static void main(String[] args) {

        for(int i=9; i>=0; i--) {
            for(int j=9; j>=0; j--) {
                if(j>=i) {
                    System.out.print(i);
                } else {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }
}