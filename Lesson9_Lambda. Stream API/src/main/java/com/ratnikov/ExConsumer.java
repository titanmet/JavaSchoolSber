package com.ratnikov;

import java.util.function.Consumer;

@FunctionalInterface
public interface ExConsumer<T> {
    void generator(Consumer<T> consumer);
}
