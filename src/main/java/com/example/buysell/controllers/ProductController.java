package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    @GetMapping("/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product){ // в category передается объект для вставки в БД
//        //MyLogger.debugMethodName("CategoryController: add(category) ---------------------------------------------------------- ");
//        if (product.getId() != null && product.getId() != 0) {
//            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
//        }
//        if (product.getTitle() == null || product.getTitle().trim().length() == 0) {
//            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
//        }

        return ResponseEntity.ok(productService.add(product));
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}