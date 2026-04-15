public class recursion1 {
    
    // public static void printnumdec(int n){
    //     if(n == 0){
    //         return;
    //     }
    //     System.out.print(n+" ");
    //     printnumdec(n-1);
    // }

    public static void printlnce(int n){
        if(n == 1){
            System.out.print("1 ");
            return;
        }
        printlnce(n-1);
        System.out.print(n+" ");
    }

    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        return n*fact(n-1);
    }
    public static int sumn(int n){
        if(n == 1){
            return 1;
        }
        return n+sumn(n-1);
    }

    // public static int fib(int n){
    //     if(n == 0 || n == 1){
    //         return n;
    //     }
    //     int fnm1 = fib(n-1);
    //     int fnm2 = fib(n-2);
    //     return fnm1 + fnm2;
    // }

    // or

    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static boolean issorted(int arr[],int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return issorted(arr, i+1);
    }

    public static int firstocc(int arr[],int key,int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstocc(arr,key,i+1);
    }

    public static int lastocc(int arr[],int key,int i){
        if(i == arr.length){
            return -1;
        }
        int isfound = lastocc(arr, key, i+1);

        if(isfound == -1 && arr[i] == key){
            return i;
        }
        return isfound;
    }

    public static int power(int x,int n){
        if(n == 0){
            return 1;
        }
        return x*power(x,n-1);
    }

    public static int optpower(int a,int n){
        if(n == 0){
            return 1;
        }
        // int halfpower = optpower(a,n/2) * optpower(a,n/2);
        // optimal
        int halfpow = optpower(a,n/2);
        int halfpower = halfpow * halfpow;
        if(n % 2 != 0){
            halfpower = a * halfpower;
        }
        return halfpower;
    }

    public static void main(String[] args) {
        int n = 23;
        // printnumdec(n);
        // printlnce(n);
        // System.out.println(fib(n));
        // int arr[] = {10,2,3,4,9,6,4};
        System.out.println(optpower(2,30));

    }
}