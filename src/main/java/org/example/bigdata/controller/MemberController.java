package org.example.bigdata.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.bigdata.controller.dto.MemberResponseDto;
import org.example.bigdata.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/api/member")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{name}")
    @Operation(summary = "회원검색", description = "이름으로 회원 검색하는 API")
    public ResponseEntity<MemberResponseDto> get(@PathVariable String name) {
        return ResponseEntity.ok(memberService.findByName(name));

    }

}
