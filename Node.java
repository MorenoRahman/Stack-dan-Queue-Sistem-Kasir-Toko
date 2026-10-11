// Node: menyimpan data satu pelanggan (kode antrian, nama, total belanja)
public class Node {
    String kode;
    String nama;
    double total;
    Node next;

    public Node(String kode, String nama, double total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}
