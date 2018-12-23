package ood.lockersystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
import java.util.TreeSet;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		String dateStr = "2018-03-12T20:00:00Z";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
		//sdf.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		//ZoneOffset.ofTotalSeconds(420).normalized();
		TimeZone tz = TimeZone.getTimeZone(ZoneOffset.of("-08:00"));
		ZoneOffset off = ZoneOffset.ofTotalSeconds(420 * 60);
		TimeZone t2 = TimeZone.getTimeZone(off);
		System.out.println(t2.getID());
		Date date = sdf.parse(dateStr);
		System.out.println(date.toString());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss VV");
		ZonedDateTime outputDT = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneOffset.of("-08:00").normalized());
		System.out.println(outputDT.format(dtf));
		
		System.out.println(ZoneId.SHORT_IDS.get("PST"));
		
		System.out.println("===============================================================================================");
		
		TreeSet<String> allZoneIds = new TreeSet<>(ZoneId.getAvailableZoneIds());
		for (String str : allZoneIds) {
			ZoneId z = ZoneId.of(str);
			ZonedDateTime zdt = ZonedDateTime.now(z);
			System.out.println(zdt.getOffset().toString() + ", " + zdt.getZone().getId());
		}
		
	}

}
