import java.util. *;

class USB {
    //идея в том, чтобы при применении методов в троке сохранять в стек обратные методы
    // при вызове undo снимается последний метод из стека - отменяется последнее действие
    private class DeleteAction implements Action{
        private int size;

        public DeleteAction(int size) {
            this.size = size;
        }

        public void undo(){
            stringBuilder.delete(
                    stringBuilder.length() - size, stringBuilder.length());
        }
    }

    private StringBuilder stringBuilder;
    private Stack<Action> actions = new Stack<>();

    // конструктор
    public USB() {
        stringBuilder = new StringBuilder();
    }

    public USB reverse() {
        stringBuilder.reverse();

        Action action = new Action(){
            public void undo() {
                stringBuilder.reverse();
            }
        };

        actions.add(action);

        return this;
    }


    public USB append(String str) {
        stringBuilder.append(str);

        Action action = new Action(){
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length() - str.length() -1,
                        stringBuilder.length());
            }
        };

        actions.add(action);
        return this;
    }

    public USB delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        actions.add(() -> stringBuilder.insert(start, deleted));
        return this;
    }

    public USB deleteCharAt(int index) {
        char deleted = stringBuilder.charAt(index);
        stringBuilder.deleteCharAt(index);
        actions.add(() -> stringBuilder.insert(index, deleted));
        return this;
    }

    public USB replace(int start, int end, String str) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, str);
        actions.add(() -> stringBuilder.replace(start, end, deleted));
        return this;
    }

    public USB insert(int index, char[] str, int offset, int len) {
        stringBuilder.insert(index, str, offset, len);
        actions.add(() -> stringBuilder.delete(index, len));
        return this;
    }

    public void undo(){
        if(!actions.isEmpty()){
            actions.pop().undo();
        }
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
