package com.compstore.mapper;

import com.compstore.dto.product.ProductDTO;
import com.compstore.entity.ProductEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {

    ProductDTO toProductDTO(ProductEntity productEntity);

    List<ProductDTO> toProductDTOList(List<ProductEntity> productsFound);
}
