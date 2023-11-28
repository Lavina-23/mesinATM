import java.net.NoRouteToHostException;
import java.util.Scanner;

public class MesinATM_5 {
    static Scanner sc = new Scanner(System.in);
    static String[][] nasabah = new String[3][5];
    static String[][] riwayat = new String[6][10];
    static String[][] va = new String[3][3];
    static int counter = 0;
    static int index = -1;
    static int indexTujuan = -1;

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
                    SetorTunai();
                    break;
                case 4:
                    // Transfer
                    Transfer();
                    break;
                case 5:
                    History();
                    break;
                case 6:
                    Login();
                    break;
                case 7:
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
        System.out.println("||          6. Masuk              ||");
        System.out.println("||          7. Keluar             ||");
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

    static void Transfer() {
        int saldoPengirim = Integer.parseInt(nasabah[index][2]);
        int saldoTujuan = 0, jmlTF = 0, totalTF = 0;
        boolean rekValid = false;
        String jenis, rekTujuan = null, namaTujuan = null;
        String bankTujuan = null;

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

        switch (menu) {
            case 1:
                do {
                    System.out.print("Masukkan Nomor Rekening Tujuan : ");
                    rekTujuan = sc.nextLine();

                    for (int j = 0; j < nasabah.length; j++) {
                        if (rekTujuan.equals(nasabah[j][0]) && !rekTujuan.equals(nasabah[index][2])) {
                            saldoTujuan = Integer.parseInt(nasabah[j][2]);
                            indexTujuan = j;
                            rekValid = true;
                            break;
                        }
                    }

                    if (!rekValid) {
                        System.out.println("Nomor Rekening Tidak Valid !");
                    }
                } while (!rekValid);

                System.out.print("Masukkan Nominal Transfer : ");
                jmlTF = sc.nextInt();
                sc.nextLine();

                if (jmlTF <= (saldoPengirim - 50_000)) {
                    int admin = 6_500;
                    totalTF = jmlTF + admin;
                    jenis = "Transfer Sesama Bank";
                    bankTujuan = nasabah[indexTujuan][4];
                    namaTujuan = nasabah[indexTujuan][3];
                    CetakResiTransfer(jenis, rekTujuan, bankTujuan, namaTujuan, saldoPengirim, saldoTujuan, jmlTF,
                            totalTF, admin);
                } else {
                    System.out.print("Saldo Anda Kurang !");
                }
                break;
            case 2:
                System.out.println("\n||================================||");
                System.out.println("||            Bank Tujuan         ||");
                System.out.println("||________________________________||");
                System.out.println("||          1. BRI                ||");
                System.out.println("||          2. BNI                ||");
                System.out.println("||          3. BCA                ||");
                System.out.println("||          4. Kembali            ||");
                System.out.println("||================================||");
                System.out.print("\nPilih Menu Transfer : ");
                int menuBank = sc.nextInt();
                sc.nextLine();

                if (menuBank == 1) {
                    bankTujuan = "BRI";
                } else if (menuBank == 2) {
                    bankTujuan = "BNI";
                } else if (menuBank == 3) {
                    bankTujuan = "BCA";
                } else if (menuBank == 4) {
                    break;
                } else {
                    System.out.println("Menu Tidak Valid !");
                }

                do {
                    System.out.print("Masukkan Nomor Rekening Tujuan : ");
                    rekTujuan = sc.nextLine();

                    for (int j = 0; j < nasabah.length; j++) {
                        if (rekTujuan.equals(nasabah[j][0]) && !rekTujuan.equals(nasabah[index][2])
                                && bankTujuan.equals(nasabah[j][4])) {
                            saldoTujuan = Integer.parseInt(nasabah[j][2]);
                            indexTujuan = j;
                            rekValid = true;
                            break;
                        }
                    }

                    if (!rekValid) {
                        System.out.println("Nomor Rekening Tidak Valid !");
                    }
                } while (!rekValid);

                System.out.print("Masukkan Nominal Transfer : ");
                jmlTF = sc.nextInt();
                sc.nextLine();

                if (jmlTF <= (saldoPengirim - 50_000)) {
                    int admin = 7_500;
                    totalTF = jmlTF + admin;
                    jenis = "Transfer Beda Bank";
                    bankTujuan = nasabah[indexTujuan][4];
                    namaTujuan = nasabah[indexTujuan][3];
                    CetakResiTransfer(jenis, rekTujuan, bankTujuan, namaTujuan, saldoPengirim, 0, jmlTF, totalTF,
                            admin);
                } else {
                    System.out.print("Saldo Anda Kurang !");
                }
                break;
            case 3:
                VirtualAkun();
                break;
            case 4:
                break;
            default:
                System.out.print("Menu Tidak Valid !");
                break;
        }
    }

