import java.util.Scanner;

/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int pin, menu, jmlSaldo, jmlTarik, jmlTF, noRek, lama_menabung, sisaSaldo;
        double bunga = 0.2, jml_tabungan_akhir;


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
                    System.out.println("Masukkan jumlah uang yang akan ditarik ");
                    jmlTarik = sc.nextInt();

                    sisaSaldo = jmlSaldo - jmlTarik;

                    if (jmlTarik <= jmlSaldo) {
                        System.out.println("Sisa saldo : " + sisaSaldo);
                    }
                    else {
                        System.out.println("Jumlah uang yang anda tarik melebihi jumlah saldo anda !");
                    }
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
                    System.out.println("masukkan jumlah tabungan awal anda");                
                    jmlSaldo = sc.nextInt();
                    System.out.println("masukkan lama menabung anda");
                    lama_menabung= sc.nextInt();

                    bunga= lama_menabung*bunga*jmlSaldo;
                    jml_tabungan_akhir=bunga+jmlSaldo;

                    System.out.println("Bunga adalah " +bunga);
                    System.out.println("Jumlah tabungan akhir anda adalah " +jml_tabungan_akhir);
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