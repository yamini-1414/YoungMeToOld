package Queue;

class MyCircularQueue {
    int[] arr;
    int front,rear,capacity;
  /** Initialize your data structure here. Set the size of the queue to be k. */
  public MyCircularQueue(int k) {
      this.arr = new int[k];
      this.front=this.rear= -1;
      this.capacity = k;
  }
  
  /** Insert an element into the circular queue. Return true if the operation is successful. */
  public boolean enQueue(int value) {
      if(rear==-1){
          rear++;
          front = rear;
          arr[rear] = value;
          return true;
      }
      if(isFull()) 
          return false;
      rear = (rear+1)%capacity;
      arr[rear] = value;
      return true;
  }
  
  /** Delete an element from the circular queue. Return true if the operation is successful. */
  public boolean deQueue() {
      if(isEmpty()) return false;
      if(front==rear){
          front=rear=-1;
          return true;
      }
      arr[front] = 0;
      front = (front+1)%capacity;
      return true;
  }
  
  /** Get the front item from the queue. */
  public int Front() {
      if(isEmpty()) return -1;
      return arr[front];
  }
  
  /** Get the last item from the queue. */
  public int Rear() {
      if(isEmpty()) return -1;
      return arr[rear];
  }
  
  /** Checks whether the circular queue is empty or not. */
  public boolean isEmpty() {
      return front==-1 && rear==-1;
  }
  
  /** Checks whether the circular queue is full or not. */
  public boolean isFull() {
      return (rear+1)%capacity==front;
  }
}

/**
* Your MyCircularQueue object will be instantiated and called as such:
* MyCircularQueue obj = new MyCircularQueue(k);
* boolean param_1 = obj.enQueue(value);
* boolean param_2 = obj.deQueue();
* int param_3 = obj.Front();
* int param_4 = obj.Rear();
* boolean param_5 = obj.isEmpty();
* boolean param_6 = obj.isFull();
*/
