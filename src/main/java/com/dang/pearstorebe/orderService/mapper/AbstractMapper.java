package com.dang.pearstorebe.orderService.mapper;

import java.util.List;

/**
 * Abstract class for creating mappers
 * @param <E> entity
 * @param <D> dto
 */
public interface AbstractMapper<E, D> {
    /**
     * Converts dto to entity
     * @param dto data transfer object
     * @return converted entity
     */
    E toEntity(D dto);

    /**
     * Converts entity to dto
     * @param entity entity to be converted
     * @return dto
     */
    D toDto (E entity);

    /**
     * Converts dto list to entity list
     * @param dtos list of dtos to be converted
     * @return list of entities
     */
    List<E> toEntity(List<D>dtos);
    /**
     * Converts entity list to dto list
     * @param entities list of entities to be converted
     * @return list of dtos
     */
    List<D> toDto (List<E>entities);
}
