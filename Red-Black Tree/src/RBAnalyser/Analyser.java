package RBAnalyser;


public class Analyser {


    public static void main(String arg[]) {
        Tester tester = new Tester();
        long start;


        System.out.println("Time For Red-Black Insertion First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionRBFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For Red-Black Insertion Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionRBSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Red-Black Insertion Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionRBThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Red-Black Insertion Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionRBFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Red-Black Insertion Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.insertionRBFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Red-Black Deletion First Batch With 10 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionRBFirstBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");


        System.out.println("Time For Red-Black Deletion Second Batch With 100 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionRBSecondBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Red-Black Deletion Third Batch With 1000 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionRBThirdBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Red-Black Deletion Fourth Batch With 10000 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionRBFourthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");

        System.out.println("Time For Red-Black Deletion Fifth Batch With 100000 Nodes: ");
        start = System.currentTimeMillis();
        tester.deletionRBFifthBatch();
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
