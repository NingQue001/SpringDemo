package algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/*
 * 快速排序
 * 
 * 在冒泡排序的基础上，使用了分治法,选择一个元素作为pivot，
 */
public class QuickSort {

	public static void main(String[] args) {
//		int[] arr = new int[]{3, 1, 2, 4, 8, 6, 5};
		int[] arr = new int[]{5, 3, 9, 2, 6, 4, 8};
		
		
		System.out.println("排序前： "+Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("排序后： "+Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		if(startIndex < endIndex) {
//			int index = wakenPartition(arr, startIndex, endIndex); //挖坑法
			int index = pointerPartition(arr, startIndex, endIndex); //指针法
			quickSort(arr, 0, index - 1);
			quickSort(arr, index + 1, endIndex);
		}
	}
	
	/*
	 * 指针法
	 */
	public static int pointerPartition(int[] arr, int startIndex, int endIndex) {
		int left = startIndex;
		int right = endIndex;
		int pivot = arr[startIndex];
		
		while(left < right) {
			while(left < right && arr[right] > pivot) {
				right --;
			}
			
			while(left < right && arr[left] <= pivot) {
				left ++;
			}
			
			if(left < right) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
		}
		
		arr[startIndex] = arr[left];
		arr[left] = pivot;
		return left;
	}
	
	/*
	 * 挖坑法
	 * 
	 * 
	 */
	public static int wakenPartition(int[] arr, int startIndex, int endIndex) {
		int left = startIndex;
		int right = endIndex;
		int index = startIndex; //坑位
		int pivot = arr[startIndex]; //基准元素
		
		while(left < right) {
			while(left < right) {
				if(arr[right] < pivot) { //先从右边搜索，如果右边元素比pivot小，则将该元素移到旧的index（坑位），并将该位置置为index(新的坑位)
					arr[index] = arr[right];
					index = right;
					left ++;
					break;
				}
				
				right --;
			}
			
			while(left < right) {
				if(arr[left] > pivot) { //搜索左边，如果左边元素比pivot大，则将该元素移到旧的index（坑位），并将该位置置为index(新的坑位)
					arr[index] = arr[left];
					index = left;
					right --;
					break;
				}
				
				left ++;
			}
		}
		
		arr[index] = pivot;
		return index;
	}

}
