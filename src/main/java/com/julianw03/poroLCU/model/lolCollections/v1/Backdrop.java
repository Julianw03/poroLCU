package com.julianw03.poroLCU.model.lolCollections.v1;

import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;
import lombok.Getter;

import java.util.List;

@Getter
public class Backdrop {
    @Getter
    public static class BackdropAugment {
        private String centeredLCOverlayPath;
        private String socialCardLCOverlayPath;

        private BackdropAugment() {
        }
    }

    private Long                  accountId;
    private List<BackdropAugment> backdropAugments;
    private String                backdropImage;
    private String                backdropMaskColor;
    private String                backdropType;
    private String                backdropVideo;
    private Integer               championId;
    private Integer               profileIconId;
    private Puuid                 puuid;
    private SummonerId            summonerId;

    private Backdrop() {}
}
