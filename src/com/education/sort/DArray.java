package com.education.sort;

import java.util.Random;

public class DArray {
    int[] theArray;          // ref to array theArray
    int nElems;               // number of data items

    //-----------------------------------------------------------
    public DArray(int max)            // constructor
    {
        theArray = new int[max];      // create array
        nElems = 0;
    }

    //-----------------------------------------------------------
    public void insert(int value)    // put element into array
    {
        theArray[nElems] = value;      // insert it
        nElems++;                      // increment size
    }

    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)    // for each element,
            System.out.print(theArray[j] + " ");  // display it
        System.out.println("");
    }

    //-----------------------------------------------------------
    public void mergeSort()           // called by main()
    {                              // provides workspace
        int[] workSpace = new int[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }

    //-----------------------------------------------------------
    private void recMergeSort(int[] workSpace, int lowerBound,
                              int upperBound) {
        if (lowerBound == upperBound)            // if range is 1,
            return;                              // no use sorting
        else {                                    // find midpoint
            int mid = (lowerBound + upperBound) / 2;
            // sort low half
            recMergeSort(workSpace, lowerBound, mid);
            // sort high half
            recMergeSort(workSpace, mid + 1, upperBound);
            // merge them
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }  // end else
    }  // end recMergeSort()

    //-----------------------------------------------------------
    private void merge(int[] workSpace, int lowPtr,
                       int highPtr, int upperBound) {
        int j = 0;                             // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;       // # of items

        while (lowPtr <= mid && highPtr <= upperBound)
            if (theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];

        while (lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];

        while (highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];

        for (j = 0; j < n; j++)
            theArray[lowerBound + j] = workSpace[j];
    }  // end merge()
    //-----------------------------------------------------------
}  // end class DArray

////////////////////////////////////////////////////////////////
class MergeSortApp {
    public static void main(String[] args) {
        int maxSize = 200_000_000;             // array size
        DArray arr;                    // reference to array
        arr = new DArray(maxSize);     // create the array
        generateArray(arr);
        long start = System.currentTimeMillis();
        arr.mergeSort();               // merge sort the array
        long duration = System.currentTimeMillis() - start;
//        arr.display();                 // display items again
        System.out.println("duration: " + duration);
    }

    private static void generateArray(DArray arr) {
        Random random = new Random(42);
        for (int i = 0; i < arr.theArray.length; i++) {
//            result[i] = random.nextInt(Integer.MAX_VALUE);
            arr.insert(random.nextInt(500));
        }
    }
}