package ru.siobko.testing.core;

/**
 * Метод, необходимый loadable элементам и пейджам, для полной загрузки или отображения перед взаимодействием
 */
public interface UIComponent {
    /**
     * Метод, необходимый loadable элементам и пейджам, для полной загрузки или отображения перед взаимодействием
     */
    void check() throws Error;
}
