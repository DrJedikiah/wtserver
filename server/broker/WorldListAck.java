/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wtserver.server.broker;

import wtserver.client.ServerMsg;
import java.nio.ByteBuffer;
import java.util.Random;

/**
 *
 * @author MSI
 */
public class WorldListAck extends ServerMsg {
    private final short msgId = ServerMsg.CS_BR_WORLDLIST_ACK;
    
    public WorldListAck()
    {
        size = 8;
        buffer = ByteBuffer.allocate(1024);
    }
    
    public byte [] getData(short seqNum)
    {
        buffer.position(0);
        byte random = (byte) new Random().nextInt();
        addByte(random);
        addShort(msgId);
        addShort(seqNum);
        addShort((short)0);
        byte checksum = 0;
        addByte(checksum);
        addByte((byte) 0);
        addByte((byte) 3);
        size += 2;
        for (int i = 0; i < 1; i++) {
            size += 15;
            //if(i == 0)
                //addInteger(0x0100007F); //addInteger(0x9801A8C0);//addInteger(0x180F6356); //addInteger(0x0100007F);
            //else addInteger(0xAA89BB25);
            addInteger(0xAA89BB25);
            addByte((byte) 0x9F);
            addByte((byte) (0x3 + i));
            addByte((byte) 0x3);
            addByte((byte) 0x2);
            addByte((byte) 0x0);
            addByte((byte) 0xF4);
            addByte((byte) 0x1);
            addByte((byte) 0x11);
            addByte((byte) 0x0);
            addByte((byte) 0xF4);
            addByte((byte) 0x1);
        }
        
        /*
        byte b[] = {0x00, 0x38, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x03, 0x03, 0x02, 0x00, (byte)0xF4, 0x01, 0x10, 0x00, (byte)0xF4, 0x01, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x04, 0x03, 0x30, 0x00, (byte)0xF4, 0x01, 0x52, 0x01, (byte)0xF4, 0x01, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x05, 0x03, 0x00, 0x00, (byte)0xF4, 0x01, 0x00, 0x00, (byte)0xF4, 0x01, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x06, 0x03, 0x00, 0x00, (byte)0xF4, 0x01, 0x00, 0x00, (byte)0xF4, 0x01, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x07, 0x03, 0x00, 0x00, (byte)0xF4, 0x01, 0x00, 0x00, (byte)0xF4, 0x01, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x08, 0x03, 0x00, 0x00, (byte)0xF4, 0x01, 0x00, 0x00, (byte)0xF4, 0x01, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x09, 0x03, 0x01, 0x00, (byte)0xF4, 0x01, 0x01, 0x00, (byte)0xF4, 0x01, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x0A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x0B, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x0C, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x0D, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x0E, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x0F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x10, 0x03, 0x00, 0x00, (byte)0xF4, 0x01, 0x00, 0x00, (byte)0xF4, 0x01, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x11, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x12, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x13, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x14, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x15, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x16, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x17, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x18, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x19, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x1A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x1B, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x1C, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x1D, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x1E, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x1F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x20, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x21, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x22, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x23, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x24, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x25, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x26, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x27, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x28, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x29, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x2A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x2B, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x2C, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x2D, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x2E, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x2F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x30, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x31, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x32, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x33, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x34, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x35, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x36, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x37, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x38, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x39, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7F, 0x00, 0x00, 0x01, (byte)0x9F, 0x3A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
        
        
        for(int i = 0; i < b.length; i++)
        {
            addByte(b[i]);
        }*/
        
        size = (short) buffer.position();
        
        if((size - 8) % 16 > 0)
        {
            size -= (size - 8) % 16;
            size += 16;
        }
        short pSize = (short) ((size - 8) / 16);
        buffer.position(5);
        addShort(pSize);
        for(int i = 0; i < 7; i++)
        {
            checksum += buffer.get(i);
        }
        addByte(checksum);
        return buffer.array();
    }
}
