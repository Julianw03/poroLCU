package com.julianw03.poroLCU.model;

import com.julianw03.poroLCU.model.deepLinks.v1.DeepLinkV1;
import com.julianw03.poroLCU.model.deepLinks.v1.impl.DeepLinkV1Impl;
import com.julianw03.poroLCU.model.lolAccountVerification.v1.AccountVerificationV1;
import com.julianw03.poroLCU.model.lolAccountVerification.v1.impl.AccountVerificationV1Impl;
import com.julianw03.poroLCU.model.lolActiveBoosts.v1.ActiveBoostsV1;
import com.julianw03.poroLCU.model.lolActiveBoosts.v1.impl.ActiveBoostsV1Impl;
import com.julianw03.poroLCU.model.lolActivityCenter.v1.ActivityCenterV1;
import com.julianw03.poroLCU.model.lolActivityCenter.v1.impl.ActivityCenterV1Impl;
import com.julianw03.poroLCU.model.lolBanners.v1.BannersV1;
import com.julianw03.poroLCU.model.lolBanners.v1.impl.BannersV1Impl;
import com.julianw03.poroLCU.model.lolChallenges.v1.ChallengesV1;
import com.julianw03.poroLCU.model.lolChallenges.v1.impl.ChallengesV1Impl;
import com.julianw03.poroLCU.model.lolChallenges.v2.ChallengesV2;
import com.julianw03.poroLCU.model.lolChallenges.v2.impl.ChallengesV2Impl;
import com.julianw03.poroLCU.model.lolChampSelect.v1.ChampSelectV1;
import com.julianw03.poroLCU.model.lolChampSelect.v1.impl.ChampSelectV1Impl;
import com.julianw03.poroLCU.model.lolChampionMastery.v1.ChampionMasteryV1;
import com.julianw03.poroLCU.model.lolChampionMastery.v1.impl.ChampionMasteryV1Impl;
import com.julianw03.poroLCU.model.lolChampions.v1.ChampionsV1;
import com.julianw03.poroLCU.model.lolChampions.v1.impl.ChampionsV1Impl;
import com.julianw03.poroLCU.model.lolHovercard.v1.HovercardV1;
import com.julianw03.poroLCU.model.lolHovercard.v1.impl.HovercardV1Impl;
import com.julianw03.poroLCU.model.lolKickout.KickoutV1;
import com.julianw03.poroLCU.model.lolKickout.impl.KickoutV1Impl;
import com.julianw03.poroLCU.model.riotclient.Riotclient;
import com.julianw03.poroLCU.model.riotclient.impl.RiotclientImpl;

import java.util.HashMap;

public class Model {
    private static final HashMap<Class<? extends PluginInterface>, PluginInterface> map = new HashMap<>();

    static {
        addToLookup(DeepLinkV1.class, new DeepLinkV1Impl());
        addToLookup(AccountVerificationV1.class, new AccountVerificationV1Impl());
        addToLookup(ActiveBoostsV1.class, new ActiveBoostsV1Impl());
        addToLookup(ActivityCenterV1.class, new ActivityCenterV1Impl());
        addToLookup(BannersV1.class, new BannersV1Impl());
        addToLookup(ChallengesV1.class, new ChallengesV1Impl());
        addToLookup(ChallengesV2.class, new ChallengesV2Impl());
        addToLookup(ChampSelectV1.class, new ChampSelectV1Impl());
        addToLookup(ChampionMasteryV1.class, new ChampionMasteryV1Impl());
        addToLookup(ChampionsV1.class, new ChampionsV1Impl());
    }

    private static <T extends PluginInterface> void addToLookup(Class<T> clazz, T obj) {
        if (obj == null) return;
        map.put(clazz, obj);
    }

    public static <T> T get(Class<T> clazz) {
        return (T) map.get(clazz);
    }

    private Model() {
    }
}
