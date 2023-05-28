package com.appsdeveloperblog.estore.ProductsService.query;

import com.appsdeveloperblog.estore.ProductsService.core.data.ProductEntity;
import com.appsdeveloperblog.estore.ProductsService.core.data.ProductsRepository;
import com.appsdeveloperblog.estore.ProductsService.core.events.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
public class ProductProjection {

    private final ProductsRepository productsRepository;

    public ProductProjection(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {

        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        productsRepository.save(productEntity);
    }
}
