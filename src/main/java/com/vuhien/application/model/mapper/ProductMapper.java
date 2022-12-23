package com.vuhien.application.model.mapper;

import com.github.slugify.Slugify;
import com.vuhien.application.config.CommonUtil;
import com.vuhien.application.entity.Brand;
import com.vuhien.application.entity.Category;
import com.vuhien.application.entity.Certification;
import com.vuhien.application.entity.Product;
import com.vuhien.application.model.dto.ProductDTO;
import com.vuhien.application.model.request.CreateProductRequest;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ProductMapper {
    public static ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setDateOfManufacture(product.getDateOfManufacture().toString());
        productDTO.setExpiry(product.getExpiry().toString());
        productDTO.setSalePrice(product.getSalePrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setImages(product.getImages());
        productDTO.setFeedBackImages(product.getImageFeedBack());
        productDTO.setTotalSold(product.getTotalSold());
        productDTO.setStatus(product.getStatus());

        return productDTO;
    }

    public static Product toProduct(CreateProductRequest createProductRequest) {
        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setDescription(createProductRequest.getDescription());
        product.setPrice(createProductRequest.getPrice());
        product.setQuantity(createProductRequest.getQuantity());
        product.setDateOfManufacture(CommonUtil.convertStringToDate(createProductRequest.getDateOfManufacture(), false));
        product.setExpiry(CommonUtil.convertStringToDate(createProductRequest.getExpiry(), false));
        product.setSalePrice(createProductRequest.getSalePrice());
        product.setImages(createProductRequest.getImages());
        product.setImageFeedBack(createProductRequest.getFeedBackImages());
        product.setStatus(createProductRequest.getStatus());
        //Gen slug
        Slugify slug = new Slugify();
        product.setSlug(slug.slugify(createProductRequest.getName()));
        //Brand
        Brand brand = new Brand();
        brand.setId(createProductRequest.getBrandId());
        product.setBrand(brand);
        //Category
        ArrayList<Category> categories = new ArrayList<>();
        for (Integer id : createProductRequest.getCategoryIds()) {
            Category category = new Category();
            category.setId(id);
            categories.add(category);
        }
        product.setCategories(categories);

        ArrayList<Certification> certifications = new ArrayList<>();
        for (Long id : createProductRequest.getCertification_ids()) {
            Certification certification = new Certification();
            certification.setId(id);
            certifications.add(certification);
        }
        product.setCertifications(certifications);

        return product;
    }
}
