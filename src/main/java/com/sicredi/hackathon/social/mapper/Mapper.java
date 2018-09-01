package com.sicredi.hackathon.social.mapper;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public interface Mapper<T, R> {

    R map(final T t);

    default List<R> mapList(final List<T> t) {
        if (isNull(t)) {
            return null;
        }
        return t.stream().map(this::map).collect(Collectors.toList());
    }

}
