import java.util.Scanner;

/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pin, menu, jmlSaldo, jmlTarik, jmlTF, noRek, sisaSaldo;
        double bunga = 0.2;

        System.out.print("Masukkan PIN anda : ");
        pin = sc.nextInt();
        
        if (pin == 123) {
            System.out.print("Masukkan jumlah saldo anda : ");
            jmlSaldo = sc.nextInt();

            System.out.println("\nSilakan Pilih Menu Dibawah Ini");
            System.out.println("\n1. Tarik Tunai \n2. Transfer \n3. Cek Saldo");
            System.out.println("\nKetik 1, 2 atau 3");
            menu = sc.nextInt();
            
            switch (menu) {
                case 1:
                // Tarik Tunai dikerjakan disini
                break;
                case 2:
                // Transfer kerjakan disini
                System.out.print("\nMasukkan nomor rekening tujuan : ");
                noRek = sc.nextInt();
                System.out.print("Masukkan nominal yang ingin di transfer : ");
                jmlTF = sc.nextInt();

                if (jmlTF <= jmlSaldo) {
                    sisaSaldo = jmlSaldo - jmlTF;

                    System.out.println("\n******** TRANSFER BERHASIL ********");
                    System.out.println("\nJumlah Transfer     : " + jmlTF);
                    System.out.println("Sisa Saldo          : " + sisaSaldo);
                    System.out.println("\n******* Sampai Jumpa Kembali *******");
                    } else {
                        System.out.println("\nNominal uang yang anda masukkan tidak valid !");
                    }
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
            sc.close();

    }
}