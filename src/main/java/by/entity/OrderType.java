package by.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_type")
public class OrderType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

}
