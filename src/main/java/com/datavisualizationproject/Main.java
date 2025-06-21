/*Program that visualizes data 
algorithms and how they work

Made by Christopher Wiratman*/



package com.datavisualizationproject;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Heap {
    private int[] heap;
    private int size;

    public Heap(int[] array) {
        this.size = array.length;
        this.heap = new int[size];

        // Copy input array
        for (int i = 0; i < size; i++) {
            heap[i] = array[i];
        }

        // Build Max Heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // Maintain Max Heap property
    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            heapify(largest);
        }
    }

    // Extract root (max element), replace with last element, then heapify
    public int extractRoot() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);

        return root;
    }
}

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        Scanner scnr = new Scanner(System.in);
        int[] dataSet = ArrayValueRandomizer();
        int[] originalDataSet = dataSet;
        Boolean pause;

        //-1 for input error
        int input = -1;

            System.out.println("\n\nHi and welcome to Data Algorithm Visuals!");

        do 
        { 
            dataSet = originalDataSet;

            System.out.println("\nPress a number key to view the corresponding data algorithm.");
            System.out.println("Press 7 to quit:\n");
            System.out.println("1: Quick Sort");
            System.out.println("2: Bubble Sort");
            System.out.println("3: Counting Sort");
            System.out.println("4: Merge Sort");
            System.out.println("5: Insertion Sort");
            System.out.println("6: Heap Sort Algorithm");
            System.out.println("7: Exit\n");
            System.out.print("Enter key: ");

            input = scnr.nextInt();

            switch(input)
            {

                //Quick Sort Algorithm
                case 1 -> {
                pause = pauseInquiry(scnr);
                Boolean[] pauseWrapper = new Boolean[]{pause};
                quickSort(dataSet, 0, dataSet.length - 1, pauseWrapper, scnr);
                PrintData(dataSet);

                }
                
                //Bubble Sort Algorithm
                case 2 -> {
                pause = pauseInquiry(scnr);

                bubbleSort(dataSet, pause, scnr);

                }

                //Counting Sort
                case 3 -> {
                pause = pauseInquiry(scnr);
                
                countingSort(dataSet, pause, scnr);
                System.out.println();

                }



                //Merge Sort
                case 4 -> {
                pause = pauseInquiry(scnr);
                mergeSort(dataSet, 0, dataSet.length - 1, pause, scnr);
                PrintData(dataSet);
                
                }

                //Insertion Sort Algorithm
                case 5 -> {
                pause = pauseInquiry(scnr);

                insertionSort(dataSet, pause, scnr);

                }

                //Heap Sort Algorithm
                //This is cooked
                case 6 -> {
                pause = pauseInquiry(scnr);
                heapSort(dataSet, pause, scnr);
                PrintData(dataSet);
                
                }
                

                //Exit Key
                case 7 -> {
                    System.exit(0);
                }

                default -> throw new IOException("Something in input went wrong");
            }
            
        } 
        while (true);
        
    }

    

    

    //Prints array data
    public static void PrintData(int[] data)
    {
        //Go through array and find the max height
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (max < data[i])
            max = data[i];
        }

        //If element is greater than max bar value, print a star
        //Else, print spaces
        for(int maxRows = max; maxRows >= 1; --maxRows)
        {
            
            for (int d = 0; d < data.length; d++) {
                if(data[d] >= maxRows)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");

                }
            }
            System.out.println();

        }

        for (int value : data)
        {
            if(value >= 10)
                System.out.printf(" %2d", value);

            else
            {
                System.out.printf("%2d ", value);

            }
        }
    }

    //Fisher-Yates shuffle
    public static void shuffle(int[] array) {

        Random rand = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            
            int j = rand.nextInt(i + 1);
            
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

    //Generates random int
    public static int[] ArrayValueRandomizer()
    {
        //Set array length to 30
        int dataSetLength = 30;
        int[] dataSet = new int[dataSetLength];
 
        for(int i = 0; i < dataSet.length; ++i)
        {
            dataSet[i] = i + 1;

            // for(int j = 0; j < i; j++)
            // {
            //     if(dataSet[j] == dataSet[i])
            //     {
            //         dataSet[j] = unDuplicate(j); 
            //     } 
            // }
        }
        shuffle(dataSet);

        return dataSet;
    }

    //Asks if algorithm should be paused between changes
    public static Boolean pauseInquiry(Scanner scnr) throws IOException {
        System.out.println("Would you like it to pause between changes?");
        System.out.println("Press 1 for yes");
        System.out.println("or 2 for no");

        int input = -2;

        input = scnr.nextInt();

        switch (input) {
            case 1 -> {
                return true;
            }
            case 2 -> {
                return false;
            }
            default -> throw new IOException("Error in pause inquiry");
        }

    }

    //Quick Sort Algorithm
    public static void quickSort(int[] data, int start, int end, Boolean[] pause, Scanner scnr) throws IOException {
        if (start >= end) return;

        int pivot = partition(data, start, end, pause, scnr);

        quickSort(data, start, pivot - 1, pause, scnr);
        quickSort(data, pivot + 1, end, pause, scnr);
    }

    public static int partition(int[] data, int start, int end, Boolean[] pause, Scanner scnr) throws IOException {
        int pivot = data[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (data[j] < pivot) {
                i++;
                // swap
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;

                // print after swap
                if (pause[0]) {
                    PrintData(data);
                    System.out.print("\nPress 1 to stop pausing or any other number to continue: ");
                    int cont = scnr.nextInt();
                    if (cont == 1) pause[0] = false;
                }
            }
        }

        // final swap to place pivot
        i++;
        int temp = data[i];
        data[i] = data[end];
        data[end] = temp;

        if (pause[0]) {
            PrintData(data);
            System.out.print("\nPress 1 to stop pausing or any other number to continue: ");
            int cont = scnr.nextInt();
            if (cont == 1) pause[0] = false;
        }

        return i;
    }

    //Bubble Sort Algorithm
    public static void bubbleSort(int[] data, Boolean pauseOption, Scanner scnr) throws IOException
    {
        int cont = -3;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    
                    if(pauseOption)
                    {
                        PrintData(data);
                        System.out.print("\nPress 1 to stop pausing or any other number to continue.");
                        cont = scnr.nextInt();
                        if(cont == 1) pauseOption = false;
                    }
                
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                    
                }
            }
        }

        PrintData(data);
    }

    //Merge Sort Algorithm
    public static void mergeSort(int[] data, int left, int right, boolean pause, Scanner scnr) throws IOException {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(data, left, mid, pause, scnr);
            mergeSort(data, mid + 1, right, pause, scnr);

            merge(data, left, mid, right);

            if (pause) {
                PrintData(data);
                System.out.print("\nPress 1 to stop pausing or any other number to continue: ");
                int cont = scnr.nextInt();
                if (cont == 1) pause = false;
            }
        }
    }

    public static void merge(int[] data, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = data[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = data[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                data[k++] = L[i++];
            } else {
                data[k++] = R[j++];
            }
        }

        while (i < n1) {
            data[k++] = L[i++];
        }

        while (j < n2) {
            data[k++] = R[j++];
        }
    }

    //Insertion Sort Algorithm
    public static void insertionSort(int[] data, Boolean pauseOption, Scanner scnr) throws IOException
    {
        int cont = -4;

        for (int i = 1; i < data.length; i++)
        {
            if(pauseOption)
            {
                PrintData(data);
                System.out.print("\nPress 1 to stop pausing or any other number to continue.");
                cont = scnr.nextInt();
                if(cont == 1) pauseOption = false;
            }


            int temp = data[i];
            int j = i - 1;

            while(j >= 0 && data[j] > temp)
            {
                data[j + 1] = data[j];
                j--;
                data[j + 1] = temp;
                
            }
        }
        PrintData(data);

    }

    //Counting Sort Algorithm
    public static void countingSort(int[] data, Boolean pauseOption, Scanner scnr) throws IOException
    {
        int cont = -5;

        // Find the maximum value in the array
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        // Initialize count array
        int[] count = new int[max + 1];
        Arrays.fill(count, 0);

        // Store the count of each element
        for (int value : data) {
            count[value]++;
            if (pauseOption) {
                PrintData(data);
                System.out.print("\nCount for value " + value + " incremented. Press 1 to stop pausing or any other number to continue: ");
                cont = scnr.nextInt();
                if (cont == 1) pauseOption = false;
            }
        }

        // Reconstruct the sorted array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                data[index++] = i;
                count[i]--;

                if (pauseOption) {
                    PrintData(data);
                    System.out.print("\nPlacing value " + i + ". Press 1 to stop pausing or any other number to continue: ");
                    cont = scnr.nextInt();
                    if (cont == 1) pauseOption = false;
                }
            }
        }

        PrintData(data);
    }

    //Heap Sort Algorithm (STILL NEEDS WORK)
    public static void heapSort(int[] array, boolean pause, Scanner scnr) {
    Heap heap = new Heap(array);
    int[] sorted = new int[array.length];

    for (int i = array.length - 1; i >= 0; i--) {
        sorted[i] = heap.extractRoot();
        PrintData(sorted);  // Print after every root extraction

        if (pause) {
            System.out.print("\nPress 1 to stop pausing or any other number to continue: ");
            int cont = scnr.nextInt();
            if (cont == 1) pause = false;
        }
    }

    // Copy back to original array
    for (int i = 0; i < array.length; i++) {
        array[i] = sorted[i];
    }
}


}



