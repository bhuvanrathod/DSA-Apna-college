import java.util.*;
public class BST{
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // serach in bst

    public static boolean search(Node root,int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        if(root.data > val){
            return search(root.left,val);
        }else{
            return search(root.right,val);
        }
    }

    // delete node

    public static Node delete(Node root,int val){
        if(root.data < val){
            root.right = delete(root.right,val);
        }else if(root.data > val){
            root.left = delete(root.left,val);
        }else{
            // case-1 delete leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            // case-2 single child node
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                Node is = findinordersuccessor(root.right);
                root.data = is.data;
                root.right = delete(root.right,val);

            }
        }
        return root;
    }

    public static Node findinordersuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    // print in range

    public static void printinrange(Node root,int k1,int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printinrange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printinrange(root.right,k1,k2);
        }else if(root.data < k1){
            printinrange(root.left,k1,k2);
        }else{
            printinrange(root.right,k1,k2);
        }
    }

    //root to leaf

    public static void printpath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println("");
    }
    public static void root2leaf(Node root,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printpath(path);
        }
        root2leaf(root.left,path);
        root2leaf(root.right,path);
        path.remove(path.size()-1);

    }

    // valid bst

    public static boolean isvalidbst(Node root,Node min,Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }
        return isvalidbst(root.left,min,root) && isvalidbst(root.right,root,max);
    }

    // create a mirror

    public static Node createmirror(Node root){
        if(root == null){
            return null;
        }

        Node leftmirror = createmirror(root.left);
        Node rightmirror = createmirror(root.right);

        root.left = rightmirror;
        root.right = leftmirror;

        return root;
    }

   public static Node createbst(int[] arr,int si,int ei){
    if(si > ei){
        return null;
    }
    int mid = (si + ei) / 2;
    Node root = new Node(arr[mid]);
    root.left = createbst(arr, si, mid - 1);
    root.right = createbst(arr, mid + 1, ei);
    return root;
   } 

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        
        preorder(root.right);
    }

    // balance BST

    public static void getinorder(Node root,ArrayList<Integer> inorder1){
        if(root == null){
            return;
        }
        getinorder(root.left,inorder1);
        inorder1.add(root.data);
        getinorder(root.right,inorder1);
    }

    public static Node createBst(ArrayList<Integer> inorder1,int si,int ei){
        if(si > ei){
            return null;
        }
        int mid = (si + ei)/2;
        Node root = new Node(inorder1.get(mid));
        root.left = createBst(inorder1,si,mid-1);
        root.right = createBst(inorder1,mid+1,ei);
        return root;
    }
    public static Node balancebst(Node root){
        // inorder sequence
        ArrayList<Integer> inorder1 = new ArrayList<>();
        getinorder(root,inorder1);
        root = createBst(inorder1,0,inorder1.size()-1);
        return root;
    }

    // size of largest BST in bt

    static class info{
        boolean isbst;
        int size;
        int min;
        int max;

        info(boolean isbst,int size,int min,int max){
            this.isbst = isbst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxbst = 0;

    public static info largestbst(Node root){
        if(root == null){
            return new info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        info leftinfo = largestbst(root.left);
        info rightinfo = largestbst(root.right);

        int size = leftinfo.size + rightinfo.size + 1;
        int min = Math.min(root.data,Math.min(leftinfo.min,rightinfo.min));
        int max = Math.max(root.data,Math.max(leftinfo.max,rightinfo.max));

        if(root.data <= leftinfo.max || root.data >= rightinfo.min){
            return new info(false,size,min,max);
        }
        if(leftinfo.isbst && rightinfo.isbst){
            maxbst = Math.max(maxbst,size);
            return new info(true,size,min,max);
        }
        return new info(false,size,min,max);
    }

    public static void main(String[] args){
        BST bst = new BST();
        // int val[] = {3,5,8,10,11,12};
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        info Info = largestbst(root);
        System.out.println("largest bst is: "+maxbst);
        // balancebst(root);
        // preorder(root);
        // Node root = null;
        // Node root = createbst(val, 0, val.length-1);
        // inorder(root);
        // for(int i=0; i<val.length; i++){
        //     root = bst.insert(root,val[i]);
        // }
        // preorder(root);
        // System.out.println("");
        // root = createmirror(root);
        // preorder(root);
        // System.out.println(bst.isvalidbst(root,null,null));
        // bst.inorder(root);
        // System.out.println("");
        // root2leaf(root,new ArrayList<Integer>());
        // printinrange(root,5,12);
        // bst.delete(root,3);
        // bst.inorder(root);
        // System.out.println(bst.search(root, 4));
    }
}