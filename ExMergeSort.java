import java.util.Random;


public class ExMergeSort {
	
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
	
    public static void _MergeSort(char[] array)
    {
        int size = array.length;

        if(size > 1)
        {
            int mid = size / 2;
            int rest = size - mid;

            char[] leftArray = new char[mid];
            char[] rightArray = new char[rest];
            
            if(size < 10)	//�뷫 size�� 10���� ������ exchange sort�� mergesort���� �� ������.
            {
            	_ExchangeSort(array, size);
            }
            else
            {
            	if(size%2==0)
            	{
            		for(int i = 0; i < mid; i++)
            			leftArray[i] = array[i];
            		for(int i = 0; i < rest; i++)
            			rightArray[i] = array[rest + i];
            	}
            	else //size�� Ȧ���� ������ ���, �����ʺκ��� rest-1���� ���۵ȴ�. �ƴϸ� array ũ�⸦ �ʰ��Ѵ�.
            	{
            		for(int i = 0; i < mid; i++)
            			leftArray[i] = array[i];
            		for(int i = 0; i < rest; i++)
            			rightArray[i] = array[(rest-1)+i]; 
            	}

            	_MergeSort(leftArray);
            	_MergeSort(rightArray);

            	_Merge(leftArray, rightArray, array);
            }
        }
    }

    public static void _Merge(char[] leftArray, char[] rightArray, char[] baseArray)
    {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int leftIndex = 0, rightIndex = 0;
        int count = 0;

        //System.out.println(Arrays.toString(leftArray) + " " + Arrays.toString(rightArray));

        while(leftIndex < leftSize && rightIndex < rightSize)
        {
            if((int)leftArray[leftIndex] < (int)rightArray[rightIndex])
            {
                baseArray[count] = leftArray[leftIndex];
                leftIndex++;
            }
            else
            {
                baseArray[count] = rightArray[rightIndex];
                rightIndex++;
            }
            count++;
            compareCount++;
        }

        if(leftIndex >= leftSize) 
        {
            for(int i = rightIndex; i < rightSize; i++)
            {
                baseArray[count++] = rightArray[i];
            }
            compareCount++;
        }
        else
        {
            for(int i = leftIndex; i < leftSize; i++)
            {
                baseArray[count++] = leftArray[i];
            }
            compareCount++;
        }
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
                array[i] = (char)temp;
                i++;
            }
        }

        endTime = System.currentTimeMillis();

        runningTime = endTime - startTime;

        System.out.println("\nRunning Time for Making Array : " + runningTime + "ms"); //�迭����µ� �ɸ��ð�

        System.out.println("<<<<<<<<<<<<<<<<  Merge Sort  >>>>>>>>>>>>>>>>");

        //System.out.println("Before Sorting : " + Arrays.toString(array));

        //startTime = System.currentTimeMillis();
        startTime = System.nanoTime();


        _MergeSort(array);

        endTime = System.nanoTime();
        //endTime = System.currentTimeMillis();

        //System.out.println("After Sorting : " + Arrays.toString(array));

        runningTime = (endTime - startTime)/1000000;
        
        System.out.println("count: " + compareCount);
        System.out.println("\nRunning Time for Sorting : " + runningTime + "ms"); //sorting�ϴµ��� �ɸ��ð�

    }

}

