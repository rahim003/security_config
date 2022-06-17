package kurbanov.restapiwork.api;

import io.swagger.v3.oas.annotations.Operation;
import kurbanov.restapiwork.dto.company.CompanyRequestDto;
import kurbanov.restapiwork.dto.company.CompanyResponse;
import kurbanov.restapiwork.dto.company.GetCompanyDto;
import kurbanov.restapiwork.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/company")
public class CompanyApi {
    private CompanyService companyService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    @Operation(summary = "save company ", description = "You can save the company here")
    public CompanyResponse save(@RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.save(companyRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping
    @Operation(summary = "find All  company ")
    public List<CompanyResponse> findAll() {
        return companyService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")

    @GetMapping("find/by/{id}")
    public GetCompanyDto findBy(@PathVariable Long id) {
        return companyService.findBy(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("update/{id}")
    @Operation(summary = "update company ", description = "You can update the company here")
    public CompanyResponse update(@PathVariable Long id, @RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.update(id, companyRequestDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete company ", description = "You can delete the company here")
    public void deleteById(@PathVariable Long id) {
        companyService.deleteById(id);
    }
}
