package database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zoo {
    private Long id;
    private String nameZoo;

    public Zoo(String nameZoo) {
        this.nameZoo = nameZoo;
    }

    public Zoo(Long id) {
        this.id = id;
    }
}
