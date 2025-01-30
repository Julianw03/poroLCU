package com.julianw03.poroLCU.model.lolHovercard.v1;

import com.julianw03.poroLCU.model.shared.Product;
import com.julianw03.poroLCU.model.shared.SocialAvailability;
import com.julianw03.poroLCU.model.shared.accountId.AccountId;
import com.julianw03.poroLCU.model.shared.id.Id;
import com.julianw03.poroLCU.model.shared.puuid.Puuid;
import com.julianw03.poroLCU.model.shared.summonerId.SummonerId;

import java.util.List;

public class FriendHovercardInfo {
    private AccountId          accountId;
    private SocialAvailability availability;
    private String             gameName;
    private String             gameTag;
    private int                icon;
    private Id                 id;
    private int                legendaryMasteryScore;
    private String             name;
    private String             note;
    private List<SummonerId>   partySummoners;
    private String             patchline;
    private String             platformId;
    private Product            product;
    private String             productName;
    private Puuid              puuid;
    private boolean            remotePlatform;
    private boolean            remoteProduct;
    private String             remoteProductBackdropUrl;
    private String             remoteProductIconUrl;
    private String             statusMessage;
    private int                summonerIcon;
    private SummonerId         summonerId;
    private int                summonerLevel;

    public AccountId getAccountId() {
        return accountId;
    }

    public SocialAvailability getAvailability() {
        return availability;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameTag() {
        return gameTag;
    }

    public int getIcon() {
        return icon;
    }

    public Id getId() {
        return id;
    }

    public int getLegendaryMasteryScore() {
        return legendaryMasteryScore;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public List<SummonerId> getPartySummoners() {
        return partySummoners;
    }

    public String getPatchline() {
        return patchline;
    }

    public String getPlatformId() {
        return platformId;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductName() {
        return productName;
    }

    public Puuid getPuuid() {
        return puuid;
    }

    public boolean isRemotePlatform() {
        return remotePlatform;
    }

    public boolean isRemoteProduct() {
        return remoteProduct;
    }

    public String getRemoteProductBackdropUrl() {
        return remoteProductBackdropUrl;
    }

    public String getRemoteProductIconUrl() {
        return remoteProductIconUrl;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public int getSummonerIcon() {
        return summonerIcon;
    }

    public SummonerId getSummonerId() {
        return summonerId;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }
}
