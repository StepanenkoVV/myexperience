import java.util.ArrayList;


public class TodoList {
    ArrayList<String> toDoList = new ArrayList<>();

    public void add(String todo) {
        toDoList.add(todo);
        System.out.println("Добавлено дело " + todo);
    }

    public void add(int index, String todo) {
        if (index > this.toDoList.size()) {
            index = this.toDoList.size();
            System.out.println("Заданный индекс превышает размер TodoList, дело добавлено в конец списка");
        }
        toDoList.add(index, todo);
    }

    public void edit(String todo, int index) {
        String s;
        if (index > this.toDoList.size()) {
            System.out.println("Задачи с таким индексом не существует");
        } else {
            s = toDoList.set(index, todo);
            System.out.println("Дело " + s + " заменено на " + todo);
        }
    }

    public void delete(int index) {
        if (index > -1 && index < toDoList.size()) {
            System.out.println("Дело " + toDoList.get(index) + " удалено");
            toDoList.remove(index);
        } else if (index > toDoList.size()) {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println(i + " - " + toDoList.get(i));
        }
        return toDoList;
    }
}