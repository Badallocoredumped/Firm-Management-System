package utilities;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * The {@code SortingAlgorithms} class provides functionality to generate random arrays,
 * apply multiple sorting algorithms, measure their execution times, and verify their correctness.
 * Algorithms implemented include Radix Sort, Shell Sort, Heap Sort, and Insertion Sort.
 * The class also provides functionality to compare results against Java's Collections.sort.
 */
public class SortingAlgorithms 
{
    /**
     * Prompts the user to input the size of the array (between 1000 and 10000) and ensures valid input.
     * Once validated, runs the sorting algorithms on a randomly generated array of the specified size.
     *
     * @param sizeOfArray a {@link Scanner} instance for user input.
     */
    public void getInputAndRunAlgorithms(Scanner sizeOfArray) 
    {
        SortingAlgorithms mainArr = new SortingAlgorithms();
        AsciiArt color = new AsciiArt();
        int sequence = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.println(color.WHITE + "Enter the array size (between 1000-10000):");
            
            // Numerical input control
            if (sizeOfArray.hasNextInt()) {
                sequence = sizeOfArray.nextInt();
                
                // Range control
                if (sequence >= 1000 && sequence <= 10000) {
                    validInput = true;
                } else {
                    Ccleaner();
                    System.out.println(color.WHITE + "Please enter a number between 1000 and 10000!!");
                }
            } else {
                Ccleaner();
                System.out.println(color.BRIGHT_RED + "Error: Please enter a valid number!!");
                sizeOfArray.next(); // Clears invalid input
            }
        }
        
