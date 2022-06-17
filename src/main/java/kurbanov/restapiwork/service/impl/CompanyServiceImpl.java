package kurbanov.restapiwork.service.impl;

import kurbanov.restapiwork.dto.company.CompanyRequestDto;
import kurbanov.restapiwork.dto.company.CompanyResponse;
import kurbanov.restapiwork.dto.company.GetCompanyDto;
import kurbanov.restapiwork.dto.company.mapper.CompanyMapper;
import kurbanov.restapiwork.dto.company.mapper.GetCompanyMapper;
import kurbanov.restapiwork.entity.Company;
import kurbanov.restapiwork.exception.BadRequestException;
import kurbanov.restapiwork.exception.NotFoundException;
import kurbanov.restapiwork.repository.CompanyRepository;
import kurbanov.restapiwork.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final GetCompanyMapper getCompanyMapper;

    @Override
    public CompanyResponse save(CompanyRequestDto companyRequestDto) {
        String companyName = companyRequestDto.getCompanyName();
        boolean exists = companyRepository.existsByCompanyName(companyName);
        if (exists) {
            throw new BadRequestException(
                    String.format("company with companyName = %s has already exists", companyName)
            );
        }
        Company company = companyMapper.convert(companyRequestDto);
        Company save = companyRepository.save(company);
        log.info("successful save company:{}", save);
        return companyMapper.deConvert(save);
    }

    @Override
    public List<CompanyResponse> findAll() {
        log.info("find all Company:{}", companyRepository.findAll());
        return companyRepository.findAll().stream()
                .map(companyMapper::deConvert).toList();
    }

    @Override
    public GetCompanyDto findBy(Long id) {
        if (id != null) {
            Company company = findById(id);
            log.info("successfully find by id company:{}", id);
            return getCompanyMapper.convert(company);
        }
        return null;
    }

    @Override
    @Transactional
    public CompanyResponse update(Long id, CompanyRequestDto companyRequestDto) {
        Company company = findById(id);
        String currentCompanyName = company.getCompanyName();
        String newCompanyName = companyRequestDto.getCompanyName();
        if (!currentCompanyName.equals(newCompanyName)) {
            company.setCompanyName(newCompanyName);
        }
        String currentLocatedCountry = company.getLocatedCountry();
        String newLocatedCountry = companyRequestDto.getLocatedCountry();
        if (!currentLocatedCountry.equals(newLocatedCountry)) {
            company.setLocatedCountry(newLocatedCountry);
        }
        log.info("successfully update company:{}", companyRequestDto);
        return companyMapper.deConvert(company);
    }

    @Override
    public void deleteById(Long id) {
        boolean exists = companyRepository.existsById(id);
        if (!exists) {
            throw new BadRequestException(
                    String.format("client with id = %s does not exists", id)
            );
        }
        log.info("successfully delete company id:{}", id);
        companyRepository.deleteById(id);
    }


    private Company findById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("client with id = %s does not exists", id)
                ));
    }

}
