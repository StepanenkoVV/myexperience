import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    ArrayList<String> list1 = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        list1.add(todo);
        System.out.println("Добавлено дело " + todo);
    }

    public void add(int index, String todo) {
        if (index > this.list1.size()) {
            index = this.list1.size();
            System.out.println("Заданный индекс превышает размер TodoList, дело добавлено в конец списка");
        }
        list1.add(index, todo);
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
    }

    public void edit(String todo, int index) {
        String s;
        if (index > this.list1.size()) {
            System.out.println("Задачи с таким индексом не существует");
        } else {
            s = list1.set(index, todo);
            System.out.println("Дело " + s + " заменено на " + todo);

        }
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
    }

    public void delete(int index) {
        if (index > -1 && index < list1.size()) {
            System.out.println("Дело " + list1.get(index) + " удалено");
            list1.remove(index);
        } else if (index > list1.size()) {
            System.out.println("Дело с таким номером не существует");
        }
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(i + " - " + list1.get(i));
        }
        // TODO: вернуть список дел
        return list1;
    }

}