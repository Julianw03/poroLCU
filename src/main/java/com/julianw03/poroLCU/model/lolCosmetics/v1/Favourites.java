package com.julianw03.poroLCU.model.lolCosmetics.v1;

import lombok.Getter;

import java.util.List;

@Getter
public class Favourites<T extends Item> {
    private List<T> favoriteItems;

    public Favourites() {}
}
