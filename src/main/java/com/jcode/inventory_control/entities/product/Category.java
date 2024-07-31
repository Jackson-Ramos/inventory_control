package com.jcode.inventory_control.entities.product;

import lombok.Getter;

@Getter
public enum Category {

    ELECTRONICS("electronics"),
    ENGINE("engine"),
    SUSPENSION("suspension"),
    BRAKES("brakes"),
    EXHAUST("exhaust"),
    BODY_PARTS("body_parts"),
    TIRES("tires"),
    LIGHTING("lighting"),
    ACCESSORIES("accessories"),
    TOOLS("tools"),
    LUBRICANTS("lubricants"),
    COOLING_SYSTEM("cooling_system"),
    FUEL_SYSTEM("fuel_system"),
    BATTERY("battery");

    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
