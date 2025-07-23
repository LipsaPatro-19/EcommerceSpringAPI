package com.example.RESTAPI.mapper;

import com.example.RESTAPI.dto.CategoryDTO;
import com.example.RESTAPI.dto.FakeStoreCategoryResponseDTO;
import com.example.RESTAPI.entity.Category;

import java.util.List;

//this mapper class is related to all the mapping of categories
public class GetAllCategoriesMapper {
    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryDTO(){
        return null;
    }

    public static List<CategoryDTO> toCategoryDTO(FakeStoreCategoryResponseDTO dto){
        return dto.getCategories().stream()
                .map(category->CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }

    public static CategoryDTO toCategoryDTOO(Category catEntity){
        return CategoryDTO.builder()
                .id(catEntity.getId())
                .name(catEntity.getName())
                .build();
    }
}
