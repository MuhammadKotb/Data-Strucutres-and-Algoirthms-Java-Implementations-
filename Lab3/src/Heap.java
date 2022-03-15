import java.util.ArrayList;

public class Heap<T extends Comparable<T>>{

    private ArrayList<Node> heap;
    private int size = 0;

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

    public int getSize(){
        return size;
    }


    public void insert(T t){
        Node newNode = new Node(t, size);
        if(heap.size() == size)
            heap.add(newNode);
        if(heap.size() > size)
            heap.set(size, newNode);
        bubbleUp(newNode);
        size++;
    }

    public void deleteMin(){
        Node lastNode = heap.get(size - 1);
        lastNode.setInedx(0);
        heap.set(0, lastNode);
        bubbleDown(lastNode);
        size--;
    }

    private void bubbleUp(Node node){
        Node parent = node.getParent();
        if(parent != null){
            if(node.data.compareTo(parent.data) < 0){
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
            if(left.data.compareTo(right.data) < 0){
                if(node.data.compareTo(left.data) > 0) {
                    heap.set(node.getIndex(), left);
                    heap.set(left.getIndex(), node);
                    int tempIndex = left.getIndex();
                    left.setInedx(node.getIndex());
                    node.setInedx(tempIndex);
                    bubbleDown(node);
                }
            }
            else{
                if(node.data.compareTo(right.data) > 0){
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
            if(node.data.compareTo(right.data) > 0){
                heap.set(node.getIndex(), right);
                heap.set(right.getIndex(), node);
                int tempIndex = right.getIndex();
                right.setInedx(node.getIndex());
                node.setInedx(tempIndex);
                bubbleDown(node);
            }
        }
        else if(right == null && left != null){
            if(node.data.compareTo(left.data) > 0) {
                heap.set(node.getIndex(), left);
                heap.set(left.getIndex(), node);
                int tempIndex = left.getIndex();
                left.setInedx(node.getIndex());
                node.setInedx(tempIndex);
                bubbleDown(node);
            }
        }




    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.print(heap.get(i).data + " ");
        }
    }



}
