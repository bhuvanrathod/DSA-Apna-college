import java.util.*;
public class stackLL{
        public class Node{
            int data;
            Node next;
            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        public static Node head = null;
        // public static int size;

        // public static boolean isempty(){
        //     return head == null;
        // }

        // public void push(int data){
        //     Node newNode = new Node(data);
        //     if(head == null){
        //         head = newNode;
        //         return;
        //     }
        //     newNode.next = head;
        //     head = newNode;
        // }

        // public int pop(){
        //     if(head == null){
        //         return -1;
        //     }
        //     int top = head.data;
        //     head = head.next;
        //     return top;
        // }

        // public int peek(){
        //     if(head == null){
        //         return -1;
        //     }
        //     return head.data;
        // }

        //push at bottom of stack

        public static void pushatbottom(Stack<Integer> s,int data){
            if(s.isEmpty()){
                s.push(data);
                return;
            }
            int top = s.pop();
            pushatbottom(s,data);
            s.push(top);
        }

        // reverse a string using stack

        public static String reversestring(String str){
            Stack<Character> s = new Stack<>();
            int idx = 0;
            while(idx < str.length()){
                s.push(str.charAt(idx));
                idx++;
            }

            StringBuilder result = new StringBuilder("");

            while(!s.isEmpty()){
                char curr = s.pop();
                result.append(curr);
            }

            return result.toString();
        }

        //reverse stack

        public static void reversestack(Stack<Integer> s){
            if(s.isEmpty()){
                return;
            }

            int top = s.pop();
            reversestack(s);
            pushatbottom(s,top);
        }

        //stock span problem

        public static void stockspan(int stock[],int span[]){
            Stack<Integer> s = new Stack<>();
            span[0] = 1;
            s.push(0);

            for(int i=0; i<stock.length; i++){
                int currprice = stock[i];
                while(!s.isEmpty() && currprice > stock[s.peek()]){
                    s.pop();
                }
                if(s.isEmpty()){
                    span[i] = i+1;
                }else{
                    int prevhigh = s.peek();
                    span[i] = i - prevhigh;
                }
                s.push(i);
            }
        }

        public static void printstack(Stack<Integer> s){
            while(!s.isEmpty()){
                System.out.println(s.pop());
            }
        }

        // valid paraenthesis
        public static boolean validpar(String str){
            Stack<Character> s = new Stack<>();

            for(int i=0;  i<str.length(); i++){
                char ch = str.charAt(i);

                if(ch == '(' || ch == '{' || ch == '['){
                    s.push(ch);
                }else{
                    if(s.isEmpty()){
                        return false;
                    }

                    if((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                        s.pop();
                    }else{
                        return false;
                    }
                }

            }
            if(!s.isEmpty()){
                return false;
            }
            return true;
        }

        // maxArea in histogram

        public static void maxArea(int arr[]){
            int maxarea = 0;
            int nsr[] = new int[arr.length];
            int nsl[] = new int[arr.length];
            Stack<Integer> s = new Stack<>();

            // next smaller right
            for(int i=arr.length-1; i>=0; i--){
                while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    nsr[i] = arr.length;
                }else{
                    nsr[i] = s.peek();
                }
                s.push(i);
            }

            // next smaller left
            s = new Stack<>();
            for(int i=0; i<arr.length; i++){
                while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    nsl[i] = -1;
                }else{
                    nsl[i] = s.peek();
                }
                s.push(i);
            }

            // max area
            for(int i=0; i<arr.length; i++){
                int height = arr[i];
                int width = nsr[i] - nsl[i] - 1;
                int currarea = height * width;
                maxarea = Math.max(maxarea, currarea);
            }
            System.out.println(maxarea);
        }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);
        // String str = "({[]}())";
        // System.out.println(validpar(str));
        // stackLL s = new stackLL();
        // Stack<Integer> s = new Stack<>();
        // // int arr[] = {6,8,0,1,3};
        //   int nextgreater[] = new int[arr.length];
        // // //   next greater element right
        // // for(int i=arr.length-1; i>=0; i--){   // next greater element left reverse loop

        //    // while(!s.isEmpty() && arr[s.peek()] <= arr[i]){    // next smaller element reverse condition arr[s.peek()] >= arr[i]
        //      //   s.pop();
        //  //   }

        //    // if(s.isEmpty()){
        //      //   nextgreater[i] = -1;
        //   //  }else{
        //     //    nextgreater[i] = arr[s.peek()];
        //    // }

        //   //  s.push(i);
        // //}

        // //for(int i=0; i<nextgreater.length; i++){
        //   //  System.out.println(nextgreater[i]);
        // //}

        
        // int stock[] = {100,80,60,70,60,85,100};
        // int span[] = new int[stock.length];
        // stockspan(stock,span);
        // for(int i=0; i<span.length; i++){
        //     System.out.println(span[i]);
        // }

        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushatbottom(s, 5);
        // String str = "Bhuvan rathod";
        // String res = reversestring("Bhuvan rathod");
        // System.out.println(res);
        // printstack(s);
        // reversestack(s);
        // printstack(s);
        
        
    }
}