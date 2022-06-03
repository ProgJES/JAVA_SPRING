package practice2.Practice2.domain;

import javax.persistence.*;

//ENTITY THAT IS MANAGED BY JPA
@Entity
public class Member {
    //AUTO_INCREMENT SETTING
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
