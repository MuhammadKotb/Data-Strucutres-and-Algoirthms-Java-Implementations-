package com.company;

public class AVLTree {
    private AVLNode root;
    public AVLTree(){ }

    public void setRoot(AVLNode root) {
        this.root = root;

    }

    public AVLNode getRoot() {
        return root;
    }

    private String findMax(AVLNode root){
        if(root.getRightChild() == null)
            return root.getElement();
        return findMax(root.getRightChild());
    }

    private String findMin(AVLNode root){
        if(root.getLeftChild() == null)
            return root.getElement();
        return findMin(root.getLeftChild());
    }

    public void insertAtRoot(String element){
        this.insert(this.getRoot(), element);
        this.printTree(this.getRoot());
        System.out.println();
    }

    public void deleteFromRoot(String element){
        this.delete(this.getRoot(), element);
        this.printTree(this.getRoot());
        System.out.println();
    }

    public void printTree(AVLNode root){
        if(root == null)
            return;

        printTree(root.getLeftChild());
        System.out.print(root.getElement() + " ");
        printTree(root.getRightChild());

    }

    public boolean search( AVLNode dummyRoot, String element){
        if(dummyRoot == null){
            return false;
        }
        else if(element.compareTo(dummyRoot.getElement()) > 0){

            if(dummyRoot.getRightChild() == null){
                return false;
            }
            else{
                return this.search(dummyRoot.getRightChild(),element);
            }

        }else if(element.compareTo(dummyRoot.getElement()) < 0){

            if(dummyRoot.getLeftChild() == null){
                return false;
            }
            else{
                return this.search(dummyRoot.getLeftChild(),element);
            }

        }else{
            return true;
        }
    }

    public void leftRotate(AVLNode node){
        AVLNode parentNode = node.getParent();
        AVLNode rightChild = node.getRightChild();



        node.setRightChild(rightChild.getLeftChild());
        if(rightChild.getLeftChild() != null)
            rightChild.getLeftChild().setParent(node);



        if(parentNode == null)
            this.setRoot(rightChild);
        else{
            if(parentNode.getLeftChild() != null){
                if(parentNode.getLeftChild().getElement() == node.getElement()){
                    parentNode.setLeftChild(rightChild);
                }
            }
            if(parentNode.getRightChild() != null){
                if(parentNode.getRightChild().getElement() == node.getElement()){
                    parentNode.setRightChild(rightChild);
                }
            }

        }



        rightChild.setParent(parentNode);
        rightChild.setLeftChild(node);
        node.setParent(rightChild);

        AVLNode.updateHeight(node);
        AVLNode.updateHeight(rightChild);
        AVLNode.updateHeight(parentNode);
    }
    public void rightRotate(AVLNode node){
        AVLNode parentNode = node.getParent();
        AVLNode leftChild = node.getLeftChild();



        node.setLeftChild(leftChild.getRightChild());
        if(leftChild.getRightChild() != null)
            leftChild.getRightChild().setParent(node);


        if(parentNode == null)
            this.setRoot(leftChild);
        else{
            if(parentNode.getLeftChild() != null){
                if(parentNode.getLeftChild().getElement() == node.getElement()){
                    parentNode.setLeftChild(leftChild);
                }
            }
            if(parentNode.getRightChild() != null){
                if(parentNode.getRightChild().getElement() == node.getElement()){
                    parentNode.setRightChild(leftChild);
                }
            }

        }

        leftChild.setParent(parentNode);
        leftChild.setRightChild(node);
        node.setParent(leftChild);

        AVLNode.updateHeight(node);
        AVLNode.updateHeight(leftChild);
        AVLNode.updateHeight(parentNode);

    }





