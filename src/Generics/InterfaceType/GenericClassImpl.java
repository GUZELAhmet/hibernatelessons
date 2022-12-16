package Generics.InterfaceType;
// eğer bir "generic interface" iplement ederseniz, class da Generic olmalıdır

public class GenericClassImpl<T> implements GenericInterface<T> {

    @Override
    public void setValue(T t) {

    }

    @Override
    public T getValue() {
        return null;
    }
}
