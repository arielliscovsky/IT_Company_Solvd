package com.solvd.itcompany.xmlParser;

import org.apache.log4j.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter <String,Date> {

    private final static org.apache.log4j.Logger LOGGER = Logger.getLogger(DateAdapter.class);

    @Override
    public Date unmarshal(String s)  {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            LOGGER.debug(e.toString());
        }
        return null;
    }

    @Override
    public String marshal(Date date)  {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
