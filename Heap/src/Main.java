





public class Main {
    public static void main(String[] args){
        Heap<Integer> heap = new Heap<>();

        heap.insert(10);
        heap.insert(5);
        heap.insert(7);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);

        heap.deleteMin();
        heap.deleteMin();
        heap.insert(14);
        heap.insert(23);
        heap.insert(6);
        heap.deleteMin();
        heap.deleteMin();
        heap.deleteMin();
        heap.deleteMin();
        heap.deleteMin();
        heap.deleteMin();

        heap.print();







    }
}
