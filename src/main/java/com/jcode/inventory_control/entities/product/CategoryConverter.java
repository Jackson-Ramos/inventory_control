package com.jcode.inventory_control.entities.product;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {


    @Override
    public String convertToDatabaseColumn(Category category) {

        if (category == null) {
            return null;
        }
        return category.getCategoryName();
    }

    @Override
    public Category convertToEntityAttribute(String dbData) {

        if (dbData == null) {
            return null;
        }

        try {
            return Category.valueOf(dbData.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown category: " + dbData);
        }
    }
}
