package com.organization.university;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import com.github.sisyphsu.dateparser.DateParserUtils;

public class TestMainClass {
	public static void main(String[] args) {
		
		Date date = DateParserUtils.parseDate("2015-04-29T10:15:00.500+0000");
		Calendar calendar = DateParserUtils.parseCalendar("2015-04-29T10:15:00.500Z");
		LocalDateTime dateTime = DateParserUtils.parseDateTime("2020-08-11T18:49:55.548Z");
		System.out.println("date time:::: "+dateTime);
}
}
