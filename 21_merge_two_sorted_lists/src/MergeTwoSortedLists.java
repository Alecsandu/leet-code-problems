public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l4;

        l2.next = l3;
        l3.next = l5;

        ListNode newList = new Solver().mergeTwoLists(l1, l2);
        while (newList != null) {
            System.out.println(newList.val);
            newList = newList.next;
        }
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/description/
    private static class Solver {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            if (list1 != null && list2 == null) {
                return list1;
            }
            if (list1 == null) {
                return list2;
            }

            ListNode newList = new ListNode(-1);
            ListNode cur = newList;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }

            if (list1 != null) {
                cur.next = list1;
            }

            if (list2 != null) {
                cur.next = list2;
            }

            return newList.next;
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
