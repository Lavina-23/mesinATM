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
        boolean login = false;

        do {
            System.out.print("Masukkan Nomor Rekening anda : ");
            noRek = sc.nextInt();
            System.out.print("Masukkan PIN anda : ");
            pin = sc.nextInt();

            if (pin == 123 && noRek == 1234567890) {
                login = true;

                System.out.print("Masukkan jumlah saldo anda : ");
                jmlSaldo = sc.nextInt();

                System.out.print("Masukkan lama menabung anda");
                lama_menabung= sc.nextInt();
        
                bunga= lama_menabung*bunga*jmlSaldo;
                jml_tabungan_akhir=bunga+jmlSaldo;

                System.out.println("\nSilakan Pilih Menu Dibawah Ini");
                System.out.println("\n1. Tarik Tunai \n2. Transfer");
                System.out.println("\nKetik 1 atau 2");
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
                    if (jmlTarik <= jmlSaldo) {
                        System.out.println("Sisa saldo : " + sisaSaldo);
                    }
                    else {
                        System.out.println("Jumlah uang yang anda tarik melebihi jumlah saldo anda !");
                    }
                      
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

                
                    case 2 :
                    // Tranfer

                        do {
                        System.out.print("\nMasukkan nomor rekening tujuan : ");
                    noRek = sc.nextInt();
                    
                    // Array
                    int [] Transfer = {100000, 500000,1000000,5000000};
                    int elemen, min;

                    int [] Tranfer = new int[elemen];
                    for (int i = 0; i <Transfer.length ; i++){
                        System.out.println(Transfer[i]);
                        Tranfer[i] = sc.nextInt();

                    }

                    int max = Transfer[3], main = Transfer[3], sum = Transfer[3];
                    for (int i = 0; i<Transfer.length; i++){
                        if (Transfer[3] > max){
                            max = Transfer[3];

                        }
                        if (Transfer[3] < min){
                            min = Transfer[3];
                        }
                        sum += Transfer[3];
                    }

                    double average = (double) sum / elemen;
                    System.out.print("Nilai tertinggi : "+max);
                    System.out.print("Nilai terendah :"+min);
                    System.out.println("Nilai rata-rata: "+average);

                    // Tranfer biasa
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
}