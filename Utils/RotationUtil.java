package at.kreeewtv.utils;

import com.hypixel.hytale.math.vector.Vector3f;

public final class RotationUtil {


       /** GET THE EXACT LOCATION like F7 in the right side WORLD -> ORIENTATION
        // https://github.com/KreeewTV

      Usage Example:

      HeadRotation headRotationComponent = store.getComponent(ref, HeadRotation.getComponentType());

      -> also possible 
      playerRef.getHeadRotation().getPitch();
      playerRef.getHeadRotation().getYaw();
      
      var pitchHead = headRotationComponent.getRotation().x;  
      var yawHead = headRotationComponent.getRotation().y;  
      var zHead = headRotationComponent.getRotation().z;  

      Vector3d vector3dLoc = new Vector3d(0,0,0);
      Vector3f vector3fBodyPos = new Vector3f(0,0,0);
      Vector3f vector3fHeadPos = new Vector3f(pitchHead,yawHead,zHead);
      Teleport teleport = Teleport.createExact(vector3dLoc, vector3fBodyPos, RotationUtil.degreesToRadians(vector3fHeadPos));

        **/

    private static final float DEG_TO_RAD = (float) (Math.PI / 180.0);

    private RotationUtil() {
    }

    public static Vector3f degreesToRadians(Vector3f degrees) {
        if (degrees == null) {
            return null;
        }
        return new Vector3f(
                degrees.x * DEG_TO_RAD,
                degrees.y * DEG_TO_RAD,
                degrees.z * DEG_TO_RAD
        );
    }

    public static Vector3f degreesToRadians(float yawDeg, float pitchDeg, float rollDeg) {
        return new Vector3f(
                yawDeg * DEG_TO_RAD,
                pitchDeg * DEG_TO_RAD,
                rollDeg * DEG_TO_RAD
        );
    }

    public static float radiansToDegrees(float radians) {
        return (float) (radians * 180.0 / Math.PI);
    }
}
