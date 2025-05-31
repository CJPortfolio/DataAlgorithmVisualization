package com.datavisualizationproject;

import java.util.Random;

public class Main 
{
    public static void main( String[] args )
    {
        
        // Testing printDataset function
        // int max = 30;
        // int min = 1;
        int[] dataSet = ArrayValueRandomizer();
        PrintData(dataSet);

        // Testing unDuplicate function
        // int num = 15;
        // num = unDuplicate(num);
        // System.out.println(num);
    }

    public static void PrintBar(int amount)
    {
        for (int i = 0; i < amount; i++) {
            System.out.println("*");

        }
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

}


