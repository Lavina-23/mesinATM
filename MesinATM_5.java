import java.util.Scanner;

public class MesinATM_5 {
    static Scanner sc = new Scanner(System.in);
    static String[][] nasabah = new String[3][3];
    static String[][] riwayat = new String[4][10];
    static int counter = 0;
    static int index = -1;

    public static void main(String[] args) {

        System.out.println("---------------------------------");
        System.out.println("  SELAMAT DATANG DI BANK BTS !");
        System.out.println("---------------------------------");

        Nasabah();
        String session = Login();
        while (session != null) {
            switch (MenuUtama()) {
                case 1:
                    // Cek Saldo
                    CekSaldo();
                    break;
                case 2:
                    // Tarik Tunai
                    break;
                case 3:
                    // Setor Tunai
                    break;
                case 4:
                    // Transfer
                    Transfer();
                    break;
                case 5:
                    History();
                    break;
                case 6:
                    session = null;
                    break;
                default:
                    break;
            }
        }
    }

    static void Nasabah() {
        nasabah[0][0] = "1234567890"; // Nomor Rekening
        nasabah[0][1] = "123456"; // PIN
        nasabah[0][2] = "2000000"; // Saldo

        nasabah[1][0] = "0987654321";
        nasabah[1][1] = "098765";
        nasabah[1][2] = "5000000";

        nasabah[2][0] = "6789054321";
        nasabah[2][1] = "654789";
        nasabah[2][2] = "10000000";
    }

    static String Login() {
        String session = null;

        do {
            boolean trueRek = false;
            boolean truePIN = false;

            System.out.print("\nMasukkan Nomor Rekening anda       : ");
            String noRek = sc.nextLine();
            System.out.print("Masukkan PIN anda                  : ");
            String pin = sc.nextLine();

            for (int i = 0; i < nasabah.length; i++) {
                index = i;
                if (nasabah[i][0].equals(noRek)) {
                    trueRek = true;
                    if (nasabah[i][1].equals(pin)) {
                        truePIN = true;
                        session = nasabah[i][0];
                        break;
                    }
                }
            }

            if (!truePIN && !trueRek) {
                System.out.print("Nomor Rekening dan PIN Anda Salah !");
            } else if (!truePIN) {
                System.out.print("PIN Anda Salah !");
            } else if (!trueRek) {
                System.out.print("Nomor Rekening Anda Salah !");
            }
        } while (session == null);
        return session;
    }

    static int MenuUtama() {
        int menu = 0;

        System.out.println("\n||================================||");
        System.out.println("||           PILIHAN MENU         ||");
        System.out.println("||________________________________||");
        System.out.println("||          1. Cek Saldo          ||");
        System.out.println("||          2. Tarik Tunai        ||");
        System.out.println("||          3. Setor Tunai        ||");
        System.out.println("||          4. Transfer           ||");
        System.out.println("||          5. Riwayat            ||");
        System.out.println("||          6. Keluar             ||");
        System.out.println("||================================||");
        System.out.print("\nPilih menu : ");
        menu = sc.nextInt();
        sc.nextLine();
        return menu;
    }

    static void CekSaldo() {
        System.out.println("\n======== JUMLAH SALDO =========");
        System.out.printf("Rp %s\n", nasabah[index][2]);
        System.out.println("===============================");
    }

    static int MenuTransfer() {
        System.out.println("\n||================================||");
        System.out.println("||           Menu Transfer        ||");
        System.out.println("||________________________________||");
        System.out.println("||          1. Sesama Bank        ||");
        System.out.println("||          2. Bank Lain          ||");
        System.out.println("||          3. Kembali            ||");
        System.out.println("||================================||");
        System.out.print("\nPilih Menu Transfer : ");
        int menu = sc.nextInt();
        sc.nextLine();

        return menu;
    }

