package by.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class Game extends AbstractEntity{

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

    public Game() {
    }

    // added this field to map the reviews
    @OneToMany(mappedBy="game")
    private List<Review> reviews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<GameCategoryMap> getGameCategoryMaps() {
        return gameCategoryMaps;
    }

    public void setGameCategoryMaps(List<GameCategoryMap> gameCategoryMaps) {
        this.gameCategoryMaps = gameCategoryMaps;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    // getters and setters
}
