import java.util.Scanner;

public class MesinATM_5 {
    static Scanner sc = new Scanner(System.in);
    static String[][] nasabah = new String[3][3];

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
                    CekSaldo(session);
                    break;
                case 2:
                    // Tarik Tunai
                    break;
                case 3:
                    // Setor Tunai
                    break;
                case 4:
                    // Transfer
                    Transfer(session, session);
                    break;
                case 5:
                    session = null;
                    break;
                default:
                    break;
            }
        }
    }

    public static void Nasabah() {
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

    public static String Login() {
        String session = null;

        do {
            boolean trueRek = false;
            boolean truePIN = false;

            System.out.print("\nMasukkan Nomor Rekening anda       : ");
            String noRek = sc.nextLine();
            System.out.print("Masukkan PIN anda                  : ");
            String pin = sc.nextLine();

            for (int i = 0; i < nasabah.length; i++) {
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

    public static int IndexNasabah(String isi, int index) {
        int i = 0;
        for (i = 0; i < nasabah.length; i++) {
            if (nasabah[i][index].equals(isi)) {
                break;
            }
        }
        return i;
    }

    public static int MenuUtama() {
        int menu = 0;

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
        return menu;
    }

    public static void CekSaldo(String noRek) {
        System.out.println("\n======== JUMLAH SALDO =========");
        System.out.printf("Rp %s\n", nasabah[IndexNasabah(noRek, 0)][2]);
        System.out.println("===============================");
    }

    public static int MenuTransfer(int menu) {
        System.out.println("\n||================================||");
        System.out.println("||           Menu Transfer        ||");
        System.out.println("||________________________________||");
        System.out.println("||          1. Sesama Bank        ||");
        System.out.println("||          2. Bank Lain          ||");
        System.out.println("||          3. Kembali            ||");
        System.out.println("||================================||");
        System.out.print("\nPilih Menu Transfer : ");
        menu = sc.nextInt();
        sc.nextLine();

        return menu;
    }

    public static void Transfer(String session, String noRek) {
        int saldoPengirim = Integer.parseInt(nasabah[IndexNasabah(noRek, 0)][2]);
        int menu = MenuTransfer(0);
        int saldoTujuan = 0, jmlTF = 0, totalTF = 0;
        boolean rekValid = false;

        System.out.print("Masukkan Nomor Rekening Tujuan : ");
        String rekTujuan = sc.nextLine();

        switch (menu) {
            case 1:
                for (int j = 0; j < nasabah.length; j++) {
                    if (rekTujuan.equals(nasabah[j][0]) && !rekTujuan.equals(session)) {
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
                    CetakResiTransfer(session, noRek, rekTujuan, saldoPengirim, saldoTujuan, jmlTF, totalTF, admin);
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
                    CetakResiTransfer(session, noRek, null, saldoPengirim, 0, jmlTF, totalTF, admin);
                } else {
                    System.out.print("Saldo Anda Kurang !");
                }
                break;
            default:
                System.out.print("Menu Tidak Valid !");
                break;
        }
    }

    public static void CetakResiTransfer(String session, String noRek, String rekTujuan, int saldoPengirim,
            int saldoTujuan, int jmlTF, int totalTF, int admin) {

        saldoPengirim = Integer.parseInt(nasabah[IndexNasabah(noRek, 0)][2]);
        String konfirmasi = "n";

        System.out.print("Apakah Anda Yakin ? (y/n) : ");
        konfirmasi = sc.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            if (saldoPengirim > 0) {
                saldoPengirim -= totalTF;
                if (rekTujuan != null) {
                    saldoTujuan += jmlTF;
                    nasabah[IndexNasabah(rekTujuan, 0)][2] = String.valueOf(saldoTujuan);
                }

                nasabah[IndexNasabah(noRek, 0)][2] = String.valueOf(saldoPengirim);

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
}
