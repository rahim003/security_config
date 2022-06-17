package kurbanov.restapiwork.dto.company.mapper;

import kurbanov.restapiwork.dto.company.GetCompanyDto;
import kurbanov.restapiwork.entity.Company;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetCompanyMapper implements Converter<Company, GetCompanyDto> {
    @Override
    public GetCompanyDto convert(Company company) {
        GetCompanyDto getCompanyDto=new GetCompanyDto();
        getCompanyDto.setCompanyName(company.getCompanyName());
        getCompanyDto.setId(company.getId());
        getCompanyDto.setLocatedCountry(company.getLocatedCountry());
        getCompanyDto.setCourseSet(company.getCourses());
        return getCompanyDto;
    }
}
