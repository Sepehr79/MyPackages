package MyPackages.datastructure.linkedlist.interfaces;

public interface IList<DataType> {

    void insert(DataType data);

    void insert_after(DataType data, DataType x);

    DataType delete(DataType data);

    DataType find(DataType data);

    DataType get(int index);

    int size();

    boolean is_empty();

}
