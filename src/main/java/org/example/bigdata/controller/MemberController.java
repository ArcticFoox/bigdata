package org.example.bigdata.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.bigdata.controller.dto.MemberRequestDto;
import org.example.bigdata.controller.dto.MemberResponseDto;
import org.example.bigdata.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/member")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/search")
    @Operation(summary = "회원검색", description = "이름으로 회원 검색하는 API")
    public ResponseEntity<MemberResponseDto> get(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(memberService.findByName(name));

    }

    @GetMapping
    @Operation(summary = "전체 회원 조회", description = "회원 전체를 조회하는 API")
    public ResponseEntity<List<MemberResponseDto>> getAll(){
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "선택 회원 조회", description = "id로 회원을 조회하는 API")
    public ResponseEntity<MemberResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @PostMapping
    @Operation(summary = "회원 추가", description = "회원을 추가하는 API")
    public ResponseEntity<Long> save(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(memberService.save(memberRequestDto));
    }
}
