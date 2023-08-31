package by.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class GameDTO {

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

    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank
    @NotEmpty
    @Size(min = 1, max = 20)
    private String developer;

    @NotBlank
    @NotEmpty
    @Size(min = 2, max = 5)
    private int price;

    public GameDTO() {
    }


}
