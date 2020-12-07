package MyPackages.datastructure.linkedlist.classes;

import MyPackages.datastructure.linkedlist.interfaces.INode;

import java.util.Iterator;

public class NodeImp<DataType> implements INode<DataType>, Iterator<NodeImp<DataType>> {

    private NodeImp<DataType> next;
    private NodeImp<DataType> prev;

    private DataType value;

    public NodeImp(){
        next = null;
        prev = this;
        value = null;
    }

    @Override
    public void set_next(INode<DataType> node) {
        this.next = (NodeImp<DataType>) node;
    }

    @Override
    public void set_prev(INode<DataType> node) {
        this.prev = (NodeImp<DataType>) node;
    }

    @Override
    public void set_value(DataType data) {
        this.value = data;
    }

    @Override
    public INode<DataType> get_next() {
        return this.next;
    }

    @Override
    public INode<DataType> get_prev() {
        return this.prev;
    }

    @Override
    public DataType get_value() {
        return this.value;
    }

    @Override
    public boolean hasNext() {
        return this.get_next() != null;
    }

    @Override
    public NodeImp<DataType> next() {
        return (NodeImp<DataType>) this.get_next();
    }
}
