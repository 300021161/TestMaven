package prefixPackage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class prefixTree {
    private final prefixTreeNode root = new prefixTreeNode(' ');

    public void add(String word){
        root.add(word);
    }

    public boolean check(String word){
        return root.check(word);
    }

    public void delete(String word){
        root.delete(word);
    }

    private class prefixTreeNode {
        private final char value;

        ArrayList<prefixTreeNode> children;

        private prefixTreeNode(char val) {
            this.value = val;
        }
        private void add(String word) {
            if (word.length() == 0) {
                return;
            }
            if (children == null) {
                children = new ArrayList<>();
            }
            char c = word.charAt(0);
            prefixTreeNode pf = null;
            for (prefixTreeNode node : children) {
                if (node.value == c) {
                    pf = node;
                    break;
                }
            }
            if (pf == null) {
                pf = new prefixTreeNode(c);
                children.add(pf);
            }
            pf.add(word.substring(1));
        }

        private boolean check(String word){
            prefixTreeNode nodeNow = root;
            for(char c : word.toCharArray()){
                prefixTreeNode nodeCheck = null;
                for(prefixTreeNode node : nodeNow.children){
                    if(node.value == c){
                        nodeCheck = node;
                        break;
                    }
                }
                if(nodeCheck == null){
                    return false;
                }
                nodeNow = nodeCheck;
            }
            return true;
        }

        private void delete(String word){

        }

    }
}