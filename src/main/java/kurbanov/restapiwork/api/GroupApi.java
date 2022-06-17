package kurbanov.restapiwork.api;

import io.swagger.v3.oas.annotations.Operation;
import kurbanov.restapiwork.dto.group.GetGroupDto;
import kurbanov.restapiwork.dto.group.GroupRequestDto;
import kurbanov.restapiwork.dto.group.GroupResponse;
import kurbanov.restapiwork.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/group")
public class GroupApi {
    private final GroupService groupService;

    @PreAuthorize("hasAnyAuthority('ADMIN,TEACHER')")
    @PostMapping("/save")
    @Operation(summary = "save group ", description = "You can save the group here")
    public GroupResponse saveGroup(@RequestBody GroupRequestDto groupRequestDto) {
        return groupService.save(groupRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping
    @Operation(summary = "findAll group ", description = "You can findAll the group here")

    public List<GroupResponse> findAllGroups() {
        return groupService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping("find/{id}")
    @Operation(summary = "findById group ", description = "You can findById the group here")
    public GetGroupDto findByIdGroup(@PathVariable Long id) {
        return groupService.findBy(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("update/{id}")
    @Operation(summary = "update group ", description = "You can update the group here")
    public GroupResponse update(@PathVariable Long id, @RequestBody GroupRequestDto groupRequestDto) {
        return groupService.update(id, groupRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN,TEACHER')")
    @DeleteMapping("delete/{id}")
    @Operation(summary = "delete group ", description = "You can delete the group here")
    public void deleteByIdGroup(@PathVariable Long id) {
        groupService.deleteById(id);
    }

}
