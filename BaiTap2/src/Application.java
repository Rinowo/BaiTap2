import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
        Methodd methodd = new Methodd();
        Scanner sc = new Scanner(System.in);

        while (true) {
            menu();
            int choose = sc.nextInt();

            switch (choose) {
                case 1 -> methodd.m1();
                case 2 -> methodd.m2();
                case 3 -> methodd.m3();
                case 4 -> methodd.m4();
                case 5 -> methodd.m5();
                case 6 -> methodd.m6();
                case 7 -> methodd.m7();
                case 8 -> methodd.m8();
                case 9 -> System.exit(0);
            }
        }
    }

    public static void menu() {
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. ");
        System.out.println("8. ");
        System.out.println("9. Exit");
        System.out.print("Choose: ");
    }
}
