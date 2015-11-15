package utils.one.com;

/**
 * Created by one on 11/14/15.
 */
public class TimeHelper {

    static public String seccondsToStringMMSS(int secconds) {
        String rv;

        int min = (int) secconds / 60;
        int sec = (int) secconds - (min*60);

        rv = String.format("%02d:%02d", min, sec);

        return rv;
    }
}
