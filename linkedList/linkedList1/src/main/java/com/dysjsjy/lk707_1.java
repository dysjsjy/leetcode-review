package com.dysjsjy;

public class lk707_1 {

    private static class MyLinkedList {

        private MyLinkedListNode head;
        private MyLinkedListNode tail;
        private int size;

        //定义列表节点类
        private static class MyLinkedListNode {
            int val;
            MyLinkedListNode next;

            MyLinkedListNode(int x) {
                this.val = x;
            }
        }

        public MyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        //获取第index节点的值
        private int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            //太妙了
            MyLinkedListNode cur = this.head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }

            return cur.val;
        }

        //在头节点添加一个节点
        public void addAtHead(int val) {
            MyLinkedListNode newNode = new MyLinkedListNode(val);
            newNode.next = head;
            head = newNode;

            //如果列表为空，更新tail
            if (tail == null) {
                tail = head;
            }
            size++;
        }

        //在尾节点添加一个节点
        public void addAtTail(int val) {
            MyLinkedListNode newNode = new MyLinkedListNode(val);
            if (tail != null) {
                tail.next = newNode;
            } else {
                head = newNode;
            }

            tail = newNode;
            size++;
        }

        //在第index个位置插入一个值
        public void addAtIndex(int index, int val) {
            if (index < 0) {
                addAtHead(val);
                return;
            }
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }

            MyLinkedListNode newNode = new MyLinkedListNode(val);
            MyLinkedListNode cur = head;

            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }

            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }

        //删除第index个节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
                size--;
                return;
            }

            MyLinkedListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }

            cur.next = cur.next.next;

            if (cur.next == null) {
                tail = cur;
            }

            size--;
        }
    }

    //错误示范
    private static class MyLinkedList_cw {

        private MyLinkedList_cw head;
        private MyLinkedList_cw tail;
        private int val;
        private MyLinkedList_cw next;
        private static int size;

        public MyLinkedList_cw() {
            head = new MyLinkedList_cw();
            head.next = null;
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            int count = 0;

            MyLinkedList_cw cur = head;

            while (cur != null) {
                if (count == index) {
                    return cur.val;
                } else {
                    cur = cur.next;
                    count++;
                }
            }

            return -1;
        }

        public void addAtHead(int val) {
            MyLinkedList_cw cur = new MyLinkedList_cw();
            cur.val = val;
            cur.next = head;
            head = cur;
            size++;
        }

        public void addAtTail(int val) {
            MyLinkedList_cw cur = new MyLinkedList_cw();
            cur.val = val;
            tail.next = cur;
            tail = cur;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0) {
                addAtHead(val);
            }
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
            }

            int count = 1;
            MyLinkedList_cw cur = head;

            while (cur != null) {
                if (count == index) {
                    MyLinkedList_cw temp = new MyLinkedList_cw();
                    temp.val = val;
                    temp.next = cur.next;
                    cur.next = temp;
                    size++;
                    break;
                } else {
                    cur = cur.next;
                    count++;
                }
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index > size) {
                return;
            }

            int count = 1;
            MyLinkedList_cw cur = head;

            while (cur != null) {
                if (count == index) {
                    cur.next = cur.next.next;
                    size--;
                    break;
                } else {
                    cur = cur.next;
                    count++;
                }
            }
        }
    }
}
