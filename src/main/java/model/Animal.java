package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal {

    private int id;
    private String nickname;
    private int age;
    private String breed;
    private String view;
}
