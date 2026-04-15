public class bit_manip{

    // public static void evenodd(int n){
    //     int bitmask = 1;
    //     if((n & bitmask) == 0){
    //         System.out.println("even number");
    //     }else{
    //         System.out.println("odd number");
    //     }
    // }

    // public static int getithbit(int n,int i){
    //     int bitmask = 1 << i;
    //     if((n & bitmask) == 0){
    //         return 0;
    //     }else{
    //         return 1;
    //     }
    // }

    public static int clearithbit(int n, int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }

    public static int setithbit(int n,int i){
        int bitmask = 1<<i;
        return n | bitmask;
    }

    public static int updateithbit(int n,int i,int newbit){
        // if(newbit == 0){
        //     return clearithbit(n, i);
        // }else{
        //     return setithbit(n, i);
        // }

        n = clearithbit(n, i);
        int bitmask = newbit<<i;
        return n | bitmask;
    }

    public static int clearlastithbit(int n,int i){
        int bitmask = (~0)<<i;
        return n & bitmask;
    }

    public static int clearrangebit(int n,int i, int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int bitmask = a|b;
        return n & bitmask;
    }

    public static boolean poweroftwo(int n){
        return ((n&(n-1)) == 0);
    }

    public static int ones(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastexp(int n,int a){
        int ans = 1;
        while(n != 0){
            if((n &1) != 0){
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    // add one

    public static int addone(int n){
        if(n % 2 != 0){
            int bitmask = 1;
            return n&bitmask;
        }else{
            return n | 1;
        }
    }
    public static void main(String[] args) {
        // evenodd(12);
        System.out.println(addone(5));
        int x=6;
        System.out.println(x+" + "+1+" is "+-~x);
        x= -4;
        System.out.println(x+" + "+1+" is "+-~x);
        x=0;
        System.out.println(x+" + "+1+" is "+-~x);
        

        
    }
}