package kurbanov.restapiwork.service;

import kurbanov.restapiwork.dto.group.GetGroupDto;
import kurbanov.restapiwork.dto.group.GroupRequestDto;
import kurbanov.restapiwork.dto.group.GroupResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    GroupResponse save(GroupRequestDto groupRequestDto);

    List<GroupResponse> findAll();

    GetGroupDto findBy(Long id);

    GroupResponse update(Long id, GroupRequestDto groupRequestDto);

    void deleteById(Long id);

    GroupResponse getById(Long id);
}
