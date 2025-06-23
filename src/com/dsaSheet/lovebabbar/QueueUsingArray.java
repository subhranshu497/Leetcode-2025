package com.dsaSheet.lovebabbar;

public class QueueUsingArray {
    int front, rear;
    int arr[] = new int[100005];

    QueueUsingArray() {
        front = 0;
        rear = -1;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        rear +=1;
        arr[rear] = x;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(front> rear) return -1;
        int res = arr[front];
        front++;
        return res;
    }
}
