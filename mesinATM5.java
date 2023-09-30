import java.util.Scanner;

import javax.swing.text.Style;
/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pin, menu, jmlSaldo, jmlTarik, jmlTF, noRek, konfirmasi, lama_menabung;
        double bunga = 0.2, jml_tabungan_akhir;

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
                    // Transfer
                    break;
                case 3:
                System.out.println("masukkan jumlah tabungan awal anda");                
                jmlSaldo = sc.nextInt();
                System.out.println("masukkan lama menabung anda");
                lama_menabung= sc.nextInt();
                bunga= lama_menabung*bunga*jmlSaldo;
                jml_tabungan_akhir=bunga+jmlSaldo;
                System.out.println("Bunga adalah " +bunga);
                System.out.println("Jumlah tabungan akhir anda adalah " +jml_tabungan_akhir);
            }
        } else {
            System.out.println("PIN anda salah !");
        }

    }
}