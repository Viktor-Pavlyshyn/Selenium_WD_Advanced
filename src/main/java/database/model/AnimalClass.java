package database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalClass {

    private Long id;
    private String type;

    public AnimalClass(String type) {
        this.type = type;
    }

    public AnimalClass(Long id) {
        this.id = id;
    }

}
