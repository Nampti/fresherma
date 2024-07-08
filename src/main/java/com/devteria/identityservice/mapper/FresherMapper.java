package com.devteria.identityservice.mapper;

import com.devteria.identityservice.dto.request.FresherCreationRequest;
import com.devteria.identityservice.dto.response.FresherResponse;
import com.devteria.identityservice.entity.Fresher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FresherMapper {

    Fresher toFresher(FresherCreationRequest request);

    FresherResponse toFresherResponse(Fresher fresher);
}