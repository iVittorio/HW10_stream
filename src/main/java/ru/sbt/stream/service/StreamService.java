package ru.sbt.stream.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


public class StreamService<T> {
    private final List<T> list;

    public StreamService(List<T> list) {
        this.list = list;
    }

    public static <E> StreamService<E> of(List<E> list) {
        List<E> streamList = new ArrayList<>();
        for (E e : list) {
            streamList.add(e);
        }
        return new StreamService<>(streamList);
    }

    public StreamService<T> filter(Predicate<? super T> predicate) {
        List<T> list = new ArrayList<>();
        for (T t : this.list) {
            if (predicate.test(t)) {
                list.add(t);
            }
        }
        return new StreamService<>(list);
    }


    public <E> StreamService<E> transform(Function<? super T, ? extends E> function) {
        List<E> list = new ArrayList<>();
        for (int i = 0; i < this.list.size(); i++) {
            list.add(function.apply(this.list.get(i)));
        }
        return new StreamService<>(list);
    }


    public <E, R> Map<E, R> toMap(Function<? super T, ? extends E> f1, Function<? super T, ? extends R> f2) {
        Map<E, R> map = new HashMap<>();
        for (T t : this.list) {
            map.put(f1.apply(t), f2.apply(t));
        }
        return map;
    }
}
