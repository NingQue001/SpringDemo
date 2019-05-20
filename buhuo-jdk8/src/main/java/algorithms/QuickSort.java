package algorithms;

import java.util.Arrays;

import org.junit.Test;

import sun.applet.Main;

public class QuickSort {
	
//	@Test
	public void test() {
//		int[] arr = new int[]{4, 2, 9, 5, 1, 8};
		int[] arr = new int[]{3, 1, 2, 8, 6, 5};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3, 1, 2, 8, 6, 5};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		if(startIndex < endIndex) {
//			int pivotIndex = partition(arr, startIndex, endIndex); //挖坑法
			int pivotIndex = partitionByPointer(arr, startIndex, endIndex); //指针法
			quickSort(arr, startIndex, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, endIndex);
		}
	}
	
	public static int partition(int[] arr, int startIndex, int endIndex) {
		int index = startIndex;
		int left = startIndex;
		int right = endIndex;
		int pivot = arr[startIndex];
		
		while(left < right) {
			while(left < right) {
				if(arr[right] < pivot) {
					arr[index] = arr[right];
					index = right;
					left++;
					break;
				}
				
				right--;
			}
			
			while(left < right) {
				if(arr[left] > pivot) {
					arr[index] = arr[left];
					index = left;
					right--;
					break;
				}
				
				left++;
			}
		}
		
		arr[index] = pivot;
		return index;
	}

	/**
	 * 指针法
	 */
	public static int partitionByPointer(int[] arr, int startIndex, int endIndex) {
		int left = startIndex;
		int right = endIndex;
		int pivot = arr[startIndex];
		
		while(left != right) {
			while(left < right && arr[right] > pivot) {
				right--;
			}
			
			while(left < right && arr[left] <= pivot) {
				left++;
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
}
