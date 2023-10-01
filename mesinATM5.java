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
                    Scanner input = new Scanner(System.in);
                    int sisaSaldo, konfirmasi;
                    System.out.println("Masukkan jumlah saldo anda ");
                    jmlSaldo = input.nextInt();
                    System.out.println("Masukkan jumlah uang yang akan ditarik ");
                    jmlTarik = input.nextInt();
                    System.out.println("Apakah anda yakin ? (Tekan 1 jika Ya dan Tekan 2 jika tidak)");
                    konfirmasi = input.nextInt();
                    sisaSaldo = jmlSaldo - jmlTarik;

                    if (konfirmasi == 1) {
                        System.out.println("Sisa saldo : " + sisaSaldo);
                    }
                    else {
                        System.out.println("Sampai jumpa kembali !");
                    }
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