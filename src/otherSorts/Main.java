package otherSorts;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import binarySearchStuff.*;

/*
 * @author Zachery Knoebel
 * 
 * Class Main is used to test the ArraySort class and to test the run times of the three sorting algorithm methods 
 * within the ArraySort class.
 */
public class Main {

	/*
	 * Method main runs four different run time test methods. Three big O tests and one average time test
	 */
	public static void main(String[] args) throws java.io.IOException{
		bw = new BufferedWriter(new FileWriter("sortTests.txt"));

		Main tester = new Main();

		tester.bigOBubTest();
		tester.bigOInsTest();
		tester.bigOSelTest();
		tester.BinarySearchTest();
		//    avgTest takes a couple minutes depending on how fast your computer is
		tester.avgTest();

		bw.close();
	}

	static BufferedWriter bw;
	ArraySort<Integer> test = new ArraySort<Integer>();
	static CompareNumbers comp = new CompareNumbers();
	int arrayLength = 5000;
	int numberOfTests = 1000;
	Random randomGeneration = new Random();
	BinarySearchTree<Integer> bst;
	long binaryTestStart;
	long binaryTestFinish;

	/*
	 * these variables are used to store the values of the number of comparisons, swaps and run times of the bubbleSort,
	 * insertionSort and selectionSort methods
	 */
	long avgBubComps = 0, avgBubSwaps = 0, avgBubTime = 0;
	long avgInsComps = 0, avgInsSwaps = 0, avgInsTime = 0;
	long avgSelComps = 0, avgSelSwaps = 0, avgSelTime = 0;
	long avgBinaryTime = 0;

	Integer[] testArray;


	/*
	 * builds an array of length arrLength that is filled with random numbers between -999 and 999
	 */
	private void arrayBuild(int arrLength) {
		testArray = new Integer[arrLength];
		for (int j = 0; j < arrLength; j++) {
			testArray[j] = randomGeneration.nextInt(1000) * (int) Math.pow(-1, j);
		}

	}


	/*
	 * runs the bubbleSort, insertionSort and selectionSort methods of class ArraySort numberOfTests times and then takes
	 * the averages of the number of swaps, number of comparisons and run times for each method
	 */
	private void avgTest() throws IOException {

		for (int i = 0; i < numberOfTests; i++) {
			arrayBuild(arrayLength);
			test.bubbleSort(testArray, comp);
			avgBubComps += test.getCompareCount();
			avgBubSwaps += test.getSwapCount();
			avgBubTime += test.getSortTime();
		}
		for (int i = 0; i < numberOfTests; i++) {
			arrayBuild(arrayLength);
			test.insertionSort(testArray, comp);
			avgInsComps += test.getCompareCount();
			avgInsSwaps += test.getSwapCount();
			avgInsTime += test.getSortTime();
		}
		for (int i = 0; i < numberOfTests; i++) {
			arrayBuild(arrayLength);
			test.selectionSort(testArray, comp);
			avgSelComps += test.getCompareCount();
			avgSelSwaps += test.getSwapCount();
			avgSelTime += test.getSortTime();
		}

		avgBinaryTime = System.nanoTime();
		for (int i = 0; i < numberOfTests; i++){
			arrayBuild(arrayLength);
			bst = new BinarySearchTree<Integer>(comp);
			for(int j = 0; j < arrayLength; j ++){
				bst.add(testArray[j]);
			}
		}
		avgBinaryTime = (System.nanoTime() - avgBinaryTime)/numberOfTests;


		//    System.out.println("Bubble Sort");
		//    System.out.println("Average number of comparisons: " + avgBubComps / numberOfTests);
		//    System.out.println("Average number of swaps: " + avgBubSwaps / numberOfTests);
		//    System.out.println("Average sort time: " + avgBubTime / numberOfTests + " nano Seconds");
		//    System.out.println("");
		//    System.out.println("Insertion Sort");
		//    System.out.println("Average number of comparisons: " + avgInsComps / numberOfTests);
		//    System.out.println("Average number of swaps: " + avgInsSwaps / numberOfTests);
		//    System.out.println("Average sort time: " + avgInsTime / numberOfTests + " nano Seconds");
		//    System.out.println("");
		//    System.out.println("Selection Sort");
		//    System.out.println("Average number of comparisons: " + avgSelComps / numberOfTests);
		//    System.out.println("Average number of swaps: " + avgSelSwaps / numberOfTests);
		//    System.out.println("Average sort time: " + avgSelTime / numberOfTests + " nano Seconds");
		//    System.out.println("");


		bw.write("Bubble Sort \n");
		bw.write("Average number of comparisons: " + avgBubComps / numberOfTests + "\n");
		bw.write("Average number of swaps: " + avgBubSwaps / numberOfTests + "\n");
		bw.write("Average sort time: " + avgBubTime / numberOfTests + " nano Seconds \n");
		bw.newLine();
		bw.write("Insertion Sort \n");
		bw.write("Average number of comparisons: " + avgInsComps / numberOfTests + "\n");
		bw.write("Average number of swaps: " + avgInsSwaps / numberOfTests + "\n");
		bw.write("Average sort time: " + avgInsTime / numberOfTests + " nano Seconds \n");
		bw.newLine();
		bw.write("Selection Sort \n");
		bw.write("Average number of comparisons: " + avgSelComps / numberOfTests + "\n");
		bw.write("Average number of swaps: " + avgSelSwaps / numberOfTests + "\n");
		bw.write("Average sort time: " + avgSelTime / numberOfTests + " nano Seconds \n");
		bw.newLine();
		bw.write("Binary Search Tree Sort \n");
		bw.write("Average sort time: " + avgBinaryTime + " nano Seconds \n");
	}


