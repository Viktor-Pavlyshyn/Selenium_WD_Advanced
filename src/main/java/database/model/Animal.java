package database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    private Long id;
    private Zoo nameZoo;
    private AnimalClass animalClass;
    private String animalName;
    private String animalAppearance;

}
