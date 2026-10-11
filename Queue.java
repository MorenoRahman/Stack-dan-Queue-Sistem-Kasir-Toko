// Queue: antrian pelanggan (FIFO), maksimal 5 data
public class Queue {
    private Node front, rear;
    private int size;
    public static final int KAPASITAS = 5;

    public boolean isEmpty() { return front == null; }
    public boolean isFull()  { return size >= KAPASITAS; }
    public int getSize()     { return size; }

    // enqueue: tambah pelanggan di belakang antrian
    public boolean enqueue(String kode, String nama, double total) {
        if (isFull()) return false;
        Node baru = new Node(kode, nama, total);
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        size++;
        return true;
    }

    // dequeue: ambil pelanggan paling depan
    public Node dequeue() {
        if (isEmpty()) return null;
        Node keluar = front;
        front = front.next;
        if (front == null) rear = null;
        keluar.next = null;
        size--;
        return keluar;
    }

    public boolean kodeSudahAda(String kode) {
        for (Node n = front; n != null; n = n.next) {
            if (n.kode.equalsIgnoreCase(kode)) return true;
        }
        return false;
    }

    // tampilkan antrian dari depan ke belakang
    public void tampil() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian saat ini:");
        int no = 1;
        for (Node n = front; n != null; n = n.next) {
            System.out.printf("%d. %s | %s | Rp%,.0f%n", no++, n.kode, n.nama, n.total);
        }
        System.out.println("Jumlah antrian: " + size);
    }
}
