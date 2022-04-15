package myutils.dateutils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * 时间戳工具
 * 时间戳：均为13位（毫秒级）
 */
public class TimeStampUtil {
    public static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final long ONE_DAY_TIME_MILLIS = 60 * 60 * 24 * 1000L;

    /**
     * @return 获取当天0点时间戳
     */
    public static Long getTodayZeroTimestamp() {
        return getTargetZeroTimestamp(System.currentTimeMillis());
    }

    /**
     * 获取指定时间戳的0点时间戳
     * @param timestamp timestamp
     * @return 0点时间戳
     */
    public static Long getTargetZeroTimestamp(Long timestamp) {
        return timestamp - (timestamp + TimeZone.getDefault().getRawOffset()) % ONE_DAY_TIME_MILLIS;
    }

    /**
     * @return 获取当前周一0点时间戳
     */
    public static Long getMondayTimestamp() {
        return getTargetMondayTimestamp(System.currentTimeMillis());
    }

    /**
     * 获取指定时间戳所在周的周一时间戳
     * @param timestamp timestamp
     * @return 周一时间戳
     */
    public static Long getTargetMondayTimestamp(Long timestamp) {
        long tmp = getTargetZeroTimestamp(timestamp);
        long dayOfWeek = getDayOfWeek(tmp);
        while (dayOfWeek != 1) {
            tmp -= ONE_DAY_TIME_MILLIS;
            dayOfWeek = getDayOfWeek(tmp);
        }
        return tmp;
    }

    /**
     * 获取星期
     * @param startTimestamp startTimestamp
     * @return 0 - 6 周日到周六
     */
    public static Long getDayOfWeek(Long startTimestamp) {
        Long zeroTimestamp = getTargetZeroTimestamp(startTimestamp);
        return (zeroTimestamp + 5 * 24 * 60 * 60 * 1000) % (7 * ONE_DAY_TIME_MILLIS) / ONE_DAY_TIME_MILLIS;
    }

    /**
     * @param timestamp Timestamp
     * @return timestamp格式化后的结果
     */
    public static String formatTimeStampToString(Timestamp timestamp) {
        return sdf.format(timestamp);
    }

    /**
     *传入 Long 类型时间戳进行格式化
     * @param timestamp Long
     * @return 格式化
     */
    public static String formatTimeStampToString(Long timestamp) {
        return sdf.format(new Timestamp(timestamp));
    }
}
