package com.lavalliere.daniel.aps;

import java.lang.InterruptedException;

public class MultitreadingOps {

    private Q q;
    private Producer producer;
    private Consumer consumer;

    class Q {
        int n;
        boolean valueSet = false;
        boolean done = false;

        public void stop() {
            done = true;
        }

        synchronized int get() {
            while(!valueSet && !done) {
                try {
                    wait();
                } catch (InterruptedException ex) {}
            }
            System.out.printf("Got: %d\n", n);
            valueSet = false;
            notifyAll();
            return n;
        }

        synchronized void set(int n) {
            while(valueSet && !done) {
                try {
                    wait();
                } catch (InterruptedException ex) {}
            }
            this.n = n;
            valueSet = true;
            System.out.printf("Set: %d\n", n);
            notifyAll();
        }
    }

    class Producer implements Runnable{
        Q q;
        Thread t;
        boolean done;

        public Producer(Q q) {
            this.q = q;
            t = new Thread(this, "Producer");
        }

        public void start() {
            t.start();
        }

        public void stop() {
            try {
                done = true;
                t.join();
            } catch (InterruptedException ex) {}
        }

        @Override
        public void run() {
            int i = 0;
            while(!done) {
                q.set(i++);
            }
            System.out.println("Producer now exiting");
        }
    }

    class Consumer implements Runnable {
        Q q;
        Thread t;
        boolean done;

        public Consumer(Q q) {
            this.q = q;
            t = new Thread(this, "Consumer");
        }

        public void start() {
            t.start();
        }

        public void stop() {
            try {
                done = true;
                t.join();
           } catch (InterruptedException ex) {}
        }

        @Override
        public void run() {
            int i = 0;
            while(!done) {
                q.get();
            }
            System.out.println("Consumer now exiting");
        }
    }

    public MultitreadingOps(long duration) {
        q = new Q();
        producer = new Producer(q);
        consumer = new Consumer(q);
        consumer.start();
        producer.start();

        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {}

        q.stop();

        consumer.stop();
        producer.stop();
        System.out.println("Done waiting... exiting");
    }
}
