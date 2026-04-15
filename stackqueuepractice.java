import java.util.*;
public class stackqueuepractice{
    public class Node{
        char data;
        Node next;

        public Node(char data){
            this.data = data;
            this.next = null;
        }
    }
    public boolean palindromll(Node head){
        Stack<Character> s1 = new Stack<>();
        Node temp = head;
        while(temp != null){
            s1.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.data != s1.pop()){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
    public static void main(String[] args) {
        stackqueuepractice ll = new stackqueuepractice();
        Node head = ll.new Node('A');
        head.next = ll.new Node('B');  
        head.next.next = ll.new Node('C');
        head.next.next.next = ll.new Node('B');
        head.next.next.next.next = ll.new Node('B');
        System.out.println(ll.palindromll(head));
    }
}