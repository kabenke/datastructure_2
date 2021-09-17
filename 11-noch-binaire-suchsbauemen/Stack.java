public class Stack<T> extends DoublyLinkedList<T>
{
    private DoublyLinkedList<T> elements;

    public Stack() {
        elements = new DoublyLinkedList<T>();
    }

    public void push( T o ) {
        elements.addFirst( o );
    }

    public T pop() {
        return elements.removeFirst();
    }

    public T peek() {
        return elements.getFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public static void main(String[] args) {

    Stack<Student> stack = new Stack<Student>();

    Student first = new Student("Nana","Dap",1);
    Student second = new Student("Nan","Dap",31);
    Student third = new Student("Na","Dap",231);
    Student forth = new Student("N","Dap",4231);


    stack.push(first);

    stack.push(second);

    stack.push(third);

    stack.push(forth);

    Student current = stack.peek();

}

}
