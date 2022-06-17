package kurbanov.restapiwork.service;

import kurbanov.restapiwork.dto.company.CompanyRequestDto;
import kurbanov.restapiwork.dto.company.CompanyResponse;
import kurbanov.restapiwork.dto.company.GetCompanyDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    CompanyResponse save(CompanyRequestDto companyRequestDto);

    List<CompanyResponse> findAll();

    GetCompanyDto findBy(Long id);

    CompanyResponse update(Long id, CompanyRequestDto companyRequestDto);

    void deleteById(Long id);

}
