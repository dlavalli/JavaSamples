package com.lavalliere.daniel.aps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListOps {

    class LinkedListNode {
        private int value;
        private LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
            this.next = null;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }

        public LinkedListNode getNext() {
            return this.next;
        }
    };


    private int[] numbersToSortArray;

    public LinkedListOps(int[] numbersToSortArray) {
        this.numbersToSortArray = numbersToSortArray;
    }

    // Recursively delete the list specified
    private void deleteList(LinkedListNode node) {
        if (node == null) return;
        if (node.next != null) deleteList(node.next);
        node = null;
    }

    private LinkedListNode getLinkedListNodeArray(int[] numbersToSortArray) {
        LinkedListNode head = null;
        LinkedListNode tail = null;
        for(int i=0; i < numbersToSortArray.length; i++) {
            LinkedListNode node = new LinkedListNode(numbersToSortArray[i]);
            if (head == null) {
                head = node;
                tail = node;
            }
            tail.next = node;
            tail = node;
        }
        return head;
    }

    public void insertionSortList(boolean reverse) {   // O(N^2)
        System.out.printf("Using list based %s ordering for array insertion sort: ", (reverse ? "decreasing" : "increasing"));
        printArray(this.numbersToSortArray);

        LinkedListNode head = getLinkedListNodeArray(this.numbersToSortArray);
        LinkedListNode listNode = head;
        while (listNode != null) {
            LinkedListNode firstNode = head;
            LinkedListNode nextNode = head.next;
            while((firstNode != null) && (nextNode != null)) {
                if (reverse) {
                    if (firstNode.getValue() < nextNode.getValue()) {
                        int tmp = nextNode.getValue();
                        nextNode.setValue(firstNode.getValue());
                        firstNode.setValue(tmp);
                    }

                } else {
                    if (firstNode.getValue() > nextNode.getValue()) {
                        int tmp = nextNode.getValue();
                        nextNode.setValue(firstNode.getValue());
                        firstNode.setValue(tmp);
                    }
                }

                LinkedListNode tmpNode = nextNode.next;
                firstNode = nextNode;
                nextNode = tmpNode;
            }
            // Print the sorted list
            // printLinkedList(head);
            listNode = listNode.next;
        }

        // Print the sorted list
        printLinkedList(head);

        // Now cleanup the list
        deleteList(head);

        /*
        printArray(numbersArr);
        int[] sortedCopy = Arrays.copyOf(numbersArr, numbersArr.length);
        for(int k=0; k < sortedCopy.length; k++) {              // Run as many times as size of array
            for(int i=0,j=1; j < sortedCopy.length;i++,j++) {   // Compare from start to end
                if (reverse) {
                    if (sortedCopy[i] < sortedCopy[j]) {
                        int tmp = sortedCopy[j];
                        sortedCopy[j] = sortedCopy[i];
                        sortedCopy[i] = tmp;
                    }

                } else {
                    if (sortedCopy[i] > sortedCopy[j]) {
                        int tmp = sortedCopy[j];
                        sortedCopy[j] = sortedCopy[i];
                        sortedCopy[i] = tmp;
                    }
                }
            }
        }
        printArray(sortedCopy);

         */
    }

    public void selectionSortList(boolean reverse) {   // O(N^2)
        System.out.printf("Using list based %s ordering for array selection sort: ", (reverse ? "decreasing" : "increasing"));
        printArray(this.numbersToSortArray);

        LinkedListNode head = getLinkedListNodeArray(this.numbersToSortArray);
        LinkedListNode listNode = head;
        while (listNode != null) {
            LinkedListNode nextNode = listNode.next;
            while(nextNode != null) {
                if (reverse) {
                    if (listNode.getValue() < nextNode.getValue()) {
                        int tmp = nextNode.getValue();
                        nextNode.setValue(listNode.getValue());
                        listNode.setValue(tmp);
                    }

                } else {
                    if (listNode.getValue() > nextNode.getValue()) {
                        int tmp = nextNode.getValue();
                        nextNode.setValue(listNode.getValue());
                        listNode.setValue(tmp);
                    }
                }
                nextNode = nextNode.next;
            }
            listNode = listNode.next;
        }

        // Print the sorted list
        printLinkedList(head);

        // Now cleanup the list
        deleteList(head);
    }

    private void printLinkedList(LinkedListNode head) {
        LinkedListNode node = head;
        while(node != null) {
            if (node != head) System.out.printf(",");
            System.out.printf("%d", node.value);
            node = node.next;
        }
        System.out.printf("\n");
    }

    private void printArray(int[] arrToPrint) {
        for(int i=0; i < arrToPrint.length;i++) {
            if (i > 0) System.out.printf(",");
            System.out.printf("%d", arrToPrint[i]);
        }
        System.out.printf("\n");
    }
}
