public class trei{
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    //insert in trie
    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i=0 ; i < word.length() ; i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // serach in trie

    public static boolean search(String key){
        Node curr = root;
        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    // word break problem

    public static boolean wordbreak(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0,i) ) && wordbreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    // // prefic proplem

    // static class Node{
    //     Node children[] = new Node[26];
    //     boolean eow = false;
    //     int freq;

    //     public Node(){
    //         for(int i=0; i<26; i++){
    //             children[i] = null;
    //         }
    //         freq = 1;
    //     }
    // }

    // insert in trie
    // public static Node root = new Node();

    // public static void insert(String word){
    //     Node curr = root;
    //     for(int i=0 ; i < word.length() ; i++){
    //         int idx = word.charAt(i) - 'a';
    //         if(curr.children[idx] == null){
    //             curr.children[idx] = new Node();
    //         }else{
    //             curr.children[idx].freq++;
    //         }
    //         curr = curr.children[idx];
    //     }
    //     curr.eow = true;
    // }

    // public static void findprefix(Node root,String ans){
    //     if(root == null){
    //         return;
    //     }
    //     if(root.freq == 1){
    //         System.out.println(ans);
    //         return;
    //     }
    //     for(int i=0; i<root.children.length; i++){
    //         if(root.children[i] != null){
    //             findprefix(root.children[i], ans+(char)(i+'a'));
    //         }
    //     }
    // }

    // starts with prefix

    public static boolean startswith(String prefix){
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    // count unique substring

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    // longest word with all prefix
    public static String ans = "";
    public static void longestword(Node root,StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestword(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args){

        // String str = "apple";
        // insert(str);
        
        String[] words = {"a","banana","app","ap","apply","apple"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        longestword(root,new StringBuilder(""));
        System.out.println(ans);

        // for(int i=0; i<str.length(); i++){
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println();

        // String k = "catsandog";
        // root.freq = -1;
        // findprefix(root,"");
        // System.out.println();
        // System.out.println(search("anya"));
    }
}