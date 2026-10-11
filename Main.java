import java.util.Scanner;

// Main: menu program sistem kasir toko
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            try {
                pilihan = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                pilihan = 0;
            }

            switch (pilihan) {
                case 1:
                    // validasi: antrian maksimal 5 pelanggan
                    if (antrian.isFull()) {
                        System.out.println("Antrian penuh (maksimal " + Queue.KAPASITAS + " pelanggan).");
                        break;
                    }
                    System.out.print("Masukkan Nomor Antrian: ");
                    String kode = sc.nextLine().trim();
                    if (kode.isEmpty() || antrian.kodeSudahAda(kode)) {
                        System.out.println("Nomor antrian kosong atau sudah dipakai.");
                        break;
                    }
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = sc.nextLine().trim();
                    System.out.print("Masukkan Total Belanja: ");
                    double total;
                    try {
                        total = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Total belanja harus berupa angka.");
                        break;
                    }
                    antrian.enqueue(kode, nama, total);
                    System.out.println("Data pelanggan ditambahkan ke antrian!");
                    break;
                case 2:
                    // dequeue dari antrian lalu push ke stack riwayat
                    Node dilayani = antrian.dequeue();
                    if (dilayani == null) {
                        System.out.println("Tidak ada pelanggan dalam antrian.");
                    } else {
                        System.out.println("Melayani pelanggan " + dilayani.kode + " (" + dilayani.nama + ")");
                        riwayat.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;
                case 3:
                    antrian.tampil();
                    break;
                case 4:
                    riwayat.tampil();
                    break;
                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia, coba lagi.");
            }
        } while (pilihan != 5);
        sc.close();
    }
}
