package com.company.Test;

import com.company.Container.Container;
import com.company.Container.QueueContainer;
import com.company.Container.StackContainer;
import com.company.Container.TaskContainerFactory;
import com.company.Task.MessageTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    void init(Container st) {
        st.add(new MessageTask("1", "t1", "m1", "Dan1", "Cineva1"));
        st.add( new MessageTask("2", "t2", "m2", "Dan2", "Cineva2"));
        st.add(new MessageTask("3", "t3", "m3", "Dan3", "Cineva3"));
    }

    @Test
    void queueTest() {
        QueueContainer st = new QueueContainer();
        testQueue(st);
    }

    @Test
    void stackTest() {
        StackContainer st = new StackContainer();
        testStack(st);
    }

    @Test
    void factoryTest() {
        TaskContainerFactory tc = TaskContainerFactory.getInstance();
        QueueContainer st = (QueueContainer) TaskContainerFactory.getInstance().createContainer("FIFO");
        testQueue(st);
        StackContainer si = (StackContainer) TaskContainerFactory.getInstance().createContainer("LIFO");
        testStack(si);
        assertEquals(tc.hashCode(), TaskContainerFactory.getInstance().hashCode());
    }

    private void testQueue(QueueContainer st) {
        init(st);
        assertEquals(st.size(), 3);
        MessageTask m = (MessageTask) st.remove();
        assertEquals(m.getTaskId(), "1");
        assertFalse(st.isEmpty());
        st.remove();
        m = (MessageTask) st.remove();
        assertEquals(st.size(), 0);
        assertTrue(st.isEmpty());
        assertEquals(m.getTaskId(), "3");
        assertNull(st.remove());
    }

    private void testStack(StackContainer st) {
        init(st);
        assertEquals(st.size(), 3);
        MessageTask m = (MessageTask) st.remove();
        assertEquals(m.getTaskId(), "3");
        assertFalse(st.isEmpty());
        st.remove();
        st.remove();
        assertEquals(st.size(), 0);
        assertTrue(st.isEmpty());
        assertNull(st.remove());
    }
}
