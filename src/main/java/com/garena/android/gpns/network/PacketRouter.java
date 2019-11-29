package com.garena.android.gpns.network;

import com.garena.android.gpns.network.tcp.TCPPacket;
import com.garena.android.gpns.processor.AbstractProcessor;
import com.garena.android.gpns.processor.PushIdResponseProcessor;
import com.garena.android.gpns.processor.PushMsgArrivedProcessor;
import com.garena.android.gpns.processor.RegionResponseProcessor;
import com.garena.android.gpns.utility.AppLogger;
import java.util.HashMap;

public final class PacketRouter {
    private static HashMap<Integer, AbstractProcessor> mProcessorMap = new HashMap<>();

    public static void registerProcessors() {
        mProcessorMap.clear();
        register(new RegionResponseProcessor());
        register(new PushIdResponseProcessor());
        register(new PushMsgArrivedProcessor());
    }

    private static void register(AbstractProcessor abstractProcessor) {
        mProcessorMap.put(Integer.valueOf(abstractProcessor.getCommand()), abstractProcessor);
    }

    public static void route(TCPPacket tCPPacket) {
        AbstractProcessor abstractProcessor = mProcessorMap.get(Integer.valueOf(tCPPacket.getCommand()));
        if (abstractProcessor != null) {
            byte[] data = tCPPacket.getData();
            if (data != null) {
                try {
                    abstractProcessor.process(data, 0, data.length);
                } catch (Exception e2) {
                    AppLogger.e(e2);
                }
            }
        }
    }

    private PacketRouter() {
    }
}
