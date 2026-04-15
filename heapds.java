import java.util.*;
public class heapds{

    static class heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){  //O(log(n))
            arr.add(data);

            int x = arr.size() - 1; // child index
            int par = (x - 1) / 2; // paraent index

            while(arr.get(x) < arr.get(par)){           // for max heap change <  to >
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }
        }
        // remove element from heap 
        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minidx = i;

            // check for left leaf node
            if(left < arr.size() && arr.get(minidx) > arr.get(left)){       // for max heap change >  to <
                minidx = left;
            }
            // check for right leaf node
            if(right < arr.size() && arr.get(minidx) > arr.get(right)){     // for max heap change >  to <
                minidx = right;
            }

            if(minidx != i){
                int temp = arr.get(i);
                arr.set(i,arr.get(minidx));
                arr.set(minidx,temp);
                heapify(minidx);
            }

        }

        public int remove(){  //O(log(n))
            int data = arr.get(0);

            //first step to swap first and last element
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            // second step to remove last element
            arr.remove(arr.size()-1);

            // 3. heapify -> balance heap tree
            heapify(0);
            return data;
        }

        public int peek(){
            return arr.get(0);
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    // heap sort

    public static void heapify(int[] arr,int i,int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxidx = i;

        if(left < size && arr[maxidx] < arr[left]){         // for decending order just chage lessthan symbol 
            maxidx = left;
        }
        if(right < size && arr[maxidx] < arr[right]){       // for decending order just chage lessthan symbol 
            maxidx = right;
        }

        if(maxidx != i){
            int temp = arr[i];
            arr[i] = arr[maxidx];
            arr[maxidx] = temp;

            heapify(arr,maxidx,size);
        }
    }

    public static void heapsort(int[] arr){
        // step1 build maxheap
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            heapify(arr,i,n);
        }

        // 2. push largest at end
        for(int i=n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,0,i);
        }
    }
    public static void main(String[] args) {
        // heap p = new heap();

        // p.add(3);
        // p.add(4);
        // p.add(1);
        // p.add(5);

        // while(!p.isEmpty()){
        //     System.out.println(p.peek());
        //     p.remove();
        // }

        int[] arr = {1,2,4,5,3};
        heapsort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
    }
}