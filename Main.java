import java.util.Scanner;
import java.util.Vector;

/**
 * Main
 */

public class Main {
    static Scanner sc = new Scanner(System.in);
    
    static int tempPrice;
    static int tempKode;
    static int tempJumlah;
    static int uang;
    static int change;

    static int choose; 
    static String tempName;

    static Vector<String> nama = new Vector<>();
    static Vector<Integer> kode = new Vector<>();
    static Vector<Integer> jumlah = new Vector<>();    
    static Vector<Integer> price = new Vector<>();



    static void namaData(){
        String tempEmail;

            do{
                System.out.println("Masukkan Nama Anda : ");
                tempName = sc.nextLine();
            }while (tempName.isEmpty() || tempName.length() < 3);

            do{
                System.out.println("Masukkan Email Anda : ");
                tempEmail  = sc.nextLine();
            }while (!tempEmail.contains("@") || !tempEmail.contains(".com"));


                int tempPrice;
                int tempKode;
                int tempJumlah;
                int uang;
                int change;

                do{
                    System.out.println("Masukkan Kode File[1...3] : ");
                    tempKode= sc.nextInt();
                    sc.nextLine();
                }while (tempKode < 1 || tempKode > 3);

                if (tempKode == 1) {
                        tempPrice = 35000;
                }else if (tempKode == 2) { 
                        tempPrice = 25000;
                }else { 
                        tempPrice = 50000;
                }

                do{
                    System.out.println("Masukkan Jumlah Pembelian (harus lebih dari 0)  : ");
                    tempJumlah = sc.nextInt();
                    sc.nextLine();
                }while (tempJumlah <= 0);

                int totalPrice = tempPrice * tempJumlah;
                System.out.println("Total Harga : " + totalPrice);

                System.out.println("Masukkan Jumlah Uang : ");
                uang = sc.nextInt();
                sc.nextLine();

                if (uang < totalPrice) {
                    System.out.println("Uangmu ra cukup, cok!");
                }else { 
                    change = uang - totalPrice;
                    System.out.println("Change : " + change);
                    System.out.println("Thank You!");
                }

                //add vector
                price.add(totalPrice);
                nama.add(tempName);
                kode.add(tempKode);
                jumlah.add(tempJumlah);
                }

    static void viewData(){
        if (nama.size() == 0){
            System.out.println("There is no data!");
        }else{
            //menampilkan data yang ada di vektor
            System.out.println("=====================================================");
            System.out.println("|No.|Nama       | Kode Film | Jumlah   | Price      |");
            System.out.println("=====================================================");

            for (int i =0; i<nama.size(); i++){
                System.out.printf("|%-2s|%-11s|%-11d|%-10d|%-11d|\n", 
                (i+1), nama.get(i), kode.get(i), jumlah.get(i), price.get(i));
            }
            for (int i = 0; i<3; i++){
                System.out.println();
            }
        }
    }

    static void editData(){
        if (nama.size() == 0){
            System.out.println("There is no Data!");
        }else {
            //menampilkan data yang ada di vektor
            System.out.println("=====================================================");
            System.out.println("|No.|Nama       | Kode Film | Jumlah   | Price      |");
            System.out.println("=====================================================");

            for (int i =0; i<nama.size(); i++){
                System.out.printf("|%-2s|%-11s|%-11d|%-10d|%-11d|\n", 
                (i+1), nama.get(i), kode.get(i), jumlah.get(i), price.get(i));
            }

            do {
                choose = 0;
                System.out.println("Choose >> ");

                try {
                    choose = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    sc.nextLine();
                    System.out.println("Must be numeric!");
                    choose = -1;
                }
            } while (choose <= 0 || choose > nama.size());

            do{ 
                System.out.println("Masukkan Nama Anda [3...25 karakter] : ");
                tempName = sc.nextLine();
            } while (tempName.isEmpty() || tempName.length() < 3);

            //replace data nama pada vector
            nama.set(choose - 1, tempName);
        }
    }

    static void deleteData(){
        if (nama.size() == 0){
            System.out.println("There is no data!");
        } else {
             //menampilkan data yang ada di vektor
            System.out.println("=====================================================");
            System.out.println("|No.|Nama       | Kode Film | Jumlah   | Price      |");
            System.out.println("=====================================================");

            for (int i =0; i<nama.size(); i++){
                System.out.printf("|%-2s|%-11s|%-11d|%-10d|%-11d|\n", 
                (i+1), nama.get(i), kode.get(i), jumlah.get(i), price.get(i));
            }

            do { 
                choose = 0;
                System.out.println("Choose >> ");

                try { 
                    choose = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) { 
                    sc.nextLine();
                    System.out.println("Must be numerik !!");
                    choose = -1;

                }
            } while (choose <= 0 || choose > nama.size());

        }
    }

    public static void main(String[] args) {


        //variabel dan tipe data
        String film1 = "Doraemon";
        String film2 = "Hamtaro";
        String film3 = "Minion";

        //vector 


        //array 
        String film [] = {"Minion", "Teletubbies", "Dora"};


        do {
            for (int i=0; i<5; i++) {
                System.out.println();
            }
        
        //menampilkan output ke user
        System.out.println("\t\t BIOSKOP 21 CS");
        System.out.println("---------------------------");
        System.out.println("| Kode Film | Nama Film   |");
        for (int i=0; i<film.length; i++){
            System.out.printf("| %9s | %13s |\n", (i+1), film[i]);
        }
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println();

        System.out.println("1. Buy");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Exit");
        System.out.println("choose >> ");
        
        
        try {
            choose = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Must be numeric!!");
            choose =-1;
            sc.nextLine();
        }

        switch (choose) {
            case 1:
                namaData();
                break;


            case 2 :
                viewData();
                break;


            case 3 :
                editData();
                break;


            case 4 : 
               deleteData();
                break;
        }
        } while (choose != 5);
        

    }

}