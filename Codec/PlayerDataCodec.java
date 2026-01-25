package at.kreeewtv.hycore.codec.playerdata;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.util.UUID;

public final class PlayerDataCodec implements Codec<PlayerData> {

    // https://github.com/KreeewTV

    // ENCODE THE DATA FROM PlayerData the variable Name
    @Override
    public void encode(BsonWriter writer, PlayerData value, EncoderContext context) {
        writer.writeStartDocument();

        writer.writeString("uuid", value.getUuid().toString());
        writer.writeString("playername", value.getPlayerName());
        writer.writeInt32("coins", value.getCoins());
        writer.writeString("language", value.getLanguage());

        writer.writeEndDocument();
    }

    // DECODE THE DATA FROM PlayerData the variable Name
    @Override
    public PlayerData decode(BsonReader reader, DecoderContext context) {
        reader.readStartDocument();

        UUID uuid = UUID.fromString(reader.readString("uuid"));
        String name = reader.readString("playername");
        int coins = reader.readInt32("coins");
        String language = reader.readString("language");

        reader.readEndDocument();

        return new PlayerData(uuid, name, coins, language);
    }

    @Override
    public Class<PlayerData> getEncoderClass() {
        return PlayerData.class;
    }
}