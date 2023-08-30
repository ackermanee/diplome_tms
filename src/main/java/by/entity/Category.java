package by.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_description", nullable = false)
    private String categoryDescription;

    @OneToMany(mappedBy="category", fetch = FetchType.EAGER)
    private List<GameCategoryMap> gameCategoryMap;

    public List<GameCategoryMap> getGameCategoryMaps() {
        return gameCategoryMap;
    }

    public void setGameCategoryMaps(List<GameCategoryMap> gameCategoryMap) {
        this.gameCategoryMap = gameCategoryMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
