package com.julianw03.poroLCU;

import com.julianw03.poroLCU.state.LCUConnectionState;

public interface ConnectionStateListener {
    void onConnectionState(LCUConnectionState state);
}
