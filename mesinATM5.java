import java.util.Scanner;

/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] jmlSaldo = {5_000_000, 2_000_000, 4_500_000};
        int pin, menu, jmlTarik, jmlTF, noRek, lama_menabung, sisaSaldo, akun;
        double bunga = 0.2, jml_tabungan_akhir = 0;
        String konfirmasi = "ya";
        boolean login = false;

        do {
            System.out.print("Masukkan Nomor Rekening anda : ");
            noRek = sc.nextInt();
            System.out.print("Masukkan PIN anda : ");
            pin = sc.nextInt();
            System.out.print("Pilih nomor akun anda antara 0 - 2");
            akun = sc.nextInt();


            if ((pin == 123 && noRek == 1234567890) && (akun <= jmlSaldo.length || akun > 0)) {
                login = true;

                System.out.println("Jumlah saldo :" + jmlSaldo[akun]);

                //System.out.print("Masukkan jumlah saldo anda : ");
                //jmlSaldo = sc.nextInt();

                //System.out.print("Masukkan lama menabung anda");
                //lama_menabung= sc.nextInt();
        
                //bunga= lama_menabung*bunga*jmlSaldo[akun];
                //jml_tabungan_akhir=bunga+jmlSaldo[akun];

                System.out.println("\nSilakan Pilih Menu Dibawah Ini");
                System.out.println("\n1. Tarik Tunai \n2. Transfer");
                System.out.println("\nKetik 1 atau 2");
                menu = sc.nextInt();
        

                switch (menu) {
                    case 1:
                        int[] pilihanPenarikan = {100000, 200000, 1000000, 2000000};

                        do {    
                        System.out.println("=== Penarikan Tunai ===");
                        System.out.println("Pilih Jumlah Penarikan : ");

                        for (int i = 0; i < pilihanPenarikan.length; i++) {
                            System.out.println((i+1) + ". " + pilihanPenarikan[i]);
                        }
                        menu = sc.nextInt();

                        if (menu >= 1 && menu <= pilihanPenarikan.length) {
                            jmlTarik = pilihanPenarikan[menu - 1];
                        } else {
                            System.out.println("Menu invalid");
                            continue;
                        }
                        
                        System.out.println("Anda yakin? (ya/tidak): ");
                        konfirmasi = sc.next();

                        System.out.println(jmlSaldo[akun]);

                        if (konfirmasi.equalsIgnoreCase("ya") && jmlSaldo[akun] > jmlTarik) {
                            sisaSaldo = jmlSaldo[akun] - jmlTarik;
                            System.out.println("Sisa Saldo : " + sisaSaldo);
                            break;
                        } else {
                            System.out.println("Saldo anda tidak cukup");
                            continue;
                        } 
                    } while (true);
                break;

                    // case 2 :
                    //     do {
                    //         System.out.print("\nMasukkan nomor rekening tujuan : ");
                    //         noRek = sc.nextInt();
                            

                    //         System.out.println("\nSilahkan Plih Menu Dibawah ini");
                    //         System.out.println("\n1. 100000 \n2. 500000 \n3. 1000000 \n4. 5000000");
                    //         System.out.println("Ketik 1, 2, 3 atau 4 ");
                    //         menu = sc.nextInt();

                        
                    //         if (menu == 1) {
                    //             jmlTF = 100000;
                    //         }else if (menu == 2) {
                    //             jmlTF = 500000;
                    //         }else if (menu == 3) {
                    //             jmlTF = 1000000;
                    //         }else if (menu == 4) {
                    //             jmlTF = 5000000;
                    //         }else {
                    //             System.out.println("Menu invalid");
                    //             continue;
                    //         } 

                    //         System.out.println("Apakah anda yakin? (ya/tidak)");
                    //         konfirmasi = sc.next();

                    //         if (konfirmasi.equalsIgnoreCase("ya") && jmlSaldo <= jml_tabungan_akhir){
                    //             sisaSaldo = (int) jml_tabungan_akhir - jmlTF;
        
                    //             System.out.println("\n******** TRANSFER BERHASIL ********");
                    //             System.out.println("\nJumlah Transfer     : " + jmlTF);
                    //             System.out.println("Sisa Saldo          : " + sisaSaldo);
                    //             System.out.println("\n******* Sampai Jumpa Kembali *******");
                    //             break;
                    //         } else {
                    //             continue;
                    //         }
                    //     } while (true);
                    default:
                        break;
                    }
            } else {
                System.out.println("Nomor rekening dan PIN salah !");
            }
        } while (!login);
        sc.close();
    }
}