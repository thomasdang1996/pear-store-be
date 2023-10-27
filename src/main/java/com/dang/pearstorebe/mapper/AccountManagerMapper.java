package com.dang.pearstorebe.mapper;

import avrogenerated.accountmanager.CreateAccountPayload;
import com.dang.pearstorebe.dto.CreateAccountRequest;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        builder = @Builder(disableBuilder = true)
)
public interface AccountManagerMapper {
    CreateAccountPayload toCreateAccountPayload(CreateAccountRequest request);
}
