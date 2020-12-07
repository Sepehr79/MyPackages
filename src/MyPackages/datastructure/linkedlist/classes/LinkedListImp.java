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
                return;
            }
        }
    }

    @Override
    public DataType delete(DataType data) {
        return null;
    }

    @Override
    public DataType find(DataType data) {
        return null;
    }

    @Override
    public DataType get(int index) {
        return null;
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
