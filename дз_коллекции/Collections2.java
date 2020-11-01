package  дз_коллекции
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Collections2 {
    public static class MatrixIterator<T> implements Iterator<T> {
        private final int size; //размер массива
        private int row = 0;
        private int col = 0; //столбец и строка текущего элемента
        private int position = 0;//номер текущего элемента для "выдачи"
        private T[][] matrix;


        public MatrixIterator(T[][] matrix) {
            this.matrix = matrix;
            this.size = Size(matrix);
        }

        public int Size(T[][] matrix) {
            int count = 0;
            for (T[] row : matrix) {
                count += row.length;
            }
            return count;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
            if (position >= size) { //если перебрали все элементы
                throw new NoSuchElementException();
            }
            T element = matrix[row][col];  //текущий элемент
            position++;
            col++;
            while (row < matrix.length && col >= matrix[row].length) { // пропустить возможные "пустые" строки
                //{{1, 2, 3}, {}, {4, 5}, {6}} - например
                col = 0;
                row++;
            }
            return element;
        }
    }
    public static class iteratorovertwo<T> implements Iterator<T> {

        private final Iterator<T> iterator1;
        private final Iterator<T> iterator2;

        public iteratorovertwo(Iterator<T> iterator1,Iterator<T> iterator2){
            this.iterator1 = iterator1;
            this.iterator2 = iterator2;
        }
        @Override
        public boolean hasNext() {
            while (iterator1.hasNext()) return true;
            while (iterator2.hasNext()) return true;
            return false;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            while (iterator1.hasNext()) return iterator1.next();
            while (iterator2.hasNext()) return iterator2.next();
            return null;
        }
    }

    public static class FlatIterator implements Iterator<String> {
        private Stack<Iterator> iteratorStack;
        private String next;
        private boolean hasNext;

        public FlatIterator(Iterator<?> iterator){
            this.iteratorStack = new Stack<Iterator>();
            iteratorStack.push(iterator);
            updateNext();
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }
        private void updateNext(){
            if(iteratorStack.empty()){
                next = null;
                hasNext = false;
            }
            Iterator current = iteratorStack.peek();
            if (current.hasNext()) {
                Object o = current.next();
                if (o instanceof String) {
                    next = (String) o;
                    hasNext = true;
                } else if (o instanceof Iterator) {
                    Iterator iterator = (Iterator) o;
                    iteratorStack.push(iterator);
                    updateNext();
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                iteratorStack.pop();
                updateNext();
            }
        }
        @Override
        public String next() throws NoSuchElementException {
            if (!hasNext){
                throw new NoSuchElementException();
            }
            String nexttoreturn = next;
            updateNext();
            return nexttoreturn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
