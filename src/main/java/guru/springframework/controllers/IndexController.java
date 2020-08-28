package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeService recipeService;

    public IndexController(CategoryRepository categoryRepository,
            UnitOfMeasureRepository unitOfMeasureRepository,
            RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"index","/index","/",""})
    public String getIndexPage(Model model) {
        Iterable<Category> all = categoryRepository.findAll();
        all.forEach(System.out::println);

        Iterable<UnitOfMeasure> all1 = unitOfMeasureRepository.findAll();
        all1.forEach(System.out::println);

        Optional<Category> categoryOptional = categoryRepository.findByDescription("This is the category description");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Unit of measure Description");

        categoryOptional.ifPresent(category -> System.out
                .println("Get Id is: " + category.getId()));
        unitOfMeasure.ifPresent(uom -> System.out.println("UOM Id is: "+ uom.getId()));
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
