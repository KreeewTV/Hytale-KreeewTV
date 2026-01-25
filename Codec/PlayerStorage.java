package at.kreeewtv.hycore.codec.playerdata;

import com.google.gson.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public final class PlayerStorage {

    // https://github.com/KreeewTV

    private static final Path DATA_FOLDER =
            Paths.get("plugins", "MyPlugin");

    private static final Path FILE =
            DATA_FOLDER.resolve("players.json");

    private static final Gson GSON =
            new GsonBuilder().setPrettyPrinting().create();

    private static final Map<UUID, PlayerData> PLAYERS = new HashMap<>();

    /* ===== SERVER START ===== */

    public static void load() throws IOException {
        PLAYERS.clear();
        Files.createDirectories(DATA_FOLDER);

        if (!Files.exists(FILE)) {
            return;
        }

        try (Reader reader = Files.newBufferedReader(FILE)) {

            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            JsonObject players = root.getAsJsonObject("players");

            if (players == null) {
                return;
            }

            for (Map.Entry<String, JsonElement> entry : players.entrySet()) {

                UUID uuid = UUID.fromString(entry.getKey());
                PlayerData data = GSON.fromJson(entry.getValue(), PlayerData.class);

                PLAYERS.put(uuid, data);
            }
        }
    }

    /* ===== MANUAL SAVE ===== */

    public static void save() throws IOException {

        JsonObject players = new JsonObject();

        for (PlayerData data : PLAYERS.values()) {
            players.add(
                    data.getUuid().toString(),
                    GSON.toJsonTree(data)
            );
        }

        JsonObject root = new JsonObject();
        root.add("players", players);

        Files.writeString(
                FILE,
                GSON.toJson(root),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }

    /* ===== INGAME API ===== */

    public static PlayerData get(UUID uuid) {
        return PLAYERS.get(uuid);
    }

    public static PlayerData createIfNotExists(UUID uuid, String playerName, Integer coins, String language) {

        PlayerData data = PLAYERS.get(uuid);
        if (data != null) {
            return data;
        }

        data = new PlayerData(
                uuid,
                playerName,
                coins,
                language
        );

        PLAYERS.put(uuid, data);
        return data;
    }

    public static Collection<PlayerData> all() {
        return Collections.unmodifiableCollection(PLAYERS.values());
    }
}