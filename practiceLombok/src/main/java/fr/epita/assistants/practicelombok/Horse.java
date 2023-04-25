package fr.epita.assistants.practicelombok;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"name", "nickname"})

public class Horse {
    @Getter @Setter private String name;
    @ToString.Exclude @Getter @Setter private String nickname;
    @Getter private int speed;
}
