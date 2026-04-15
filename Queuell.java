import java.util.*;
public class Queuell{
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // public Node front = null;
    // public Node rear = null;

    // public boolean isEmpty(){
    //     return front == null && rear == null;
    // }

    // public void add(int data){
    //     Node newNode = new Node(data);
    //     if(front == null){
    //         front = rear = newNode;
    //     }else{
    //         rear.next = newNode;
    //         rear = newNode;
    //     }
    // }

    // public int remove(){
    //     if(isEmpty()){
    //         return -1;
    //     }
    //     int fro = front.data;
    //     if(front == rear){
    //         front = rear = null;
    //     }else{
    //         front = front.next;
    //     }
    //     return fro;
    // }

    // public int peek(){
    //     if(isEmpty()){
    //         return -1;
    //     }
    //     return front.data;
    // }

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public boolean isEmpty(){
        return s1.isEmpty();
    }

    public void addd(int data){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(data);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int removee(){
        if(isEmpty()){
            return -1;
        }
        return s1.pop();
    }

    public int peekk(){
        if(isEmpty()){
            return -1;
        }
        return s1.peek();
    }
    public class stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        
        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(!isEmpty()){
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }


    // print first non repeating character in a stream of characters    
    public static void printnonrep(String str){
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i< str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(" "+ -1);
            }else{
                System.out.print(" "+ q.peek());
            }
        }
    }

    public static void main(String[] args) {
        Queuell q = new Queuell();
        String str = "aabccxb";
        printnonrep(str);
        // Queue<Integer> q = new LinkedList<>();
        // q.addd(10);
        // q.addd(20);
        // q.addd(30);
        // while(!q.isEmpty()){
        //     System.out.println(q.peekk());
        //     q.removee();
            
        // }

        // stack s = new Queuell().new stack();
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        
        
    }
}