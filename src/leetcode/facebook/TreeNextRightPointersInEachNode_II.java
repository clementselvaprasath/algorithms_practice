package leetcode.facebook;

public class TreeNextRightPointersInEachNode_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cursor = null;
        TreeLinkNode head = null;
        while (root != null) {
            while (root != null) {
                if (root.left != null) {
                    if (cursor == null) {
                        head = root.left;
                        cursor = head;
                    } else {
                        cursor.next = root.left;
                        cursor = cursor.next;
                    }
                }
                if (root.right != null) {
                    if (cursor == null) {
                        head = root.right;
                        cursor = head;
                    } else {
                        cursor.next = root.right;
                        cursor = cursor.next;
                    }
                }
                root = root.next;
            }
            root = head;
            cursor = null;
            head = null;
        }
    }
	
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
}
