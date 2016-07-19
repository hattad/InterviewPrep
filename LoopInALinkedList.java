import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class LoopInALinkedList
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Node head = null;
        boolean loopExists = findIfLoopExistsUsingFloyds(head);
        pw.println("Loops existed by floyds? : " + loopExists);
        loopExists = findIfLoopExistsUsingBrents(head);
        pw.println("Loops existed by brents? : " + loopExists);
        int length = findLengthOfTheLoop(head);
        pw.println("Length of the loop: " + length);
        Node start = startNodeOfTheLoop(head);
        pw.println("Start node of the loop: " + start.data);

        pw.close();
    }

    private static int findLengthOfTheLoop(Node head)
    {
        Node fastPtr = head;
        Node slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        int length = 0;
        if (loopExists) {
            do {
                slowPtr = slowPtr.next;
                length++;
            } while (slowPtr != fastPtr);
        }

        return length;
    }

    private static Node startNodeOfTheLoop(Node head)
    {
        Node fastPtr = head;
        Node slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            return fastPtr;
        } else
            return null;
    }

    private static boolean findIfLoopExistsUsingFloyds(Node head)
    {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return true;

        }
        return false;
    }

    private static boolean findIfLoopExistsUsingBrents(Node head)
    {
        Node movingPtr = head;
        Node stationaryPtr = head;
        int stepsTaken = 0;
        int stepLimit = 2;
        while (movingPtr != null) {
            movingPtr = movingPtr.next;
            stepsTaken++;
            if (movingPtr == stationaryPtr)
                return true;
            if (stepsTaken == stepLimit) {
                stepLimit = 2 * stepLimit;
                stepsTaken = 0;
                stationaryPtr = movingPtr;
            }
        }
        return false;
    }
}