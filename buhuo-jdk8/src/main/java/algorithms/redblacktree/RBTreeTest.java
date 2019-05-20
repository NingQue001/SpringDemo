package algorithms.redblacktree;

public class RBTreeTest {

//	private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
	private static final int a[] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
	private static final boolean mDebugInsert = true;    // "插入"动作的检测开关(false，关闭；true，打开)
    private static final boolean mDebugDelete = true;    // "删除"动作的检测开关(false，关闭；true，打开)
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, ilen = a.length;
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        
		System.out.printf("== 原始数据: ");
        for(i=0; i<ilen; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
        
        for(i=0; i<ilen; i++) {
            tree.insert(a[i]);
             // 设置mDebugInsert=true,测试"添加函数"
             if (mDebugInsert) {
                 System.out.printf("== 添加节点: %d\n", a[i]);
                 System.out.printf("== 树的详细信息: \n");
                 tree.print();
                 System.out.printf("\n");
             }
         }
	}

}
