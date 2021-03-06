package com.yang.codeboy.io;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-07
 */
@Slf4j
public class IntegerAddDecoder extends ReplayingDecoder<IntegerAddDecoder.Status> {
    enum Status {
        PARSE_1, PARSE_2
    }

    private int first;
    private int second;

    public IntegerAddDecoder() {
        super(Status.PARSE_1);
    }

    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        switch (state()) {
            case PARSE_1:
                first = in.readInt();
                checkpoint(Status.PARSE_2);
                break;
            case PARSE_2:
                second = in.readInt();
                Integer sum = first + second;
                out.add(sum);
                checkpoint(Status.PARSE_1);
                break;
            default:
                break;
        }
    }
}
