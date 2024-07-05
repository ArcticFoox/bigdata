package org.example.bigdata.domain;

import org.example.bigdata.controller.dto.MemberRequestDto;
import org.example.bigdata.controller.dto.MemberResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MemberMapper {
//    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);
    MemberResponseDto memberToMemberResponseDto(Member member);
    Member memberRequestDtoToMember(MemberRequestDto memberRequestDto);
}
