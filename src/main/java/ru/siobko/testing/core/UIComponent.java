package ru.siobko.testing.core;

public interface UIComponent {
    /**
     * Метод, необходимый loadable элементам и пейджам, для полной загрузки или отображения перед взаимодействием
     */
    void check() throws Error;
}