	/*
	 * runs the bubbleSort method for arrays with random numbers between -999 and 999. Starts with an array of 10, next an
	 * array of 100, then an array of 1000 and finally an array of 5000. This is used to show how the run time of the
	 * bubble sort grows exponentially
	 */
	private void bigOBubTest() throws IOException {
		arrayBuild(10);
		test.bubbleSort(testArray, comp);
		test.printResults(testArray, "Bubble Sort", bw);
		arrayBuild(100);
		test.bubbleSort(testArray, comp);
		test.printResults(testArray, "Bubble Sort", bw);
		arrayBuild(1000);
		test.bubbleSort(testArray, comp);
		test.printResults(testArray, "Bubble Sort", bw);
		arrayBuild(5000);
		test.bubbleSort(testArray, comp);
		test.printResults(testArray, "Bubble Sort", bw);
	}

	private void BinarySearchTest() throws IOException {
		arrayBuild(10);
		bst = new BinarySearchTree<Integer>(comp);
		binaryTestStart = System.nanoTime();
		for(int i = 0; i < testArray.length; i ++){
			bst.add(testArray[i]);
		}
		binaryTestFinish = System.nanoTime();
		bw.newLine();
		bw.write("Binary search tree sorting " + testArray.length + " items.");
		bw.write("This method took " + ((binaryTestFinish - binaryTestStart)) + " nano seconds to complete \n");

		arrayBuild(100);
		bst = new BinarySearchTree<Integer>(comp);
		binaryTestStart = System.nanoTime();
		for(int i = 0; i < testArray.length; i ++){
			bst.add(testArray[i]);
		}
		binaryTestFinish = System.nanoTime();
		bw.newLine();
		bw.write("Binary search tree sorting " + testArray.length + " items.");
		bw.write("This method took " + ((binaryTestFinish - binaryTestStart)) + " nano seconds to complete \n");

		arrayBuild(1000);
		bst = new BinarySearchTree<Integer>(comp);
		binaryTestStart = System.nanoTime();
		for(int i = 0; i < testArray.length; i ++){
			bst.add(testArray[i]);
		}
		binaryTestFinish = System.nanoTime();
		bw.newLine();
		bw.write("Binary search tree sorting " + testArray.length + " items.");
		bw.write("This method took " + ((binaryTestFinish - binaryTestStart)) + " nano seconds to complete \n");

		arrayBuild(5000);
		bst = new BinarySearchTree<Integer>(comp);
		binaryTestStart = System.nanoTime();
		for(int i = 0; i < testArray.length; i ++){
			bst.add(testArray[i]);
		}
		binaryTestFinish = System.nanoTime();
		bw.newLine();
		bw.write("Binary search tree sorting " + testArray.length + " items.");
		bw.write("This method took " + ((binaryTestFinish - binaryTestStart)) + " nano seconds to complete \n");
		bw.newLine();
	}


	/*
	 * runs the insertionSort method for arrays with random numbers between -999 and 999. Starts with an array of 10, next
	 * an array of 100, then an array of 1000 and finally an array of 5000. This is used to show how the run time of the
	 * insertion sort grows exponentially
	 */
	private void bigOInsTest() throws IOException {
		arrayBuild(10);
		test.insertionSort(testArray, comp);
		test.printResults(testArray, "Insertion Sort", bw);
		arrayBuild(100);
		test.insertionSort(testArray, comp);
		test.printResults(testArray, "Insertion Sort", bw);
		arrayBuild(1000);
		test.insertionSort(testArray, comp);
		test.printResults(testArray, "Insertion Sort", bw);
		arrayBuild(5000);
		test.insertionSort(testArray, comp);
		test.printResults(testArray, "Insertion Sort", bw);
	}


	/*
	 * runs the selectionSort method for arrays with random numbers between -999 and 999. Starts with an array of 10, next
	 * an array of 100, then an array of 1000 and finally an array of 5000. This is used to show how the run time of the
	 * selection sort grows exponentially
	 */
	private void bigOSelTest() throws IOException {
		arrayBuild(10);
		test.selectionSort(testArray, comp);
		test.printResults(testArray, "Selection Sort", bw);
		arrayBuild(100);
		test.selectionSort(testArray, comp);
		test.printResults(testArray, "Selection Sort", bw);
		arrayBuild(1000);
		test.selectionSort(testArray, comp);
		test.printResults(testArray, "Selection Sort", bw);
		arrayBuild(5000);
		test.selectionSort(testArray, comp);
		test.printResults(testArray, "Selection Sort", bw);
	}


	/*
	 * used to create on object of Main so the methods other than main can be used
	 */
	Main() {

	}
}
