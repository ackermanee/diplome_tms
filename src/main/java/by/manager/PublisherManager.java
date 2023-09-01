package by.manager;



import by.dao.OrderDao;
import by.dao.PublisherDao;
import by.dto.UserDTO;
import by.entity.Orderr;
import by.entity.Publisher;
import by.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PublisherManager {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PublisherDao publisherDao;

    public void save(Orderr order) {
        orderDao.save(order);
    }

    public void delete(Orderr order) {
        orderDao.delete(order);
    }

    public Publisher getById(int id) {
        return publisherDao.getById(id, Publisher.class);
    }





    public List<Orderr> getOrder() {
        return orderDao.getList();
    }

    public User toUser(UserDTO userDTO) {
        User user = new User();

        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPassword(userDTO.getPassword());
        user.setNickname(userDTO.getNickname());
        user.setCountry(userDTO.getCountry());


        return user;
    }

    public void editUser(User user) {
        orderDao.update(user);
    }

//    public List<String> getUsersLog() {
//        File file = new File("myApp.log");
//        ArrayList<String> logs = new ArrayList<>();
//        String line;
//        BufferedReader bufferedReader = null;
//
//        try {
//            Reader reader = new FileReader(file);
//            try (reader) {
//                bufferedReader = new BufferedReader(reader);
//                while ((line = bufferedReader.readLine()) != null) {
//                    if (line.isEmpty()) {
//                        continue;
//                    }
//                    if (line.contains("DeliveryController") ||
//                            line.contains("c.w.controller.OrderController") ||
//                            line.contains("c.w.controller.ProviderController") ||
//                            line.contains("c.w.controller.StorageController")) {
//                        try {
////                            logs.add(helper.logParse(line));
//                        } catch (Exception e) {
//                            log.error(e.getMessage());
//                        }
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (bufferedReader != null) {
//                    try {
//                        bufferedReader.close();
//                    } catch (IOException exception) {
//                        log.error(exception.getMessage());
//                    }
//                }
//            }
//        } catch (FileNotFoundException exception) {
//            log.error(exception.getMessage());
//        }
//        return logs;
//    }
}
