import java.util.Scanner;
public class tranfer_array{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

                    // Array Tranfer
                    int [] Transfer = {100000, 500000,1000000,5000000};
                    int elemen = 0;
                    int min = 0;

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
                    System.out.print("Nilai terendah :+min");
                    System.out.println("Nilai rata-rata: "+average);

    }
}