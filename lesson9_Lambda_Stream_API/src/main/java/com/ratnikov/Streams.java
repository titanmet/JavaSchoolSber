package com.ratnikov;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {

    private ExConsumer<T> exConsumer;

    public Streams(ExConsumer<T> exConsumer) {
        this.exConsumer = exConsumer;
    }

    public static <T> Streams<T> of(List<T> list) {
        return new Streams<>(list::forEach);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        return new Streams<>(p -> exConsumer.generator(
          p1 -> {
              if(predicate.test(p1))
                  p.accept(p1);
          }
        ));
    }

    public <H> Streams <T> transform(Function<? super  T, ? extends H> tr) {
        return new Streams<>(p->exConsumer.generator(p1->
                p.accept((T) tr.apply(p1))));
    }

    public <Key,Value> Map<Key,Value> toMap(Function<? super T,? extends Key> key,
                                            Function<? super T,? extends Value> value) {
        Map<Key, Value> map = new HashMap<>();
        exConsumer.generator(p->map.put(key.apply(p),value.apply(p)));
        return map;
    }

}
