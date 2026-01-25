#README 

<img src="https://github.com/KreeewTV/Hytale-KreeewTV/blob/4e38ba5f8087fb33147c64be73c4c66aadffa7a7/Codec/Codec.png" alt="Alt-Text" width="300">

This example demonstrates a codec implementation for structured data storage.
After loading, all data is kept in memory using a HashMap, allowing very fast access as well as efficient reading, updating, and deletion of values.
Changes are performed in RAM only and are not immediately written to disk, which prevents unnecessary and frequent write operations.
The data is serialized and persisted only during an explicit save operation.
This approach significantly improves performance while providing clear control over data persistence and lifecycle management.

USAGE:
````
//SAVE FILE WHENEVER YOU WANT
  try {
              PlayerStorage.save();
          } catch (IOException e) {
              throw new RuntimeException(e);
          }

//LOAD FILE - IMPORTANT LOAD ON SETUP!
  try {
            PlayerStorage.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//CREATE PLAYER IF NOT EXISTS
PlayerStorage.createIfNotExists(playerRef.getUuid(), playerRef.getUsername(), 20, "de_DE");

//Get Data from Player in Json
PlayerData playerData = PlayerStorage.get(playerRef.getUUID(), playerRef.getUsername());

//Get Data specific
playerData.getCoins();
playerData.setCoins(20);
...
````

<img width="1000" height="2017" alt="image" src="https://github.com/user-attachments/assets/94348e8a-ee17-4e30-aa49-2ecb2945a064" />













