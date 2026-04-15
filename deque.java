import java.util.*;
public class deque{
    //implementation of stack using deque
    static class stack{
        Deque<Integer> dq = new LinkedList<>();

        public void push(int data){
            dq.addLast(data);
        }
        public int pop(){
            return dq.removeLast();
        }
        public int peek(){
            return dq.getLast();
        }

    }
    //implementation of queue using deque
    static class queue{
        Deque<Integer> dq = new LinkedList<>();

        public void add(int data){
            dq.addLast(data);
        }
        public int remove(){
            return dq.removeFirst();
        }
        public int peek(){
            return dq.getFirst();
        }

    }
    public static void main(String[] args) {
    //     Deque<Integer> dq = new LinkedList<>();
    //     dq.addFirst(399);
    //     dq.addFirst(299);
    //     dq.addLast(499);
    //     System.out.println(dq);
    //     dq.removeFirst();
    //     System.out.println(dq);
    //     dq.removeLast();
    //     System.out.println(dq);

    stack s = new stack();
    s.push(20);
    s.push(30);
    s.push(40);
    System.out.println(s.peek());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    
    }
}