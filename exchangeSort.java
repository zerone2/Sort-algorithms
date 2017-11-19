package exchangeSort;

import java.util.Random;


public class exchangeSort {
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
	
	public static void main(String args[])
	{
		int size = 20;
		char[] array = new char[size];
		
		 boolean[] check = new boolean[size];
	        long startTime, endTime, runningTime;

	        Random random = new Random();

	        int i = 0;
	        int temp;

	        for(int k = 0; k < size; k++)
	            check[k] = false;

	        while(i < size)
	        {
	            temp = random.nextInt(size);

	            if(!check[temp])
	            {
	                check[temp] = true;
	                array[i] = (char)temp;
	                i++;
	            }
	        }
	        
	        System.out.println("<<<<<<<<<<<<<<<<  Exchange Sort  >>>>>>>>>>>>>>>>");

	        //System.out.println("Before Sorting : " + Arrays.toString(array));

	        //startTime = System.currentTimeMillis();
	        startTime = System.nanoTime();

	        _ExchangeSort(array,size);

	        //endTime = System.currentTimeMillis();

	        //System.out.println("After Sorting : " + Arrays.toString(array));

	        endTime = System.nanoTime();
	        runningTime = (endTime - startTime)/1000000;

	        System.out.println("count: " + compareCount);
	        System.out.println("\nRunning Time for Sorting : " + runningTime + "ms");
	}

}
