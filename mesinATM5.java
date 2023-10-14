import java.util.Scanner;

/**
 * mesinATM5
 */
public class mesinATM5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pin, menu, jmlSaldo, jmlTarik, jmlTF, noRek, lama_menabung, sisaSaldo; 
        double bunga = 0.2, jml_tabungan_akhir;
        String konfirmasi = "ya";
        
        System.out.print("Masukkan Nomor Rekening anda : ");
        noRek = sc.nextInt();
        System.out.print("Masukkan PIN anda : ");
        pin = sc.nextInt();

        if (pin == 123 && noRek == 1234567890) {
            System.out.println("Masukkan jumlah saldo anda : ");
            jmlSaldo = sc.nextInt();

            System.out.println("\nSilakan Pilih Menu Dibawah ini");
            System.out.println("\n1. tarik Tunai \n2. Transfer \n3. Cek Saldo");
            System.out.println("\nketik 1, 2 atau 3");
            menu = sc.nextInt();

            

            switch (menu) {
                case 1:
                    // Tarik Tunai dikerjakan disini
                    do {    
                    System.out.println("=== Penarikan Tunai ===");
                    System.out.println("Pilih Jumlah Penarikan : ");
                    System.out.println("1. 100000");
                    System.out.println("2. 200000");
                    System.out.println("3. 1000000");
                    System.out.println("4. 2000000");
                    menu = sc.nextInt();
                    

                    if (menu == 1) {
                        jmlTarik = 100000;
                    }else if (menu == 2) {
                        jmlTarik = 200000;
                    }else if (menu == 3) {
                        jmlTarik = 1000000;
                    }else if (menu == 4) {
                        jmlTarik = 2000000;
                    }else {
                        System.out.println("Menu invalid");
                        continue;
                    } 

                    System.out.println("Anda yakin? (ya/tidak): ");
                    konfirmasi = sc.next();

                    if (konfirmasi.equalsIgnoreCase("ya")) {
                        sisaSaldo = jmlSaldo - jmlTarik;
                        System.out.println("Sisa Saldo : " + sisaSaldo);
                        break;
                    } else {
                        continue;
                    } 
                } while (true);

                
                case 2:
                    // Transfer kerjakan disini
                    break;
                case 3:
                    // Cek Saldo kerjakan disini
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