    public void insert(AVLNode root, String element){

        if(root == null){
            this.root = new AVLNode(element);
            AVLNode.updateHeight(root);
            return;

        }
        else if(element.compareTo(root.getElement()) > 0) {

            if (root.getRightChild() == null) {
                AVLNode newNode = new AVLNode(element);
                root.setRightChild(newNode);
                newNode.setParent(root);

            } else {
                insert(root.getRightChild(), element);

            }
            AVLNode.updateHeight(root);

        }

        else if(element.compareTo(root.getElement()) < 0){

            if(root.getLeftChild() == null){
                AVLNode newNode = new AVLNode(element);
                root.setLeftChild(newNode);
                newNode.setParent(root);

            } else{
                insert(root.getLeftChild(), element);

            }
            AVLNode.updateHeight(root);
        }
        else{
            System.out.println("Duplicated values aren't allowed");
        }


        int bf = AVLNode.getBalanceFactor(root);


        if (bf > 1){

            if(AVLNode.getBalanceFactor(root.getLeftChild()) < 0){
                leftRotate(root.getLeftChild());
                rightRotate(root);

            }
            else if(AVLNode.getBalanceFactor(root.getLeftChild()) > 0){
                rightRotate(root);

            }
            bf = AVLNode.getBalanceFactor(root);


        } else if (bf < -1){
            if(AVLNode.getBalanceFactor(root.getRightChild()) > 0){
                rightRotate(root.getRightChild());
                leftRotate(root);

            }
            else if(AVLNode.getBalanceFactor(root.getRightChild()) < 0){
                leftRotate(root);

            }
            bf = AVLNode.getBalanceFactor(root);

        }


    }


    public void delete(AVLNode root, String element) {
        if (root == null){
            System.out.println("CANNOT FIND ELEMENT TO DELTE");
            return;
        }

        if (element.compareTo(root.getElement()) > 0){
            delete(root.getRightChild(), element);
            AVLNode.updateHeight(root);

        } else if (element.compareTo(root.getElement()) < 0){
            delete(root.getLeftChild(), element);
            AVLNode.updateHeight(root);

        } else {
            if (root.getRightChild() == null && root.getLeftChild() == null) {

                if(root.getParent() == null){
                    this.setRoot(null);
                    return;
                }
                if(root.getParent().getRightChild() != null){
                    if(root.getParent().getRightChild().getElement().equals(root.getElement())){
                        root.getParent().setRightChild(null);
                    }
                }
                if(root.getParent().getLeftChild() != null){
                    if(root.getParent().getLeftChild().getElement().equals(root.getElement())){
                        root.getParent().setLeftChild(null);
                    }
                }
                AVLNode.updateHeight(root);
                return;

            }
            else if(root.getLeftChild() != null && root.getRightChild() == null){
                String tempData = this.findMax(root.getLeftChild());
                root.setElement(tempData);
                this.delete(root.getLeftChild(), tempData);
                AVLNode.updateHeight(root);

            }
            else if(root.getLeftChild() == null && root.getRightChild() != null){
                String tempData = findMin(root.getRightChild());
                root.setElement(tempData);
                this.delete(root.getRightChild(), tempData);
                AVLNode.updateHeight(root);
            }
            else {
                String tempElement = this.findMax(root.getLeftChild());
                root.setElement(tempElement);
                delete(root.getLeftChild(), tempElement);
                AVLNode.updateHeight(root);
            }

        }


        int bf = AVLNode.getBalanceFactor(root);



        if (bf > 1){
            if(AVLNode.getBalanceFactor(root.getLeftChild()) < 0){
                leftRotate(root.getLeftChild());
                rightRotate(root);

            }
            else if(AVLNode.getBalanceFactor(root.getLeftChild()) > 0){
                rightRotate(root);

            }
            bf = AVLNode.getBalanceFactor(root);
        }

        if (bf < -1){
            if(AVLNode.getBalanceFactor(root.getRightChild()) > 0){
                rightRotate(root.getRightChild());
                leftRotate(root);

            }
            else if(AVLNode.getBalanceFactor(root.getRightChild()) < 0){
                leftRotate(root);

            }
            bf = AVLNode.getBalanceFactor(root);
        }


    }

    public void getHeight(){
        System.out.println("The height = "+ AVLNode.getHeight(this.getRoot()));
    }
}
