import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

public class MesinATM_5 {
    static Scanner sc = new Scanner(System.in);
    static LocalDate date = LocalDate.now();
    static LocalTime time = LocalTime.now();
    static String[][] nasabah = new String[3][5];
    static String[][] riwayat = new String[6][10];
    static String[][] va = new String[3][3];
    static int counter = 0;
    static int index = -1;
    static int indexTujuan = -1;

    public static void main(String[] args) {

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
                    TarikTunai();
                    break;
                case 3:
                    // Setor Tunai
                    SetorTunai();
                    break;
                case 4:
                    // Transfer
                    MenuTransfer();
                    break;
                case 5:
                    // Riwayat
                    GantiPIN();
                    break;
                case 6:
                    // Masuk
                    History();
                    break;
                case 7:
                    Login();
                    break;
                case 8:
                    // Keluar
                    session = null;
                    break;
                default:
                    System.out.println("Menu Tidak Valid !");
                    break;
            }
        }
    }

    static void Nasabah() {
        nasabah[0][0] = "1234567890"; // Nomor Rekening
        nasabah[0][1] = "123456"; // PIN
        nasabah[0][2] = "20000000"; // Saldo
        nasabah[0][3] = "Lavina";
        nasabah[0][4] = "BTS";

        nasabah[1][0] = "0987654321";
        nasabah[1][1] = "098765";
        nasabah[1][2] = "30000000";
        nasabah[1][3] = "Alyssa";
        nasabah[1][4] = "BTS";

        nasabah[2][0] = "6789054321";
        nasabah[2][1] = "654789";
        nasabah[2][2] = "10000000";
        nasabah[2][3] = "Galih";
        nasabah[2][4] = "BRI";
    }

    static void VA() {
        va[0][0] = "123456789012";
        va[0][1] = "Listrik PLN";
        va[0][2] = "550000";

        va[1][0] = "123456789034";
        va[1][1] = "Air PDAM";
        va[1][2] = "1500000";

        va[2][0] = "123456789056";
        va[2][1] = "Uang Kuliah Tunggal";
        va[2][2] = "5000000";
    }

    static String Login() {
        String session = null;

        do {
            boolean trueRek = false;
            boolean truePIN = false;

            System.out.println("\n------------------------------------");
            System.out.println("    SELAMAT DATANG DI BANK BTS !");
            System.out.println("------------------------------------");
            System.out.print("\nMasukkan Nomor Rekening anda : ");
            String noRek = sc.nextLine();
            System.out.print("Masukkan PIN anda            : ");
            String pin = sc.nextLine();
            System.out.println("\n------------------------------------");

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
                System.out.println("Nomor Rekening dan PIN Anda Salah !");
            } else if (!truePIN) {
                System.out.println("PIN Anda Salah !");
            } else if (!trueRek) {
                System.out.println("Nomor Rekening Anda Salah !");
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
        System.out.println("||          5. Ganti PIN          ||");
        System.out.println("||          6. Riwayat            ||");
        System.out.println("||          7. Masuk              ||");
        System.out.println("||          8. Keluar             ||");
        System.out.println("||================================||");
        System.out.print("\nPilih menu : ");
        menu = sc.nextInt();
        sc.nextLine();
        return menu;
    }

    static void CekSaldo() {
        while (true) {
            int saldo = Integer.parseInt(nasabah[index][2]);
            System.out.println("\n======== JUMLAH SALDO ANDA =========");
            System.out.printf(Locale.ITALY, "\nRp %,d %n", saldo);
            System.out.println("\n====================================");
            System.out.print("Transaksi Lain ? (y/n) : ");
            String konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                break;
            } else {
                Login();
            }
            break;
        }

    }

    static void TarikTunai() {
        int saldo = Integer.parseInt(nasabah[index][2]);
        int jmlTarik = 0;
        int saldoAkhir;

        System.out.println("\n||================================||");
        System.out.println("||           TARIK TUNAI          ||");
        System.out.println("||________________________________||");
        System.out.println("||        1. 100.000              ||");
        System.out.println("||        2. 200.000              ||");
        System.out.println("||        3. 300.000              ||");
        System.out.println("||        4. 500.000              ||");
        System.out.println("||        5. 1.000.000            ||");
        System.out.println("||        6. 2.000.000            ||");
        System.out.println("||        7. Penarikan lainnya    ||");
        System.out.println("||================================||");
        System.out.print("Pilih menu : ");
        int menu = sc.nextInt();
        sc.nextLine();

        if (menu < 7) {
            System.out.print("Apakah Anda Yakin ? (y/n) : ");
            String konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                if (menu == 1) {
                    jmlTarik = 100_000;
                } else if (menu == 2) {
                    jmlTarik = 200_000;
                } else if (menu == 3) {
                    jmlTarik = 300_000;
                } else if (menu == 4) {
                    jmlTarik = 500_000;
                } else if (menu == 5) {
                    jmlTarik = 1_000_000;
                } else if (menu == 6) {
                    jmlTarik = 2_000_000;
                }
                saldoAkhir = saldo - jmlTarik;
                nasabah[index][2] = String.valueOf(saldoAkhir);
                CetakResiTarikTunai(saldoAkhir, jmlTarik);

                String jenisTrans = "Tarik Tunai";
                LocalDate tglTrans = date;

                riwayat[index][0] = String.valueOf(tglTrans);
                riwayat[index][1] = jenisTrans;
                riwayat[index][2] = String.valueOf(jmlTarik);
                riwayat[index][3] = String.valueOf(saldoAkhir);
            } else {
                System.out.println("Transaksi Dibatalkan !");
            }
        } else if (menu == 7) {
            boolean isTarik = false;
            do {
                System.out.print("Masukkan jumlah penarikan: Rp ");
                jmlTarik = sc.nextInt();
                sc.nextLine();

                if (jmlTarik >= 100_000) {
                    if (jmlTarik <= 7_000_000) {
                        isTarik = true;
                        System.out.print("Apakah Anda Yakin ? (y/n) : ");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("y")) {
                            saldoAkhir = saldo - jmlTarik;
                            nasabah[index][2] = String.valueOf(saldoAkhir);
                            CetakResiTarikTunai(saldoAkhir, jmlTarik);

                            String jenisTrans = "Tarik Tunai";
                            LocalDate tglTrans = date;

                            counter++;
                            riwayat[counter][0] = String.valueOf(tglTrans);
                            riwayat[counter][1] = jenisTrans;
                            riwayat[counter][2] = String.valueOf(jmlTarik);
                            riwayat[counter][3] = nasabah[index][2];
                        }
                    } else {
                        System.out.println("\n------------------------------------");
                        System.out.println("Maksimal Tarik Tunai Rp 7.000.000");
                        System.out.println("------------------------------------\n");

                    }
                } else {
                    System.out.println("\n------------------------------------");
                    System.out.println("Minimal Tarik Tunai Rp 100.000");
                    System.out.println("------------------------------------\n");
                }
            } while (!isTarik);
        }
    }

    static void CetakResiTarikTunai(int saldoAkhir, int jmlTarik) {
        do {
            System.out.println("\n====================================");
            System.out.println("               ATM BTS");
            System.out.println("====================================");
            System.out.printf("\n" + date + " %tT%n", time);
            System.out.println("Cabang JTI Polinema");
            System.out.println("\nTarik Tunai");
            System.out.printf(Locale.ITALY, "Jumlah              : Rp %,d %n", jmlTarik);
            System.out.printf(Locale.ITALY, "Sisa Saldo          : Rp %,d %n ", saldoAkhir);
            System.out.println("\n========== Terima Kasih ! ==========");
            System.out.print("\nTransaksi Lain ? (y/n) : ");
            String konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                break;
            } else {
                Login();
            }
            break;
        } while (true);
    }

    static void SetorTunai() {
        int jmlSetor;
        int saldoAkhir = 0, saldoAkhirLain = 0;
        String rekSetor = null, namaTujuan = null, Banktujuan = null, riwayatSetor = null;
        int saldoSendiri = Integer.parseInt(nasabah[index][2]);

        boolean isSetor = false;
        do {
            System.out.print("Masukkan Nominal Setor : ");
            jmlSetor = sc.nextInt();
            sc.nextLine();

            if (jmlSetor % 50_000 == 0) {
                if (jmlSetor <= 15_000_000 && jmlSetor >= 50_000) {
                    isSetor = true;
                    System.out.println("\n||================================||");
                    System.out.println("||         Rekening Tujuan        ||");
                    System.out.println("||________________________________||");
                    System.out.println("||       1. Rekening Sendiri      ||");
                    System.out.println("||       2. Rekening Lainnya      ||");
                    System.out.println("||================================||");
                    System.out.print("\nPilih Rekening Tujuan    : ");
                    int menu = sc.nextInt();
                    sc.nextLine();

                    if (menu == 1) {
                        System.out.print("Apakah Anda Yakin ? (y/n) : ");
                        String konfirmasi = sc.nextLine();

                        if (konfirmasi.equalsIgnoreCase("y")) {
                            rekSetor = nasabah[index][0];
                            saldoAkhir = saldoSendiri + jmlSetor;
                            nasabah[index][2] = Integer.toString(saldoAkhir);

                            CetakResiSetoran(jmlSetor, saldoAkhir);
                        } else {
                            System.out.println("\n------------------------------------");
                            System.out.println("Transaksi Dibatalkan !");
                            System.out.println("------------------------------------");

                        }

                    } else if (menu == 2) {
                        do {
                            System.out.print("Masukkan Rekening Tujuan : ");
                            rekSetor = sc.nextLine();

                            for (int i = 0; i < nasabah.length; i++) {
                                if (rekSetor.equals(nasabah[i][0])) {
                                    saldoAkhirLain += jmlSetor;
                                    saldoAkhirLain = Integer.parseInt(nasabah[i][2]);
                                    nasabah[i][2] = String.valueOf(saldoAkhirLain);
                                    saldoAkhir = Integer.parseInt(nasabah[index][2]);
                                    Banktujuan = nasabah[i][4];
                                    namaTujuan = nasabah[i][3];
                                }
                            }

                            System.out.print("Apakah Anda Yakin ? (y/n) : ");
                            String konfirmasi = sc.nextLine();

                            if (konfirmasi.equalsIgnoreCase("y")) {
                                if (Banktujuan == "BTS") {
                                    CetakResiSetoranLain(namaTujuan, rekSetor, jmlSetor);
                                    break;
                                } else {
                                    System.out.println("Rekening Tidak Valid");
                                }
                            } else {
                                System.out.println("Transaksi Dibatalkan !");
                                break;
                            }

                        } while (true);
                    }
                } else {
                    System.out.println("\n====================================");
                    System.out.println("Jumlah Setor Minimal Rp 50.000 dan \nMaksimal Rp 15.000.000");
                    System.out.println("====================================\n");
                }
            } else {
                System.out.println("\n====================================");
                System.out.println("Jumlah Setor Harus Kelipatan Rp 50.000");
                System.out.println("====================================\n");
            }
        } while (!isSetor);

                String jenisTrans = "Setor Tunai";
                LocalDate tglTrans = date;

                riwayat[index][0] = String.valueOf(tglTrans);
                riwayat[index][1] = jenisTrans;
                riwayat[1][index] = String.valueOf(rekSetor);
                riwayat[index][2] = String.valueOf(jmlSetor);
                riwayat[index][3] = String.valueOf(saldoAkhir);
    }

    static void CetakResiSetoran(int jmlSetor, int saldoAkhir) {
        do {
            System.out.println("\n====================================");
            System.out.println("               ATM BTS");
            System.out.println("====================================");
            System.out.printf("\n" + date + " %tT%n", time);
            System.out.println("Cabang JTI Polinema");
            System.out.println("\nSetor Tunai");
            System.out.printf(Locale.ITALY, "Jumlah          : Rp %,d %n ", jmlSetor);
            System.out.printf(Locale.ITALY, "Total Saldo    : Rp %,d %n ", saldoAkhir);
            System.out.println("\n========= Terima Kasih !  ==========");
            System.out.print("\nTransaksi Lain ? (y/n) : ");
            String konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                break;
            } else {
                Login();
            }
            break;
        } while (true);
    }

    static void CetakResiSetoranLain(String namaTujuan, String rekTujuan, int jmlSetor) {
        do {
            System.out.println("\n====================================");
            System.out.println("       SETOR TUNAI BERHASIL !");
            System.out.println("====================================");
            System.out.println("\nSetor Tunai");
            System.out.println("No Rekening       : " + rekTujuan);
            System.out.println("Nama Penerima     : " + namaTujuan);
            System.out.printf(Locale.ITALY, "Jumlah            : Rp %,d %n ", jmlSetor);
            System.out.println("\n========= Terima Kasih !  ==========");
            System.out.print("\nTransaksi Lain ? (y/n) : ");
            String konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                break;
            } else {
                Login();
            }
            break;
        } while (true);

    }

    static void MenuTransfer() {
        System.out.println("\n||================================||");
        System.out.println("||           Menu Transfer        ||");
        System.out.println("||________________________________||");
        System.out.println("||          1. Sesama Bank        ||");
        System.out.println("||          2. Bank Lain          ||");
        System.out.println("||          3. Virtual Akun       ||");
        System.out.println("||          4. Kembali            ||");
        System.out.println("||================================||");
        System.out.print("\nPilih Menu Transfer : ");
        int menu = sc.nextInt();
        sc.nextLine();

        int admin;
        String bankTujuan = null;
        if (menu == 1) {
            admin = 6_500;
            bankTujuan = "BTS";
            Transfer(admin, bankTujuan);
        } else if (menu == 2) {
            admin = 7_500;
            System.out.println("\n||================================||");
            System.out.println("||            Bank Tujuan         ||");
            System.out.println("||________________________________||");
            System.out.println("||          1. BRI                ||");
            System.out.println("||          2. BNI                ||");
            System.out.println("||          3. BCA                ||");
            System.out.println("||          4. Kembali            ||");
            System.out.println("||================================||");
            System.out.print("Pilih Menu Bank               : ");
            int menuBank = sc.nextInt();
            sc.nextLine();

            if (menuBank == 1) {
                bankTujuan = "BRI";
            } else if (menuBank == 2) {
                bankTujuan = "BNI";
            } else if (menuBank == 3) {
                bankTujuan = "BCA";
            } else if (menuBank == 4) {
                MenuUtama();
            } else {
                System.out.println("Menu Tidak Valid !");
            }

            Transfer(admin, bankTujuan);
        } else if (menu == 3) {
            VirtualAkun();
        } else {
            System.out.println("Menu Tidak Valid !");
        }

    }

    static void Transfer(int admin, String bankTujuan) {
        int saldoPengirim = Integer.parseInt(nasabah[index][2]);
        int saldoTujuan = 0, jmlTF = 0, totalTF = 0;
        boolean rekValid = false;
        String rekTujuan = null, namaTujuan = null, jenis = null;

        do {
            System.out.print("Masukkan Nomor Rekening Tujuan: ");
            rekTujuan = sc.nextLine();

            for (int j = 0; j < nasabah.length; j++) {
                if (rekTujuan.equals(nasabah[j][0]) && !rekTujuan.equals(nasabah[index][2])
                        && bankTujuan.equals(nasabah[j][4])) {
                    indexTujuan = j;
                    rekValid = true;
                    break;
                }
            }

            if (!rekValid) {
                System.out.println("Nomor Rekening Tidak Valid !");
            }
        } while (!rekValid);

        boolean isTransfer = false;
        do {
            System.out.print("Masukkan Nominal Transfer     : ");
            jmlTF = sc.nextInt();
            sc.nextLine();

            System.out.print("Apakah Anda Yakin ? (y/n)     : ");
            String konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                if (jmlTF >= 10_000 && jmlTF <= 25_000_000) {
                    isTransfer = true;
                    if (jmlTF <= (saldoPengirim - 50_000)) {
                        totalTF = jmlTF + admin;
                        jenis = "Transfer Sesama Bank";
                        saldoTujuan = Integer.parseInt(nasabah[indexTujuan][2]);
                        namaTujuan = nasabah[indexTujuan][3];
                        bankTujuan = nasabah[indexTujuan][4];
                        CetakResiTransfer(jenis, rekTujuan, bankTujuan, namaTujuan, saldoPengirim, saldoTujuan, jmlTF,
                                totalTF, admin);
                    } else {
                        System.out.print("Saldo Anda Kurang !");
                    }
                } else {
                    System.out.println("\n====================================");
                    System.out.println("Minimal Transfer Rp 10.000 dan \nMaksimal Rp 25.000.000");
                    System.out.println("====================================\n");
                }
            } else {
                System.out.println("Transaksi Dibatalkan !");
                break;
            }
        } while (!isTransfer);

    }

    static void CetakResiTransfer(String jenis, String rekTujuan, String bankTujuan, String namaTujuan,
            int saldoPengirim, int saldoTujuan, int jmlTF, int totalTF, int admin) {
        saldoPengirim = Integer.parseInt(nasabah[index][2]);
        String konfirmasi = "n";

        do {
            if (saldoPengirim > 0) {
                saldoPengirim -= totalTF;
                saldoTujuan += jmlTF;
                nasabah[indexTujuan][2] = String.valueOf(saldoTujuan);
                nasabah[index][2] = String.valueOf(saldoPengirim);

                System.out.println("\n====================================");
                System.out.println("               ATM BTS");
                System.out.println("====================================");
                System.out.printf("\n" + date + " %tT%n", time);
                System.out.println("Cabang JTI Polinema");
                System.out.println("\nTransfer");
                System.out.println("Ke Bank             : " + bankTujuan);
                System.out.println("Ke Rekening         : " + rekTujuan);
                System.out.println("Nama                : " + namaTujuan);
                System.out.printf(Locale.ITALY, "Jumlah              : Rp %,d %n", jmlTF);
                System.out.println("\n========== Terima Kasih ! ==========");

                String jenisTrans = "Transfer";
                LocalDate tglTrans = date;

                riwayat[index][0] = String.valueOf(tglTrans);
                riwayat[index][1] = jenisTrans;
                riwayat[index][2] = String.valueOf(totalTF);
                riwayat[index][3] = String.valueOf(saldoPengirim);

            } else {
                System.out.print("Saldo Anda Kurang !");
            }
            System.out.print("\nTransaksi Lain ? (y/n) : ");
            konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                break;
            } else {
                Login();
            }
            break;
        } while (true);

    }

    static void GantiPIN() {
        boolean isPIN = false;
        do {
            System.out.print("Masukkan PIN Lama : ");
            String pinLama = sc.nextLine();

            if (pinLama.equals(nasabah[index][1])) {
                System.out.print("Masukkan PIN Baru : ");
                String pinBaru = sc.nextLine();

                if (pinBaru.length() == 6) {
                    isPIN = true;
                    nasabah[index][1] = pinBaru;
                    Login();
                } else {
                    System.out.println("PIN Harus 6 Digit");
                }
            } else {
                System.out.println("PIN Anda Salah !");
            }
        } while (!isPIN);
    }

    static void VirtualAkun() {
        VA();
        int saldoPembayar = Integer.parseInt(nasabah[index][2]);
        boolean vaValid = false;
        int jmlTagihan = 0;
        String jenis = null, noVA, konfirmasi;

        do {
            System.out.print("Masukkan Nomor Virtual Acoount (12 Digit): ");
            noVA = sc.nextLine();

            for (int i = 0; i < va.length; i++) {
                if (va[i][0].equals(noVA)) {
                    if (noVA.length() == 12) {
                        if (jmlTagihan <= (saldoPembayar - 50_000)) {
                            vaValid = true;
                            jenis = va[i][1];
                            jmlTagihan = Integer.parseInt(va[i][2]);
                            continue;
                        }
                    } else {
                        System.out.println("Nomor Virtual Akun Harus 12 Digit !");
                    }
                }
            }

            if (!vaValid) {
                System.out.println("Nomor Virtual Akun Tidak Valid !");
            }
        } while (!vaValid);

        while (true) {
            System.out.println("\n===================================");
            System.out.println("        RINCIAN PEMBAYARAN        ");
            System.out.println("===================================");
            System.out.println("\nNomor VA          : " + noVA);
            System.out.println("Pembayaran        : " + jenis);
            System.out.printf(Locale.ITALY, "Tunggakan         : Rp %,d %n", jmlTagihan);
            System.out.printf(Locale.ITALY, "Jumlah Tagihan    : Rp %,d %n", jmlTagihan);
            System.out.println("\n===================================");
            System.out.print("Apakah Anda Yakin ? (y/n) : ");
            konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                saldoPembayar -= jmlTagihan;
                nasabah[index][2] = Integer.toString(saldoPembayar);
                System.out.println("Pembayaran Berhasil !");
                break;
            } else {
                System.out.println("Transaksi Dibatalkan");
            }

            System.out.print("\nTransaksi Lain ? (y/n) : ");
            konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                break;
            } else {
                Login();
            }
            break;
        }

                String jenisTrans = "Pembayaran VA";
                LocalDate tglTrans = date;

                riwayat[index][0] = String.valueOf(tglTrans);
                riwayat[index][1] = jenisTrans;
                riwayat[index][2] = String.valueOf(jmlTagihan);
                riwayat[index][3] = String.valueOf(saldoPembayar);
    }

    static void History() {
        do {
            System.out.println("\n==========================================================================");
            System.out.println("|                              Mutasi Rekening                           |");
            System.out.printf("|\t\t\t\t%1$tB %1$tY                            |%n", date);
            System.out.println("==========================================================================");
            System.out.println("|     Tgl    |       Keterangan       |     Mutasi     |      Saldo      |");
            System.out.println("==========================================================================");

            for (int i = 0; i < riwayat.length; i++) {
                if (riwayat[i] != null) {
                    if (riwayat[i][0] != null && riwayat[i][1] != null && riwayat[i][2] != null
                            && riwayat[i][3] != null) {
                        System.out.printf("| %-10s | %-22s | %-14s | %-15s | %n", riwayat[i][0],
                                riwayat[i][1], riwayat[i][2], riwayat[i][3]);
                        System.out
                                .println("==========================================================================");
                    }
                } else {
                    break;
                }
            }

            System.out.println();

            System.out.print("Transaksi Lain ? (y/n) : ");
            String konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                break;
            } else {
                Login();
            }
            break;
        } while (true);
    }
}
