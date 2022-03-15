package RBAnalyser;

import RB.RBTree;

import java.util.Arrays;
import java.util.Collections;

public class Tester {
    private String [] firstBatch;
    private String [] secondBatch;
    private String [] thirdBatch;
    private String [] fourthBatch;
    private String [] fifthBatch;
    private RBTree RBFirstTree = new RBTree();
    private RBTree RBSecondTree = new RBTree();
    private RBTree RBThirdTree = new RBTree();
    private RBTree RBFourthTree = new RBTree();
    private RBTree RBFifthTree = new RBTree();

    public Tester(){
        Randomizer randomizer = new Randomizer();
        this.firstBatch = randomizer.randomBatch(10);
        this.secondBatch = randomizer.randomBatch(100);
        this.thirdBatch = randomizer.randomBatch(1000);
        this.fourthBatch = randomizer.randomBatch(10000);
        this.fifthBatch = randomizer.randomBatch(100000);
    }

    public void insertionRBFirstBatch(){
        for (String element:this.firstBatch) {
            this.RBFirstTree.insertAtRoot(element);
        }
    }

    public void insertionRBSecondBatch(){
        for (String element:this.secondBatch) {
            this.RBSecondTree.insertAtRoot(element);
        }
    }

    public void insertionRBThirdBatch(){
        for (String element:this.thirdBatch) {
            this.RBThirdTree.insertAtRoot(element);
        }
    }

    public void insertionRBFourthBatch(){
        for (String element:this.fourthBatch) {
            this.RBFourthTree.insertAtRoot(element);
        }
    }

    public void insertionRBFifthBatch(){
        for (String element:this.fifthBatch) {
            this.RBFifthTree.insertAtRoot(element);
        }
    }

    public void deletionRBFirstBatch(){
        Collections.shuffle(Arrays.asList(this.firstBatch));
        for (String element:this.firstBatch) {
            this.RBFirstTree.deleteFromRoot(element);
        }
    }

    public void deletionRBSecondBatch(){
        Collections.shuffle(Arrays.asList(this.secondBatch));
        for (String element:this.secondBatch) {
            this.RBSecondTree.deleteFromRoot(element);
        }
    }
    public void deletionRBThirdBatch(){
        Collections.shuffle(Arrays.asList(this.thirdBatch));
        for (String element:this.thirdBatch) {
            this.RBThirdTree.deleteFromRoot(element);
        }
    }
    public void deletionRBFourthBatch(){
        Collections.shuffle(Arrays.asList(this.fourthBatch));
        for (String element:this.fourthBatch) {
            this.RBFourthTree.deleteFromRoot(element);
        }
    }

    public void deletionRBFifthBatch(){
        Collections.shuffle(Arrays.asList(this.fifthBatch));
        for (String element:this.fifthBatch) {
            this.RBFifthTree.deleteFromRoot(element);
        }
    }
}
