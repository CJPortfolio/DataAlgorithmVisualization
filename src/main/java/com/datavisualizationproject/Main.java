package com.datavisualizationproject;

public class Main 
{
    public static void main( String[] args )
    {
        int[] dataSet = ArrayValueRandomizer();
        printData(dataSet);
    }

    public static void printData(int[] data)
    {
        //Outer goes through entire array
        for (int i = 0; i < data.length; ++i)
        {
            //Inner prints amount of characters the element in the array's number is
            for (int j = 0; j < data[i]; ++j)
            {
                System.out.print("*");
            }
            System.out.println();
        } 
    }


    //Generates random int
    public static int[] ArrayValueRandomizer()
    {
    
        
        int dataSetLength = 31;
        int[] dataSet = new int[dataSetLength];
 
        
        return dataSet;
    }


}


