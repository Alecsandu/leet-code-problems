public class ReverseLinkedList {

    public static void main(String[] args) {
        Solver solver = new Solver();
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        var res = solver.reverseListRecursive(l1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    private static class Solver {
        ListNode reverseList(ListNode head) {
            ListNode prev = null, curr = head;
            while (curr != null) {
                var temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

        ListNode reverseListRecursive(ListNode head) {
            if (head == null || head.next == null)
                return head;

            var newHead = reverseListRecursive(head.next);
            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
