package org.example.bigdata.domain;

import org.example.bigdata.dto.MemberRequestDto;
import org.example.bigdata.dto.MemberResponseDto;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberResponseDto memberToMemberResponseDto(Member member);
    Member memberRequestDtoToMember(MemberRequestDto memberRequestDto);
}
