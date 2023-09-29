import java.util.Scanner;

/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pin, menu, jmlSaldo, jmlTarik, jmlTF, noRek;
        double bunga = 0.2;

        System.out.print("Masukkan PIN anda : ");
        pin = sc.nextInt();
        
        if (pin == 123) {
            System.out.println("Silakan Pilih Menu Dibawah Ini");
            System.out.println("1. Tarik Tunai \n2. Transfer \n3. Cek Saldo");
            System.out.println("Ketik 1, 2 atau 3");
            menu = sc.nextInt();
            sc.close();
            switch (menu) {
                case 1:
                    // Tarik Tunai dikerjakan disini
                    break;
                case 2:
                    // Transfer kerjakan disini
                    break;
                case 3:
                    // Cek Saldo kerjakan disini
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("PIN anda salah !");
        }

    }
}