        mainArr.runAlgorithmComparison(sequence);
    }
    
    /**
     * Runs multiple sorting algorithms on a randomly generated array of the specified size.
     * Measures and prints the execution time of each sorting algorithm in milliseconds.
     * Verifies the correctness of sorting by comparing results with Java's Collections.sort.
     *
     * @param sizeOfArray the size of the array to be sorted, must be between 1000 and 10000.
     */
    public void runAlgorithmComparison(int sizeOfArray) 
    { // sizeOfArray = array size
        // Random number generator
        AsciiArt color = new AsciiArt();
        Random randNumCretor = new Random();
        
        // Create a main array
        int[] mainArr = new int[sizeOfArray];
        for(int count = 0; count < sizeOfArray; count++) {
            mainArr[count] = randNumCretor.nextInt(20001) - 10000; // -10000 to 10000
        }
        
        // Duplicate arrays for each algorithm
        int[] copyRadix = mainArr.clone();
        int[] copyShell = mainArr.clone(); 
        int[] copyHeap = mainArr.clone();
        int[] copyInsert = mainArr.clone();
        
        // ArrayList for Java Collections.sort
        ArrayList<Integer> array = new ArrayList<>();
        for(int i : mainArr) {
            array.add(i);
        }
        
        // time measurements
        long startTime, finishTime;
        
        // Radix Sort
        startTime = System.nanoTime();
        radixSort(copyRadix);
        finishTime = System.nanoTime();
        long timeOfRadix = finishTime - startTime;
        
        // Shell Sort
        startTime = System.nanoTime();
        shellSort(copyShell);
        finishTime = System.nanoTime();
        long timeOfShell = finishTime - startTime;
        
        // Heap Sort
        startTime = System.nanoTime();
        heapSort(copyHeap);
        finishTime = System.nanoTime();
        long timeOfHeap = finishTime - startTime;
        
        // Insertion Sort
        startTime = System.nanoTime();
        insertionSort(copyInsert);
        finishTime = System.nanoTime();
        long timeOfInsert = finishTime - startTime;
        
        // Collections.sort
        startTime = System.nanoTime();
        Collections.sort(array);
        finishTime = System.nanoTime();
        
        // Performs accuracy checks
        boolean harmony = true;
        for(int i = 0; i < sizeOfArray; i++) {
            if(copyRadix[i] != array.get(i) || 
               copyShell[i] != array.get(i) ||
               copyHeap[i] != array.get(i) ||
               copyInsert[i] != array.get(i)) {
                harmony = false;
                break;
            }
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorted_arrays.txt"))) 
        {
            writer.write("Original Array:\n" + arrayToString(mainArr) + "\n\n");
            writer.write("Radix Sort Result:\n" + arrayToString(copyRadix) + "\n\n");
            writer.write("Shell Sort Result:\n" + arrayToString(copyShell) + "\n\n");
            writer.write("Heap Sort Result:\n" + arrayToString(copyHeap) + "\n\n");
            writer.write("Insertion Sort Result:\n" + arrayToString(copyInsert) + "\n\n");
        } 
        catch (IOException e) 
        {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        

        Ccleaner();
        System.out.println(color.MAGENTA + "=================================");
        System.out.println(color.MAGENTA + "         Ranking Results         ");
        System.out.println(color.MAGENTA + "=================================");
        System.out.printf(color.WHITE + "  %-20s: %.3f ms%n", "Radix Sort", timeOfRadix / 1000000.0);
        System.out.printf(color.WHITE + "  %-20s: %.3f ms%n", "Shell Sort", timeOfShell / 1000000.0);
        System.out.printf(color.WHITE + "  %-20s: %.3f ms%n", "Heap Sort", timeOfHeap / 1000000.0);
        System.out.printf(color.WHITE + "  %-20s: %.3f ms%n", "Insertion Sort", timeOfInsert / 1000000.0);
        System.out.println(color.MAGENTA + "=================================");

        
        if(harmony) 
        {
            System.out.println(color.WHITE + "\nAll algorithms sorted correctly!");
            System.out.println(color.WHITE + "\nPrinted the original array and its sorted versions for each algortihm!");
        } else {
            System.out.println(color.BRIGHT_RED + "\nERROR: Sorts do not match!!");
        }
    }
    
    // Shell sort, which is an improved version of insertion sort, sorts the array by dividing it at certain intervals.
    /**
     * Implements Shell Sort on the given array. Shell Sort is an optimized version of Insertion Sort,
     * which sorts elements at specific gaps that reduce over iterations.
     *
     * @param sequence the array to be sorted.
     */
    private void shellSort(int[] sequence) {
        int dimension = sequence.length;
        for(int harper = dimension/2; harper > 0; harper /= 2) {
            for(int i = harper; i < dimension; i++) {
                int temp = sequence[i];
                int j;
                for(j = i; j >= harper && sequence[j-harper] > temp; j -= harper) {
                    sequence[j] = sequence[j-harper];
                }
                sequence[j] = temp;
            }
        }
    }
    
    // It works with the logic of a tree branch.
    /**
     * Implements Heap Sort on the given array. Heap Sort constructs a binary heap and repeatedly
     * extracts the maximum element to build a sorted array.
     *
     * @param heap the array to be sorted.
     */
    private void heapSort(int[] heap) {
        int arraySize = heap.length;
        
        for(int i = arraySize / 2 - 1; i >= 0; i--) {
            heapify(heap, arraySize, i);
        }
        
        for(int sorter = arraySize-1; sorter > 0; sorter--) {
            int swap = heap[0];
            heap[0] = heap[sorter];
            heap[sorter] = swap;
            
            heapify(heap, sorter, 0);
        }
    }
    
    /**
     * Helper method for Heap Sort. Organizes a subtree into a max heap.
     *
     * @param tree the array representing the heap.
     * @param capacity the size of the heap.
     * @param root the root index of the subtree.
     */
    private void heapify(int[] tree, int capacity, int root) {
        int third = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        
        if(leftChild < capacity && tree[leftChild] > tree[third]) {
            third = leftChild;
        }
        
        if(rightChild < capacity && tree[rightChild] > tree[third]) {
            third = rightChild;
        }
        
        if(third != root) {
            int swap = tree[root];
            tree[root] = tree[third];
            tree[third] = swap;
            
            heapify(tree, capacity, third);
        }
    }
    
    // insertion sort sorts the array by scanning it from left to right
    /**
     * Implements Insertion Sort on the given array. Insertion Sort works by dividing the array into a sorted
     * and an unsorted part and repeatedly inserting the first element of the unsorted part into the sorted part.
     *
     * @param array the array to be sorted.
     */
    private void insertionSort(int[] array) {
        int length = array.length;
        
        // The array is scanned from left to right
        for (int i = 1; i < length; i++) {
            // We store the current element in temporary variable
            int key = array[i];
            
            // Finds the correct position in the sorted section
            int harmony = i - 1;
            
            // Move large elements to the right
            while (harmony >= 0) {
                // If the element on the left is larger
                if (array[harmony] > key) {
                    // Scrolls right
                    array[harmony + 1] = array[harmony];
                    harmony--;
                } else {
                    // We found the right position
                    break;
                }
            }
            
            // Places the element in the correct position
            array[harmony + 1] = key;
        }
    }
    
    // radix sort sorts numbers according to their digits, uses the counting sort auxiliary algorithm
    /**
     * Implements Radix Sort on the given array. Radix Sort processes the digits of numbers in multiple passes,
     * sorting numbers by each digit starting from the least significant to the most significant digit.
     *
     * @param data the array to be sorted.
     */
    private void radixSort(int[] data) {
        // Converts negative numbers to positive
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) max = data[i];
            if (data[i] < min) min = data[i];
        }
        
        //Makes all numbers positive
        if (min < 0) {
            for (int i = 0; i < data.length; i++) {
                data[i] -= min;
            }
            max -= min;
        }
        
        // We apply counting sort for each digit
        for(int placeVal = 1; max/placeVal > 0; placeVal *= 10) {
            countingSortForRadix(data, placeVal);
        }
        
        // Allows to return numbers to their original values
        if (min < 0) {
            for (int i = 0; i < data.length; i++) {
                data[i] += min;
            }
        }
    }
    
    /**
     * A helper method for Radix Sort. Performs counting sort on the array based on the specified digit place.
     *
     * @param input the array to be sorted.
     * @param exp the current digit's place value (e.g., 1 for units, 10 for tens).
     */
    private void countingSortForRadix(int[] input, int exp) {
        int[] count = new int[10];
        int[] output = new int[input.length];
        
        for(int first = 0; first < input.length; first++) {
            count[(input[first]/exp) % 10]++;
        }
        
        for(int second = 1; second < 10; second++) {
            count[second] += count[second - 1];
        }
        
        for(int third = input.length - 1; third >= 0; third--) {
            output[count[(input[third]/exp) % 10] - 1] = input[third];
            count[(input[third]/exp) % 10]--;
        }
        
        for(int fourth = 0; fourth < input.length; fourth++) {
            input[fourth] = output[fourth];
        }
    }

    /**
     * Converts an array to a string with comma-separated values.
     *
     * @param array the array to convert.
     * @return a string representation of the array.
     */
    private String arrayToString(int[] array) 
    {
        String result = "";
        for (int i = 0; i < array.length; i++) 
        {
            result += array[i];
            if (i < array.length - 1) 
            {
                result += ", "; // Add a comma unless it's the last element
            }
        }
        return result;
    }
    /**
     * Clears the console screen.
     * 
     * This method attempts to clear the console by running a system command. 
     * If an error occurs during the process, an error message is printed.
     * 
     *
     */
    static public void Ccleaner()
    {
        try 
        {
            new ProcessBuilder("cmd","/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) 
        {
            System.err.println("Error Code #Clear");
        }
    }
}


