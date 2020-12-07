package MyPackages.datastructure.linkedlist.interfaces;

public interface INode<DataType> {

    void set_next(INode<DataType> node);

    void set_prev(INode<DataType> node);

    void set_value(DataType data);

    INode<DataType> get_next();

    INode<DataType> get_prev();

    DataType get_value();

}
