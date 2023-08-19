package by.manager;



import by.dao.ReviewDao;
import by.entity.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReviewManager {

    @Autowired
    private ReviewDao reviewDao;



    public void save(Review review) {
        reviewDao.save(review);
    }

    public void delete(Review review) {
        reviewDao.delete(review);
    }

    public Review getById(int id) {
        return reviewDao.getById(id, Review.class);
    }





    public List<Review> getReview() {
        return reviewDao.getList();
    }



    public void editUser(Review review) {
        reviewDao.update(review);
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
