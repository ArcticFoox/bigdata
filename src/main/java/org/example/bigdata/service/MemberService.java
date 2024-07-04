package org.example.bigdata.service;

import lombok.RequiredArgsConstructor;
import org.example.bigdata.domain.Member;
import org.example.bigdata.domain.MemberMapper;
import org.example.bigdata.domain.MemberRepository;
import org.example.bigdata.dto.MemberRequestDto;
import org.example.bigdata.dto.MemberResponseDto;
import org.example.bigdata.dto.MemberUpdateDto;
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
        Optional<Member> member = memberRepository.findByName(name);
        //예외처리 변환 해야함
        return memberMapper.memberToMemberResponseDto(member.orElseThrow());
    }

    @Transactional
    public List<MemberResponseDto> findAll(){
        //이 부분 예외처리에 대해 질문
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
