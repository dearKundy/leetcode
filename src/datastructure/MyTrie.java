package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树
 *
 * @author kundy
 * @date 2022/5/16 10:08 AM
 */
public class MyTrie {

    private TrieNode root;

    private class TrieNode {
        /**
         * 节点值
         */
        private Character value;
        /**
         * 孩子节点
         */
        private Map<Character, TrieNode> childMap;
        /**
         * 当前节点是否已结束
         */
        private Boolean isEnd;

        public TrieNode(Character value) {
            this.value = value;
            this.childMap = new HashMap<>();
            this.isEnd = false;
        }

    }

    public MyTrie() {
        this.root = new TrieNode(' ');
    }

    public void insert(String word) {

        char[] chars = word.toCharArray();
        TrieNode curNode = root;

        for (char aChar : chars) {

            if (!curNode.childMap.containsKey(aChar)) {
                curNode.childMap.put(aChar, new TrieNode(aChar));
            }
            curNode = curNode.childMap.get(aChar);

        }

        curNode.isEnd = true;

    }

    public boolean search(String word) {
        TrieNode trieNode = this.searchPrefix(word);
        return trieNode != null && trieNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        return this.searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        char[] chars = word.toCharArray();
        TrieNode curNode = root;
        for (char aChar : chars) {
            if (!curNode.childMap.containsKey(aChar)) {
                return null;
            }
            curNode = curNode.childMap.get(aChar);
        }

        return curNode;
    }

    public static void main(String[] args) {
        MyTrie myTrie = new MyTrie();
        myTrie.insert("apple");
        System.out.println(myTrie.search("apple"));
        System.out.println(myTrie.search("app"));
        System.out.println(myTrie.startsWith("app"));
        myTrie.insert("app");
        System.out.println(myTrie.search("app"));
    }

}
