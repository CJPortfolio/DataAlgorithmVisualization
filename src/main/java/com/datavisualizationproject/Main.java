package com.datavisualizationproject;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main 
{
    public static void main( String[] args ) throws IOException
    {
        Scanner scnr = new Scanner(System.in);
        int[] dataSet = ArrayValueRandomizer();


        //-1 for input error
        int input = -1;

            System.out.println("\n\nHi and welcome to Data Algorithm Visuals!");

        do 
        { 
            System.out.println("\nPress a number key to view the corresponding data algorithm.");
            System.out.println("Press 7 to quit:\n");
            System.out.println("1: Quick Sort");
            System.out.println("2: Bubble Sort");
            System.out.println("3: Counting Sort");
            System.out.println("4: Merge Sort");
            System.out.println("5: Insertion Sort");
            System.out.println("6: Heap Sort Algorithm\n");
            System.out.print("Enter key: ");

            input = scnr.nextInt();

            switch(input)
            {
                case 1 -> {

                }

                case 2 -> {
                Boolean pause = pauseInquiry(scnr);

                bubbleSort(dataSet, pause);

                }

                case 3 -> {
                }

                case 4 -> {
                }

                case 5 -> {
                }

                case 6 -> {
                }
                
                case 7 -> {

                    System.exit(0);
                }

                default -> throw new IOException("Something in input went wrong");
            }
            
            //Quick Sort Algorithm

            //Bubble Sort Algorithm

            //Counting Sort Algorithm

            //Merge Sort Algorithm

            //Insertion Sort Algorithm

            //Heap Sort Algorithm
        } 
        while (true);
        
        // Testing printDataset function
        // int max = 30;
        // int min = 1;



        // Testing unDuplicate function
        // int num = 15;
        // num = unDuplicate(num);
        // System.out.println(num);
    }

    


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

    //Bubble Sort Algorithm
    public static void bubbleSort(int[] data, Boolean pauseOption) throws IOException
    {
        Scanner scnr = new Scanner(System.in);
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

}


