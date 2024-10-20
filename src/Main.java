import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Точка координат
        System.out.println("Поочередно введите 3 точки координат");
        double x_1 = testDoubleInput(scanner,"Введите координату точки x_1: ");
        double y_1 = testDoubleInput(scanner,"Введите координату точки y_1: ");
        double x_2 = testDoubleInput(scanner,"Введите координату точки x_2: ");
        double y_2 = testDoubleInput(scanner,"Введите координату точки y_2: ");
        double x_3 = testDoubleInput(scanner,"Введите координату точки x_3: ");
        double y_3 = testDoubleInput(scanner,"Введите координату точки y_3: ");

        Point point1 = new Point(x_1, y_1);
        Point point2 = new Point(x_2, y_2);
        Point point3 = new Point(x_3, y_3);

        System.out.println("Координаты точек: ");
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println();

        //Прямая
        point1.setValue(1,3);
        point2.setValue(23, 8);
        Line line1 = new Line(point1, point2);
        point3.setValue(5, 10);
        Point point4 = new Point(25,10);
        Line line2 = new Line(point3, point4);
        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.println("Координаты линий: ");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.printf("Теперь измените координаты линий: \nПоследовательно введите координаты точек первой линии: ");
        //Изменение координат
        x_1 = testDoubleInput(scanner, "");
        y_1 = testDoubleInput(scanner, "");
        x_2 = testDoubleInput(scanner, "");
        y_2 = testDoubleInput(scanner, "");
        System.out.printf("Теперь точек второй линии: ");
        x_3 = testDoubleInput(scanner, "");
        y_3 = testDoubleInput(scanner, "");
        double x_4 = testDoubleInput(scanner, "");
        double y_4 = testDoubleInput(scanner, "");
        point1.setValue(x_1, y_1);
        point2.setValue(x_2, y_2);
        point3.setValue(x_3, y_3);
        point4.setValue(x_4, y_4);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        //Изменение первой линии без изменения третьей
        System.out.printf("Последовательно перезапишите координаты первой линии (третья линия не изменится): ");
        x_1 = testDoubleInput(scanner, "");
        y_1 = testDoubleInput(scanner, "");
        x_2 = testDoubleInput(scanner, "");
        y_2 = testDoubleInput(scanner, "");
        point1 = new Point(x_1, y_1);
        point2 = new Point(x_2, y_2);
        line1 = new Line(point1, point2);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println();

        //Студент
        int[] marks_1 = {3, 4, 5};
        Student student_1 = new Student("Вася", marks_1);
        Student student_2 = new Student("Петя", student_1.getMarks());
        System.out.println("Изначальные оценки Васи и Пети: ");
        System.out.println(student_1);
        System.out.println(student_2);
        student_2.changeMark(1, 5);
        System.out.println("Петя исправил первую оценку на 5, а Вася списал у Пети и получил аналогичную оценку: ");
        System.out.println(student_1);
        System.out.println(student_2);
        Student student_3 = new Student("Андрей", student_1.getMarks().clone());
        System.out.printf("Учительница узнала о списывании и заставила Петю и Васю переписать все работы, но они опять умудрились написать на одинаковые отметки. Пожалуйста, перезапишите оценки Васи и Пети: ");
        int[] newMarks = new int[student_1.getMarks().length];
        for (int i = 0; i < student_1.getMarks().length; i++) {
            newMarks[i] = testMarkInput(scanner, "");
        }
        student_1.changeAllMarks(newMarks);
        System.out.println("Также новому студенту Андрею были выставлены такие же оценки как у Васи и Пети до изменений: ");
        System.out.println(student_1);
        System.out.println(student_2);
        System.out.println(student_3);
        System.out.println();

        //Создаем Точку
        point1 = new Point(3, 5);
        point2 = new Point(25, 6);
        point3 = new Point(7, 8);
        System.out.println("Новые точки: ");
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
        System.out.println();

        //Создаем Студента.
        System.out.println("Новые студенты: ");
        Student student_4 = new Student("Вася", 3, 4, 5);
        Student student_5 = new Student("Максим");
        System.out.println(student_4);
        System.out.println(student_5);
        System.out.println();

        //Студент отличник.
        System.out.println("Новые студенты и их средние баллы: ");
        student_1 = new Student("Вася", 3, 4, 5, 4);
        student_2 = new Student("Петя", 5, 5, 5, 5);
        double avg_student_1 = student_1.averageMark();
        double avg_student_2 = student_2.averageMark();
        System.out.println(student_1 + ". Его средний балл: " + avg_student_1 + ". Данный студент - " + (student_1.isExellent() ? "отличник" : "не отличник"));
        System.out.println(student_2 + ". Его средний балл: " + avg_student_2 + ". Данный студент - " + (student_2.isExellent() ? "отличник" : "не отличник"));
    }


    public static double testDoubleInput(Scanner scanner, String prompt) { //Проверка вводимых данных
        double value;
        System.out.print(prompt);
        while (!(scanner.hasNextDouble())) {
            System.out.printf("Вы ошиблись с вводом, попробуйте еще раз: ");
            scanner.next();
        }
        value = scanner.nextDouble();
        return value;
    }

    public static int testMarkInput(Scanner scanner, String prompt) { //Проверка вводимых данных
        int value;
        System.out.print(prompt);
        while(true) {
            value = scanner.nextInt();
            if (value >= 1 && value <= 5) {
                break;
            }
            System.out.println("Ошибка: введите целое число от 1 до 5.");
        }
        return value;
    }
}