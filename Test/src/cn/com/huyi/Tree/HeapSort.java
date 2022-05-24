package cn.com.huyi.Tree;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;

/**
 * @title: HeapSort
 * @Author SXSQ
 * @Description //TODO 堆排序实现 时间复杂度：O(nlogn)
 * @Date 2022/4/26 10:55
 **/

/**
 * 堆排序的基本思想：
 * 1）将待排序序列构造成一个大顶堆
 * 2）此时，整个序列的最大值就是堆顶的根结点
 * 3）将其与末尾元素进行交换，此时末尾就为最大值
 * 4）然后将剩余的n-1个元素重新构成一个堆，这样就会得到n个元素的次小值。重复，便得到一个有序序列
 */
public class HeapSort {
    public static void main(String[] args) {
        int intArr[] = {4,6,8,2,4,1,-1,90,43,3,4,5,9};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(intArr);
    }

    public void heapSort(int [] intArr){
        System.out.println("堆排序：");
        int temp = 0;
//        adajustHeap(intArr,1,intArr.length);
//        System.out.println("第一次："+Arrays.toString(intArr));//[4, 9, 8, 5, 6]
//        adajustHeap(intArr,0,intArr.length);
//        System.out.println("第二次："+Arrays.toString(intArr));//[9, 6, 8, 5, 4]

        //intArr.length / 2 - 1 :表示非叶子结点的个数，从右到左，从下到上
        for (int i = intArr.length / 2 - 1; i >= 0; i--) {
            adajustHeap(intArr,i,intArr.length);
        }
        for (int j = intArr.length - 1 ; j > 0 ; j--){
            temp = intArr[j];
            intArr[j] = intArr[0];
            intArr[0] = temp;
            adajustHeap(intArr,0,j);
        }
        System.out.println(Arrays.toString(intArr));
    }

    //将一个数组调整成为一个大顶堆
    /**
     *
     * @param arr 调整的数组
     * @param i 表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素进行调整,length在逐渐变小
     */
    public static void adajustHeap(int [] arr ,int i, int length){
        //先取出当前元素的，保存在临时变量中
        int temp = arr[i];
        //k为index为i的左子结点的index
        for (int k = getLeftIndex(i); k < length; k = getLeftIndex(k)) {
            if (k+1 < length && arr[k] < arr[k+1]) {//当index为i的左子结点的值小于其右子结点的值时
                k++; //k指针指向右结点
            }
            if (arr[k] > temp){//当子结点大于当前结点
                arr[i] = arr[k]; //把较大的结点赋值给当前结点
                i = k; //
                // !! i指向k，继续循环比较
            } else {
                break;
            }
            //当for循环结束后，我们已经将以i为父结点的树的最大值放在了最顶部
            arr[i] = temp;//将temp值放到原来子结点的位置；
        }
    }

    //获取index为i的结点的左子结点的index
    public static int getLeftIndex(int i){ return i * 2 + 1 ;}

    //获取index为i的结点的右子结点的index
    public static int getRightIndex(int i){ return i * 2 + 2 ;}
}
