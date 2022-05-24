package cn.com.huyi.problem;

import cn.com.huyi.linearlist.SeqList;


public class LinearListTest {
	public static void main(String[] args) {
//		SeqList<Integer> seqList = new SeqList<>();
//		for(int i=0;i<30;i++) {
//			Integer data = (int)(Math.random()*26)+65;
//			seqList.insert(data);
//		}
//		System.out.println("partition前 :"+seqList);
//		seqList.partition();
//		System.out.println("partition后 :"+seqList);

		Integer[] a = {1,2,1,4,5,1,4};
		SeqList<Integer> seqList = new SeqList<Integer>();
		for (Integer key : a){
			seqList.insert(key);
		}
//		System.out.println(seqList+":"+seqList.size());
//		seqList.removeALL(1);
//		System.out.println(seqList);

//		seqList.replaceFirst(9,2);
//		System.out.println(seqList);

		System.out.println(seqList.searchLast(1));

	}
}
