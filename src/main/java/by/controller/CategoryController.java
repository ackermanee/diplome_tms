package by.controller;


import by.dao.CategoryDao;
//import by.dto.CategoryDTO;
import by.entity.Category;
import by.entity.Game;
import by.entity.GameCategoryMap;
import by.entity.User;
import by.manager.CategoryManager;
import by.manager.GameCategoryMapManager;
import by.manager.GameManager;
import by.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private UserManager userManager;

    @Autowired
    private GameCategoryMapManager gameCategoryMapManager;

    @Autowired
    private GameManager gameManager;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryManager categoryManager;

//    @GetMapping("/category")
//    public String getCategory(Principal principal, ModelMap map, @RequestParam(value = "error", required = false) String error) {
//        User user = userManager.findByLogin(principal.getName());
//        map.put("user", user);
//        return "category";
//    }

    @GetMapping("/categories")
    public String getCategories(Principal principal, ModelMap map) {
        User user = userManager.findByLogin(principal.getName());
        map.put("user", user);
        List<Category> category = categoryManager.getCategoryList();
        map.put("categories", category);
        List<GameCategoryMap> gameCategoryMap = gameCategoryMapManager.getGameCategoryMap();
        map.put("gameCategoryMap", gameCategoryMap);
        List<Game> game = gameManager.getGameList();
        map.put("game", game);
//        map.put("providers", providerManager.getProviders().stream().limit(5).collect(Collectors.toList()));
        return "categories";
    }


    @GetMapping("/delete")
    public String deleteCategoryById (@RequestParam("id") int categoryId) {
        Category category = categoryManager.getById(categoryId);
        categoryDao.deleteCategory(categoryId);
        log.info("Категория " + category.getCategoryName() + " была удалена из системы");
        return "redirect:/category";
    }

    @GetMapping("/categoryGame")
    public String getLibrary(@RequestParam(value = "id") Integer id, ModelMap map, Principal principal) {
        User user = userManager.findByLogin(principal.getName());
        map.put("user", user);
        Category category = categoryManager.getById(id);
        map.put("category", category);
        List<GameCategoryMap> gameCategoryMapList = category.getGameCategoryMaps();
        List<Game> gameList = new ArrayList<>();
        for (GameCategoryMap gameCategoryMap: gameCategoryMapList) {
            Game game = gameCategoryMap.getGame();
            gameList.add(game);
        }
        map.put("game", gameList);

//        map.put("game", gameManager.categoryManager.getById(id).);
//        map.put("gameCategoryMap", gameCategoryMapManager.getById(id));
        return "categoryGame";
    }




//    //
//    @GetMapping("/category")
//    public String getDelivery(@RequestParam(value = "id") Integer id, ModelMap map, Principal principal) {
//        User user = userManager.findByLogin(principal.getName());
//        map.put("user", user);
////        map.put("products", productManager.getProducts());
////        map.put("providers", providerManager.getProviders());
////        map.put("productList", deliveryManager.getDeliveryProductLIst(deliveryManager.getById(id)));
//        map.put("category", categoryManager.getById(id));
//        return "category";
//    }

    @PostMapping("/categoryGame")
    public String updateDelivery(@ModelAttribute Category category) {
        return "redirect:/category/categoryGame?id=" + category.getId();
    }

//    }





























//    @GetMapping("/createCategory")
//    public String createDelivery(ModelMap map, Principal principal) {
//        User user = userManager.findByLogin(principal.getName());
//        map.put("user", user);
//        map.put("categoryDTO", new CategoryDTO());
////        map.put("games", gameManager.getGames());
////        map.put("categorylist", categoryManager.getProductList());
//        return "createDelivery";
//    }
//
//    @PostMapping("/createCategory")
//    public String saveCategory(@ModelAttribute @Valid CategoryDTO categoryDTO, BindingResult bindingResult,
//                               Principal principal, RedirectAttributes redirectAttributes) {
//        User user = userManager.findByLogin(principal.getName());
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
//            return "redirect:/category/createCategory";
//        }
//        categoryManager.saveCategory(categoryDTO);
//        return "redirect:/category/categories";
//    }
//
//    @PostMapping("/createCategoryGameList")
//    public String createDeliveryProductList(@ModelAttribute @Valid DeliveryProductMapDTO deliveryProductMapDTO,
//                                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
//            return "redirect:/delivery/createDelivery";
//        }
//        categoryManager.setUpProductList(deliveryProductMapDTO);
//        return "redirect:/delivery/createDelivery";
//    }
//
//    @GetMapping("/editDelivery")
//    public String getDelivery(@RequestParam(value = "id") Integer id, ModelMap map, Principal principal) {
//        User user = userManager.findByLogin(principal.getName());
//        map.put("user", user);
//        map.put("products", categoryManager.пу());
//        map.put("providers", providerManager.getProviders());
//        map.put("productList", deliveryManager.getDeliveryProductLIst(deliveryManager.getById(id)));
//        map.put("delivery", deliveryManager.getById(id));
//        return "delivery";
//    }
//
//
//
//    @GetMapping("/deleteDelivery")
//    public String deleteDelivery(@RequestParam(value = "id") Integer id, Principal principal) {
//        Delivery delivery = deliveryManager.getById(id);
//        deliveryManager.delete(delivery);
//        log.info("Пользователь " + userManager.findByLogin(principal.getName()).getLogin() + " отменил поставку от " +
//                helper.formatDate(delivery.getDate()));
//        return "redirect:/delivery/deliveries";
//    }
//
//    @PostMapping("/editDelivery")
//    public String updateDelivery(@ModelAttribute Delivery delivery) {
////        deliveryManager.updateDelivery(delivery);
//        return "redirect:/delivery/editDelivery?id=" + delivery.getId();
//    }
//
//    @GetMapping("/deliveries")
//    public String getDeliveries(Principal principal, ModelMap map) {
//        User user = userManager.findByLogin(principal.getName());
//        map.put("user", user);
//        if (!user.isApproved()) {
//            return "approvalWaitingPage";
//        }
//        List<Delivery> deliveries = deliveryManager.getDeliveryList();
//        deliveries.sort(Comparator.comparing(Delivery::getDate));
//        map.put("deliveries", deliveries);
//        map.put("providers", providerManager.getProviders().stream().limit(5).collect(Collectors.toList()));
//        return "deliveries";
//    }
//
//    @GetMapping("/takeDelivery")
//    public String takeDelivery(@RequestParam("id") Integer id, Principal principal) {
//        Delivery delivery = deliveryManager.getById(id);
//        deliveryManager.takeDelivery(delivery);
//        log.info("Пользователь " + userManager.findByLogin(principal.getName()).getLogin() + " принял поставку от " +
//                helper.formatDate(delivery.getDate()));
//        return "redirect:/storage";
//    }
//
//    @GetMapping("/deleteProducts")
//    public String deleteProduct() {
//        deliveryManager.deleteProductList();
//        return "redirect:/delivery/createDelivery";
//    }
}

