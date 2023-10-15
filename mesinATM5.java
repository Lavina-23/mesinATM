import java.util.Scanner;

/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int pin, menu, jmlSaldo, jmlTarik, jmlTF, noRek, lama_menabung, sisaSaldo;
        double bunga = 0.2, jml_tabungan_akhir = 0;
        String konfirmasi = "ya";

        System.out.print("Masukkan Nomor Rekening anda : ");
        noRek = sc.nextInt();
        System.out.print("Masukkan PIN anda : ");
        pin = sc.nextInt();
        
        if (pin == 123 && noRek == 1234567890) {
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

                    do {
                        System.out.print("\nMasukkan nomor rekening tujuan : ");
                    noRek = sc.nextInt();
                    

                    System.out.println("\nSilahkan Plih Menu Dibawah ini");
                    System.out.println("\n1. 100000 \n2. 500000 \n3. 1000000 \n4. 5000000");
                    System.out.println("Ketik 1, 2, 3 atau 4 ");
                    menu = sc.nextInt();

                    
                        if (menu == 1) {
                            jmlTF = 100000;
                        }else if (menu == 2) {
                            jmlTF = 500000;
                        }else if (menu == 3) {
                            jmlTF = 1000000;
                        }else if (menu == 4) {
                            jmlTF = 5000000;
                        }else {
                            System.out.println("Menu invalid");
                            continue;
                        } 

                        System.out.println("Apakah anda yakin? (ya/tidak)");
                        konfirmasi = sc.next();

                        if (konfirmasi.equalsIgnoreCase("ya") && jmlSaldo <= jml_tabungan_akhir){
                            sisaSaldo = jmlSaldo - jmlTF;
    
                            System.out.println("\n******** TRANSFER BERHASIL ********");
                            System.out.println("\nJumlah Transfer     : " + jmlTF);
                            System.out.println("Sisa Saldo          : " + sisaSaldo);
                            System.out.println("\n******* Sampai Jumpa Kembali *******");
                        } else {
                            System.out.println("\nNominal uang yang anda masukkan tidak valid !");
                        }
                        
                    } while (true);
                    default :
                    break;

            }
            sc.close();
    }
}
}