    static void CetakResiTransfer(String jenis, String rekTujuan, String bankTujuan, String namaTujuan,
            int saldoPengirim, int saldoTujuan, int jmlTF, int totalTF, int admin) {
        saldoPengirim = Integer.parseInt(nasabah[index][2]);
        String konfirmasi = "n";

        System.out.print("Apakah Anda Yakin ? (y/n) : ");
        konfirmasi = sc.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            if (saldoPengirim > 0) {
                saldoPengirim -= totalTF;
                if (rekTujuan != null && rekTujuan.equals(nasabah[index][0])) {
                    saldoTujuan += jmlTF;
                    nasabah[indexTujuan][2] = String.valueOf(saldoTujuan);
                }

                nasabah[index][2] = String.valueOf(saldoPengirim);

                String riwayatTF = "\nJenis Transaksi       : " + jenis +
                        "\nBank Tujuan           : " + bankTujuan +
                        "\nNomor Rekening Tujuan : " + rekTujuan +
                        "\nNama                  : " + namaTujuan +
                        "\nTotal Transfer        : Rp " + totalTF +
                        "\nSisa Saldo            : Rp " + saldoPengirim;

                riwayat[index][counter] = riwayatTF;
                counter++;

                System.out.println("\n===================================");
                System.out.println("            ATM BTS            ");
                System.out.println("===================================");
                System.out.println("\nTransfer");
                System.out.println("Ke Bank             : " + bankTujuan);
                System.out.println("Ke Rekening         : " + rekTujuan);
                System.out.println("Nama                : " + namaTujuan);
                System.out.printf("Jumlah              : Rp %s\n", jmlTF);
                System.out.println("\n========= Terima Kasih !  ==========");
            } else {
                System.out.print("Saldo Anda Kurang !");
            }
        } else {
            System.out.print("Transfer Dibatalkan");
        }
    }

    static void VirtualAkun() {
        VA();
        int saldoPembayar = Integer.parseInt(nasabah[index][2]);
        boolean vaValid = false;
        int jmlTagihan = 0, indexVA;
        String jenis = null, noVA;

        do {
            System.out.print("Masukkan Nomor Virtual Acoount (12 Digit): ");
            noVA = sc.nextLine();

            for (int i = 0; i < va.length; i++) {
                if (va[i][0].equals(noVA) && noVA.length() == 12) {
                    vaValid = true;
                    indexVA = i;
                    jmlTagihan = Integer.parseInt(va[indexVA][2]);
                    jenis = va[indexVA][1];
                }
            }

            if (!vaValid) {
                System.out.println("Nomor Virtual Akun Tidak Valid !");
            }
        } while (!vaValid);

        if (jmlTagihan <= (saldoPembayar - 50_000)) {
            System.out.println("\n===================================");
            System.out.println("        RINCIAN PEMBAYARAN        ");
            System.out.println("===================================");
            System.out.println("\nNomor VA          : " + noVA);
            System.out.println("Pembayaran        : " + jenis);
            System.out.printf("Tunggakan         : Rp %d\n", jmlTagihan);
            System.out.printf("Jumlah Tagihan    : Rp %d\n", jmlTagihan);
            System.out.print("\nApakah Anda Yakin ? (y/n) : ");
            String konfirmasi = sc.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                saldoPembayar -= jmlTagihan;
                nasabah[index][2] = Integer.toString(saldoPembayar);
                System.out.println("\nPembayaran Berhasil !");
                System.out.printf("Sisa Saldo : Rp %d\n", saldoPembayar);
            } else {
                System.out.println("Transaksi Dibatalkan");
            }
        } else {
            System.out.println("Saldo Anda Kurang !");
        }

        String riwayatVA = "\nJenis Transaksi       : Pembayaran Virtual Akun" +
                "\nNomor VA             : " + noVA +
                "\nPembayaran           : " + jenis +
                "\nTunggakan            : Rp " + jmlTagihan +
                "\nJumlah Tagihan       : Rp " + jmlTagihan;

        riwayat[index][counter] = riwayatVA;
        counter++;
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

    // Setor Tunai
    static void SetorTunai(){
        int jmlSetor;
        int totalSetoran = 0, totalSetoran2 = 0, saldoAkhir = 0, saldoAkhirLain = 0;
        String rekSetor = null, namaTujuan = null, Banktujuan = null;
        int saldoSendiri = Integer.parseInt(nasabah[index][2]);
        
        System.out.print("Masukkan Nominal Uang Yang Ingin Anda Setorkan : ");
        jmlSetor = sc.nextInt();
        sc.nextLine();

        System.out.println("\n||==========================================||");
        System.out.println("||           Rekening Tujuan                ||");
        System.out.println("||__________________________________________||");
        System.out.println("||          1. Rekening Sendiri             ||");
        System.out.println("||          2. Rekening Lainnya             ||");
        System.out.println("||==========================================||");
        System.out.print("\nPilih Rekening Tujuan : ");
        int menu = sc.nextInt();
        sc.nextLine();

        if (menu == 1) { rekSetor = nasabah[index][0];
            saldoAkhir = saldoSendiri + jmlSetor;
            nasabah[index][2] = Integer.toString(saldoAkhir);
            CetakResiSetoran(jmlSetor, saldoAkhir);
        } else if (menu == 2){
            System.out.println("Masukkan Rekening Tujuan : ");
            rekSetor = sc.nextLine(); 
            
            for (int i = 0; i < nasabah.length; i++) {
                if (rekSetor.equals(nasabah[i][0])) { 
                    saldoAkhirLain = Integer.parseInt(nasabah[i][2]);
                    Banktujuan = nasabah[i][4]; 
                    namaTujuan = nasabah[i][3];
                    saldoAkhirLain += jmlSetor;
                    nasabah[i][2] = String.valueOf(saldoAkhirLain);
                }
            }
            if (Banktujuan == "BTS") {
                CetakResiSetoranLain(namaTujuan, rekSetor, jmlSetor);
            } else{
                System.out.println("Rekening Tidak Valid");
            }
        }
        String riwayatSetor =
                "\nNo Rekening               : " + rekSetor +
                "\nJumlah Setoran            : Rp " + jmlSetor;
        riwayat[index][counter] = riwayatSetor;
        counter++;
    }

    static void CetakResiSetoran(int jmlSetor, int saldoAkhir){

        System.out.println("\n===================================");
        System.out.println("        SETOR TUNAI BERHASIL !       ");
        System.out.println("=====================================");
        System.out.println("Jumlah                  : Rp " + jmlSetor);
        System.out.println("Total Saldo             : Rp " + saldoAkhir);
        System.out.println("\n====== Sampai Jumpa Kembali =======");
    }

    static void CetakResiSetoranLain(String namaTujuan, String rekTujuan, int jmlSetor){

        System.out.println("\n==============================================");
        System.out.println("             SETOR TUNAI BERHASIL !             ");
        System.out.println("================================================");
        System.out.println("No Rekening                       :   " + rekTujuan);
        System.out.println("Nama Penerima                     :  " + namaTujuan);
        System.out.println("Jumlah                            : Rp " + jmlSetor);
        System.out.println("\n====== Sampai Jumpa Kembali =======");
    }
}
