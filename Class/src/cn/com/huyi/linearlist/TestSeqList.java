package cn.com.huyi.linearlist;

import org.junit.Test;

/**
 * @title: TestSeqList
 * @Author SXSQ
 * @Description //TODO
 * @Date 2022/3/30 20:50
 **/

public class TestSeqList {
    @Test
    public void testSeqListremoveALL(){
        SeqList<Integer> seqList = new SeqList<>();
		for(int i=0;i<30;i++) {
			Integer data = (int)(Math.random()*26)+65;
			seqList.insert(data);
		}
        System.out.println("删除前："+seqList);
		seqList.removeALL(77);
        System.out.println("删除后："+seqList);
    }

    @Test
    public void testreSeqListrplaceFirst(){
        Integer[] a = {1,2,1,4,5,1,4};
        SeqList<Integer> seqList = new SeqList<Integer>();
        for (Integer key : a){
            seqList.insert(key);
        }
        System.out.println("替换前："+seqList);
        seqList.replaceFirst(4,9);
        System.out.println("将第一个4替换成9");
        System.out.println("替换后："+seqList);
    }

    @Test
    public void testSeqListsearchLast(){
        Integer[] a = {1,2,1,4,5,1,4};
        SeqList<Integer> seqList = new SeqList<Integer>();
        for (Integer key : a){
            seqList.insert(key);
        }
        System.out.println(seqList);
        int i = seqList.searchLast(1);
        System.out.println("最后一个1位于:"+i);
    }
}
