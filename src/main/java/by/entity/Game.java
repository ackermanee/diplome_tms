package by.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "developer", nullable = false)
    private String developer;

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;


    // added this field to map the game category maps
    @OneToMany(mappedBy="game")
    private List<GameCategoryMap> gameCategoryMaps;

    // added this field to map the reviews
    @OneToMany(mappedBy="game")
    private List<Review> reviews;

    // getters and setters
}
