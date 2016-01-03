package com.one.pilot.healtheyes.healtheyes.alarm.vibration;

import android.os.Vibrator;

import com.one.pilot.healtheyes.healtheyes.alarm.AbstractAlarm;

import java.util.HashMap;

/**
 * Created by Garkusha Andrey on 1/3/16.
 *
 * User notifier, which use vibration as a alarm at Android
 * devices.
 * Previously need to define vibration patterns. It happens
 * in constructor of the class.
 */
public class AndroidVibration extends AbstractAlarm {
    private Vibrator vibrator;
    private static HashMap<AlarmType, long[]> pattern = null;

    private AndroidVibration(){}

    public AndroidVibration(android.content.Context context) {
        vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);

        if (pattern == null) {
            pattern = new HashMap();

            // Pattern transcript; {pause, play, pause, play ...}
            pattern.put(AlarmType.READY, new long[]{0});
            pattern.put(AlarmType.RUNNING, new long[]{0});
            pattern.put(AlarmType.FINISHED, new long[]{0, 200, 200, 200});
        }
    }

    @Override
    public int call(AlarmType type) {
        vibrator.vibrate(pattern.get(type), -1);
        return 0;
    }
}
