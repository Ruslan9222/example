package by.ruslan.radzevich.task14;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Стек с поддержкой операций getMin и getMax за O(1),
 * при этом push и pop также работают за O(1).
 */
public class IntStackWithMinMax {
    // Основной стек, хранящий все значения
    private Deque<Integer> stack = new ArrayDeque<>();

    // Стек минимальных значений: на вершине — минимум на текущем уровне
    private Deque<Integer> minStack = new ArrayDeque<>();

    // Стек максимальных значений: на вершине — максимум на текущем уровне
    private Deque<Integer> maxStack = new ArrayDeque<>();

    /**
     * Добавляет элемент в стек.
     * Обновляет minStack и maxStack, чтобы сохранить актуальные min/max.
     */
    public void push(int value) {
        stack.push(value);

        // Если стек пуст или новый элемент меньше текущего минимума — кладём его
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        } else {
            // Иначе дублируем текущий минимум
            minStack.push(minStack.peek());
        }

        // Аналогично для максимума
        if (maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    /**
     * Удаляет верхний элемент из стека.
     * Также синхронно удаляет значения из minStack и maxStack.
     */
    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Удаляем из всех трёх стеков
        minStack.pop();
        maxStack.pop();
        return stack.pop();
    }

    /**
     * Возвращает текущий минимум в стеке.
     */
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

    /**
     * Возвращает текущий максимум в стеке.
     */
    public int getMax() {
        if (maxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return maxStack.peek();
    }

    /**
     * Проверка, пуст ли стек.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}


