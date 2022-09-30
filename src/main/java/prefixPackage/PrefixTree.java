package prefixPackage;

import java.util.ArrayList;

public class PrefixTree {
    private final PrefixTreeNode root = new PrefixTreeNode(' ');

    public void add(String word,String s){
        root.add(word,s);
    }

    public boolean check(String word){
        return root.getNode(word) != null;
    }

    public String getMeaning(String key){
        return root.getMeaning(key);
    }

    public void delete(String word){
        root.delete(word);
    }

    private class PrefixTreeNode {
        private final char key;

        private String meaning = null;

        ArrayList<PrefixTreeNode> children;

        private PrefixTreeNode(char val) {
            this.key = val;
        }

        private void add(String key, String meaning) {
            if (key.length() == 0) {
                return;
            }
            if (children == null) {
                children = new ArrayList<>();
            }
            char c = key.charAt(0);
            PrefixTreeNode pf = null;
            for (PrefixTreeNode node : children) {
                if (node.key == c) {
                    pf = node;
                    if (key.length() == 1) pf.meaning = meaning;
                    break;
                }
            }
            if (pf == null) {
                pf = new PrefixTreeNode(c);
                if (key.length() == 1) pf.meaning = meaning;
                children.add(pf);
            }
            pf.add(key.substring(1), meaning);
        }

        private PrefixTreeNode getNode(String word){ // node null добавить исключение для null для полей которые не должны быть null
            PrefixTreeNode nodeNow = root;     // unit test
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                PrefixTreeNode nodeCheck = null;
                if(nodeNow.children == null) return null;
                for (PrefixTreeNode node : nodeNow.children) {
                    if (node.key == c) {
                        nodeCheck = node;
                        if(i == chars.length-1 && nodeCheck.meaning!=null) return nodeCheck;
                        break;
                    }
                }
                if (nodeCheck == null) {
                    return null;
                }
                nodeNow = nodeCheck;
            }
            return null;
        }

        private void delete(String word) {
            PrefixTreeNode node = getNode(word);
            if(node!=null) node.meaning = null;
        }

        private String getMeaning(String key){
            PrefixTreeNode node = getNode(key);
            if(node!=null) return node.meaning;
            else return null;
        }
    }
}