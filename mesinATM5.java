import java.util.Scanner;

public class mesinATM5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu, jmlTarik, totalTF = 0, admin = 0;
        boolean login = false, transfer = false;
        int jmlTF = 0, saldo = 0, sisaSaldo = 0, jmlSetor = 0, totalSetoran = 0;
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
                continue;
            } else {
                System.out.println("\nNomor Rekening dan PIN Salah !");
            }
        } while (!login);

        while (true) {
            System.out.println("\n||================================||");
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
                    // Cek Saldo
                    System.out.println("\n======== JUMLAH SALDO =========");
                    System.out.println(saldo);
                    System.out.println("===============================");

                    System.out.print("Kembali ke menu utama ? (y/n) : ");
                    konfirmasi = sc.nextLine();

                    if (konfirmasi.equalsIgnoreCase("y")) {
                        break;
                    } else {
                        login = false;
                    }
                    break;
                case 2:
                    // Tarik tunai
                        jmlTarik = 0;
                        while (true) {
                            System.out.println("\n||================================||");
                            System.out.println("||         TARIK TUNAI            ||");
                            System.out.println("||________________________________||");
                            System.out.println("||           1. 100.000           ||");
                            System.out.println("||           2. 200.000           ||");
                            System.out.println("||           3. 500.000           ||");
                            System.out.println("||           4. 1.000.000         ||");
                            System.out.println("||           5. Selesai           ||");
                            System.out.println("||================================||");
                            System.out.print("\nPilih Jumlah Tarik Tunai : ");
                            menu = sc.nextInt();
                            sc.nextLine();

                            if (menu == 1) {
                                jmlTarik += 100_000;
                            } else if (menu == 2) {
                                jmlTarik += 200_000;
                            } else if (menu == 3) {
                                jmlTarik += 500_000;
                            } else if (menu == 4) {
                                jmlTarik += 1_000_000;
                            } else if (menu == 5) {
                                break; // Kembali ke pemilihan menu utama
                            } else {
                                System.out.println("Menu invalid");
                                continue;
                            }
                        }
                            System.out.print("Apakah anda yakin? (y/n) : ");
                            konfirmasi = sc.next();

                            if (konfirmasi.equalsIgnoreCase("y") && (saldo - 50_000) > jmlTarik) {
                                sisaSaldo = saldo - jmlTarik;

                                System.out.println("\n===================================");
                                System.out.println("       PENARIKAN TUNAI BERHASIL !     ");
                                System.out.println("===================================");
                                System.out.println("Sisa Saldo           : " + sisaSaldo);
                                System.out.println("\n====== Sampai Jumpa Kembali =======");

                                saldo = sisaSaldo;
                            } else {
                                System.out.println("Penarikan dibatalkan atau Saldo Anda tidak mencukupi");
                                break;
                            }

                    System.out.print("\nKembali ke menu utama? (y/n)");
                    konfirmasi = sc.next();
                    sc.nextLine();

                    if (konfirmasi.equalsIgnoreCase("y")) {
                        break;
                    } else {
                        login = false;
                    }
                    break;
                case 3:
                    // Setor tunai
                    System.out.println("\n||================================||");
                    System.out.println("||           SETOR TUNAI          ||");
                    System.out.println("||________________________________||");
                    System.out.println("||           1. 100.000           ||");
                    System.out.println("||           2. 200.000           ||");
                    System.out.println("||           3. 500.000           ||");
                    System.out.println("||           4. 1.000.000         ||");
                    System.out.println("||           5. Batal             ||");
                    System.out.println("||================================||");
                    System.out.print("\nPilih Jumlah Setor Tunai : ");
                    menu = sc.nextInt();

                    if (menu == 1) {
                        jmlSetor = 100_000;
                    } else if (menu == 2) {
                        jmlSetor = 200_000;
                    } else if (menu == 3) {
                        jmlSetor = 500_000;
                    } else if (menu == 4) {
                        jmlSetor = 1_000_000;
                    } else if (menu == 5) {
                        break;
                    } else {
                        System.out.println("Menu invalid");
                        continue;
                    }
                    
                    if ((saldo - 50_000) > jmlTF) {
                        totalSetoran += jmlSetor;
                        totalSetoran = saldo + jmlSetor;
                        System.out.println("Total Transfer saat ini : " + totalSetoran);
                    } else {
                        System.out.println("Saldo Anda Kurang !");
                    }

                    System.out.print("Apakah anda yakin? (y/n) : ");
                    konfirmasi = sc.next();

                    if (konfirmasi.equalsIgnoreCase("y")) {
                            admin = 2_000;
                            int totalSetoran2 = totalSetoran + admin;

                            if ((saldo - 50_000) > totalTF) {
                                sisaSaldo = saldo - totalSetoran2;


                    if (konfirmasi.equalsIgnoreCase("y") && (saldo - 50_000) > jmlSetor) {
                        totalSetoran = saldo + jmlSetor;

                        // Menampilkan total setoran
                        System.out.println("\n===================================");
                        System.out.println("        SETOR TUNAI BERHASIL !       ");
                        System.out.println("===================================");
                        System.out.println("Total Saldo           : " + totalSetoran);
                        System.out.println("\n====== Sampai Jumpa Kembali =======");
                    }

                    System.out.print("\nKembali ke menu utama ? (y/n) : ");
                    konfirmasi = sc.next();

                    if (konfirmasi.equalsIgnoreCase("y")) {
                        break;
                    } else {
                        login = false;
                    }
                }
            }
                    break;

                case 4:
                    // Transfer
                    while (true) {
                        do {
                            System.out.print("Masukkan nomor rekening tujuan : ");
                            String rekTF = sc.nextLine();

                            for (int i = 0; i < nasabah.length; i++) {
                                if (nasabah[i][0].equals(rekTF)) {
                                    transfer = true;
                                }
                            }

                            if (transfer == true) {
                                continue;
                            } else {
                                System.out.println("\nNomor Rekening Tujuan Tidak Valid\n");
                            }
                        } while (!transfer);

                        while (true) {
                            System.out.println("\n||================================||");
                            System.out.println("||             TRANSFER           ||");
                            System.out.println("||________________________________||");
                            System.out.println("||           1. 50.000            ||");
                            System.out.println("||           2. 100.000           ||");
                            System.out.println("||           3. 500.000           ||");
                            System.out.println("||           4. 1.000.000         ||");
                            System.out.println("||           5. Selesai           ||");
                            System.out.println("||================================||");
                            System.out.print("\nPilih Jumlah Transfer : ");
                            menu = sc.nextInt();

                            if (menu == 1) {
                                jmlTF = 50_000;
                            } else if (menu == 2) {
                                jmlTF = 100_000;
                            } else if (menu == 3) {
                                jmlTF = 500_0000;
                            } else if (menu == 4) {
                                jmlTF = 1_000_000;
                            } else if (menu == 5) {
                                break;
                            } else {
                                System.out.println("Menu invalid");
                                continue;
                            }

                            if ((saldo - 50_000) > jmlTF) {
                                totalTF += jmlTF;
                                System.out.println("Total Transfer saat ini : " + totalTF);
                            } else {
                                System.out.println("Saldo Anda Kurang !");
                            }
                        }

                        System.out.print("Apakah anda yakin? (y/n) : ");
                        konfirmasi = sc.next();

                        if (konfirmasi.equalsIgnoreCase("y")) {
                            admin = 2_000;
                            int totalTF2 = totalTF + admin;

                            if ((saldo - 50_000) > totalTF) {
                                sisaSaldo = saldo - totalTF2;

                                System.out.println("\n===================================");
                                System.out.println("        TRANSFER BERHASIL !          ");
                                System.out.println("===================================");
                                System.out.println("\nJumlah Transfer     : " + totalTF);
                                System.out.println("Biaya Admin         : " + admin);
                                System.out.println("Total Transfer      : " + totalTF2);
                                System.out.println("Sisa Saldo          : " + sisaSaldo);
                                System.out.println("\n====== Sampai Jumpa Kembali =======");

                                System.out.print("\nKembali ke menu utama ? (y/n) : ");
                                konfirmasi = sc.next();

                                if (konfirmasi.equalsIgnoreCase("y")) {
                                    break;
                                } else {
                                    login = false;
                                }
                                break;
                            } else {
                                System.out.println("Saldo anda kurang !");
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih. Sampai jumpa!");
                    login = false;
                default:
                    break;
            }
            if (!login) {
                break;
            }
        }
        sc.close();
    }
}