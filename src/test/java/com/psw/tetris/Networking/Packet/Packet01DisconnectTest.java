package com.psw.tetris.Networking.Packet;

import com.psw.tetris.networking.packets.Packet01Disconnect;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Packet01DisconnectTest {

  private Packet01Disconnect packet;

  @Test
  public void testConstructorWithString() {
    assertEquals("TestUser", packet.getUsername());
  }

  @Test
  public void testGetData() {
    byte[] expectedData = "01,TestUser".getBytes();
    assertArrayEquals(expectedData, packet.getData());
  }

  // @Test
  // public void testWriteDataToClient() {
  // // Mock GameClient
  // GameClient mockClient = new GameClient();
  // packet.writeData(mockClient);
  // }
  //
  // @Test
  // public void testWriteDataToServer() {
  // GameServer mockServer = new GameServer();
  // packet.writeData(mockServer);
  // }

  @Test
  public void testConstructorWithDataArray() {
    byte[] data = "01,TestUser".getBytes();
    Packet01Disconnect newPacket = new Packet01Disconnect(data);
    assertEquals("TestUser", newPacket.getUsername());
  }
}
