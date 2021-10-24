package com.ratnikov.model;

import lombok.*;
import org.springframework.data.annotation.AccessType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

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
