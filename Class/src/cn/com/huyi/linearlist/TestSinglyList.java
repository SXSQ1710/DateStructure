package cn.com.huyi.linearlist;

import org.junit.Test;

public class TestSinglyList {

    //测试SinglyList中的Partition方法
    @Test
    public void testSinglyListPartition(){
        SinglyList<Integer> singlyList = new SinglyList<>();
        for(int i=0;i<30;i++) {
            Integer data = (int)(Math.random()*26)+65;
            singlyList.insert(data);
        }
        System.out.println("partition前 :"+singlyList);
        System.out.println("基准为 :"+singlyList.head.next.data);
        singlyList.partition();
        System.out.println("partition后 :"+singlyList);
    }

    @Test
    public void testSinglyListreversal(){
        SinglyList<Integer> singlyList = new SinglyList<>();
        for(int i=0;i<30;i++) {
            Integer data = (int)(Math.random()*26)+65;
            singlyList.insert(data);
        }
        System.out.println("reversal前 :"+singlyList);
        singlyList.reversal();
        System.out.println("reversal后 :"+singlyList);
    }

    @Test
    public void testSinglyListlast(){
        SinglyList<Integer> singlyList = new SinglyList<>();
        for(int i=0;i<23;i++) {
            Integer data = (int)(Math.random()*26)+65;
            singlyList.insert(data);
        }
        System.out.println(singlyList);
        long start1 = System.nanoTime();
        Node<Integer> last1 = singlyList.last1();
        long end1 = System.nanoTime();
        System.out.println(end1-start1);
        System.out.println(last1);
        long start2 = System.nanoTime();
        Node<Integer> last2 = singlyList.last2(singlyList.head);
        long end2 = System.nanoTime();
        System.out.println(end2-start2);
        System.out.println(last2);


    }

    @Test
    public void testSinglyListprev(){
        SinglyList<Integer> singlyList = new SinglyList<>();
        for(int i=0;i<10;i++) {
            Integer data = (int)(Math.random()*26)+65;
            singlyList.insert(data);
        }
        System.out.println(singlyList);
        Node<Integer> integerNode = new Node<>(500,null);
        singlyList.insert(5,integerNode);
        System.out.println(singlyList);
        Node<Integer> prev = singlyList.prev(integerNode);
        System.out.println(prev.data);
    }

    @Test
    public void testSinglyListsubList() throws Exception{
        SinglyList<Integer> singlyList = new SinglyList<>();
        for(int i=0;i<13;i++) {
            Integer data = (int)(Math.random()*26)+65;
            singlyList.insert(data);
        }
        System.out.println(singlyList);
        SinglyList<Integer> singlyList1 = singlyList.subList(4, 10);
        System.out.println(singlyList1);
    }

    @Test
    public void testPooi(){
        Pooi a = new Pooi(1,2);
        Pooi b = new Pooi(2,2);
        System.out.println(a.compareTo(b));
        System.out.println(0/2);
        System.out.println(1%2);
    }

    @Test
    public void testaddALL(){
        Pooi [] a = {new Pooi(2,0),new Pooi(-1,1),new Pooi(1,2),
                new Pooi(-9,3),new Pooi(2,6)};
        Pooi [] b = {new Pooi(-1,0),new Pooi(1,1),new Pooi(-1,2),
                new Pooi(10,4),new Pooi(-3,5),new Pooi(5,7),new Pooi(9,8)};
        SinglyList<Pooi> A = new SinglyList<Pooi>(a);
        SinglyList<Pooi> B = new SinglyList<Pooi>(b);
        System.out.println("A:"+A);
        System.out.println("B:"+B);
        SinglyList<Pooi> pooiSinglyList = SinglyList.addALL(A, B);
        System.out.println("A+B:"+pooiSinglyList);
    }
}
