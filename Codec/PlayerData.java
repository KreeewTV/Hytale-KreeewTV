package at.kreeewtv.hycore.codec.playerdata;

import java.util.UUID;

public final class PlayerData {

    // https://github.com/KreeewTV

    private final UUID uuid;
    private String playerName;
    private int coins;
    private String language;

    public PlayerData(UUID uuid, String playerName, int coins, String language) {
        this.uuid = uuid;
        this.playerName = playerName;
        this.coins = coins;
        this.language = language;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getCoins() {
        return coins;
    }

    public String getLanguage() {
        return language;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}