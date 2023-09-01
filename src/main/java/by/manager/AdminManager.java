package by.manager;

//import by.util.Helper;
import by.dao.UserDao;
import by.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AdminManager {


    public List<String> getUsersLog() {
        List<String> logs = new ArrayList<>();

        try {
            // Открываем файл лога для чтения
            BufferedReader reader = new BufferedReader(new FileReader("myApp.log"));

            // Читаем строки из файла и добавляем только действия пользователя или админа
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("by.controller.UserController") || line.contains("by.controller.ProfileController") ||
                        line.contains("by.controller.CategoryController") || line.contains("by.controller.GameCategoryController") ||
                        line.contains("by.controller.WishlistController") ) {
                    logs.add(line);
                } else if (line.contains("by.controller.AdminController")) {
                    logs.add(line);
                }
            }

            // Закрываем файл
            reader.close();
        } catch (IOException e) {
            // Обработка ошибок чтения файла
            e.printStackTrace();
        }

        return logs;
    }


}
