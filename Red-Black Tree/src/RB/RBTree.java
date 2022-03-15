package RB;

public class RBTree {



    RBNode root = null;

    public void setRoot(RBNode root){
        this.root = root;
    }
    public RBNode getRoot(){
        return this.root;
    }

    public RBTree(){}

    private String findMax(RBNode root){
        if(root.getRight() == null)
            return root.getData();
        return findMax(root.getRight());
    }
    private String findMin(RBNode root){
        if(root.getLeft() == null)
            return root.getData();
        return findMax(root.getLeft());
    }

    public RBNode search(RBNode dummyRoot, String element){
        if(dummyRoot == null){
            return null;
        }
        else if(element.compareTo(dummyRoot.getData()) > 0){

            if(dummyRoot.getRight() == null){
                return null;
            }
            else{
                return this.search(dummyRoot.getRight(),element);
            }

        }else if(element.compareTo(dummyRoot.getData()) < 0){

            if(dummyRoot.getLeft() == null){
                return null;
            }
            else{
                return this.search(dummyRoot.getLeft(),element);
            }

        }else{
            return dummyRoot;
        }
    }



    private void leftRotate(RBNode node){
        RBNode parent = node.getParent();
        RBNode right = node.getRight();

        node.setRight(right.getLeft());
        if(right.getLeft() != null)
            right.getLeft().setParent(node);

        if(parent == null){
            this.setRoot(right);

        }
        else{
            if(parent.getLeft() != null){
                if(parent.getLeft().getData().equals(node.getData())){
                    parent.setLeft(right);
                }
            }
            if(parent.getRight() != null){
                if(parent.getRight().getData().equals(node.getData())){
                    parent.setRight(right);
                }
            }
        }
        right.setParent(parent);
        right.setLeft(node);
        node.setParent(right);
    }

    private void rightRotate(RBNode node){
        RBNode parent = node.getParent();
        RBNode left = node.getLeft();

        node.setLeft(left.getRight());
        if(left.getRight() != null)
            left.getRight().setParent(node);

        if(parent == null){
            this.setRoot(left);
        }
        else{
            if(parent.getLeft() != null){
                if(parent.getLeft().getData().equals(node.getData())){
                    parent.setLeft(left);
                }
            }
            if(parent.getRight() != null){
                if(parent.getRight().getData().equals(node.getData())){
                    parent.setRight(left);
                }
            }
        }
        left.setParent(parent);
        left.setRight(node);
        node.setParent(left);
    }

    public void insertAtRoot(String data){
        this.insert(this.root, data);
    }
    public void deleteFromRoot(String data){
        this.delete(this.root, data);
    }


    public void rotateRecolor(RBNode root){

        RBNode parent = root.getParent();
        RBNode grandParent = root.getParent().getParent();


        // LL
        if(grandParent.getLeft() != null && parent.getLeft() != null){
            if((grandParent.getLeft().getData().equals(parent.getData())) && (parent.getLeft().getData().equals(root.getData()))){
                rightRotate(grandParent);
                root.getParent().setRed(false);
                root.getParent().getRight().setRed(true);
                return;
            }
        }

        // LR

        if(grandParent.getLeft() != null && parent.getRight() != null){
            if((grandParent.getLeft().getData().equals(parent.getData())) && (parent.getRight().getData().equals(root.getData()))){
                leftRotate(parent);
                rightRotate(grandParent);
                root.setRed(false);
                root.getRight().setRed(true);
                return;
            }
        }


        // RR

        if(grandParent.getRight() != null && parent.getRight() != null){
            if((grandParent.getRight().getData().equals(parent.getData())) && (parent.getRight().getData().equals(root.getData()))){
                leftRotate(grandParent);
                root.getParent().setRed(false);
                root.getParent().getLeft().setRed(true);
                return;
            }
        }

        // RL
        if(grandParent.getRight() != null && parent.getLeft() != null){
            if((grandParent.getRight().getData().equals(parent.getData())) && (parent.getLeft().getData().equals(root.getData()))){
                rightRotate(parent);
                leftRotate(grandParent);
                root.setRed(false);
                root.getLeft().setRed(true);
                return;
            }
        }



    }

    public void recolor(RBNode root){

        RBNode uncle = root.getUncle();
        RBNode parent = root.getParent();
        RBNode grandParent = root.getParent().getParent();


        uncle.setRed(false);
        parent.setRed(false);
        grandParent.setRed(true);
    }



