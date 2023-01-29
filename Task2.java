import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;
// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

public class Task2 {
    public static void main(String[] args) throws SecurityException, IOException {

        Logger log = Logger.getLogger(Task4.class.getName());
        FileHandler fh = new FileHandler("log_task2.txt");
        log.setUseParentHandlers(false);
        log.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        log.info("Запуск программы");
        int [] mas = {11, 3, 14, 16, 7};
        log.info("Присваивание в массив mas значений -> " + Arrays.toString(mas));
 
        boolean status = false;
        int temp;
        while(!status) {
            log.info("Вход в цикл");
            status = true;
            for (int i = 0; i < mas.length-1; i++) {
                log.info("Итерация в цикле -> " + i);
                
                if(mas[i] > mas[i+1]){
                    log.info("Выполнение условия " + mas[i] + " > " + mas[i+1]);
                    status = false;

                    temp = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = temp;
                    log.info("Перестановка элементов -> " + Arrays.toString(mas));
                }
            }
        }
        log.info("Завершения цикла while");
        log.info("Вывод значений -> " + Arrays.toString(mas));
        
        System.out.println(Arrays.toString(mas));

        log.info("Завершения программы");
    }
}

