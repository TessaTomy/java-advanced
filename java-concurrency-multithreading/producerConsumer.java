class SharedBuffer {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait();
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait();
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notifyAll();
    }
}

public class producerConsumer {
    public static void main(String[] args) {
        SharedBuffer s = new SharedBuffer();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    s.produce(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    s.consume();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
