package com.julianw03.poroLCU.model.lolDrops.v1;

import com.julianw03.poroLCU.model.shared.iso8601Date.ISO8601Date;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
public class DropData {
    @Getter
    @NoArgsConstructor
    public static class DisplayMetadata {
        @Getter
        @NoArgsConstructor
        public static class MinimalTable {
            private String  nameTraKey;
            private Integer priority;
        }

        private String                  bountyType;
        private UUID                    chaseContentId;
        private List<UUID>              chaseContentIds;
        private UUID                    dataAssetId;
        private Boolean                 isCollectorsBounty;
        private UUID                    mythicOfferId;
        private String                  nameTraKey;
        private OddsTree                oddsTree;
        private List<UUID>              prestigeContentIds;
        private Integer                 priority;
        private UUID                    progressionId;
        private Map<UUID, MinimalTable> tables;
        private Integer                 version;
    }

    @Getter
    @NoArgsConstructor
    public static class PityInfo {
        private List<UUID> chaseContentIds;
        private Integer    pityLimit;
    }

    @Getter
    @NoArgsConstructor
    public static class TotalRollsInfo {
        private Integer maxTotalRolls;
        private UUID    totalRollsCounterId;
    }

    private Integer         cost;
    private UUID            currencyId;
    private DisplayMetadata displayMetadata;
    private ISO8601Date     endDate;
    private UUID            id;
    private PityInfo        pityInfo;
    private UUID            productId;
    private UUID            rollOffer;
    private UUID            sourceId;
    private ISO8601Date     startDate;
    private TotalRollsInfo  totalRollsInfo;
}
