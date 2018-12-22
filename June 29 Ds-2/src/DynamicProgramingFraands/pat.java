package DynamicProgramingFraands;


import java.util.Scanner;

public class pat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k <= 2 * i; k++) {
                if (k<=((2*i)/2)){
                    c++;
                    System.out.print(c+" ");
                }else {
                    c--;
                    System.out.print(c+" ");
                }

            }
            System.out.println();

        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <=i ; j++) {
                System.out.print("  ");
            }
            for (int k = n-i; k >= 0; k--) {
                System.out.print("*"+" ");

            }
            System.out.println();


        }
    }
}
