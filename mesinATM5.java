import java.util.Scanner;

import javax.swing.text.Style;
/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int NoRek, jmlTF, konfirmasi;
        System.out.println("Masukkan nominal uang yang ingin ditranfer");
        jmlTF = input.nextInt();
        System.out.println("Masukkan nomor rekening yang dituju");
        NoRek = input.nextInt();
        System.out.println("Apakah anda yakin? (Tekan 1 = yakin dan klik 2 = tidak yakin)");
        konfirmasi = input.nextInt();
        if (konfirmasi == 1) {
            System.out.println("Yakin");
        }
         else{
            System.out.println("Transaksi tidak valid");
         }
            System.out.println("Transaksi anda berhasil dilakukan");
        }
        }