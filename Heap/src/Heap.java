import java.util.ArrayList;

public class Heap<T extends Comparable<T>>{

    private ArrayList<Node> heap;

    private class Node<T extends Comparable<T>>{
        private int index;
        private T data;

        private Node(T data, int index){
            this.index = index;
            this.data = data;
        }

        private void setInedx(int index){
            this.index = index;
        }
        private void setData(T data){
            this.data = data;
        }
        private int getIndex(){
            return this.index;
        }
        private T getData(){
            return this.data;
        }

        private Node getParent(){
            if(this.index != 0)
                return (heap.get((int)(this.index - 1)/2));
            return null;
        }
        private Node getLeft(){
            if((2 * this.index + 1) < heap.size())
                return heap.get((2*this.index + 1));
            return null;
        }
        private Node getRight(){
            if((2 * this.index + 2) < heap.size())
                return heap.get((2*this.index + 2));
            return null;
        }

    }

    public Heap(){
        heap = new ArrayList<>();
    }



    public void insert(T t){
        Node newNode = new Node(t, heap.size());
        heap.add(newNode);
        bubbleUp(newNode);
    }

    public T deleteMin(){
        T data;
        if(heap.size() == 0)
            return null;
        if(heap.size() == 1){
            data = (T)heap.get(heap.size() - 1).getData();
            heap.remove(heap.size() - 1);
            return data;
        }
        else{
            Node lastNode = heap.get(heap.size() - 1);
            data = (T)heap.get(0).getData();
            heap.remove(heap.size() - 1);
            lastNode.setInedx(0);
            heap.set(0, lastNode);
            bubbleDown(lastNode);
        }
        return data;
    }

    private void bubbleUp(Node node){
        Node parent = node.getParent();
        if(parent != null){
            if(node.data.compareTo(parent.data) > 0){
                heap.set(node.getIndex(), parent);
                heap.set(parent.getIndex(), node);
                int tempIndex = parent.getIndex();
                parent.setInedx(node.getIndex());
                node.setInedx(tempIndex);
                bubbleUp(node);
            }
        }
    }
    private void bubbleDown(Node node){
        Node left = node.getLeft();
        Node right = node.getRight();
        if(left != null && right != null){
            if(left.data.compareTo(right.data) >= 0){
                if(node.data.compareTo(left.data) < 0) {
                    heap.set(node.getIndex(), left);
                    heap.set(left.getIndex(), node);
                    int tempIndex = left.getIndex();
                    left.setInedx(node.getIndex());
                    node.setInedx(tempIndex);
                    bubbleDown(node);
                }
            }
            else{
                if(node.data.compareTo(right.data) < 0){
                    heap.set(node.getIndex(), right);
                    heap.set(right.getIndex(), node);
                    int tempIndex = right.getIndex();
                    right.setInedx(node.getIndex());
                    node.setInedx(tempIndex);
                    bubbleDown(node);
                }
            }
        }
        else if(left == null && right != null){
            if(node.data.compareTo(right.data) < 0){
                heap.set(node.getIndex(), right);
                heap.set(right.getIndex(), node);
                int tempIndex = right.getIndex();
                right.setInedx(node.getIndex());
                node.setInedx(tempIndex);
                bubbleDown(node);
            }
        }
        else if(right == null && left != null){
            if(node.data.compareTo(left.data) < 0) {
                heap.set(node.getIndex(), left);
                heap.set(left.getIndex(), node);
                int tempIndex = left.getIndex();
                left.setInedx(node.getIndex());
                node.setInedx(tempIndex);
                bubbleDown(node);
            }
        }
    }

    public ArrayList<T> HeapSort(ArrayList<T> unsortedElements){
        ArrayList<T> sortedElements = new ArrayList<T>();
        this.buildHeap(unsortedElements);
        for(int i = 0; i < unsortedElements.size(); i++){
            sortedElements.add(this.deleteMin());
        }
        return sortedElements;
    }
    public void buildHeap(ArrayList<T> arrayList){
        this.heap = new ArrayList<Node>();
        for(int i = 0; i < arrayList.size(); i++){
            heap.add(new Node(arrayList.get(i), i));
        }

        for(int i = arrayList.size() / 2 - 1; i >= 0; i--){
            bubbleDown(heap.get(i));
        }
    }

    @Override
    public String toString(){
        String ret = "";
        ret += "[";
        for(int i = 0; i < heap.size(); i++){
            if(i != heap.size() - 1)
                ret += heap.get(i).getData() + ", ";
            else
                ret += heap.get(i).getData() + "]";

        }
        return ret;
    }



}
