

public class recursion_part2{

    // 2Xn
    public static int tillingproblem(int n){        // 4 X n
        if(n == 0 || n == 1 ){       //if(n == 0 || n == 1 || n == 2 || n == 3)
            return 1;                                    
        }

        //vertical 
        int fnm1 = tillingproblem(n - 1);       //int fnm1 = tillingproblem(n - 1);

        //horizontal
        int fnm2 = tillingproblem(n - 2);       //int fnm2 = tillingproblem(n - 4);

        int totalways = fnm1 + fnm2;

        return totalways;
    }

    public static void removedupli(String str,int idx,StringBuilder newstr,boolean map[]){
        if(idx == str.length()){
            System.out.println(newstr);
            return;
        }

        char currchar = str.charAt(idx);
        if(map[currchar - 'a'] == true){
            removedupli(str,idx+1,newstr,map);
        }else{
            map[currchar - 'a'] = true;
            removedupli(str,idx+1,newstr.append(currchar),map);
        }


    }

    // friend Pair
    public static int friendpair(int n){
        if(n == 1 || n == 2){
            return n;
        }
        return friendpair(n - 1) + (n - 1) * friendpair(n - 2);
    }

    public static void printbinstring(int n,int lastplace,String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        printbinstring(n-1, 0, str+"0");
        if(lastplace == 0){
            printbinstring(n-1,1,str+"1");
        }
    }

    public static int occurebcekey(int arr[],int key,int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            System.out.println(i);
        }

        return occurebcekey(arr, key, i+1);
    }

    public static void strlenght(String str,int i){
       
    }

    public static void main(String[] args) {
        // System.out.println(tillingproblem(5));
        // String str = "bbhhuvannraathood";
        // removedupli(str,0,new StringBuilder(""),new boolean[26]);
        // System.out.println(friendpair(5));
        // printbinstring(3,0,"");
        int arr[]= {1,2,3,4,5,3,5,3};
        // int key = 3;
        occurebcekey(arr, 3, 0);
    }
}
