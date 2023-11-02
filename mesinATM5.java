import java.util.Scanner;

/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu;
        boolean login = false;

        String[][] nasabah = new String[3][4];

        nasabah[0][0] = "1234567890"; // Nomor Rekening
        nasabah[0][1] = "123456"; // PIN
        nasabah[0][2] = "2_000_000"; // Saldo
        nasabah[0][3] = "1"; // Lama menabung

        nasabah[1][0] = "0987654321";
        nasabah[1][1] = "098765";
        nasabah[1][2] = "5_000_000";
        nasabah[1][3] = "2";
        
        nasabah[2][0] = "6789054321";
        nasabah[2][1] = "654789";
        nasabah[2][2] = "10_000_000";
        nasabah[2][3] = "3";

        int[] menu2 = { 100000, 200000, 1000000, 2000000 };

        System.out.println("---------------------------------");
        System.out.println("  SELAMAT DATANG DI BANK BCA !");
        System.out.println("---------------------------------");

        do {
            System.out.print("\nMasukkan Nomor Rekening anda       : ");
            String noRek = sc.nextLine();
            System.out.print("Masukkan PIN anda                  : ");
            String pin = sc.nextLine();

            for (int i = 0; i < nasabah.length; i++) {
                if (nasabah[i][0].equals(noRek) && nasabah[i][1].equals(pin)) {
                    login = true;
                    break;
                }
            }

            if (login == true) {
                System.out.println("||==================||");
                System.out.println("||   PILIHAN MENU   ||");
                System.out.println("||__________________||");
                System.out.println("||  1. Cek Saldo    ||");
                System.out.println("||  2. Tarik Tunai  ||");
                System.out.println("||  3. Setor Tunai  ||");
                System.out.println("||  4. Transfer     ||");
                System.out.println("||  5. Keluar       ||");
                System.out.println("||==================||");
                System.out.println("\nPilih menu : ");
                menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        // Cek Saldo
                        //System.out.print("Masukkan jumlah saldo anda : ");
                        //jmlSaldo = sc.nextInt();

                        //System.out.print("Masukkan lama menabung anda");
                        //lama_menabung= sc.nextInt();

                        //bunga= lama_menabung*bunga*jmlSaldo[akun];
                        //jml_tabungan_akhir=bunga+jmlSaldo[akun];
                        break;
                    case 2:
                        // Tarik Tunai
                        // int[] pilihanPenarikan = { 100000, 200000, 1000000, 2000000 };

                        // do {
                        //     System.out.println("=== Penarikan Tunai ===");
                        //     System.out.println("Pilih Jumlah Penarikan : ");

                        //     for (int i = 0; i < pilihanPenarikan.length; i++) {
                        //         System.out.println((i + 1) + ". " + pilihanPenarikan[i]);
                        //     }
                        //     menu = sc.nextInt();

                        //     if (menu >= 1 && menu <= pilihanPenarikan.length) {
                        //         jmlTarik = pilihanPenarikan[menu - 1];
                        //     } else {
                        //         System.out.println("Menu invalid");
                        //         continue;
                        //     }

                        //     System.out.println("Anda yakin? (y/n): ");
                        //     konfirmasi = sc.next();

                        //     System.out.println(jmlSaldo[akun]);

                        //     if (konfirmasi.equalsIgnoreCase("y") && jmlSaldo[akun] > jmlTarik) {
                        //         sisaSaldo = jmlSaldo[akun] - jmlTarik;
                        //         System.out.println("Sisa Saldo : " + sisaSaldo);
                        //         break;
                        //     } else {
                        //         System.out.println("Saldo anda tidak cukup");
                        //         continue;
                        //     }
                        // } while (true);
                        break;
                    case 3:
                        // Setor tunai
                        break;
                    case 4:
                        // Transfer
                        // do {
                        //     System.out.print("\nMasukkan nomor rekening tujuan : ");
                        //     noRek = sc.nextLine();

                        //     System.out.println("\nSilahkan Plih Menu Dibawah ini");
                        //     System.out.println("\n1. 100000 \n2. 500000 \n3. 1000000 \n4. 5000000");
                        //     System.out.println("Ketik 1, 2, 3 atau 4 ");
                        //     menu = sc.nextInt();

                        //     if (menu == 1) {
                        //         jmlTF = 100000;
                        //     } else if (menu == 2) {
                        //         jmlTF = 500000;
                        //     } else if (menu == 3) {
                        //         jmlTF = 1000000;
                        //     } else if (menu == 4) {
                        //         jmlTF = 5000000;
                        //     } else {
                        //         System.out.println("Menu invalid");
                        //         continue;
                        //     }

                        //     System.out.println("Apakah anda yakin? (y/n)");
                        //     konfirmasi = sc.next();

                        //     if (konfirmasi.equalsIgnoreCase("y") && jmlSaldo[akun] >= jmlTF) {
                        //         sisaSaldo = (int) jmlSaldo[akun] - jmlTF;

                        //         System.out.println("\n******** TRANSFER BERHASIL ********");
                        //         System.out.println("\nJumlah Transfer     : " + jmlTF);
                        //         System.out.println("Sisa Saldo          : " + sisaSaldo);
                        //         System.out.println("\n******* Sampai Jumpa Kembali *******");
                        //         break;
                        //     } else {
                        //         continue;
                        //     }
                        // } while (true);
                        //  
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("NOMOR REKENING DAN PIN SALAH");
            }
        } while (!login);
        sc.close();
    }
}