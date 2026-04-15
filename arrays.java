public class arrays {

    // largest in an array
    // public static void update(int marks[]){
    //     for(int i=0; i<=marks.length; i++){
    //         marks[i] = marks[i] + 1;
    //         System.out.println("marks "+ marks[i]);
    //     }
    // }

    //linear search
    // public static boolean  linerseearch(int arr[], int target){
    //     for(int i=0; i<arr.length;i++ ){
    //         if(arr[i] == target){
    //             System.out.print("the given number is present in " + i + " index");
    //         }
    //     }
    //     return false;
    // }

    // Bineary search

    // public static int Bineary(int arr[], int target){
    //     int start = 0, end = arr.length-1;

    //     while(start <= end){
    //         int mid = (start + end)/2;

    //         if(arr[mid] == target){
    //             return mid;
    //         }else if(arr[mid] >= target){
    //             start = mid - 1;
    //         }else{
    //             end = mid + 1;
    //         }
    //     }

    //     return -1;
    // }

    // reverse an array

    // public static void reverce(int arr[]){
    //     int start = 0, end = arr.length - 1;

    //     while(start < end){
    //         int temp = arr[start];
    //         arr[start] = arr[end];
    //         arr[end] = temp;

    //         start++;
    //         end--;
    //     }

    //     for(int i=0; i<arr.length; i++){
    //         System.out.print(arr[i] + " ");
    //     }

        
    // }

    // pairs
    
    // public static void pairs(int arr[]){
    //     int tp = 0;
    //     for(int i=0; i<arr.length; i++){
    //         for(int j=i+1; j<arr.length; j++){
    //             System.out.print("("+arr[i]+ ","+arr[j] +")");
    //             tp++;
    //         }
    //         System.out.println();
    //     }
    //     System.out.println(tp);
    // }

    // subarray

    // public static void subarray(int arr[]){
    //     for(int i=0; i<arr.length; i++){
            
    //         for(int j=i; j<arr.length; j++){
                
    //             for(int k=i; k<=j; k++){
    //                 System.out.print(arr[k] + " ");
    
    //             }
    //             System.out.println();
    //         }
    //         System.out.println();
            
    //     }

    // }

    // max subarray sum brute force approch

    // public static void maxsubarr(int arr[]){
    //     int maxsum = Integer.MIN_VALUE;
    //     int currsum ;

    //     for(int i=0; i<arr.length; i++){
    //         for(int j=i; j<arr.length; j++){
    //             currsum = 0;
    //             for(int k=i; k<=j; k++){
    //                 currsum += arr[k];
    //             }
    //             System.out.println(currsum);
    //             if(currsum > maxsum){
    //                 maxsum = currsum;
    //             }
    //         }            
    //     }
    //     System.out.println("the maximum sub array sum is "+ maxsum);

    // }

    // max sub array optimal

    // public static void maxsubarr(int arr[]){
    //     int maxsum = Integer.MIN_VALUE;
    //     int currsum ;
    //     int prefix[] = new int[arr.length];

    //     prefix[0] = arr[0];

    //     for(int i=1; i<prefix.length; i++){
    //         prefix[i] = prefix[i-1] + arr[i];
    //     }

    //     for(int i=0; i<arr.length; i++){
    //         for(int j=i; j<arr.length; j++){
    //             currsum = i == 0 ? prefix[j] :prefix[j] - prefix[i-1];
               
    //             if(currsum > maxsum){
    //                 maxsum = currsum;
    //             }
    //         }            
    //     }
    //     System.out.println("the maximum sub array sum is "+ maxsum);

    // }

    // kadanes algorim

//    public static void kadanes(int arr[]){
//         int maxsum = Integer.MIN_VALUE;
//         int currsum = 0;
        
//         for(int i=0; i<arr.length; i++){
//             currsum = currsum + arr[i]; 
//             if(currsum < 0){
//                 currsum = 0;
//             }
//             maxsum = Math.max(currsum,maxsum);
//         }
//         System.out.println("the maximum sub array sum is "+ maxsum);

//     }


    // Buy and sell stock
    
    // public static int buyandsell(int price[]){
    //     int maxprofit = 0;
    //     int buyprice = Integer.MAX_VALUE;

    //     for(int i=0; i<price.length; i++){
    //         if(buyprice < price[i]){
    //             int profit = price[i] - buyprice;
    //             maxprofit = Math.max(maxprofit,profit);
    //         }else{
    //             buyprice = price[i];
    //         }
    //     }

    //     return maxprofit;
    // }

    // trapped rain water

    // public static int trappedrain(int height[]){
    //     int n = height.length;
    //     // left max

    //     int leftmax[] = new int[n];
    //     leftmax[0] = height[0];
    //     for(int i=1; i<n; i++){
    //         leftmax[i] = Math.max(leftmax[i],height[i-1]);
    //     }

        // right max

    //     int rightmax[] = new int[n];
    //     rightmax[n-1] = height[n-1];
    //     for(int i=n-2;i >=0; i--){
    //         rightmax[i] = Math.max(rightmax[i],height[i+1]);
    //     }  

    //     int trappedrain = 0;

    //     for(int i=0; i<n; i++){
    //         int width = Math.min(leftmax[i],rightmax[i]);

    //         trappedrain += -width + height[i];
    //     }

    //     return trappedrain;
    // }

    // bubble sort

    // public static void bublesor(int arr[]){
    //     for(int i=0; i<arr.length-1; i++){
    //         int swap = 0;
    //         for(int j=0; j<arr.length-1-i; j++){
    //             if(arr[j] > arr[j+1]){
    //                 int temp = arr[j];
    //                 arr[j] = arr[j+1];
    //                 arr[j+1] = temp;
    //                 swap ++;
    //             }
                
    //         }
    //     }
    // }

    // public static void printarr(int arr[]) {
    //     for(int i=0; i<arr.length; i++){
    //         System.out.println(arr[i]+ " ");
    //     }
    //     System.out.println();
    // }

    // sorted or not

    // public static void bublesor(int arr[]){
    //     int swap = 0;
    //     for(int i=0; i<arr.length-1; i++){
    //         if(arr[i] > arr[i+1]){
    //             swap ++;
    //         }
    //     }
    //     if(swap > 0){
    //         System.out.println("not sorted");
    //     }else{
    //         System.out.println("sorted");
    //     }
    // }

    // // selection sort
    // T.C o(n2) for both case
    public static void selectionsort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minpos = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minpos] > arr[j]){
                    minpos = j;
                }
            }
            //swap

            int temp = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = temp;
        }
    }
    // T.C o(n1) for best case and o(n2) for worst case
    public static void modifiedselectionsort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minpos = i;
            boolean swaped = false;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minpos] > arr[j]){
                    minpos = j;
                    swaped = true;
                }
            }
            if(swaped == false){
                break;
            }
            //swap

            int temp = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = temp;
        }
    }

    // insertion sort

    public static void insertion(int arr[]){
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            // finding out correct position to insert
            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

    // modify insertoi sort
    public static void modifyinsertion(int arr[]){
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            boolean swaped = false;
            // finding out correct position to insert
            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
                swaped = true;
            }
            if(swaped == false){
                break;
            }
            arr[prev+1] = curr;
        }
    }

    // counting sort

    public static void countsort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length; i++){
            largest = Math.max(largest,arr[i]);
        }

        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }

        int j=0;
        for(int i=0; i<count.length;i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void printarr(int arr[]) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    


    public static void main(String[] args) {
        // int marks[] = new int[20];

        // Scanner sc = new Scanner(System.in);
        // int marks[] = {1,2,3,4};
        // marks[0] = sc.nextInt();
        // marks[1] = sc.nextInt();
        // marks[2] = sc.nextInt();
        // marks[3] = sc.nextInt();

        // System.out.println("math : " + marks[0]);
        // System.out.println("phy : " + marks[1]);
        // System.out.println("bio : " +marks[2]);
        // System.out.println("chem : " +marks[3]);

        // int avg = (marks[0] + marks[1] + marks[2] + marks[3])/4;

        // System.out.print(avg);

        // update(marks);

        // for(int i=0; i<=marks.length; i++){
        //     System.out.println("marks "+ marks[i]);
        // }

        // Scanner sc = new Scanner(System.in);
        // int target = sc.nextInt();

        int num[] = {7,5,6,9,9,8,4,3,2,4,1};
        countsort(num);
        printarr(num);
        
        // System.out.println(trappedrain(num));

        // linerseearch(num, target);

        // int largest = Integer.MIN_VALUE;

        // for(int i=0; i<num.length; i++){
        //     if(num[i] > largest){
        //         largest = num[i];
        //     }
        // }

        // System.out.println("largest number in given array is "+ largest);
        // System.out.println("target is found at index "+ Bineary(num, target));

        // reverce(num);

        // pairs(num);
        // subarray(num);

        
        
        

    }
}