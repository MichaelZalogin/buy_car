package ru.buycar.dto;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class FileDto {

    private String name;

    private byte[] content;

}