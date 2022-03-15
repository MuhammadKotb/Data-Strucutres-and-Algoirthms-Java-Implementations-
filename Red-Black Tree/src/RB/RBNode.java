package RB;

public class RBNode {

    RBNode right = null;
    RBNode left = null;
    RBNode parent = null;
    boolean red;
    boolean doubleyBlack;
    String data;

    public RBNode(String data) {
        this.data = data;
        this.red = true;
        this.doubleyBlack = false;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    public void setData(String data) {
        this.data = data;
    }


    public RBNode getUncle() {

        RBNode uncle = null;

        if (this.getParent().getParent().getLeft() != null) {
            if (this.getParent().getParent().getLeft().getData() == this.getParent().getData()) {
                uncle = this.getParent().getParent().getRight();
            }
        }
        if (this.getParent().getParent().getRight() != null) {
            if (this.getParent().getParent().getRight().getData() == this.getParent().getData()) {
                uncle = this.getParent().getParent().getLeft();
            }
        }

        return uncle;


    }

    public RBNode getSibling() {

        RBNode sibling = null;

        if (this.getParent().getLeft() != null) {
            if (this.getParent().getLeft().getData() == this.getData()) {
                sibling = this.getParent().getRight();
            }
        }
        if (this.getParent().getRight() != null) {
            if (this.getParent().getRight().getData() == this.getData()) {
                sibling = this.getParent().getLeft();
            }
        }

        return sibling;


    }


    public RBNode getRight() {
        return this.right;
    }

    public RBNode getLeft() {
        return this.left;
    }

    public RBNode getParent() {
        return this.parent;
    }

    public String getData() {
        return this.data;
    }

    public boolean isRed() {
        if (this == null)
            return false;
        return this.red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public boolean isDoubleyBlack() {
        return this.doubleyBlack;
    }

    public void setDoubleyBlack(Boolean doubleyBlack) {
        this.doubleyBlack = doubleyBlack;
    }


}
