package algorithms.redblacktree;

public class RBTreeTest {

//	private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
	private static final int a[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
	private static final boolean mDebugInsert = true;    // "����"�����ļ�⿪��(false���رգ�true����)
    private static final boolean mDebugDelete = true;    // "ɾ��"�����ļ�⿪��(false���رգ�true����)
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, ilen = a.length;
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        
		System.out.printf("== ԭʼ����: ");
        for(i=0; i<ilen; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
        
        for(i=0; i<ilen; i++) {
            tree.insert(a[i]);
             // ����mDebugInsert=true,����"��Ӻ���"
             if (mDebugInsert) {
                 System.out.printf("== ��ӽڵ�: %d\n", a[i]);
                 System.out.printf("== ������ϸ��Ϣ: \n");
                 tree.print();
                 System.out.printf("\n");
             }
         }
	}

}
