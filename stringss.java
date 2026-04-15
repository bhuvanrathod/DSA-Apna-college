public class stringss{

    // public static void printchar(String str){
    //     for(int i=0; i<str.length(); i++){
    //         System.out.println(str.charAt(i)+ " ");
    //     }
    // }

    // check palindrome

    // public static boolean ispalindrome(String str){
    //     for(int i=0; i<(str.length())/2; i++){
    //         int n = str.length();
    //         if(str.charAt(i) != str.charAt(n-1-i)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // smallest path

    // public static float getshortestpath(String path){
    //     int x = 0,y = 0;
    //     for(int i=0; i<path.length(); i++){
    //         char dir = path.charAt(i);

    //         if(dir == 'N'){
    //             y++;
    //         }else if(dir == 'S'){
    //             y--;
    //         }else if(dir == 'W'){
    //             x--;
    //         }else{
    //             x++;
    //         }
    //     }
    //     int x2 = x*x;
    //     int y2 = y*y;

    //     return (float)Math.sqrt(x2 + y2);
    // }

    // substring

    // public static String substringss(String str, int st,int en){
    //     for(int i=st; i<en; i++){
    //         str += str.charAt(i);
    //     }
    //     return str;
    // }

    //  largest string in array

    // public static int laestr(String str[]){
    //     int larstr = Integer.MIN_VALUE;
    //     for(int i=0; i<str.length; i++){
    //         larstr = Math.max(larstr,str[i].length());
    //     }
    //     return larstr;
    // }

    // first letter uppercase

    // public static String touppercases(String str){
    //     StringBuilder sb = new StringBuilder("");
    //     char ch = Character.toUpperCase(str.charAt(0));
    //     sb.append(ch);
    //     for(int i=0; i<str.length(); i++){
    //         if(str.charAt(i) == ' ' && i <str.length()-1){
    //             sb.append(str.charAt(i));
    //             i++;
    //             sb.append(Character.toUpperCase(str.charAt(i)));

    //         }else{
    //             sb.append(str.charAt(i));
    //         }
    //     }
    //     return sb.toString();
    // }

    // string compression

    // public static String compression(String str){
    //     String newstr = "";
    //     for(int i=0; i<str.length(); i++){
    //         int count = 1;
    //         while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
    //             count++;
    //             i++;
    //         }
    //         newstr += str.charAt(i);
    //         if(count > 1){
    //             newstr += String.valueOf(count);
    //         }        
    //     }
    //     return newstr;
    // }

    // compression using string builder

    public static String compression(String str){
        StringBuilder newstr = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            int count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newstr.append(str.charAt(i));
            if(count > 1){
                newstr.append(String.valueOf(count));
            }        
        }
        return newstr.toString();
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        String sbb = "aaabbcccddddd";
        System.out.println(compression(sbb));
        // String name = sc.nextLine();               // sc.next -> take only first word 
        // System.out.println(name);                   // sc.nextLine -> take one full
        // System.out.println(name.length()); 

        // printchar(name);
       
        // System.out.println(ispalindrome(name));
        
        // System.out.println(getshortestpath(name));
        // String str[] = {"apple","mango","pinaple"};
        // String str = "hello world";
        // System.out.println(str.substring(3, 6));
        // System.out.println(laestr(str));
        // System.out.println(substringss(str, 1, 5));


        // largest string in array
        // String largest = str[0];
        // for(int i=1; i<str.length; i++){
        //     if(largest.compareTo(str[i]) < 0){
        //         largest = str[i];
        //     }
        // }
        // System.out.println(largest);

        // String Builder

        // StringBuilder sb = new StringBuilder("");
        // for(char ch='a'; ch<'z'; ch++){
        //     sb.append(ch);
        // }
        // System.out.println(sb);
    }
}