
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class IntersectionOfLinkedLists {
    public int length(ListNode x) {
        int l = 0;
        while (x != null) {
            l += 1;
            x = x.next;
        }
        return l;
    }

    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        int la = length(A);
        int lb = length(B);

        ListNode a = A;
        ListNode b = B;

        while (a != null && b != null) {
            if (a == b) {
                return a;
            }

            if (la > lb) {
                la -= 1;
                a = a.next;
            } else if (la < lb) {
                lb -= 1;
                b = b.next;
            } else {
                a = a.next;
                b = b.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        IntersectionOfLinkedLists solution = new IntersectionOfLinkedLists();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter values for linked list A separated by spaces: ");
        String inputValuesA = scanner.nextLine();
        String[] inputValuesArrayA = inputValuesA.split(" ");
        ListNode A = createLinkedList(inputValuesArrayA);

        System.out.print("Enter values for linked list B separated by spaces: ");
        String inputValuesB = scanner.nextLine();
        String[] inputValuesArrayB = inputValuesB.split(" ");
        ListNode B = createLinkedList(inputValuesArrayB);

        ListNode result = solution.getIntersectionNode(A, B);

        if (result != null) {
            System.out.println("Intersection node value: " + result.val);
        } else {
            System.out.println("No intersection found.");
        }
    }

    public static ListNode createLinkedList(String[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(Integer.parseInt(values[0]));
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i]));
            current = current.next;
        }

        return head;
    }
}
