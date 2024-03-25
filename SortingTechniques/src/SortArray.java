import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class SortArray {
    private int[] array;

    public SortArray(String filePath) {
        readInputFile(filePath);
    }

    private void readInputFile(String filePath) {              //to read the array from the file 
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line.startsWith("[") && line.endsWith("]")) {
                line = line.substring(1, line.length() - 1);
            }
                System.out.println(line);
            String[] elements = line.split(",");
            array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void mergeArr(int []nums, int begin, int mid, int end,int l) {
        int sizeL = mid - begin;
        int sizeR = end - mid - 1;


        int left[]=new int[sizeL+1];
        int right[]=new int[sizeR+1];

        for (int i = 0; i <= sizeL; i++) {
            left[i] = nums[begin + i];
        }
        for (int i = 0; i <= sizeR; i++) {
            right[i] = nums[mid + i + 1];
        }
        int indexLeft = 0;
        int indexRight = 0;

        int index = begin;

        while (indexLeft <= sizeL && (indexRight) <= sizeR) {
            if (left[indexLeft] <= right[indexRight]) {
                nums[index] = left[indexLeft];
                indexLeft++;
            } else {
                nums[index] = right[indexRight];
                indexRight++;
            }
            index++;
        }
        if (indexLeft <= sizeL) {
            while (indexLeft <= sizeL) {
                nums[index] = left[indexLeft];
                index++;
                indexLeft++;
            }
        } else {
            while (indexRight <= sizeR) {
                nums[index] = right[indexRight];
                index++;
                indexRight++;
            }
        }
   if (l==2||l==3) {
    System.out.print("[ ");
        for(int i=begin;i<end;i++){
            System.out.print(nums[i]+" ,");
        }
        System.out.println(nums[end]+" ]");
   } 
    }
    void merge(int []nums, int begin, int end,int l) {
        if (begin >= end) {
            // if one element begin greater than end
            return;
        }
        int mid = (begin + end) / 2;
        merge(nums, begin, mid ,l);
        merge(nums, mid + 1, end,l);
        mergeArr(nums,begin,mid,end,l);
    }

    public int[] simpleSort(int i) {
        if(i==1||i==3){                                           // if 1 or 3 it will sort the array and return final array
            int n = array.length;
            for (int l = 1; l < n; l++) {
                int key = array[l];
                int index = l - 1;
                while (index >= 0 && array[index] < key) {
                    array[index + 1] = array[index];
                    index--;
                }
                array[index + 1] = key;
            }
        }
        if (i==2 ||i==3) {                                          //if 2 or 3 it will return subarrays
            int n = array.length;
            List<int[]> output = new ArrayList<>();
            output.add(array.clone());
            for (int k = 1; k < n; k++) {
                int key = array[k];
                int index = k - 1;
                while (index >= 0 && array[index] < key) {
                    array[index + 1] = array[index];
                    index--;
                }
                array[index + 1] = key;
                output.add(array.clone());
            }
            for (int[] num : output) {
                for(int m :num){
                    System.out.print(m + " ");
                }
                System.out.println();
            }

        }
        return array;
    }

    public int[] efficientSort(int l) {
        int size=array.length-1;
        merge(array,0,size,l);
        return array;
    }




    public int[] nonComparisonSort(int l) {
        // filter array to 2 arrays +ve , -ve
        int postive=0,negative=0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]>=0)postive++;
            else    negative++;
        }
        int positives[]=new int[postive];
        int negatives[]=new int[negative];
        int p=0,n=0;

        for(int i=0;i<array.length;i++)
        {
            if(array[i]>=0){
                positives[p++]=array[i];
            }
            else
            {
                negatives[n++]=-1*array[i];
            }
        }
        if (l==2||l==3) {
            System.out.println("Fisrt split array to positives and negatives");
            System.out.print("positives: ");
            printArray(positives);
            System.out.print("abs(negatives): ");
            printArray(negatives);
        }

        int maxp=getmax(positives);
        int maxn=getmax(negatives);
        if (l==2||l==3) { System.out.println("first thing to sort positives using radix sort");}

        for(int pos=1;maxp/pos>0;pos=pos*10)
        {
            countSortHelpRadix(positives,pos,l);
        }
        if (l==2||l==3) { System.out.print("positives after sorting:");
            printArray(positives);
            System.out.println("second thing to sort negatives using radix sort");}

        for(int pos=1;maxn/pos>0;pos=pos*10)
        {
            countSortHelpRadix(negatives,pos,l);
        }
        if (l==2||l==3) {  System.out.print("negatives after sorting:");
            printArray(negatives);}

        int i=0;
        while(n-1>=0)
        {
            array[i++]=negatives[--n]*-1;
        }
        for(int k=0;k<positives.length;k++)
        {
            array[i++]=positives[k];
        }

        return array;

    }
    private int getmax(int arr[])
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])max=arr[i];
        }
        return max;
    }
    private void countSortHelpRadix(int a[],int pos,int l)
    {
        int count[]=new int[10];
        for(int i=0;i<10;i++)count[i]=0;
        for(int i=0;i<a.length;i++)
        {
            ++count[(a[i]/pos)%10];
        }
        if (l==2||l==3){
            System.out.print((Math.log10(pos)+1)+" ith iteration\n the array: a");
            printArray(a);
            System.out.print("count array: ");
            printArray(count);
        }
        for(int i=1;i<10;i++)count[i]+=count[i-1];
        if (l==2||l==3){
            System.out.print("after prefix sum to array count:");
            printArray(count);}
        int []b=new int[a.length];
        for(int i=a.length-1;i>=0;i--)
        {
            b[--count[(a[i]/pos)%10]]=a[i];
        }
        if (l==2||l==3){
            System.out.print("sorted a according to pos "+(Math.log10(pos)+1)+"\na:");
            printArray(b);}

        for(int i=0;i<a.length;i++)a[i]=b[i];
    }

    void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" , ");
            }
        }
        System.out.println(" ]");
    }
}