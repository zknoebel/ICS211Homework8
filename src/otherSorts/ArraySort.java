package otherSorts;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Comparator;

/**
 * ArraySort Copyright (C) Zachery Knoebel 2016
 * 
 * ArraySort: This class provides the user with the ability to sort arrays using
 * bubble sort, insertion sort and selection sort. It also gives the user the
 * ability to print out the sorted array, number of comparisons made, number of
 * swaps made and the time it took to run the sort method.
 */
public class ArraySort<E> {

	private boolean finished = false;
	private E e;
	private int placeHolder = 0;
	private long compareCount, swapCount;
	private long sortTime, startTime;

	public ArraySort() {
	}

	/*
	 * sorts an array of numbers by "sinking" the large numbers to the "bottom"
	 * or end of the list and "bubbling" the small numbers to the "top" or front
	 * of the list
	 * 
	 * @param data: the unsorted array
	 * 
	 * @param compare: a comparator made for the specific type to be sorted
	 */
	public void bubbleSort(E[] data, Comparator<? super E> compare) {

		sortTime = 0;
		startTime = System.nanoTime();
		compareCount = 0;
		swapCount = 0;

		for (int i = 0; i < data.length - 1; i++) {

			finished = true;

			for (int j = 0; j < data.length - 1 - i; j++) {

				compareCount++;

				if (compare.compare(data[j], data[j + 1]) > 0) {

					finished = false;
					swapCount++;
					e = data[j];
					data[j] = data[j + 1];
					data[j + 1] = e;
				}
			}

			if (finished == true) {
				break;
			}
		}

		sortTime = System.nanoTime() - startTime;
		// printResults(data, "Bubble Sort");

	}

	/*
	 * returns the number of comparisons that were made by the sort method that
	 * ran last
	 */
	public long getCompareCount() {
		return compareCount;
	}

	/*
	 * returns the amount time it took for the most recently run sort method to
	 * run.
	 */
	public long getSortTime() {
		return sortTime;
	}

	/*
	 * returns the amount of swaps that were made by the sort method that ran
	 * last
	 */
	public long getSwapCount() {
		return swapCount;
	}

	/*
	 * sorts an array by looking at a number in an unsorted array and then
	 * moving it to it's numerically sorted spot then it moves to the next
	 * number in the array and does the same over and over again until it gets
	 * to the end of the list
	 * 
	 * @param data: the unsorted array
	 * 
	 * @param compare: a comparator made for the specific type to be sorted
	 */
	public void insertionSort(E[] data, Comparator<? super E> compare) {

		sortTime = 0;
		startTime = System.nanoTime();
		compareCount = 0;
		swapCount = 0;

		for (int i = 0; i < data.length - 1; i++) {

			placeHolder = i;

			while (compare.compare(data[placeHolder], data[placeHolder + 1]) > 0) {

				compareCount++;
				swapCount++;

				e = data[placeHolder];
				data[placeHolder] = data[placeHolder + 1];
				data[placeHolder + 1] = e;

				if (placeHolder > 0) {
					placeHolder--;
				}
			}
			compareCount++;
		}

		sortTime = System.nanoTime() - startTime;
		// printResults(data, "Insertion Sort");
	}

	/*
	 * prints out the name of the sort used, the sorted array, time and number
	 * of comparisons and swaps made for the used sort method
	 */
	public void printResults(E[] arrayToBePrinted, String title, BufferedWriter bw) throws IOException {

		bw.write(title + "\n");
		bw.write("The sorted array is \n");
		// System.out.println(title);
		// System.out.print("The sorted array is ");

		for (int i = 0; i < arrayToBePrinted.length; i++) {

			bw.write(arrayToBePrinted[i] + "  ");
			// System.out.print(arrayToBePrinted[i] + " ");
		}

		bw.newLine();
		bw.write("This method made " + compareCount + " comparisons. \n");
		bw.write("This method made " + swapCount + " swaps. \n");
		bw.write("This method took " + sortTime + " nano seconds to complete. \n");
		bw.newLine();

		// System.out.println("");
		// System.out.println("This method made " + compareCount + "
		// comparisons.");
		// System.out.println("This method made " + swapCount + " swaps.");
		// System.out.println("This method took " + sortTime + " nano seconds to
		// complete.");
		// System.out.println("");
	}

	/*
	 * sorts an array of numbers by finding the smallest number in the array and
	 * moving it to the front then it finds the next smallest number in the
	 * array and moves it to the next spot this continues until the list is
	 * sorted
	 * 
	 * @param data: the unsorted array
	 * 
	 * @param compare: a comparator made for the specific type to be sorted
	 */
	public void selectionSort(E[] data, Comparator<? super E> compare) {

		startTime = System.nanoTime();
		compareCount = 0;
		swapCount = 0;
		placeHolder = 0;

		for (int i = 0; i < data.length - 1; i++) {

			e = data[i];
			placeHolder = i;

			for (int j = i; j < data.length; j++) {

				compareCount++;

				if (compare.compare(e, data[j]) > 0) {

					e = data[j];
					swapCount++;
					placeHolder = j;
				}
			}

			data[placeHolder] = data[i];
			data[i] = e;
		}

		sortTime = System.nanoTime() - startTime;
	}
}
