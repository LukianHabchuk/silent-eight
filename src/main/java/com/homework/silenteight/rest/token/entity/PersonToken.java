package com.homework.silenteight.rest.token.entity;

import com.homework.silenteight.entity.GenderType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonToken {
    private String name;
    private GenderType gender;
}
