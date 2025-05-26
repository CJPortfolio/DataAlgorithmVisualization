package com.datavisualizationproject;

import java.util.Random;

public class Main 
{
    public static void main( String[] args )
    {
        
    }

    public static void printData()
    {
        
    }


    //Generates random int
    public static int intRandomizer()
    {
        //Creates instant of random class
        Random r = new Random();
        //Generates random integer from 0 to 1000
        int randNumber = r.nextInt(1001);

        return randNumber;
    }
}


