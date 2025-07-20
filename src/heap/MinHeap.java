package heap;

public class MinHeap {

    private int[] heap;

    private int index;

    public MinHeap(int size) {
        heap = new int[size];
    }

    public void insert(int element) {

    }

    public void pop(){

    }

    public int peek(){
        return this.heap[0];
    }

    private int parent(int i) {
        return (i - 1) >> 1;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private void siftUp() {
        int i = index;
        int j = parent(i);
        while (this.heap[j] > this.heap[i]) {
            this.swap(i, j);
            i = j;
            j = parent(i);
        }
        index++;
    }

    private void siftDown(int n) {
        int child ;
        while (true) {
            child = n << 1 + 1;
            if (child > heap.length - 1) break;
            if (child+ 1 < heap.length && this.heap[child+1]  < this.heap[child])
                child++;

            if (this.heap[n]  < this.heap[child]){
                break;
            }
            this.swap(n, child);
            n = child;
        }

    }

    private void swap(int i, int j) {
        int tmp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = tmp;
    }
}
