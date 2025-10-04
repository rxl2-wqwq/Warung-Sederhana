/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jualan_nasi_goreng;

/**
 *
 * @author Bravo 15
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Persiapan Warung
        Scanner inputPengguna = new Scanner(System.in);
        final double DISKON_MEMBER = 0.10; // Diskon 10%

        //Menggunakan Array standar (bukan ArrayList)
        topping[] menuPelengkap = new topping[5];
        menuPelengkap[0] = new topping("Telur Dadar", 4000);
        menuPelengkap[1] = new topping("Sosis", 5000);
        menuPelengkap[2] = new topping("Ayam Suwir", 6000);
        menuPelengkap[3] = new topping("Bakso", 5000);
        menuPelengkap[4] = new topping("Ati Ampela", 6000);

        System.out.println("Selamat Datang di Warung Nasi Goreng Kustom!");

        // --- Proses Pemesanan ---
        nasiGoreng pesanan = new nasiGoreng();
        int pilihan = -1; // Variabel lokal

        // memilih pelengkap
        do {
            System.out.println("\n--- Pilih Pelengkap/Topping ---");
            // Looping for untuk menampilkan menu dari Array
            for (int i = 0; i < menuPelengkap.length; i++) {
                topping t = menuPelengkap[i];
                System.out.printf("%d. %-15s (Rp %,d)\n", (i + 1), t.nama, t.harga);
            }
            System.out.println("0. Selesai Memilih");
            System.out.print("Masukkan pilihan: ");
            
            pilihan = inputPengguna.nextInt();

            // Kondisional
            if (pilihan > 0 && pilihan <= menuPelengkap.length) {
                pesanan.tambahPelengkap(menuPelengkap[pilihan - 1]);
            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        // input Character dan manipulasinya
        System.out.println("\n--- Pilih Level Pedas ---");
        System.out.println("0. Tidak Pedas");
        System.out.println("1. Sedang");
        System.out.println("2. Pedas");
        System.out.print("Masukkan Pilihan (0/1/2): ");
        char pilihanPedas = inputPengguna.next().charAt(0); 
        pesanan.setLevelPedas(pilihanPedas);
        
        // Menampilkan detail pesanan sebelum diskon
        pesanan.tampilkanPesanan();
        int subTotal = pesanan.hitungTotalHarga();
        System.out.println("--------------------------------- +");
        System.out.printf("TOTAL                  : Rp %,d\n", subTotal);

        // member
        System.out.print("\nApakah member? (Y/T): ");
        String jawabanMember = inputPengguna.next(); // Variabel lokal
        double totalAkhir = subTotal;

        // membandingkan String tanpa peduli huruf besar/kecil
        if (jawabanMember.equalsIgnoreCase("Y")) {
            System.out.println("Selamat! mendapatkan diskon member 10%.");
            double besarDiskon = subTotal * DISKON_MEMBER;
            totalAkhir = subTotal - besarDiskon;
            System.out.printf("Potongan Harga         : Rp %,.0f\n", besarDiskon);
        }

        System.out.printf("\nTOTAL BAYAR            : Rp %,.0f\n", totalAkhir);
        System.out.println("\nTerima kasih selamat menikmati!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        
        inputPengguna.close();
    }
}