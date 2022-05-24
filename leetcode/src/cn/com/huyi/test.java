package cn.com.huyi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: test
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/4/19 14:52
 **/

public class test {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        int maxindex = 0;
        int maxStr = 0;
        for (int i = 0; i < d.size(); i++) {
            if (isSubstr(s,d.get(i))){
                if(d.get(i).length()>maxStr) {
                    maxStr=d.get(i).length();
                    maxindex = Math.max(i,maxindex);
                }
            }
        }
        longestWord = d.get(maxindex);
        return longestWord;
    }

    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    @Test
    public void test(){
        List<String> a = new ArrayList<String>(){};
        a.add( "ale");
        a.add("applea");
        a.add("apple");
        a.add("abp");
        String abpcplea = findLongestWord("abpcplea", a);
        System.out.println(abpcplea);
        int i = climbStairs(10);
        System.out.println(i);
    }
}
