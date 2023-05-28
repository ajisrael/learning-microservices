package com.appsdeveloperblog.estore.ProductsService.core.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productlookup")
public class ProductLookupEntity implements Serializable { // Serializable is not completely necessary here

    private static final long serialVersionUID = 278800460547645663L;

    @Id
    @Column(unique = true)
    private String productId;
    @Column(unique = true)
    private String title;
}
