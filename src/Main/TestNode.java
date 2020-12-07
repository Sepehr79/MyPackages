package Main;

import MyPackages.datastructure.linkedlist.classes.LinkedListImp;
import MyPackages.datastructure.linkedlist.classes.NodeImp;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.Iterator;

public class TestNode {

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
}
