package by.manager;


import by.dao.OrderTypeDao;
import by.entity.OrderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderTypeManager {


    @Autowired
    private OrderTypeDao orderTypeDao;

    public OrderType getById(int id) {
        return orderTypeDao.getById(id, OrderType.class);
    }
}
