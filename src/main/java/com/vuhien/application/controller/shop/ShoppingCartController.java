package com.vuhien.application.controller.shop;

import com.vuhien.application.entity.CartItem;
import com.vuhien.application.entity.Product;
import com.vuhien.application.entity.User;
import com.vuhien.application.repository.ProductRepository;
import com.vuhien.application.security.CustomUserDetails;
import com.vuhien.application.service.CartItemServiceService;
import com.vuhien.application.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private CartItemServiceService cartItemServiceService;

    @Autowired
    private UserService userService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/gio-hang")
    public String showShoppingCart(Model model){
        User user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
//        List<CartItem> listCartItems = cartItemServiceService.listCartItems(user);
        Collection<CartItem> listCartItems = cartItemServiceService.getCartItems();
        model.addAttribute("listCartItems", listCartItems);

        return "shop/shopping_cart_v1";
    }

//    @PostMapping("/gio-hang/create/{productId}/{qty}")
//    public String addProductToCart(@PathVariable("productId") String productId,
//                                   @PathVariable("qty") Long quantity,
//                                   @AuthenticationPrincipal Authentication authentication){
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
//            return "Bạn cần đăng nhập để thêm sản phẩm vào giỏ hàng!";
//        }
//
//        User user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
//
//        if (user == null){
//            return "Bạn cần đăng nhập để thêm sản phẩm vào giỏ hàng!";
//        }
//
//        Long addedQuantity = cartItemServiceService.addProduct(productId, quantity, user);
//
//        return addedQuantity + "sản phẩm đã được thêm vào giỏ hàng!";
//    }
    @GetMapping("gio-hang/add/{productId}")
    public String add(@PathVariable("productId") String productId,
                      @AuthenticationPrincipal Authentication authentication){
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
//            return "Bạn cần đăng nhập để thêm sản phẩm vào giỏ hàng!";
//        }

        User user = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();

        if (user == null){
            return "Bạn cần đăng nhập để thêm sản phẩm vào giỏ hàng!";
        }
        Product product = productRepository.findById(productId).get();

        if (product != null){
            CartItem item = new CartItem();
            BeanUtils.copyProperties(product, item);
            cartItemServiceService.add(item);
        }
        return "shop/shopping_cart_v1";
    }
}
