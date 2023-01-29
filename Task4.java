import java.util.logging.*;
import java.io.IOException;
import java.util.Scanner;


// К калькулятору из предыдущего дз добавить логирование.

public class Task4 {
    static Logger log = Logger.getLogger(Task4.class.getName());
        
        public static void main(String[] args) throws SecurityException, IOException {
        FileHandler fh = new FileHandler("log_task4.txt");
        log.setUseParentHandlers(false);
        log.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        log.info("Запуск.");
        System.out.println("Добро пожаловать в калькулятор.\n");
        Scanner iScanner = new Scanner(System.in);
    
        boolean status = true;
        while (status) {
            System.out.print("Введите первое число: ");
            int first = iScanner.nextInt();
            log.info("Ввод значения -> " + first);
                        
            System.out.print("Введите второе число: ");
            int second = iScanner.nextInt();
            log.info("Ввод значения -> " + second);

            System.out.print("Введите операцию (+ - / *): ");
            char op = iScanner.next().charAt(0);
            log.info("Ввод операции -> " + op);

            System.out.println(oper(first, second, op));
            log.info("Вывод значения");

            System.out.println("Для выхода введите -> s\nПродолжить -> Любой другой символ");
    
            op = iScanner.next().charAt(0);
            if(op == 's') status = false;
        }
        log.info("Закрытие программы");

        iScanner.close();
        System.out.println("Спасибо!");
    
        }
    
    public static int oper(int a, int b, char o) {
        int result = 0;
        switch (o) {
            case '+':
                result = a + b;
                log.info("Операция сложения -> " + a + " и " + b);
                break;
            case '-':
                result = a - b;
                log.info("Операция разности -> " + a + " и " + b);
                break;
            case '*':
                result = a * b;
                log.info("Операция умножения -> " + a + " и " + b);
                break;
            case '/':
                log.info("Операция деления -> " + a + " и " + b);
                if(b != 0) result = a / b;
                else 
                {
                    log.log(Level.WARNING, "Деление на ноль!");
                    System.out.println("Деление на ноль!");
                }
                break;
            default:
                log.info("Операция не распознана -> " + o);
                System.out.println("Операция не распознана. Повторите ввод.");
        }
        return result;        
    }
        
}
    
