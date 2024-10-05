package com.sise.restaurant_api.mappers;

import com.sise.restaurant_api.entities.Sucursal;
import com.sise.restaurant_api.payload.request.SucursalRequest;
import com.sise.restaurant_api.shared.IMapperBase;

public class SucursalMapper implements IMapperBase<Sucursal, SucursalRequest> {

    @Override
    public Sucursal requestToEntity(SucursalRequest request) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(request.getNombre());
        sucursal.setDireccion(request.getDireccion());
        sucursal.setImagenUrl(request.getImagenUrl());
        sucursal.setTelefono(request.getTelefono());
        sucursal.setCorreo(request.getCorreo());
        sucursal.setDiasAtencion(request.getDiasAtencion());
        sucursal.setHorarioAtencion(request.getHorarioAtencion());
        sucursal.setLatitud(request.getLatitud());
        sucursal.setLongitud(request.getLongitud());
        return sucursal;
    }
    
}
