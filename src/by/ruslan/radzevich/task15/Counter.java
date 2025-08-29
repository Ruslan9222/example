package by.ruslan.radzevich.task15;

import org.springframework.stereotype.Service;

@Service
public class Counter {

    public void count() {
        // Перекличка, пусть каждый подаст голос
        // Вывести имя и голос по заданной очереди - сначала Матроскин, потом Шарик и в конце Мурка или Гаврюша
        // Важно, чтобы при множественном запуске говорили именно Мурка ИЛИ Гаврюша, то есть, чтобы прототип при инжекте оставался прототипом
    }
}
