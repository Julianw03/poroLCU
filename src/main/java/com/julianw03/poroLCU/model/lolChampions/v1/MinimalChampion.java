package com.julianw03.poroLCU.model.lolChampions.v1;

import com.julianw03.poroLCU.model.shared.Ownership;
import lombok.Getter;

import java.util.List;

@Getter
public class MinimalChampion {
    protected boolean       active;
    protected String        alias;
    protected String        banVoPath;
    protected String        baseLoadScreenPath;
    protected String        baseSplashPath;
    protected Boolean       botEnabled;
    protected String        chooseVoPath;
    protected List<Integer> disabledQueues;
    protected Boolean       freeToPlay;
    protected Integer       id;
    protected String        name;
    protected Ownership     ownership;
    protected Long          purchased;
    protected Boolean       rankedPlayEnabled;
    protected List<String>  roles;
    protected String        squarePortraitPath;
    protected String        stingerSfxPath;
    protected String        title;

    protected MinimalChampion() {
    }
}
