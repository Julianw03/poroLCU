package com.julianw03.poroLCU.model.lolContentTargeting.v1;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface ContentTargetingV1 extends PluginInterface {
    Function<LCUHttpConnector, LCUApiResponse<FilterInfo>> getFilters();

    Function<LCUHttpConnector, LCUApiResponse<LocaleInfo>> getLocale();

    Function<LCUHttpConnector, LCUApiResponse<FilterInfo>> getProtectedFilters();
}
