package org.digitalwallet.common.mapper;

import java.util.List;

public abstract class BaseMapper<E, R, S> {

    public abstract S toResponseDTO(E entity);

    public abstract E toEntity(R dto);

    public List<S> toResponseDTOList(List<E> entities) {
        return entities.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public List<E> toEntityList(List<R> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

}
