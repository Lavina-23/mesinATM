import java.util.Scanner;

/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu;
        boolean login = false, transfer = false;
        int jmlTF = 0, saldo = 0, sisaSaldo = 0, jmlTarik;
        String konfirmasi;

        String[][] nasabah = new String[3][4];

        nasabah[0][0] = "1234567890"; // Nomor Rekening
        nasabah[0][1] = "123456"; // PIN
        nasabah[0][2] = "2000000"; // Saldo
        nasabah[0][3] = "1"; // Lama menabung

        nasabah[1][0] = "0987654321";
        nasabah[1][1] = "098765";
        nasabah[1][2] = "5000000";
        nasabah[1][3] = "2";
        
        nasabah[2][0] = "6789054321";
        nasabah[2][1] = "654789";
        nasabah[2][2] = "10000000";
        nasabah[2][3] = "3";

        System.out.println("---------------------------------");
        System.out.println("  SELAMAT DATANG DI BANK BTS !");
        System.out.println("---------------------------------");

        do {
            System.out.print("\nMasukkan Nomor Rekening anda       : ");
            String noRek = sc.nextLine();
            System.out.print("Masukkan PIN anda                  : ");
            String pin = sc.nextLine();

            for (int i = 0; i < nasabah.length; i++) {
                if (nasabah[i][0].equals(noRek) && nasabah[i][1].equals(pin)) {
                    login = true;
                    saldo = Integer.parseInt(nasabah[i][2]);
                    break;
                }
            }

            if (login == true) {
                System.out.println("||================================||");
                System.out.println("||           PILIHAN MENU         ||");
                System.out.println("||________________________________||");
                System.out.println("||          1. Cek Saldo          ||");
                System.out.println("||          2. Tarik Tunai        ||");
                System.out.println("||          3. Setor Tunai        ||");
                System.out.println("||          4. Transfer           ||");
                System.out.println("||          5. Keluar             ||");
                System.out.println("||================================||");
                System.out.print("\nPilih menu : ");
                menu = sc.nextInt();
                sc.nextLine();

                switch (menu) {
                    case 1:
                        //Cek Saldo
                        System.out.println("\n======== JUMLAH SALDO =========");
                        System.out.println(saldo);
                        System.out.println("===============================");
                        break;
                    case 2:
                        // Tarik Tunai
                        do {
                            System.out.println("\n||================================||");
                            System.out.println("||         TARIK TUNAI            ||");
                            System.out.println("||________________________________||");
                            System.out.println("||           1. 100.000           ||");
                            System.out.println("||           2. 200.000           ||");
                            System.out.println("||           3. 500.000           ||");
                            System.out.println("||           4. 1.000.000         ||");
                            System.out.println("||           5. Batal             ||");
                            System.out.println("||================================||");
                            System.out.print("\nPilih Jumlah Tarik Tunai : ");
                            int menuTT = sc.nextInt();

                            if (menuTT == 1) {
                                jmlTarik = 100_000;
                            } else if (menuTT == 2) {
                                jmlTarik = 200_000;
                            } else if (menuTT == 3) {
                                jmlTarik = 500_000;
                            } else if (menuTT == 4) {
                                jmlTarik = 1_000_000;
                            } else if (menuTT == 5) {
                                break; // Kembali ke pemilihan menu utama
                            } else {
                                System.out.println("Menu invalid");
                                continue;
                            }

                            if (menuTT < 5) {
                                System.out.print("Apakah anda yakin? (y/n) : ");
                                konfirmasi = sc.next();
                                if (konfirmasi.equalsIgnoreCase("y") && saldo >= jmlTF) {
                                    sisaSaldo = saldo - jmlTarik;
                    
                                    System.out.println("\n===================================");
                                    System.out.println("       PENARIKAN TUNAI BERHASIL !     ");
                                    System.out.println("===================================");
                                    System.out.println("Sisa Saldo           : " + sisaSaldo);
                                    System.out.println("\n====== Sampai Jumpa Kembali =======");
                                    break;
                                }
                            }
                        } while (true);
                        break;
                    case 3:
                        // Setor tunai
                        for (int i = 0; i < nasabah.length; i++) {
                            int totalSetoran = 0;
                            int jmlSetor = 0;

                            System.out.println("\nSilahkan Pilih Menu Dibawah ini");
                            System.out.println("\n1. 100000 \n2. 500000 \n3. 1000000 \n4. 5000000");
                            System.out.println("Ketik 1, 2, 3 atau 4 ");
                            menu = sc.nextInt();

                            if (menu == 1) {
                                    jmlSetor = 100000;
                                } else if (menu == 2) {
                                    jmlSetor = 500000;
                                } else if (menu == 3) {
                                    jmlSetor = 1000000;
                                } else if (menu == 4) {
                                    jmlSetor = 5000000;
                                } else if (menu == 5) {
                                    break;
                                } else {
                                    System.out.println("Menu invalid");
                                    continue;
                                }

                                if (menu < 5) {
                                    System.out.print("Apakah anda yakin? (y/n) : ");
                                    konfirmasi = sc.next();
                                    if (konfirmasi.equalsIgnoreCase("y") && saldo >= totalSetoran) {
                                        totalSetoran = saldo + jmlSetor;

                                        // Menampilkan total setoran
                                        System.out.println("\nTotal saldo anda : " + totalSetoran);
                                        System.out.println("\n====== Sampai Jumpa Kembali =======");
                                        break;
                                    }
                                }
                        }
                        break;
                    case 4:
                        // Transfer
                        do {
                            System.out.print("Masukkan nomor rekening tujuan : ");
                            String rekTF = sc.nextLine();
                            
                            for (int i = 0; i < nasabah.length; i++) {
                                if (nasabah[i][0].equals(rekTF)) {
                                    transfer = true;
                                }
                            }
                            
                            if (transfer == true) {
                                System.out.println("\n||================================||");
                                System.out.println("||            TRANSFER            ||");
                                System.out.println("||________________________________||");
                                System.out.println("||           1. 50.000            ||");
                                System.out.println("||           2. 100.000           ||");
                                System.out.println("||           3. 500.000           ||");
                                System.out.println("||           4. 1000.000          ||");
                                System.out.println("||           5. Batal             ||");
                                System.out.println("||================================||");
                                System.out.print("\nPilih Jumlah Transfer    : ");
                                int menuTF = sc.nextInt();

                                if (menuTF == 5) {
                                    break;
                                }
    
                                if (menuTF == 1) {
                                    jmlTF = 50_000;
                                } else if (menuTF == 2) {
                                    jmlTF = 100_000;
                                } else if (menuTF == 3) {
                                    jmlTF = 500_0000;
                                } else if (menuTF == 4) {
                                    jmlTF = 1_000_000;
                                } else {
                                    System.out.println("Menu invalid");
                                    continue;
                                }

                                
    
                                if (menuTF < 5) {
                                    System.out.print("Apakah anda yakin? (y/n) : ");
                                    konfirmasi = sc.next();
                                    if (konfirmasi.equalsIgnoreCase("y") && saldo >= jmlTF) {
                                        sisaSaldo = saldo - jmlTF;

                                        System.out.println("\n===================================");
                                        System.out.println("        TRANSFER BERHASIL !          ");
                                        System.out.println("===================================");
                                        System.out.println("\nJumlah Transfer     : " + jmlTF);
                                        System.out.println("Sisa Saldo          : " + sisaSaldo);
                                        System.out.println("\n====== Sampai Jumpa Kembali =======");
                                        break;
                                    }
                                }
    
                            }
                        } while (true);
                        break;
                    case 5:
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