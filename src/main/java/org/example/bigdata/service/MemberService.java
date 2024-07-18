package org.example.bigdata.service;

import lombok.RequiredArgsConstructor;
import org.example.bigdata.domain.Member;
import org.example.bigdata.domain.MemberMapper;
import org.example.bigdata.domain.MemberRepository;
import org.example.bigdata.controller.dto.MemberRequestDto;
import org.example.bigdata.controller.dto.MemberResponseDto;
import org.example.bigdata.controller.dto.MemberUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    @Transactional
    public Long save(MemberRequestDto requestDto){
        Member member = memberMapper.memberRequestDtoToMember(requestDto);
        return memberRepository.save(member).getId();
    }

    @Transactional
    public MemberResponseDto findByName(String name){
        Member member = memberRepository.findByName(name).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 멤버입니다."));

        return memberMapper.memberToMemberResponseDto(member);
    }

    @Transactional
    public MemberResponseDto findById(Long id){
        Member member = memberRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 멤버입니다."));

        return memberMapper.memberToMemberResponseDto(member);
    }

    @Transactional
    public List<MemberResponseDto> findAll(){

        return memberRepository.findAll().stream()
                .map(MemberResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void update(Long id, MemberUpdateDto dto){
        Member member = memberRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 맴버입니다."));

        member.update(dto.getName(), dto.getPhone(), dto.getAddress());
    }

    @Transactional
    public void delete(Long id){
        Member member = memberRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 맴버입니다."));

        memberRepository.delete(member);
    }
}
