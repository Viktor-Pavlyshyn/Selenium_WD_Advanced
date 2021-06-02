package database.config;

public enum SQLProp {

    INSERT_ZOO("INSERT INTO zoo(id, name_zoo) VALUES(DEFAULT, ?)"),
    SELECT_BY_ID_ZOO("SELECT id, name_zoo FROM zoo WHERE id=?"),
    UPDATE_ZOO("UPDATE zoo SET name_zoo=? WHERE id=?"),
    DELETE_ZOO("DELETE FROM zoo WHERE id=?"),
    SELECT_ALL_ZOO("SELECT id, name_zoo FROM zoo"),

    INSERT_ANIMAL_CLASS("INSERT INTO animal_class(id, type_of_animal) VALUES(DEFAULT, ?)"),
    SELECT_BY_ID_ANIMAL_CLASS("SELECT id, type_of_animal FROM animal_class WHERE id=?"),
    SELECT_ALL_ANIMAL_CLASS("SELECT id, type_of_animal FROM animal_class"),
    UPDATE_ANIMAL_CLASS("UPDATE animal_class SET type_of_animal=? WHERE id=?"),
    DELETE_ANIMAL_CLASS("DELETE FROM animal_class WHERE id=?"),

    INSERT_ANIMAL("INSERT INTO animal(id, name_zoo, animal_class, animal_name, animal_appearance) VALUES(DEFAULT, ?, ?, ?, ?)"),
    SELECT_BY_ID_ANIMAL("SELECT id, name_zoo, animal_class, animal_name, animal_appearance FROM animal WHERE id=?"),
    UPDATE_ANIMAL("UPDATE animal SET name_zoo=?, animal_class=?, animal_name=?, animal_appearance=? WHERE id=?"),
    DELETE_ANIMAL("DELETE FROM animal WHERE id=?"),
    DELETE_ANIMAL_BY_ZOO("DELETE FROM animal WHERE name_zoo=?"),
    DELETE_ANIMAL_BY_ANIMAL_ClASS_AND_ZOO("DELETE FROM animal WHERE animal_class=? AND name_zoo=?"),
    DELETE_ANIMAL_BY_ANIMAL_ClASS("DELETE FROM animal WHERE animal_class=?"),
    SELECT_ALL_ANIMAL_BY_ZOO_AND_CLASS("SELECT animal.id, zoo.name_zoo, animal_class.type_of_animal, animal.animal_name, animal.animal_appearance FROM animal INNER JOIN zoo on zoo.id = animal.name_zoo INNER JOIN animal_class on animal_class.id = animal.animal_class WHERE animal.name_zoo=? and animal.animal_class=?"),
    SELECT_ALL_CLASS_BY_ZOO("SELECT animal_class.id FROM animal INNER JOIN animal_class on animal_class.id = animal.animal_class WHERE animal.name_zoo=?");

    public String QUERY;

    SQLProp(String QUERY) {
        this.QUERY = QUERY;
    }
}
