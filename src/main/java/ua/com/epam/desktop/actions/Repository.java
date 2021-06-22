package ua.com.epam.desktop.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class Repository {
    private final Map<Class<?>, Object> storage = new HashMap<>();

    public <T> T get(final Class<T> clazz) {
        return Optional.ofNullable(getFromStorage(clazz)).orElseGet(() -> setAndGet(clazz));
    }

    private <T> T getFromStorage(Class<T> clazz) {
        return clazz.cast(storage.get(clazz));
    }

    private <T> T setAndGet(final Class<T> clazz) {
        try {
            set(clazz, clazz.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getFromStorage(clazz);
    }

    private <T> void set(Class<T> clazz, T object) {
        storage.put(clazz, object);
    }
}
