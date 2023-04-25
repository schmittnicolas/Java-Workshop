package fr.epita.assistants.practicelombok;

import lombok.*;


@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode(of = {"name", "nickname", "speed"})
final public class Shark {
    private final String name;
    private final String nickname;
    private final int speed;
}
