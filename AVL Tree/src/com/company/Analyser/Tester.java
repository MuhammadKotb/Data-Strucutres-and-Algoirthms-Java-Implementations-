package com.company.Analyser;

import com.company.AVLTree;

import java.util.Arrays;
import java.util.Collections;

public class Tester {
    private  String [] firstBatch;
    private  String [] secondBatch;
    private  String [] thirdBatch;
    private  String [] fourthBatch;
    private  String [] fifthBatch;
    private  AVLTree AVLFirstTree = new AVLTree();
    private  AVLTree AVLSecondTree = new AVLTree();
    private  AVLTree AVLThirdTree = new AVLTree();
    private  AVLTree AVLFourthTree = new AVLTree();
    private  AVLTree AVLFifthTree = new AVLTree();

    public Tester(){
        Randomizer randomizer = new Randomizer();
        this.firstBatch = randomizer.randomBatch(10);
        this.secondBatch = randomizer.randomBatch(100);
        this.thirdBatch = randomizer.randomBatch(1000);
        this.fourthBatch = randomizer.randomBatch(10000);
        this.fifthBatch = randomizer.randomBatch(100000);
    }

    public void insertionAVLFirstBatch(){
        for (String element:this.firstBatch) {
            this.AVLFirstTree.insert(this.AVLFirstTree.getRoot(), element);
        }
    }

    public void insertionAVLSecondBatch(){
        for (String element:this.secondBatch) {
            this.AVLSecondTree.insert(this.AVLSecondTree.getRoot(), element);
        }
    }

    public void insertionAVLThirdBatch(){
        for (String element:this.thirdBatch) {
            this.AVLThirdTree.insert(this.AVLThirdTree.getRoot(), element);
        }
    }

    public void insertionAVLFourthBatch(){
        for (String element:this.fourthBatch) {
            this.AVLFourthTree.insert(this.AVLFourthTree.getRoot(), element);
        }
    }

    public void insertionAVLFifthBatch(){
        for (String element:this.fifthBatch) {
            this.AVLFifthTree.insert(this.AVLFifthTree.getRoot(), element);
        }
    }

    public void deletionAVLFirstBatch(){
        Collections.shuffle(Arrays.asList(this.firstBatch));
        for (String element:this.firstBatch) {
            this.AVLFirstTree.delete(this.AVLFirstTree.getRoot(), element);
        }
    }

    public void deletionAVLSecondBatch(){
        Collections.shuffle(Arrays.asList(this.secondBatch));
        for (String element:this.secondBatch) {
            this.AVLSecondTree.delete(this.AVLSecondTree.getRoot(), element);
        }
    }
    public void deletionAVLThirdBatch(){
        Collections.shuffle(Arrays.asList(this.thirdBatch));
        for (String element:this.thirdBatch) {
            this.AVLThirdTree.delete(this.AVLThirdTree.getRoot(), element);
        }
    }
    public void deletionAVLFourthBatch(){
        Collections.shuffle(Arrays.asList(this.fourthBatch));
        for (String element:this.fourthBatch) {
            this.AVLFourthTree.delete(this.AVLFourthTree.getRoot(), element);
        }
    }

    public void deletionAVLFifthBatch(){
        Collections.shuffle(Arrays.asList(this.fifthBatch));
        for (String element:this.fifthBatch) {
            this.AVLFifthTree.delete(this.AVLFifthTree.getRoot(), element);
        }
    }
}
