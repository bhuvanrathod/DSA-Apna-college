import java.util.*;
public class BT{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildtree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildtree(nodes);
            newNode.right = buildtree(nodes);

            return newNode;
        }

        public static void preorder(Node root){
            if(root == null){
                System.out.print("-1"+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){
            if(root == null){
                // System.out.print(" -1 ");
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public static void postorder(Node root){
            if(root == null){
                System.out.print(" -1 ");
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data);
        }

        public static void levelorder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println("");
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

    }

    // height of the binarytree

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh,rh)+1;
    }

    // count no of nodes in tree

    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int leftcount = count(root.left);
        int rightcount = count(root.right);

        return leftcount+rightcount+1;
    }

    // sum of nodes

    public static int sumofnodes(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = sumofnodes(root.left);
        int rightsum = sumofnodes(root.right);

        return leftsum+rightsum+root.data;
    }

    // diameter of tree // O(n2)

    public static int diameter2(Node root){
        if(root == null){
            return 0;
        }
        int leftdia = diameter2(root.left);
        int leftht = height(root.left);
        int rightdia = diameter2(root.right);
        int rightht = height(root.right);

        int selfdia = leftht + rightht +1;

        return Math.max(selfdia,Math.max(leftdia,rightdia));
    }

    // optimize diameter of tree
    
    // int maxDiameter = 0;

    // public int diameterOfBinaryTree(TreeNode root) {
    //     height(root);
    //     return maxDiameter;
    // }

    // int height(TreeNode node) {
    //     if (node == null) {
    //         return 0;
    //     }
    //     int left = height(node.left);
    //     int right = height(node.right);
    //     maxDiameter = Math.max(maxDiameter, left + right);
    //     return 1 + Math.max(left, right);
    // }

    // diameter and height O(n)

    static class info{
        int diam;
        int ht;

        public info(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static info diameter(Node root){
        if(root == null){
            return new info(0,0);
        }

        info leftinfo = diameter(root.left);
        info rightinfo = diameter(root.right);

        int diam =Math.max(Math.max(leftinfo.diam,rightinfo.diam),leftinfo.ht+rightinfo.ht+1);

        int ht = Math.max(leftinfo.ht,rightinfo.ht)+1;

        return new info(diam,ht);
    }

    // subtree of another tree

    public static boolean isidentical(Node node,Node subroot){
        if(node == null && subroot == null){
            return true;
        }else if(node == null || subroot == null || node.data != subroot.data){
            return false;
        }
        if(!isidentical(node.left,subroot.left)){
            return false;
        }
        if(!isidentical(node.right,subroot.right)){
            return false;
        }
        return true;
    }

    public static boolean issubtree(Node root,Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isidentical(root,subroot)){
                return true;
            }
        }
        return issubtree(root.left,subroot) || issubtree(root.right,subroot);
    } 

    // top view of the tree

    static class info1{
        Node node;
        int hd;
        public info1(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topview(Node root){

        //level order
        Queue<info1> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min = 0,max = 0;
        q.add(new info1(root,0));
        q.add(null); 

        while(!q.isEmpty()){
            info1 curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }

                if(curr.node.left != null){
                    q.add(new info1(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new info1(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }   
        for(int i=min; i<= max; i++){
            System.out.println(map.get(i).data+" ");
        }
    }

    public static void kthlevel(Node root,int level,int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data+" ");
            return;
        }

        kthlevel(root.left,level+1,k);
        kthlevel(root.right,level+1,k);
    }

    // lowest common ancestor
    public static boolean getpath(Node root,int n,ArrayList<Node> path){
        if(root == null){
            return false;
        }

        path.add(root);
        if(root.data == n){
            return true;
        }

        boolean foundleft = getpath(root.left,n,path);
        boolean foundright = getpath(root.right,n,path);

        if(foundleft || foundright){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getpath(root,n1,path1);
        getpath(root,n2,path2);

        int i=0;
        for(;i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }

    // optimize lca

    public static Node lca2(Node root,int n1,int n2){
        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca2(root.left,n1,n2);
        Node rightlca = lca2(root.right,n1,n2);

        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }
        return root;
    }

    // min distance b.w teo nodes
    public static int lcadist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftdist = lcadist(root.left,n);
        int rightdist = lcadist(root.right,n);

        if(leftdist == -1 && rightdist == -1){
            return -1;
        }else if(leftdist == -1){
            return rightdist+1;
        }else{
            return leftdist+1;
        }
    }
    public static int mindist(Node root,int n1,int n2){
        Node lca = lca2(root,n1,n2);
        int dist1 = lcadist(lca,n1);
        int dist2 = lcadist(lca,n2);

        return dist1+dist2;
    }

    // kth ancestor of node n

    public static int kthancestor(Node root,int n,int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftdist = kthancestor(root.left, n, k);
        int rightdist = kthancestor(root.right, n, k);

        if(leftdist == -1 && rightdist == -1){
            return -1;
        }

        int max = Math.max(leftdist,rightdist);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }

    // tranform tp sum tree

    public static int transform(Node root){
        if(root == null){
            return 0;
        }

        int leftchild = transform(root.left);
        int rightchild = transform(root.right);

        int data = root.data;

        int newleft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;

        root.data = leftchild + rightchild + newleft + newright;

        return data;
    }

    public static void preordert(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preordert(root.left);
        preordert(root.right);
    }
    public static void main(String[] args){
        // BinaryTree bt = new BinaryTree();
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // Node root = bt.buildtree(nodes);
        // // System.out.println(root.data);
        // bt.levelorder(root);

        BT tr = new BT();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(6);

        transform(root);
        preordert(root);

        int k = 3;
        // tr.kthancestor(root,4,1);
        // System.out.println(tr.mindist(root,4,6)+" ");

        // Node subroot = new Node(2);
        // subroot.left = new Node(4);
        // subroot.right = new Node(5);

        // System.out.println(issubtree(root,subroot));

    }
}