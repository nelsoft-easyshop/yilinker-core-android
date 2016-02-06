package com.yilinker.core.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Arci.Malabanan on 2/28/2015.
 */
public class DateDeserializer implements JsonDeserializer<Date>
{

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try
        {
            return df.parse(json.getAsString());
        }
        catch (final java.text.ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
