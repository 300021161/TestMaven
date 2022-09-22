package prefixPackage;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("adb2f");
        lines.add("abb2f");
        lines.add("aab2f");
        lines.add("add2f");
        lines.add("add2f");
        prefixTree pT = new prefixTree();
        for (String l : lines) {
            pT.add(l);
        }
        System.out.println(pT.check("abb2f"));
    }
}
