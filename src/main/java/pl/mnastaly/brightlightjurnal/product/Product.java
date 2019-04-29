package pl.mnastaly.brightlightjurnal.product;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
}
