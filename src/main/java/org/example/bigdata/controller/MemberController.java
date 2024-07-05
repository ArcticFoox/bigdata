package org.example.bigdata.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.bigdata.controller.dto.MemberResponseDto;
import org.example.bigdata.exception.dto.DataResponseDto;
import org.example.bigdata.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public DataResponseDto<List<MemberResponseDto>> get() {
        return DataResponseDto.of(memberService.findAll());
    }

}
