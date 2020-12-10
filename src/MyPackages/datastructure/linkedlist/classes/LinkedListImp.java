package MyPackages.datastructure.linkedlist.classes;

import MyPackages.datastructure.linkedlist.interfaces.IList;

import java.util.Iterator;


public class LinkedListImp<DataType> implements IList<DataType>, Iterable<NodeImp<DataType>> {

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
