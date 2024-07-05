package org.example.bigdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.bigdata.domain.Member;

@Getter
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