    public void insert(RBNode root, String data){

        if(this.root == null){
            this.setRoot(new RBNode(data));
            this.getRoot().setRed(false);
        }
        else{

            if((root.getLeft() == null) && (data.compareTo(root.getData()) < 0)){
                RBNode newNode = new RBNode(data);
                newNode.setParent(root);
                root.setLeft(newNode);
                if(root.getData().equals(this.getRoot().getData()))
                    return;
                if(!root.isRed())
                    return;

                if(root.getParent().getLeft() != null){
                    if(root.getParent().getLeft().getData().equals(root.getData())){
                        if(root.getParent().getRight() == null)
                            this.rotateRecolor(newNode);
                        else{
                            if(root.isRed() && !root.getParent().getRight().isRed())
                                this.rotateRecolor(newNode);

                            if(root.isRed() && root.getParent().getRight().isRed())
                                this.recolor(newNode);
                        }
                        return;

                    }
                }
                if(root.getParent().getRight() != null){
                    if(root.getParent().getRight().getData().equals(root.getData())){
                        if(root.getParent().getLeft() == null)
                            this.rotateRecolor(newNode);
                        else{
                            if(root.isRed() && !root.getParent().getLeft().isRed())
                                this.rotateRecolor(newNode);

                            if(root.isRed() && root.getParent().getLeft().isRed())
                                this.recolor(newNode);
                        }
                        return;

                    }

                }

            }
            if((root.getRight() == null) && (data.compareTo(root.getData()) > 0)){

                RBNode newNode = new RBNode(data);
                newNode.setParent(root);
                root.setRight(newNode);
                if(root.getData().equals(this.getRoot().getData())){
                    return;
                }
                if(!root.isRed())
                    return;

                if(root.getParent().getLeft() != null){
                    if(root.getParent().getLeft().getData().equals(root.getData())){
                        if(root.getParent().getRight() == null){
                            this.rotateRecolor(newNode);
                        }
                        else{
                            if(root.isRed() && !root.getParent().getRight().isRed())
                                this.rotateRecolor(newNode);

                            if(root.isRed() && root.getParent().getRight().isRed())
                                this.recolor(newNode);
                        }
                        return;
                    }

                }
                if(root.getParent().getRight() != null){

                    if(root.getParent().getRight().getData().equals(root.getData())){

                        if(root.getParent().getLeft() == null)
                            this.rotateRecolor(newNode);
                        else{

                            if(root.isRed() && !root.getParent().getLeft().isRed())
                                this.rotateRecolor(newNode);

                            if(root.isRed() && root.getParent().getLeft().isRed())
                                this.recolor(newNode);
                        }
                        return;
                    }
                }
            }

            if(data.compareTo(root.getData()) < 0 && root.getLeft() != null){
                insert(root.getLeft(), data);
            }
            if(data.compareTo(root.getData()) > 0 && root.getRight() != null){
                insert(root.getRight(), data);
            }

            if(root.getParent() == null){

                root.setRed(false);
                return;
            }

            if(root.getParent().getParent() != null){
                RBNode uncle = root.getUncle();


                if(root.isRed() && root.getParent().isRed()){

                    if(uncle == null)
                        this.rotateRecolor(root);
                    else{
                        if(!uncle.isRed()){
                            this.rotateRecolor(root);
                        }
                        else{
                            this.recolor(root);
                        }
                    }
                }
            }
        }

    }
    public void DBFixUp(RBNode root){

        RBNode sibling = root.getSibling();

        boolean left = false;


        if(root.getParent().getRight() != null){
            if(root.getParent().getRight().getData().equals(root.getData())){
                left = false;
            }
        }

        if(root.getParent().getLeft() != null){
            if(root.getParent().getLeft().getData().equals(root.getData())){
                left = true;
            }
        }

        if(!sibling.isRed()){
            if(sibling.getLeft() == null && sibling.getRight() == null){
                root.setDoubleyBlack(false);
                sibling.setRed(true);

                if(root.getParent().isRed())
                    root.getParent().setRed(false);
                else
                    root.getParent().setDoubleyBlack(true);


            }


            else {
                if(left){

                    // far is black
                    if(sibling.getRight() != null && !sibling.getRight().isRed()){
                        if(sibling.getLeft().isRed()){
                            sibling.getLeft().setRed(false);
                            sibling.setRed(true);
                            rightRotate(sibling);
                            DBFixUp(root);
                        }
                        else{

                            root.setDoubleyBlack(false);
                            sibling.setRed(true);

                            if(root.getParent().isRed())
                                root.getParent().setRed(false);
                            else
                                root.getParent().setDoubleyBlack(true);

                        }

                    }
                    else if(sibling.getRight() == null) {
                        if(sibling.getLeft().isRed()){
                            sibling.getLeft().setRed(false);
                            sibling.setRed(true);
                            rightRotate(sibling);
                            DBFixUp(root);
                        }
                        else{
                            root.setDoubleyBlack(false);
                            sibling.setRed(true);

                            if(root.getParent().isRed())
                                root.getParent().setRed(false);
                            else
                                root.getParent().setDoubleyBlack(true);

                        }
                    }
                    // far is red
                    else if(sibling.getRight().isRed()){
                        boolean siblingRed = sibling.isRed();
                        sibling.setRed(sibling.getParent().isRed());
                        sibling.getParent().setRed(siblingRed);
                        leftRotate(sibling.getParent());
                        root.setDoubleyBlack(false);
                        sibling.getRight().setRed(false);
                    }
                }
                else{


                    // far is black
                    if(sibling.getLeft() != null && !sibling.getLeft().isRed()){
                        if(sibling.getRight().isRed()){
                            sibling.getRight().setRed(false);
                            sibling.setRed(true);
                            leftRotate(sibling);
                            DBFixUp(root);
                        }
                        else{
                            root.setDoubleyBlack(false);
                            sibling.setRed(true);

                            if(root.getParent().isRed())
                                root.getParent().setRed(false);
                            else
                                root.getParent().setDoubleyBlack(true);



                        }

                    }
                    else if(sibling.getLeft() == null){
                        if(sibling.getRight().isRed()){
                            sibling.getRight().setRed(false);
                            sibling.setRed(true);
                            leftRotate(sibling);
                            DBFixUp(root);
                        }
                        else{
                            root.setDoubleyBlack(false);
                            sibling.setRed(true);

                            if(root.getParent().isRed())
                                root.getParent().setRed(false);
                            else
                                root.getParent().setDoubleyBlack(true);




                        }
                    }
                    // far is red
                    else if(sibling.getLeft().isRed()){
                        boolean siblingRed = sibling.isRed();
                        sibling.setRed(sibling.getParent().isRed());
                        sibling.getParent().setRed(siblingRed);
                        rightRotate(sibling.getParent());
                        root.setDoubleyBlack(false);
                        sibling.getLeft().setRed(false);
                    }

                }


            }

        }
        else{
            boolean siblingRed = sibling.isRed();
            sibling.setRed(sibling.getParent().isRed());
            sibling.getParent().setRed(siblingRed);
            if(root.getParent().getLeft() != null){
                if(root.getParent().getLeft().getData().equals(root.getData())){
                    this.leftRotate(root.getParent());
                }
            }
            if(root.getParent().getRight() != null){
                if(root.getParent().getRight().getData().equals(root.getData())){
                    this.rightRotate(root.getParent());
                }
            }
            this.DBFixUp(root);

        }

    }

