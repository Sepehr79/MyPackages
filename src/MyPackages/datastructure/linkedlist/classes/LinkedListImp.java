package MyPackages.datastructure.linkedlist.classes;

import MyPackages.datastructure.linkedlist.interfaces.IList;

import java.util.Iterator;

/**
 * Implementing a linkedlist in java without import any libraries
 * @class LinkedListImp implements linkedlist in java it can be used as generic data types.
 * @author Sepehr79
 */
public class LinkedListImp<DataType> implements IList<DataType>, Iterable<NodeImp<DataType>> {

    /**
     * To save first and last node of each linkedlist
     */
    private final NodeImp<DataType> firstNode;
    private NodeImp<DataType> lastNode;

    private Integer size = 0;

    public LinkedListImp(){
        firstNode = new NodeImp<>();
        lastNode = firstNode;
    }

    @Override
    public void insert(DataType data) {
        addNodeWithData(data);
        size++;
    }

    /**
     *
     * @param data is one of the linkedlist data's we are looking for
     * @param x to insert a new value after all data's in linked list
     */
    @Override
    public void insert_after(DataType data, DataType x) {
        for (NodeImp<DataType> nodeImp : this) {
            if (nodeImp.get_value().equals(data)) {
                insertAfterNodeWithData(nodeImp, x);
                size++;
            }
        }
    }

    @Override
    public DataType delete(DataType data) {
        for (NodeImp<DataType> nodeImp : this) {
            if (nodeImp.get_value().equals(data)) {
                nodeImp.get_prev().set_next(nodeImp.get_next());
                nodeImp.get_next().set_prev(nodeImp.get_prev());

                size--;

                return nodeImp.get_value();
            }
        }
        return null;
    }

    @Override
    public DataType find(DataType data) {
        for (NodeImp<DataType> nodeImp : this) {
            if (nodeImp.get_value().equals(data)) {
                return nodeImp.get_value();
            }
        }
        return null;
    }

    /**
     *
     * @param index of linkedlist
     * @return a value from linkedlist based on its generic type
     * @throws IllegalArgumentException if index is more than size
     */
    @Override
    public DataType get(int index) {
        Iterator<NodeImp<DataType>> iterator = iterator();
        NodeImp<DataType> nodeImp = null;
        int counter = 0;
        while (counter < index){
            nodeImp = iterator.next();
            counter++;
        }

        if (nodeImp != null) {
            return nodeImp.get_value();
        }
        throw new IllegalArgumentException("Arg is more than size!");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean is_empty() {
        return size == 0;
    }

    private void addNodeWithData(DataType data){
        NodeImp<DataType> nodeImp = new NodeImp<>();
        nodeImp.set_value(data);

        lastNode.set_next(nodeImp);
        nodeImp.set_prev(lastNode);

        lastNode = nodeImp;
    }

    private void insertAfterNodeWithData(NodeImp<DataType> nodeImp, DataType dataType){
        NodeImp<DataType> newNode = new NodeImp<>();
        newNode.set_value(dataType);

        newNode.set_next(nodeImp.get_next());
        newNode.set_prev(nodeImp);

        nodeImp.set_next(newNode);
    }

    /**
     * Implementing linkedlist iterator
     */
    @Override
    public Iterator<NodeImp<DataType>> iterator() {
        return new Iterator<NodeImp<DataType>>() {
            NodeImp<DataType> nodeImp = firstNode;
            @Override
            public boolean hasNext() {
                return nodeImp.hasNext();
            }

            @Override
            public NodeImp<DataType> next() {
                nodeImp = (NodeImp<DataType>) nodeImp.get_next();
                return nodeImp;
            }
        };
    }
}
