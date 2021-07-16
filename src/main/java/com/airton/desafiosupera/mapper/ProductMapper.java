package com.airton.desafiosupera.mapper;

import com.airton.desafiosupera.dto.ProductDTO;
import com.airton.desafiosupera.dto.ShopcartDTO;
import com.airton.desafiosupera.entities.Shopcart;
import com.airton.desafiosupera.entities.ShopcartProduct;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ShopcartMapper {

    public static ShopcartDTO toDTO(Shopcart shopcart, String sortAttribute) {
        ShopcartDTO dto = new ShopcartDTO();

        dto.setId(shopcart.getId());
        dto.setMoment(shopcart.getMoment());

        for (ShopcartProduct sp : shopcart.getProducts()) {
            ProductDTO pdto = new ProductDTO();
            pdto.setQuantity(sp.getQuantity());
            pdto.setId(sp.getProduct().getId());
            pdto.setName(sp.getProduct().getName());
            pdto.setScore(sp.getProduct().getScore());
            pdto.setPrice(sp.getProduct().getPrice());
            pdto.setImage(sp.getProduct().getImage());
            dto.setProductQuantity(dto.getProductQuantity() + sp.getQuantity());
            dto.getProducts().add(pdto);
        }

        if (StringUtils.isNotBlank(sortAttribute)) { //verificar se não é null/vazio/apenas espaço/ " "
            dto.sortProducts(sortAttribute);
        }
        return dto;
    }

    public static ShopcartDTO toDTO(Shopcart shopcart) {
        return toDTO(shopcart, null);
    }


    public static List<ShopcartDTO> toDTOList(List<Shopcart> shopcarts, String sortAttribute) {
        List<ShopcartDTO> listDTO = new ArrayList<>();
        for (Shopcart shop : shopcarts) {
            listDTO.add(toDTO(shop, sortAttribute));
        }
        return listDTO;
    }

    public static List<ShopcartDTO> toDTOList(List<Shopcart> shopcarts) {
        return toDTOList(shopcarts, null);
    }

}
