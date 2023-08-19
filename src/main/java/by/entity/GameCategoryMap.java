package by.entity;

import javax.persistence.*;

@Entity
@Table(name = "game_category_map")
public class GameCategoryMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    // getters and setters
}