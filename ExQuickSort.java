import java.util.Random;


public class ExQuickSort {
	static long compareCount=0;
	
	public static void _ExchangeSort(char[] array, int size)
	{
		int temp;
		int i,j;
		for(i=0; i<size-1; i++)
		{
			for(j=i+1; j<size; j++)
			{
				if((int)array[i] > (int)array[j])
				{
					temp = (int)array[i];
					array[i] = array[j];
					array[j] = (char)temp;
					compareCount++;
				}
			}
		}
	}

    public static void _QuickSort(char[] array, int low, int high)
    {
        int pivotIndex;

        if(low < high)
        {
        	
            pivotIndex = _Partition(array, low, high);
            if(pivotIndex > 20)
            {
            	_QuickSort(array, low, pivotIndex);
            	_QuickSort(array, pivotIndex+1, high);
            }
            else
            	_ExchangeSort(array, pivotIndex);
        }
    }

    public static int _Partition(char[] array, int low, int high)
    {
        int i, j, pivot, temp;

        pivot = (int)array[low];
        j = low + 1;
        
        for (i = low + 1; i < high; i++) 
        {
            if ((int)array[i] < pivot) 
            {
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
        int size = 100000000;
        char[] array = new char[size];
        boolean[] check = new boolean[size];
        long startTime, endTime, runningTime;

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

        System.out.println("\nRunning Time for Making Array : " + runningTime + "ms");	//배열 생성하는데 걸린시간

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
        System.out.println("\nRunning Time for Sorting : " + runningTime + "ms"); //sorting하는데에 걸린시간
 
    }
}

