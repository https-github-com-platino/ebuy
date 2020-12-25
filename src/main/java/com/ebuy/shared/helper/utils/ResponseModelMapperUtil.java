package com.ebuy.shared.helper.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @created 14/12/2020 - 10:31 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */
@Component
public class ResponseModelMapperUtil {

    private ModelMapper modelMapper = new ModelMapper();

    public <S,D> D getResponseDTO(S s, Class<D> d ){

        return modelMapper.map(s, d);
    }
    public <D, T> List<D> getResponseDTOList(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }
    public  <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

}
