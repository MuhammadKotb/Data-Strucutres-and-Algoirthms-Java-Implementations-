package com.company;

public class AVLNode {
    private String element;
    private AVLNode parent = null;
    private AVLNode rightChild = null;
    private AVLNode leftChild = null;
    private int height;
    private int bf;
    public AVLNode(String element){
        this.element = element;
        this.height = 0;
    }

    public String getElement() {
        return element;
    }

    public AVLNode getParent() {
        return parent;
    }

    public AVLNode getLeftChild() {
        return leftChild;
    }

    public AVLNode getRightChild() {
        return rightChild;
    }

    public static void updateHeight(AVLNode node){
        if(node == null)
            return ;
        node.height = Integer.max(getHeight(node.rightChild), getHeight(node.leftChild)) + 1;
        node.updateBalanceFactor();
    }

    public void updateBalanceFactor() {
        this.bf = AVLNode.getHeight(this.leftChild) - AVLNode.getHeight(this.rightChild);

    }

    public static int getHeight(AVLNode node) {
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public static int getBalanceFactor(AVLNode node){
        if(node == null){
            return 0;
        }
        return node.bf;
    }


    public void setElement(String element) {
        this.element = element;
    }

    public void setParent(AVLNode parent) {
        this.parent = parent;
    }

    public void setLeftChild(AVLNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(AVLNode rightChild) {
        this.rightChild = rightChild;
    }




}
