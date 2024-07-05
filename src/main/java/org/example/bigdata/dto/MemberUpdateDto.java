package org.example.bigdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateDto {
    private String name;
    private String phone;
    private String address;
}
