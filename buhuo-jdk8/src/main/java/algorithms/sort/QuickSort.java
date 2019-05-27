package algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/*
 * ��������
 * 
 * ��ð������Ļ����ϣ�ʹ���˷��η�,ѡ��һ��Ԫ����Ϊpivot��
 */
public class QuickSort {

	public static void main(String[] args) {
//		int[] arr = new int[]{3, 1, 2, 4, 8, 6, 5};
		int[] arr = new int[]{5, 3, 9, 2, 6, 4, 8};
		
		
		System.out.println("����ǰ�� "+Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println("����� "+Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		if(startIndex < endIndex) {
//			int index = wakenPartition(arr, startIndex, endIndex); //�ڿӷ�
			int index = pointerPartition(arr, startIndex, endIndex); //ָ�뷨
			quickSort(arr, 0, index - 1);
			quickSort(arr, index + 1, endIndex);
		}
	}
	
	/*
	 * ָ�뷨
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
	 * �ڿӷ�
	 * 
	 * 
	 */
	public static int wakenPartition(int[] arr, int startIndex, int endIndex) {
		int left = startIndex;
		int right = endIndex;
		int index = startIndex; //��λ
		int pivot = arr[startIndex]; //��׼Ԫ��
		
		while(left < right) {
			while(left < right) {
				if(arr[right] < pivot) { //�ȴ��ұ�����������ұ�Ԫ�ر�pivotС���򽫸�Ԫ���Ƶ��ɵ�index����λ����������λ����Ϊindex(�µĿ�λ)
					arr[index] = arr[right];
					index = right;
					left ++;
					break;
				}
				
				right --;
			}
			
			while(left < right) {
				if(arr[left] > pivot) { //������ߣ�������Ԫ�ر�pivot���򽫸�Ԫ���Ƶ��ɵ�index����λ����������λ����Ϊindex(�µĿ�λ)
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
