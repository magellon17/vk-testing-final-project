package ru.siobko.testing.models.hobby;

public enum HobbyCategory {
    PETS{
        public String toString() {
            return "Питомцы";
        }
    },
    COOKING{
        public String toString() {
            return "Кулинария";
        }
    }
}
