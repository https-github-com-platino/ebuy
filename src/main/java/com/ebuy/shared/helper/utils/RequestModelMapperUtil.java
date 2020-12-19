package com.ebuy.shared.helper.utils;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @created 14/12/2020 - 10:31 PM
 * @project ebuy
 * @author Nazim Uddin Asif
 */

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RequestModelMapperUtil {
    public <S,D> D getRequestDTO(S s, Class<D> d ){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(s, d);
    }

}
