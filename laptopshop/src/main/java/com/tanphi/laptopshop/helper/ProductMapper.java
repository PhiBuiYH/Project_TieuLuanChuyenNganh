package com.tanphi.laptopshop.helper;

import com.tanphi.laptopshop.entity.Product;
import com.tanphi.laptopshop.respone.product.GetProductResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static List<GetProductResponse> toResponeGetAllProduct(List<Product> productList)
    {
        List<GetProductResponse> list=new ArrayList<>();
        for(Product product:productList) {
            GetProductResponse tmp = new GetProductResponse();
            tmp.setProductId(product.getProductId());
            tmp.setProductName(product.getProductName());
            tmp.setQuantity(product.getQuantity());
            tmp.setImage(product.getImage());
            tmp.setUnitprice(product.getUnitprice());
            tmp.setDiscount(product.getDiscount());
            tmp.setDescription(product.getDescription());
            tmp.setCPU(product.getCPU());
            tmp.setRam(product.getRam());
            tmp.setWeight(product.getWeight());
            tmp.setHardDiskCapacity(product.getHardDiskCapacity());
            tmp.setHardDiskType(product.getHardDiskType());
            tmp.setScreenSize(product.getScreenSize());
            tmp.setScreenResolution(product.getScreenResolution());
            tmp.setGraphicCardName(product.getGraphicCardName());
            tmp.setGraphicCardMemory(product.getGraphicCardMemory());
            tmp.setBatteryCapacity(product.getBatteryCapacity());
            tmp.setOsSupplied(product.getOsSupplied());
            list.add(tmp);
        }
        return list;
    }
}
