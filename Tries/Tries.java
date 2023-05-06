import java.util.ArrayList;
import java.util.List;

public class Tries {

    private TrieNode root;

    public Tries() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char letter =  word.charAt(i);
            if (cur.children[letter - 'a'] == null) {
                cur.children[letter - 'a'] = new TrieNode(letter);
            }
            cur = cur.children[letter - 'a'];
        } 
        cur.wordEnds = true;
    }

    public boolean contains(String word) {
        TrieNode node = getNode(word);
        if (node != null && node.wordEnds) {
            return true;
        }
        return false;
    }

    public TrieNode getNode(String word){
        TrieNode cur = root; 
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (cur.children[letter - 'a'] == null) {
                return null;
            }
            cur = cur.children[letter - 'a'];
        }
        return cur;
    }

    String autocomplete(String prefix) {
        TrieNode node = root;
        List<Character> res = new ArrayList<Character>();
        char prefixArray[] = prefix.toCharArray();
        for (int i = 0; i < prefixArray.length; i++) {
            node = node.children[prefixArray[i] - 'a'];
            res.add(node.letter);
            /*if (node == null) {
                return "";
            }*/
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
        }
        System.out.println(node.children);
        System.out.println(node.letter);
        return sb.toString();
    }

    

    class TrieNode {
        public char letter;
        public TrieNode[] children = new TrieNode[26];
        public boolean wordEnds;

        public TrieNode(char letter) {
            this.letter = letter;
            wordEnds = false;
        }
    }
}