    static void Transfer() {
        int saldoPengirim = Integer.parseInt(nasabah[index][2]);
        int menu = MenuTransfer();
        int saldoTujuan = 0, jmlTF = 0, totalTF = 0;
        boolean rekValid = false;
        String jenis;

        System.out.print("Masukkan Nomor Rekening Tujuan : ");
        String rekTujuan = sc.nextLine();

        switch (menu) {
            case 1:
                for (int j = 0; j < nasabah.length; j++) {
                    if (rekTujuan.equals(nasabah[j][0]) && !rekTujuan.equals(nasabah[index][2])) {
                        saldoTujuan = Integer.parseInt(nasabah[j][2]);
                        rekValid = true;
                        break;
                    }
                }

                if (!rekValid) {
                    System.out.print("Nomor Rekening Tidak Valid !");
                    break;
                }

                System.out.print("Masukkan Nominal Transfer : ");
                jmlTF = sc.nextInt();
                sc.nextLine();

                if (jmlTF <= (saldoPengirim - 50_000)) {
                    int admin = 6_500;
                    totalTF = jmlTF + admin;
                    jenis = "Transfer Sesama Bank";
                    CetakResiTransfer(jenis, rekTujuan, saldoPengirim, saldoTujuan, jmlTF, totalTF, admin);
                } else {
                    System.out.print("Saldo Anda Kurang !");
                }
                break;
            case 2:
                System.out.print("Masukkan Nominal Transfer : ");
                jmlTF = sc.nextInt();
                sc.nextLine();

                if (jmlTF <= (saldoPengirim - 50_000)) {
                    int admin = 7_500;
                    totalTF = jmlTF + admin;
                    jenis = "Transfer Beda Bank";
                    CetakResiTransfer(jenis, rekTujuan, saldoPengirim, 0, jmlTF, totalTF, admin);
                } else {
                    System.out.print("Saldo Anda Kurang !");
                }
                break;
            case 3:
                break;
            default:
                System.out.print("Menu Tidak Valid !");
                break;
        }
    }

    static void CetakResiTransfer(String jenis, String rekTujuan, int saldoPengirim, int saldoTujuan, int jmlTF,
            int totalTF, int admin) {
        saldoPengirim = Integer.parseInt(nasabah[index][2]);
        String konfirmasi = "n";

        System.out.print("Apakah Anda Yakin ? (y/n) : ");
        konfirmasi = sc.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            if (saldoPengirim > 0) {
                saldoPengirim -= totalTF;
                if (rekTujuan != null) {
                    saldoTujuan += jmlTF;
                    nasabah[index][2] = String.valueOf(saldoTujuan);
                }

                nasabah[index][2] = String.valueOf(saldoPengirim);

                String dataRiwayat = "\nJenis Transaksi       : " + jenis +
                        "\nNomor Rekening Tujuan : " + rekTujuan +
                        "\nTotal Transfer        : " + totalTF +
                        "\nSisa Saldo            : " + saldoPengirim;

                riwayat[index][counter] = dataRiwayat;
                counter++;

                System.out.println("\n===================================");
                System.out.println("        TRANSFER BERHASIL !          ");
                System.out.println("===================================");
                System.out.println("\nJumlah Transfer     : " + jmlTF);
                System.out.println("Biaya Admin         : " + admin);
                System.out.println("Total Transfer      : " + totalTF);
                System.out.println("Sisa Saldo          : " + saldoPengirim);
                System.out.println("\n====== Sampai Jumpa Kembali =======");
            } else {
                System.out.print("Saldo Anda Kurang !");
            }
        } else {
            System.out.print("Transfer Dibatalkan");
        }
    }

    static void History() {
        System.out.println("\n===================================");
        System.out.println("          Riwayat Transaksi        ");
        System.out.println("===================================");

        for (int i = 0; i < riwayat.length; i++) {
            if (riwayat[i] != null) {
                for (String history : riwayat[i]) {
                    if (history != null) {
                        System.out.println(history);
                        System.out.println("===================================");
                    }
                }
            }
        }
        System.out.println();
    }
}
