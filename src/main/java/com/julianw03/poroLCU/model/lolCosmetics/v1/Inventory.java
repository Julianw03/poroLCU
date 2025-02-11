package com.julianw03.poroLCU.model.lolCosmetics.v1;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Inventory<T> {
    @Getter
    @NoArgsConstructor
    private static class Group<T> {
        private Integer groupId;
        private String  groupName;
        private List<T> items;
        private Integer numAvailable;
        private Integer numOwned;
        private Long    purchaseDate;
    }

    private Integer        defaultItemId;
    private List<Group<T>> groups;
    private T              selectedLoadoutItem;
}
