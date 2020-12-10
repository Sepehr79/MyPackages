package MyPackages.datastructure.linkedlist.classes;

import MyPackages.datastructure.linkedlist.interfaces.INode;

import java.util.Iterator;

/**
 * Implementing a linkedlist in java without import any libraries
 * @class NodeImp implements each node of linkedlist it can be used as generic data types.
 * @author Sepehr79
 */
public class NodeImp<DataType> implements INode<DataType>, Iterator<NodeImp<DataType>> {

    /**
     * Each node has next and previews siblings
     */
    private NodeImp<DataType> next;
    private NodeImp<DataType> prev;

    /**
     * Value can be any type of data
     */
    private DataType value;

    /**
     * At fist next node is null this is because we should iterate nodes
     */
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

    /**
     *
     * Iterating nodes
     * checking that next node is not null
     */
    @Override
    public boolean hasNext() {
        return this.get_next() != null;
    }

    /**
     *
     * Iterating nodes
     * @return next node in linkedlist
     */
    @Override
    public NodeImp<DataType> next() {
        return (NodeImp<DataType>) this.get_next();
    }
}
