package MyPackages.datastructure.linkedlist.tests;

import MyPackages.datastructure.linkedlist.classes.LinkedListImp;
import MyPackages.datastructure.linkedlist.classes.NodeImp;
import org.junit.Assert;
import org.junit.Test;

public class TestLinkedList {

    @Test
    public void testNodeValue(){

        NodeImp<Integer> nodeImp = new NodeImp<>();
        nodeImp.set_value(56);
        NodeImp<Integer> nodeImp1 = nodeImp;

        int num = nodeImp1.get_value();
        Assert.assertEquals(56, num);
    }

    @Test
    public void testInsert(){
        LinkedListImp<Integer> linkedListImp = new LinkedListImp<>();
        linkedListImp.insert(5);
        linkedListImp.insert(6);
        linkedListImp.insert(6);
        linkedListImp.insert(6);
        Assert.assertEquals(linkedListImp.size(), 4);
    }

    @Test
    public void testNodeEmpty(){
        LinkedListImp<Object> linkedListImp = new LinkedListImp<>();
        Assert.assertTrue(linkedListImp.is_empty());
    }

    @Test
    public void testIterator(){
        LinkedListImp<Integer> linkedListImp = new LinkedListImp<>();
        linkedListImp.insert(1);
        linkedListImp.insert(2);
        linkedListImp.insert(3);
        linkedListImp.insert(4);

        System.out.println("iterator start");
        for (NodeImp<Integer> integerNodeImp : linkedListImp) System.out.println(integerNodeImp.get_value());
    }

    @Test
    public void test_insert_after(){
        LinkedListImp<Integer> linkedListImp = new LinkedListImp<>();
        linkedListImp.insert(1);
        linkedListImp.insert(3);
        linkedListImp.insert(4);
        linkedListImp.insert(6);

        linkedListImp.insert_after(1, 2);
        linkedListImp.insert_after(4, 5);

        System.out.println("iterator start");
        for (NodeImp<Integer> integerNodeImp : linkedListImp) System.out.println(integerNodeImp.get_value());
    }

    @Test
    public void testGetIndex(){
        LinkedListImp<Integer> linkedListImp = new LinkedListImp<>();
        linkedListImp.insert(1);
        linkedListImp.insert(3);
        linkedListImp.insert(4);
        linkedListImp.insert(6);

        Integer num = linkedListImp.get(4);
        Assert.assertEquals(6, (int) num);
    }

    @Test
    public void testDelete(){
        LinkedListImp<Integer> linkedListImp = new LinkedListImp<>();
        linkedListImp.insert(1);
        linkedListImp.insert(3);
        linkedListImp.insert(4);
        linkedListImp.insert(6);

        Integer num = linkedListImp.delete(4);
        Assert.assertEquals(3, linkedListImp.size());
        Assert.assertEquals(4, (int) num);
        Assert.assertEquals(6, (int) linkedListImp.get(3));
    }
}
