package by.entity;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;


}
