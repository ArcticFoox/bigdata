package org.example.bigdata.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bigdata.domain.Member;

@Getter
@Setter
@NoArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String name;
    private String phone;
    private String address;

    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.phone = member.getPhone();
        this.address = member.getAddress();
    }
}
