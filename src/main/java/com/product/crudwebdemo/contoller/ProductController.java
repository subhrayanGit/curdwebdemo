package com.product.crudwebdemo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.product.crudwebdemo.model.Product;
import com.product.crudwebdemo.respository.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product/list";
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "product/view";
    }

    @GetMapping("/create")
    public String createProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String updateProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "product/update";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
    
}
