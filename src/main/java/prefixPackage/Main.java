package prefixPackage;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("adb2f");
        lines.add("abb2f");
        lines.add("abb3f");
        lines.add("aab2f");
        lines.add("add2f");
        lines.add("add2f");
        lines.add("add2d");
        prefixTree pT = new prefixTree();
        for (String l : lines) {
            pT.add(l);
        }
        System.out.println(pT.check("abb2f"));
        System.out.println(pT.check("abb3f"));
        pT.delete("abb2f");
        System.out.println(pT.check("abb2f"));
        System.out.println(pT.check("abb3f"));
        System.out.println(pT.check("add2d"));
    }
}
