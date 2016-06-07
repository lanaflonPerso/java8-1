package com.michalprzysucha.java8.collectors;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author Michal Przysucha
 */
public class MultivaluedMapCollector<T, K, V> implements Collector<T, MultivaluedMap<K, V>, MultivaluedMap<K, V>> {

    private Function<T, K> keyMapper;
    private Function<T, V> valueMapper;

    private MultivaluedMapCollector(Function<T, K> keyMapper, Function<T, V> valueMapper) {
        this.keyMapper = keyMapper;
        this.valueMapper = valueMapper;
    }

    public static <T, K, V> MultivaluedMapCollector<T, K, V> toMultivaluedMap(Function<T, K> keyMapper, Function<T, V> valueMapper) {
        return new MultivaluedMapCollector<>(keyMapper, valueMapper);
    }

    public Supplier<MultivaluedMap<K, V>> supplier() {
        return mapSupplier();
    }

    public BiConsumer<MultivaluedMap<K, V>, T> accumulator() {
        return (acc, elem) -> acc.add(keyMapper.apply(elem), valueMapper.apply(elem));
    }

    public BinaryOperator<MultivaluedMap<K, V>> combiner() {
        return (left, right) -> combine(left, right);
    }

    public Function<MultivaluedMap<K, V>, MultivaluedMap<K, V>> finisher() {
        return m -> m;
    }

    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }

    private static <K, V> MultivaluedMap<K, V> combine(MultivaluedMap<K, V> left, MultivaluedMap<K, V> right) {
        MultivaluedMap<K, V> combined = MultivaluedMapCollector.<K, V>mapSupplier().get();
        left.forEach((k, v) -> v.forEach(e -> combined.add(k, e)));
        right.forEach((k, v) -> v.forEach(e -> combined.add(k, e)));
        return combined;
    }

    private static <K, V> Supplier<MultivaluedMap<K, V>> mapSupplier() {
        return MultivaluedHashMap<K, V>::new;
    }

}

