package ru.siobko.testing.core;

public interface UIComponent {
    /**
     * Метод, необходимый loadable элементам, для отображения перед взаимодействием
     */
    void isLoaded() throws Error;
}
