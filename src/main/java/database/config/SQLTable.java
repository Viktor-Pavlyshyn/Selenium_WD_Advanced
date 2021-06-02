package database.config;

public enum SQLTable {

    CREATE_ZOO_TABLE("CREATE TABLE IF NOT EXISTS zoo(id integer not null auto_increment, name_zoo varchar(255) not null, constraint zoo_pkey primary key(id));"),
    CREATE_ANIMAL_CLASS_TABLE("CREATE TABLE IF NOT EXISTS animal_class (id integer not null auto_increment, type_of_animal varchar(255) not null, constraint animal_class_pkey primary key(id));"),
    CREATE_ANIMAL_TABLE("CREATE TABLE IF NOT EXISTS animal (id integer not null auto_increment, name_zoo integer not null, animal_class integer not null, animal_name varchar(255) not null, animal_appearance varchar(255) not null, constraint animal_pkey primary key(id), constraint animal_zoo_fkey foreign key (name_zoo) references zoo (id), constraint animal_class_fkey foreign key (animal_class) references animal_class (id));");

    public String QUERY;

    SQLTable(String QUERY) {
        this.QUERY = QUERY;
    }
}
