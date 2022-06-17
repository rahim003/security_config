package kurbanov.restapiwork.dto.group.mapper;

import kurbanov.restapiwork.dto.group.GetGroupDto;
import kurbanov.restapiwork.entity.Group;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetGroupMapper implements Converter<Group, GetGroupDto> {
    @Override
    public GetGroupDto convert(Group group) {
        GetGroupDto getGroupDto=new GetGroupDto();
        getGroupDto.setGroupName(group.getGroupName());
        getGroupDto.setId(group.getId());
        getGroupDto.setDateOfStart(group.getDateOfStart());
        getGroupDto.setDateOfFinish(group.getDateOfFinish());
        return getGroupDto;
    }


}
