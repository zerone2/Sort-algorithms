import java.util.Random;


public class QuickSort {
	static long compareCount=0;

    public static void _QuickSort(char[] array, int low, int high)
    {
        int pivotIndex;

        if(low < high)
        {
            pivotIndex = _Partition(array, low, high);
            _QuickSort(array, low, pivotIndex);
            _QuickSort(array, pivotIndex+1, high);
        }
    }

    public static int _Partition(char[] array, int low, int high)
    {
        int i, j, pivot, temp;

        pivot = (int)array[low];
        j = low + 1;

        for (i = low + 1; i < high; i++) {
            if ((int)array[i] < pivot) {
                temp = (int)array[j];
                array[j] = array[i];
                array[i] = (char)temp;
                j++;
                compareCount++;

            }
        }


        int pivotPoint = j - 1;

        temp = (int)array[low];
        array[low] = array[pivotPoint];
        array[pivotPoint] = (char)temp;

        return pivotPoint;
    }

    public static void main(String args[])
    {
        int size = 20;
        char[] array = new char[size];
        boolean[] check = new boolean[size];
        long startTime, endTime, runningTime;
        
        /*for(int k=0; k < size; k++)
        	array[k]=(char)k;*/   //오름차순 (quickSort worst case)

        Random random = new Random();

        int i = 0;
        int temp;
        
        startTime = System.currentTimeMillis();
        
        for(int k = 0; k < size; k++)
            check[k] = false;

        while(i < size)
        {
            temp = random.nextInt(size);
           
            if(!check[temp])
            {
                check[temp] = true;
                array[i] = (char)temp; //65535
                i++;
                
            }
        }
        endTime = System.currentTimeMillis();
        
        runningTime = endTime - startTime;

        System.out.println("\nRunning Time for Making Array : " + runningTime + "ms");

        System.out.println("\n<<<<<<<<<<<<<<<<  Quick Sort  >>>>>>>>>>>>>>>>");

        //System.out.println("Before Sorting : " + Arrays.toString(array));

        //startTime = System.currentTimeMillis();
        startTime = System.nanoTime();

        _QuickSort(array, 0, array.length);

        endTime = System.nanoTime();
        //endTime = System.currentTimeMillis();

        //System.out.println("After Sorting : " + Arrays.toString(array));

        runningTime = (endTime - startTime)/1000000;
        System.out.println("count: " + compareCount);
        System.out.println("\nRunning Time for Sorting : " + runningTime + "ms");
 
    }
}
