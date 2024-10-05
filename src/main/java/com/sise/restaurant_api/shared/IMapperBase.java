package com.sise.restaurant_api.shared;
public interface IMapperBase<TEntity,TRequest> {
    TEntity requestToEntity(TRequest request);
}
