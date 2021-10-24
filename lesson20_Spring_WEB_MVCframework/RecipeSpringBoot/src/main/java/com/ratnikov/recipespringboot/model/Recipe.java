package com.ratnikov.recipespringboot.model;

import lombok.*;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AccessType(AccessType.Type.FIELD)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Recipe implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String descriptions;
    private String date;
}
