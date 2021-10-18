import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();
    public static final String ADD_CASE = "ADD";
    public static final String LIST_CASE = "LIST";
    public static final String EDIT_CASE = "EDIT";
    public static final String DELETE_CASE = "DELETE";

    public static void main(String[] args) {
        while (true) {
            int index;
            Scanner scaner = new Scanner(System.in);
            String input = scaner.nextLine();
            switch (input.split(" ")[0]) { //берем первое слово из консоли на проверку для case;

                case ADD_CASE -> {
                    if (input.matches("ADD\\s[\\D].+")) {
                        todoList.add(input.replaceAll("ADD", "").trim());
                    }
                    if (input.matches("ADD\\s\\d+.+")) {
                        Pattern addIndexPattern = Pattern.compile("ADD\\s\\d+");
                        Matcher matcher = addIndexPattern.matcher(input);
                        matcher.find();
                        int indexAdd = Integer.parseInt(matcher.group().replaceAll("ADD", "").trim());
                        todoList.add(indexAdd, input.replaceAll("ADD\\s[\\d]+", "").trim());
                    }
                }

                case LIST_CASE -> todoList.getTodos();

                case DELETE_CASE -> {
                    index = Integer.parseInt(input.substring(input.indexOf(' ')).trim());
                    todoList.delete(index);
                }
                case EDIT_CASE -> {
                    int indexEdit;
                    String todoEdit;
                    indexEdit = Integer.parseInt(input.split(" ")[1]);
                    todoEdit = input.replaceAll("EDIT\\s[\\d]+", "").trim();
                    todoList.edit(todoEdit, indexEdit);
                }

                case "HELP" -> System.out.println("""
                        Привет, я твой список дел, я помогу тебе в продуктивности!
                        Я умею выполнять следующие команды:
                        ADD - добавить дело
                        EDIT - разместить дело на определенное место в списке
                        DELETE - удалить дело из списка
                        LIST - вывести все дела на экран
                        """);

                default -> System.out.println("Напишите - HELP, я объясню как работать с TodoList");
            }
        }
    }
}
