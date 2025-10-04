/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jualan_nasi_goreng;

/**
 *
 * @author Bravo 15
 */
import java.util.ArrayList;

public class nasiGoreng {
    // Variabel Static (konstanta)
    public static final int HARGA_DASAR = 15000;

    // Variabel Instance
    private ArrayList<topping> daftarPelengkap;
    private char levelPedas; // Variabel untuk menyimpan karakter 

    // Constructor
    public nasiGoreng() {
        this.daftarPelengkap = new ArrayList<>();
        this.levelPedas = '0'; // Default tidak pedas
    }

    public void tambahPelengkap(topping pelengkap) {
        this.daftarPelengkap.add(pelengkap);
        System.out.println( pelengkap.nama + " ditambahkan.");
    }

    public void setLevelPedas(char level) {
        this.levelPedas = level;
    }

    public int hitungTotalHarga() {
        int totalHargaPelengkap = 0;
        // Looping
        for (topping pelengkap : this.daftarPelengkap) {
            totalHargaPelengkap += pelengkap.harga;
        }
        return HARGA_DASAR + totalHargaPelengkap;
    }

    public void tampilkanPesanan() {
        System.out.println("\n      Detail Pesanan Anda      ");
        System.out.printf("Nasi Goreng Polos      : Rp %,d\n", HARGA_DASAR);
        // Menggunakan switch-case untuk menampilkan level pedas
        String deskripsiLevelPedas;
        switch (this.levelPedas) {
            case '0':
                deskripsiLevelPedas = "Tidak Pedas";
                break;
            case '1':
                deskripsiLevelPedas = "Sedang";
                break;
            case '2':
                deskripsiLevelPedas = "Pedas";
                break;
            default:
                deskripsiLevelPedas = "Tidak Diketahui";
        }
        System.out.println("Level Pedas            : " + deskripsiLevelPedas);

        // Kondisional if
        if (!daftarPelengkap.isEmpty()) {
            System.out.println("Pelengkap/Topping:");
            // Looping
            for (topping pelengkap : this.daftarPelengkap) {
                System.out.printf("- %-20s : Rp %,d\n", pelengkap.nama, pelengkap.harga);
            }
        }
    }
}