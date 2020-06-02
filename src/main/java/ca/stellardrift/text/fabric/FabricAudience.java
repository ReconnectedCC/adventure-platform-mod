/*
 * Copyright © 2020 zml [at] stellardrift [.] ca
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the “Software”), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package ca.stellardrift.text.fabric;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.minecraft.network.MessageType;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.util.Util;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public interface FabricAudience extends Audience {
    /**
     * Send a chat message to this player.
     *
     * Messages of type {@link MessageType#GAME_INFO} should be
     * sent as action bar titles to preserve formatting.
     *
     * @param text The contents of the message
     * @param type The type of message to send.
     */
    default void sendMessage(MessageType type, Component text) {
        sendMessage(type, text, Util.field_25140);
    }

    /**
     * Send a chat message to this player.
     *
     * Messages of type {@link MessageType#GAME_INFO} should be
     * sent as action bar titles to preserve formatting.
     *
     * @param text The contents of the message
     * @param type The type of message to send.
     * @param source The UUID of the message's sender, or {@link Util#field_25140}
     */
    void sendMessage(MessageType type, Component text, UUID source);

    @Override
    default void sendMessage(@NonNull Component message) {
        sendMessage(MessageType.SYSTEM, message);
    }

    @Override
    default void sendActionBar(@NonNull Component message) {
        sendMessage(MessageType.GAME_INFO, message);
    }
}
