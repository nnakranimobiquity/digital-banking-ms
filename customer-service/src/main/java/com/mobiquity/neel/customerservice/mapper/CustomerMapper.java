package com.mobiquity.neel.customerservice.mapper;


import com.mobiquity.neel.customerservice.entity.Customer;
import com.mobiquity.neel.customerservice.entity.enumerator.Language;
import com.mobiquity.neel.customerservice.entity.enumerator.UserStatus;
import openapi.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    @Mapping(target = "status",source = "customer.status")
    GetCustomerResponseDto customerToGetCustomerResponseDto(Customer customer);

    @Mapping(target = "usingUserName",source = "createCustomerRequestDto.userName")
    @Mapping(target = "usingFirstName",source = "createCustomerRequestDto.firstName")
    @Mapping(target = "usingLastName",source = "createCustomerRequestDto.lastName")
    @Mapping(target = "usingPhoneNumber",source = "createCustomerRequestDto.phoneNumber")
    @Mapping(target = "usingEmail",source = "createCustomerRequestDto.email")
    @Mapping(target = "usingPreferredLanguage",source = "createCustomerRequestDto.preferredLanguage")
    @Mapping(target = "usingAge",source = "age")
    Customer createCustomerRequestDtoToCustomer(CreateCustomerRequestDto createCustomerRequestDto,String age);

    Customer updateCustomerFromPatchCustomerRequestDto(PatchCustomerRequestDto patchCustomerRequestDto, @MappingTarget Customer customer);

    StatusDto userStatusToStatusDto(UserStatus status);

    UserStatus statusToUserStatus(StatusDto statusDto);

    PreferredLanguageDto languageToPreferredLanguageDto(Language language);

    Language preferredLanguageDtoToLanguage(PreferredLanguageDto preferredLanguageDto);
}
