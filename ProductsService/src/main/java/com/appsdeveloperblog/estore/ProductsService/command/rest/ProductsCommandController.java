package com.appsdeveloperblog.estore.ProductsService.command.rest;

import com.appsdeveloperblog.estore.ProductsService.command.commands.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductsCommandController {

    // Property based dependency injection
//    @Autowired
//    private Environment environment;

    private final Environment environment;
    private final CommandGateway commandGateway;

    // Constructor based dependency injection
    @Autowired
    public ProductsCommandController(Environment environment, CommandGateway commandGateway) {
        this.environment = environment;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString()).build();

        return commandGateway.sendAndWait(createProductCommand);
    }
}
