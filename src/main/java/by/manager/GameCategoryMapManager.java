package by.manager;


import by.dao.*;
//import by.dto.CategoryDTO;
import by.entity.Game;
import by.entity.GameCategoryMap;
import by.manager.CategoryManager;
import by.dto.UserDTO;
import by.entity.Category;
import by.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GameCategoryMapManager {

    @Autowired
    private GameCategoryMapDao gameCategoryMapDao;

    @Autowired
    private CategoryManager categoryManager;


    public void delete(GameCategoryMap gameCategoryMap) {
        gameCategoryMapDao.delete(gameCategoryMap);
    }

    public GameCategoryMap getById(int id) {
        return gameCategoryMapDao.getById(id, GameCategoryMap.class);
    }

    public List<GameCategoryMap> getGameCategoryMap() {
        return gameCategoryMapDao.getList();
    }


    public void save(GameCategoryMap gameCategoryMap) {
        gameCategoryMapDao.save(gameCategoryMap);
    }
}
