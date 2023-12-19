package bsu.rfct.lab1.kobyakov.var9;

public class Main {
    public static int equalsInBreakfast(Food obj, Food[] breakfast)
    {

        int result = -1;
        for (Food fd : breakfast)
        {
            if (fd != null)
            {
                if (obj.equals(fd))
                    result++;
            }
            else break;
        }
        return result;
    }
    // Конструктор класса отсутствует!!!
    // Главный метод главного класса
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;
        int count = 0;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
// У сыра дополнительных параметров нет
                breakfast[itemsSoFar] = new Cheese();
                count++;
            } else if (parts[0].equals("Apple")) {
// У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Apple(parts[1]);
                count++;
            } else if (parts[0].equals("Eggs")) {
                breakfast[itemsSoFar] = new Eggs(parts[1]);
                count++;
            }
// ... Продолжается анализ других продуктов для завтрака
            itemsSoFar++;
        }
        /*
        for (String arg : args) {
            for (int i = 0; i < args.length; i++) {
                int number = 0;
                String[] parts = arg.split("/");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                if (parts[i].equals(name)) {
                    number++;
                }
                System.out.println("numbers of " + name + "=" + number);
            }
        }
        */

        for (Food item : breakfast)
            if (item != null)
                item.consume();
            else
                break;
        Food newFd = breakfast[count-1];
        int number = equalsInBreakfast(newFd,breakfast);
        System.out.println("Всего в завтраке объектов " + breakfast[count -1].name + " " + number + " шт.");
        System.out.println("Всего хорошего!");
    }
}