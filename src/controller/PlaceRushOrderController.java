package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class PlaceRushOrderController {

    public static List<String> PROVINCES_SUPPORT_RUSH_ODER = List.of("Ha Noi");

    public static List<Integer> MEDIA_IDS_SUPPORT_RUSH_ORDER = List.of(200);

    private static final Logger LOGGER = utils.Utils.getLogger(PlaceRushOrderController.class.getName());

    public static final String RECEIVE_TIME_FORMATTER = "dd-MM-yyyy HH:mm";

    public boolean isLocationSupportRushOrder(String location) {
        if (location == null) {
            return false;
        }
        if (PROVINCES_SUPPORT_RUSH_ODER.contains(location)) {
            return true;
        }
        return false;
    }

    public boolean isItemsSupportRushOrder(int mediaID) {
        if (MEDIA_IDS_SUPPORT_RUSH_ORDER.contains(mediaID)) {
            return true;
        }
        return false;
    }

    public boolean isSupportRushOrder(String location, int mediaID) {
        return isLocationSupportRushOrder(location) && isItemsSupportRushOrder(mediaID);
    }

    public boolean validateReceiveTime(String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(RECEIVE_TIME_FORMATTER);
            LocalDateTime start = LocalDateTime.of(2000, 1, 1, 0, 0);
            LocalDateTime end = LocalDateTime.of(2100, 1, 1,0,0);
            LocalDateTime timeInput = LocalDateTime.parse(time, formatter);
            if(timeInput.isAfter(start)&&timeInput.isBefore(end)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateRushOrderInfo(String info) {
        return validateBasicString(info);
    }

    public boolean validateRushOrderInstruction(String instruction) {
        return validateBasicString(instruction);
    }

    private boolean validateBasicString(String info) {
        if (info == null || info.isEmpty()) {
            return false;
        }

        boolean isValid = true;
        for (char ch : info.toCharArray()) {
            if ( Character.isSpaceChar(ch) ) {
                continue;
            }
            if ( Character.isDigit(ch) ) {
                continue;
            }
            if ( Character.isLetter(ch) ) {
                continue;
            }
            isValid = false;
            break;
        }

        return isValid;
    }
}
