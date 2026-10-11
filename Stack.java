// Stack: riwayat transaksi (LIFO), transaksi terbaru berada di atas
public class Stack {
    private Node top;
    private int size;

    public boolean isEmpty() { return top == null; }

    // push: simpan transaksi baru di puncak stack
    public void push(Node data) {
        Node baru = new Node(data.kode, data.nama, data.total);
        baru.next = top;
        top = baru;
        size++;
    }

    // tampilkan dari transaksi terbaru ke terlama
    public void tampil() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat transaksi (terbaru ke lama):");
        int no = 1;
        for (Node n = top; n != null; n = n.next) {
            System.out.printf("%d. %s | %s | Rp%,.0f%n", no++, n.kode, n.nama, n.total);
        }
        System.out.println("Total transaksi: " + size);
    }
}