    public void delete(RBNode root, String data){
        if (root == null){
            System.out.println("CANNOT FIND ELEMENT TO DELTE");
            return;
        }

        if (data.compareTo(root.data) > 0)
            delete(root.getRight(), data);
        else if (data.compareTo(root.data) < 0)
            delete(root.getLeft(), data);
        else {
            if (root.getRight() == null && root.getLeft() == null) {


                if(root.getParent() == null){
                    this.setRoot(null);
                    return;

                }

                if(!root.isRed()){
                    root.setDoubleyBlack(true);
                    this.DBFixUp(root);
                }
                if(root.getParent().getRight() != null){
                    if(root.getParent().getRight().getData().equals(root.getData())){
                        root.getParent().setRight(null);
                    }
                }

                if(root.getParent().getLeft() != null){
                    if(root.getParent().getLeft().getData().equals(root.getData())){
                        root.getParent().setLeft(null);
                    }
                }
                return;



            }
            else if(root.getLeft() != null && root.getRight() == null){
                String tempData = this.findMax(root.getLeft());
                root.setData(tempData);
                this.delete(root.getLeft(), tempData);


            }
            else if(root.getLeft() == null && root.getRight() != null){
                String tempData = findMin(root.getRight());
                root.setData(tempData);
                this.delete(root.getRight(), tempData);
            }
            else {
                String tempData = this.findMax(root.getLeft());
                root.setData(tempData);
                delete(root.getLeft(), tempData);
            }

        }

        if(root.getParent() == null){
            root.setDoubleyBlack(false);
            return;
        }

        if(root.isDoubleyBlack()){
            this.DBFixUp(root);
        }







    }
    public boolean contains(String target){
        return this.search(this.getRoot(), target) != null;
    }
    public boolean isEmpty(){
        return this.getRoot() == null;
    }

    public void clear(){
        this.setRoot(null);
    }

    // inorder print of tree
    public void printTree(RBNode root){
        if(root == null)
            return;

        printTree(root.getLeft());
        if(root.getParent() == null)
            System.out.print(" *" + root.getData() + " " +  root.isRed() + "* ");
        else
            System.out.print(root.getData() + " " +  root.isRed() + " ");

        printTree(root.getRight());

    }


}



