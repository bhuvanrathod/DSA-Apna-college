import java.util.*;
public class divid_and_concer{

    //merge sort
    public static void mergesort(int arr[],int si,int ei){
        if(si >= ei){
            return;
        }

        int mid = si + (ei - si)/2;
        mergesort(arr,si,mid);
        mergesort(arr,mid+1,ei);

        mergea(arr,si,mid,ei);
    }

    public static void mergea(int arr[],int si,int mid,int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // for left over element of 1st sorted arry
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        // for left over element of 2nd sorted arry
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i] = temp[k];
        }
    }

    //qucik sort
    public static void quicksort(int arr[],int si,int ei){
        if(si >= ei){
            return;
        }
        int pidx = parition(arr,si,ei);
        quicksort(arr, si, pidx-1);
        quicksort(arr, pidx+1, ei);
    }

    public static int parition(int arr[],int si,int ei){
        int pivot = arr[ei];
        int i = si - 1;
        for(int j=si;j<ei;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        // int arr[] = {6,3,9,5,2,8};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        Random rand = new Random();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = rand.nextInt(100);
        }
        long start = System.currentTimeMillis();
        mergesort(arr, 0, arr.length-1);
        long end = System.currentTimeMillis();
        // quicksort(arr, 0, arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nTime taken by merge sort: "+ (end - start) + "ms");
    }
}