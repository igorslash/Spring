//Я использовал Java23
//Я добавил библиотеку Lombok для возможности сократить код,
// поэтому можно с ним или без него
package DoubleLinkedList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

//@Slf4j
public class DoubleLinkedList {
    private static final Logger logger = Logger.getLogger(DoubleLinkedList.class.getName());

    public static void main() {
        final int LIST_SIZE = 100; // Размер списка
        LinkedList list = new LinkedList();
        Random random = new Random();

        // Заполнение списка случайными значениями
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(random.nextInt(100)); // Случайные числа от 0 до 99
        }

        AtomicInteger zeroBitsCount = new AtomicInteger(); // Счетчик нулевых битов
        AtomicInteger oneBitsCount = new AtomicInteger();  // Счетчик единичных битов
        AtomicInteger elementsProcessedThread1 = new AtomicInteger(); // Элементы, обработанные потоком 1
        AtomicInteger elementsProcessedThread2 = new AtomicInteger(); // Элементы, обработанные потоком 2

        // Поток №1: обрабатывает голову списка
        Thread thread1 = new Thread(() -> {
            Node node;
            while ((node = list.removeHead()) != null) {
                zeroBitsCount.addAndGet(Integer.SIZE - Integer
                        .bitCount(node.getValue())); // Подсчет нулевых битов
                elementsProcessedThread1.incrementAndGet();
                logger.log(Level.INFO, "Поток 1 обработал " +
                        "узел со значением: " + node.getValue());
            }
        });

        // Поток №2: обрабатывает хвост списка
        Thread thread2 = new Thread(() -> {
            Node node;
            while ((node = list.removeTail()) != null) {
                // Подсчет единичных битов
                oneBitsCount.addAndGet(Integer
                        .bitCount(node.getValue()));
                elementsProcessedThread2.incrementAndGet();
                logger.log(Level.INFO, "Поток 2 обработал " +
                        "узел со значением: " + node.getValue());
            }
        });

        // Запуск потоков
        thread1.start();
        thread2.start();

        // Ожидание завершения потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.log(Level.SEVERE, "Поток прерван", e);
        }

        // Вывод результатов
        System.out.println("Нулевой бит: "
                + zeroBitsCount.get());
        System.out.println("Единичный бит: "
                + oneBitsCount.get());
        System.out.println("Элементы, обработанные потоком 1: "
                + elementsProcessedThread1.get());
        System.out.println("Элементы, обработанные потоком 2: "
                + elementsProcessedThread2.get());
    }
}
//@Getter
//@AllArgsConstructor
//@Slf4j
class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }
}
//@Slf4j
class LinkedList {
    private Node head; // Голова списка
    private Node tail; // Хвост списка
    private static final Logger logger = Logger
            .getLogger(LinkedList.class.getName());

    // Добавление элемента в конец списка
    public synchronized void add(int value) {
        Node newNode = new Node(value, null, tail);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        logger.log(Level.INFO, "Добавление узла " +
                "со значением: " + value);
    }

    // Удаление элемента с головы списка
    public synchronized Node removeHead() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        if (head != null) {
            head.prev = null; // Обновляем указатель
            // на предыдущий элемент
        } else {
            tail = null;
        }
        logger.log(Level.INFO, "Удаление головы " +
                "узел со значением: " + temp.getValue());
        return temp;
    }

    // Удаление элемента с хвоста списка
    public synchronized Node removeTail() {
        if (tail == null) {
            return null;
        }
        Node node = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null; // Обновляем указатель
            // на следующий элемент
        } else {
            head = null;
        }
        logger.log(Level.INFO, "Удаление хвоста " +
                "узел со значением: " + node.getValue());
        return node;
    }
}

