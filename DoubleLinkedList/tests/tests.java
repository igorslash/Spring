import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DoubleLinkedListTest {
    private DoubleLinkedList doubleLinkedList;
    private LinkedList mockList;

    @BeforeEach
    void setUp() {
        doubleLinkedList = new DoubleLinkedList();
        mockList = Mockito.mock(LinkedList.class);
    }

    @Test
    void testAddAndProcessNodes() {
        // Подготовка данных
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            when(mockList.removeHead())
                    .thenReturn(new Node(random
                            .nextInt(100), null, null));
            when(mockList.removeTail())
                    .thenReturn(new Node(random
                            .nextInt(100), null, null));
        }

        // Запуск потоков
        Thread thread1 = new Thread(() -> mockList.removeHead());
        Thread thread2 = new Thread(() -> mockList.removeTail());

        thread1.start();
        thread2.start();

        // Ожидание завершения потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Проверка, что removeHead и removeTail были вызваны
        verify(mockList, times(5)).removeHead();
        verify(mockList, times(5)).removeTail();
    }

    @Test
    void testNodeValue() {
        Node node = new Node(42, null, null);
        assertEquals(42, node.getValue());
    }

    @Test
    void testNodeLinks() {
        Node prevNode = new Node(1, null, null);
        Node nextNode = new Node(3, null, prevNode);
        Node node = new Node(2, nextNode, prevNode);

        assertEquals(prevNode, node.getPrev());
        assertEquals(nextNode, node.getNext());
    }
}